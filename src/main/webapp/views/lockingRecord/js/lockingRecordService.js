angular.module("LockingRecordServiceModule",[])
	.factory("LockingRecordService",["$resource","$http",function($resource,$http)
	{
		var lockingRecordService = $resource("../lockingRecordController/:method", {});
		lockingRecordService.saveLockingRecord=function(newLockingRecord,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../lockingRecordController/saveLockingRecord",
                 data: newLockingRecord
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.saveLockingRecords=function(lockingRecords,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../lockingRecordController/saveLockingRecords",
                 data: lockingRecords
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.findLockingRecordById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../lockingRecordController/findLockingRecordById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.findLockingRecordByCode=function(code,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../lockingRecordController/findLockingRecordByCode",
                 data: {'code':code},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.deleteLockingRecord=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../lockingRecordController/deleteLockingRecord",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.updateLockingRecorderState=function(code,state,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../lockingRecordController/updateLockingRecorderState",
				data: {'code':code,'state':state},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		lockingRecordService.updateLockingRecord=function(LockingRecord,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../lockingRecordController/updateLockingRecord",
                 data: LockingRecord
             }).success(successcb).error(errorcb);
		};
		
		lockingRecordService.findAllLockingRecords=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../lockingRecordController/findAllLockingRecords",
			}).success(successcb).error(errorcb);
		};
		
		
		lockingRecordService.findAllLockingRecordsByUserId=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../lockingRecordController/findAllLockingRecordsByUserId",
			}).success(successcb).error(errorcb);
		};
		
		
		lockingRecordService.findLockingRecordsByLandId=function(landId,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../lockingRecordController/findAllLockingRecords",
				data: {'id':id},
                transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		lockingRecordService.getSearchPageList=function(pageIndex,pageSize,searchCondition,id,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../lockingRecordController/getSearchPageList",
				data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition,"id":id},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		return lockingRecordService;
    
}]);