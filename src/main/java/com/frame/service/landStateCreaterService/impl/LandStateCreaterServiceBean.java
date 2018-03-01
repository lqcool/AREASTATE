package com.frame.service.landStateCreaterService.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.entity.land.Land;
import com.frame.entity.landDailyState.LandDailyState;
import com.frame.entity.lockingRecord.LockingRecord;
import com.frame.entity.sysconfig.SysConfig;
import com.frame.service.landService.LandService;
import com.frame.service.landStateCreaterService.LandStateCreaterService;
import com.frame.service.lockingRecordService.LockingRecordService;
import com.frame.service.sysConfigService.SysConfigService;

@Service("landStateCreaterService")
public class LandStateCreaterServiceBean implements LandStateCreaterService{

	@Autowired
	private LandService landService;
	@Autowired
	private SysConfigService sysConfigService;
	@Autowired
	private LockingRecordService lockingRecordService;

	@Override
	public List<LandDailyState> getLandDailyState(Integer landId,HttpServletRequest request) {
		SysConfig sysConfig = sysConfigService.findSysConfigByProperty("展示用地状态数据天数", request);
		List<LandDailyState> landDailyStates;
		if(sysConfig==null){
			/**
			 * 默认展示15天状态
			 */
			landDailyStates = landDailyStateHander(landId,15,request);
		}else{
			Integer displayDay = Integer.parseInt(sysConfig.getValue());
			landDailyStates = landDailyStateHander(landId,displayDay,request);
		}
		return landDailyStates;
	}


	/**
	 * TODO:初始化从今天开始到后面15天的用地状态信息
	 * @return List<LandDailyState>
	 * @author 李桥
	 * @time 2017年12月30日
	 */
	private List<LandDailyState> initialLandDailyState(Integer landId,Integer displayDay,HttpServletRequest request){
		ArrayList<LandDailyState> landDailyStates = new ArrayList<LandDailyState>();
		//用地信息
		Land land = landService.findLandById(landId, null);
		//初始化上午、下午、晚上都是可用状态
		for(int i = 0; i < displayDay; i ++){
			Calendar calendar = Calendar.getInstance();
			LandDailyState landDailyState = new LandDailyState();
			calendar.add(Calendar.DATE, i);
			landDailyState.setDate(calendar.getTime());
			landDailyState.setAmState("可用");
			landDailyState.setPmState("可用");
			landDailyState.setNightState("可用");
			landDailyState.setLand(land);
			landDailyStates.add(landDailyState);
		}
		return landDailyStates;
	} 

	/**
	 * TODO:模拟查询数据库，生成用地锁定申请记录信息
	 * @return List<LandLockApplication>
	 * @author 李桥
	 * @time 2017年12月30日
	 */
	private List<LockingRecord> loadMySqlDataOfLandLockApplication(Integer landId,Integer displayDay,HttpServletRequest request){
		List<LockingRecord> lockingRecords = new ArrayList<LockingRecord>();
		lockingRecords = lockingRecordService.findLockingRecordsByLandId(landId, displayDay,request);
		return lockingRecords;
	}

	/**
	 * TODO:将初始化的用地数据和查出的数据库锁定申请记录数据结合进行处理，得到最终结果
	 * @return List<LandDailyState>
	 * @author 李桥
	 * @time 2017年12月30日
	 */
	private List<LandDailyState> landDailyStateHander(Integer landId,Integer displayDay,HttpServletRequest request){
		ArrayList<LockingRecord> lockingRecords = (ArrayList<LockingRecord>) loadMySqlDataOfLandLockApplication(landId,displayDay,request);
		List<LandDailyState> landDailyStates = initialLandDailyState(landId,displayDay,request);
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
		for(int i = 0; i < lockingRecords.size(); i ++){
			for(int j = 0; j < landDailyStates.size(); j ++){
				LockingRecord lockingRecord = lockingRecords.get(i);
				LandDailyState landDailyState = landDailyStates.get(j);
				//是当天
				if(df.format(lockingRecord.getLockDate()).compareTo(df.format(landDailyState.getDate())) == 0){
					if(lockingRecord.getTimeQuantum().equals("上午")){
						landDailyState.setAmState(lockingRecord.getState());
					}
					if(lockingRecord.getTimeQuantum().equals("下午")){
						landDailyState.setPmState(lockingRecord.getState());
					}
					if(lockingRecord.getTimeQuantum().equals("晚上")){
						landDailyState.setNightState(lockingRecord.getState());
					}
				}
			}
		}

		return landDailyStates;
	}
}

