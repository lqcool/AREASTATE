package com.frame.service.landStateCreaterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.landDailyState.LandDailyState;

public interface LandStateCreaterService {
	List<LandDailyState> getLandDailyState(Integer landId,HttpServletRequest request);
}
