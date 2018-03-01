package com.frame.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestGennerateStateCreate {
	public static void main(String [] args){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<LandLockApplication> landLockApplications = new ArrayList<LandLockApplication>();
		ArrayList<LandDayState> landDayStates = new ArrayList<LandDayState>();
		
		String [] stage = {"上午","下午","晚上"};
		String [] state = {"可用","锁定","已分配"};
		
		for(int i = 0; i < 10; i ++){
			LandLockApplication landLockApplication = new LandLockApplication();
			int index = (int)(Math.random() * 3);
			calendar.add(Calendar.DATE, i);
			landLockApplication.setDate(calendar.getTime());
			
			landLockApplication.setLand("场地一");
			
			landLockApplication.setDateStage(stage[index]);
			
			landLockApplication.setLandState(state[index]);
			
			landLockApplications.add(landLockApplication);
		}
		
		Calendar calendar2 = Calendar.getInstance();
		//初始化上午、下午、晚上都是可用状态
		for(int i = 0; i < 15; i ++){
			LandDayState landDayState = new LandDayState();
			calendar2.add(Calendar.DATE, i);
			landDayState.setDate(calendar2.getTime());
			landDayState.setAmState("可用");
			landDayState.setPmState("可用");
			landDayState.setNightState("可用");
			landDayStates.add(landDayState);
		}
		
		//处理
		for(int i = 0; i < landLockApplications.size(); i ++){
			for(int j = 0; j < landDayStates.size(); j ++){
				LandLockApplication landLockApplication = landLockApplications.get(i);
				LandDayState landDayState = landDayStates.get(j);
				//是当天
				if(df.format(landLockApplication.getDate()).compareTo(df.format(landDayState.getDate())) == 0){
					if(landLockApplication.getDateStage() == "上午"){
						landDayState.setAmState(landLockApplication.getLandState());
					}
					if(landLockApplication.getDateStage() == "下午"){
						landDayState.setPmState(landLockApplication.getLandState());
					}
					if(landLockApplication.getDateStage() == "晚上"){
						landDayState.setNightState(landLockApplication.getLandState());
					}
				}
			}
		}
		
		System.out.print("日期\t\t上午\t下午\t晚上\n");
		for(int i = 0; i < landDayStates.size(); i ++){
			LandDayState landDayState = landDayStates.get(i);
			System.out.print(df.format(landDayState.getDate()) + "\t\t" + landDayState.getAmState() + "\t" + landDayState.getPmState() + "\t" + landDayState.getNightState());
			System.out.println();
		}
		
/*		System.out.println(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar.getTime());*/
	}
}

class LandLockApplication{
	
	public String land;
	public Date date;
	public String dateStage;
	public String lockuser;
	public Date lockDate;
	public String landState;
	
	public String getLandState() {
		return landState;
	}
	public void setLandState(String landState) {
		this.landState = landState;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateStage() {
		return dateStage;
	}
	
	public void setDateStage(String dateStage) {
		this.dateStage = dateStage;
	}
	
	public String getLockuser() {
		return lockuser;
	}
	
	public void setLockuser(String lockuser) {
		this.lockuser = lockuser;
	}
	
	public Date getLockDate() {
		return lockDate;
	}
	
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
}



class LandDayState{
	public String land;
	
	public String amState;
	
	public String pmState;
	
	public String nightState;
	
	public Date date;

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getAmState() {
		return amState;
	}

	public void setAmState(String amState) {
		this.amState = amState;
	}

	public String getPmState() {
		return pmState;
	}

	public void setPmState(String pmState) {
		this.pmState = pmState;
	}

	public String getNightState() {
		return nightState;
	}

	public void setNightState(String nightState) {
		this.nightState = nightState;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
