package com.frame.service.lockingRecordService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.dao.lockingRecordDao.LockingRecordDao;
import com.frame.dao.logDao.LogDao;
import com.frame.entity.lockingRecord.LockingRecord;
import com.frame.entity.user.User;
import com.frame.service.lockingRecordService.LockingRecordService;

/**
 * @author chengbangguo
 *2018年1月1日 上午11:31:03 
 */
@Service("lockingRecordService")
public class LockingRecordServiceBean implements LockingRecordService{

	@Autowired
	private LockingRecordDao lockingRecordDao;
	@Autowired
	private LogDao logDao;
	
	@Override
	public LockingRecord saveLockingRecord(LockingRecord lockingRecord,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj instanceof User){
				User user = (User) obj;
				//设置当前用户
				lockingRecord.setUser(user);
				//设置提交时间
				lockingRecord.setSubmitDate(new Date());
				//设置用户电话
				lockingRecord.setUserTel(user.getTel());
				//设置状态
				lockingRecord.setState("锁定");
				lockingRecord.setCode(createCode());
			} else {
				return null;
			}
			return lockingRecordDao.saveLockingRecord(lockingRecord);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Map<String,Object> saveLockingRecords(ArrayList<LockingRecord> lockingRecords,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//获取当前登陆用户
		User user = (User)request.getSession().getAttribute("user");
		//提交时间
		Date submitDate = new Date();
		//编码
		String code = createCode();
		try {
			for(int i = 0; i < lockingRecords.size(); i ++){
				LockingRecord lockingRecord = lockingRecords.get(i);
				//设置当前用户
				lockingRecord.setUser(user);
				//设置提交时间
				lockingRecord.setSubmitDate(submitDate);
				//设置用户电话
				lockingRecord.setUserTel(user.getTel());
				//设置状态
				lockingRecord.setState("锁定");
				lockingRecord.setCode(code);
				lockingRecordDao.saveLockingRecord(lockingRecord);
			}
			resultMap.put("code", code);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteLockingRecord(Integer id, HttpServletRequest request) {
		try {
			this.lockingRecordDao.deleteLockingRecord(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LockingRecord findLockingRecordById(Integer id,
			HttpServletRequest request) {
		try {
			return this.lockingRecordDao.findLockingRecordById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public List<LockingRecord> findLockingRecordByCode(String code,
			HttpServletRequest request) {
		try {
			List<LockingRecord> results = this.lockingRecordDao.findLockingRecordByCode(code);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LockingRecord updateLockingRecord(LockingRecord lockingRecord,
			HttpServletRequest request) {
		try {
			lockingRecordDao.updateLockingRecord(lockingRecord);
			return lockingRecord;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LockingRecord> findAllLockingRecords(HttpServletRequest request) {
		try {
			return this.lockingRecordDao.findAllLockingRecords();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<LockingRecord> findAllLockingRecordsByUserId(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("user");
			if(obj instanceof User){
				User user = (User) obj;
				return this.lockingRecordDao.findAllLockingRecordsByUserId(user.getId());
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LockingRecord> findLockingRecordsByLandId(Integer landId, Integer displayDay, HttpServletRequest request) {
		try {
			return this.lockingRecordDao.findLockingRecordsByLandId(landId,displayDay);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public LockingRecord updateLockingRecorderState(String code,String state, HttpServletRequest request) {
		try {
			return this.lockingRecordDao.updateLockingRecorderState(code,state);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LockingRecord> getSearchPageList(Integer pageIndex,Integer pageSize,String searchCondition,Integer id, HttpServletRequest request){
		try {
			List<LockingRecord> results = this.lockingRecordDao.getSearchPageList(pageIndex, pageSize, searchCondition, id);
			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getSearchTotalItems(String searchCondition,Integer id, HttpServletRequest request){
		try {
			int totalItems = this.lockingRecordDao.getSearchTotalItems(searchCondition, id);
			return totalItems;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * TODO:生成锁定申请的编码
	 * @return String
	 * @author AbnerLi
	 * @time 2018年1月14日
	 */
	public String createCode(){
		String charcat = "0123456789abcdefghigklmnopqrstuvwxyz";
		return new Date().getTime() + charcat.charAt((int)(Math.random() * charcat.length())) + charcat.charAt((int)(Math.random() * charcat.length())) + "";
	}
}

