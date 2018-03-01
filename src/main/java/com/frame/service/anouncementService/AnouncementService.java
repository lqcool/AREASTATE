package com.frame.service.anouncementService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.anouncement.Anouncement;

public interface AnouncementService {
	public boolean  saveAnouncement(Anouncement anouncement, HttpServletRequest request);
	
	public boolean deleteAnouncement(Integer id, HttpServletRequest request);
	
	public Anouncement findAnouncementById(Integer id, HttpServletRequest request);
	
	public boolean updateAnouncement(Anouncement anouncement, HttpServletRequest request);
	
	public List<Anouncement> findAllAnouncements(HttpServletRequest request);

	public boolean updateAnouncementState(String state, HttpServletRequest request);

	public List<Anouncement> findAnouncementByState(String state);

	public boolean publish(Anouncement anouncement, HttpServletRequest request);

	public boolean updateAnouncementStateById(Integer id, String state);

	public List<Anouncement> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition);

	public int getSearchTotalItems(String searchCondition);
	
}
