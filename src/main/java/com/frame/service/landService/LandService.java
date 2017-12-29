package com.frame.service.landService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.land.Land;

public interface LandService {
	public Land  saveLand(Land land, HttpServletRequest request);
	
	public void deleteLand(Integer id, HttpServletRequest request);
	
	public Land findLandById(Integer id, HttpServletRequest request);
	
	Land updateLand(Land land, HttpServletRequest request);
	
	List<Land> findAllLands(HttpServletRequest request);
}
