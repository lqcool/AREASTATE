angular.module("AnouncementServiceModule",[])
	.factory("AnouncementService",["$resource","$http",function($resource,$http)
	{
		var anouncementService = $resource("../AnouncementController/:method", {});
		anouncementService.saveAnouncement=function(newAnouncement,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../anouncementController/saveAnouncement",
                 data: newAnouncement
             }).success(successcb).error(errorcb);
		};
		
		anouncementService.findAnouncementById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../anouncementController/findAnouncementById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		anouncementService.deleteAnouncement=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../anouncementController/deleteAnouncement",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		anouncementService.updateAnouncement=function(anouncement,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../anouncementController/updateAnouncement",
                 data: anouncement
             }).success(successcb).error(errorcb);
		};
		
		anouncementService.findAllAnouncements=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../anouncementController/findAllAnouncements",
			}).success(successcb).error(errorcb);
		};
		
		anouncementService.publish=function(anouncement,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
	            url: "../anouncementController/publish",
	            data: anouncement
			}).success(successcb).error(errorcb);
		};
		
		anouncementService.getSearchPageList=function(pageIndex,pageSize,searchCondition,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../anouncementController/getSearchPageList",
				data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		return anouncementService;
    
}]);