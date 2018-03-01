angular.module("SysConfigServiceModule",[])
	.factory("SysConfigService",["$resource","$http",function($resource,$http)
	{
		var sysConfigService = $resource("../sysConfigController/:method", {});
		sysConfigService.saveSysConfig=function(newSysConfig,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../sysConfigController/saveSysConfig",
                 data: newSysConfig
             }).success(successcb).error(errorcb);
		};
		
		sysConfigService.findSysConfigById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../sysConfigController/findSysConfigById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		sysConfigService.deleteSysConfig=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../sysConfigController/deleteSysConfig",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		sysConfigService.updateSysConfig=function(sysConfig,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../sysConfigController/updateSysConfig",
                 data: sysConfig
             }).success(successcb).error(errorcb);
		};
		
		sysConfigService.findAllSysConfigs=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../sysConfigController/findAllSysConfigs",
			}).success(successcb).error(errorcb);
		};
		
		sysConfigService.getSearchPageList=function(pageIndex,pageSize,searchCondition,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../sysConfigController/getSearchPageList",
				data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		return sysConfigService;
    
}]);