package com.frame.dao.lockingRecordDao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.frame.entity.land.Land;
import com.frame.entity.lockingRecord.LockingRecord;

/**
 * @author chengbangguo
 *2018年1月1日 上午11:31:37 
 */
public interface LockingRecordDao {
	public LockingRecord saveLockingRecord(LockingRecord lockingRecord) throws Exception;
	
	public void deleteLockingRecord(Integer id) throws Exception;
	
	public LockingRecord findLockingRecordById(Integer id) throws Exception;

	public LockingRecord updateLockingRecord(LockingRecord lockingRecord) throws Exception;
	
	public LockingRecord updateLockingRecordState() throws Exception;
	
	public List<LockingRecord> findAllLockingRecords() throws Exception;
	
	public List<LockingRecord> findAllLockingRecordsByUserId(Integer userId) throws Exception;
	
	public List<LockingRecord> findLockingRecordsByLandId(Integer landId, Integer displayDay) throws Exception;
	
	public LockingRecord updateLockingRecorderState(String code, String state) throws Exception;

	List<LockingRecord> getSearchPageList(Integer pageIndex, Integer pageSize,
			String searchCondition, Integer id) throws Exception;

	int getSearchTotalItems(String searchCondition, Integer id)
			throws Exception;

	public List<LockingRecord> findLockingRecordByCode(String code) throws Exception;

}

