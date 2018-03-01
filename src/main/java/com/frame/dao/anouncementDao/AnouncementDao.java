package com.frame.dao.anouncementDao;

import java.util.List;

import com.frame.entity.anouncement.Anouncement;
import com.frame.entity.lockingRecord.LockingRecord;

public interface AnouncementDao {
	public boolean saveAnouncement(Anouncement anouncement) throws Exception;
	
	public boolean deleteAnouncement(Integer id) throws Exception;
	
	public Anouncement findAnouncementById(Integer id) throws Exception;

	public boolean updateAnouncement(Anouncement anouncement) throws Exception;
	
	public List<Anouncement> findAllAnouncements() throws Exception;
	
	public List<Anouncement> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition) throws Exception;

	public int getSearchTotalItems(String searchCondition)
			throws Exception;

	public boolean updateAnouncementState(String state) throws Exception;

	public List<Anouncement> findAnouncementByState(String state) throws Exception;

	public boolean updateAnouncementStateById(Integer id, String state)
			throws Exception;
}
