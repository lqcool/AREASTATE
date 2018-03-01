package com.frame.dao.landDao;

import java.util.List;

import com.frame.entity.land.Land;

public interface LandDao {
	public Land saveLand(Land Land) throws Exception;
	
	public void deleteLand(Integer id) throws Exception;
	
	Land findLandById(Integer id) throws Exception;

	Land updateLand(Land Land) throws Exception;
	
	public List<Land> findAllLands() throws Exception;
	
	public List<Land> findAllLandsByState() throws Exception;

	public List<Land> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition) throws Exception;

	public int getSearchTotalItems(String searchCondition) throws Exception;
}
