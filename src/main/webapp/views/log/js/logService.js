angular.module("logServiceModule",[])
.factory("LogService",["$resource","$http",function($resource,$http){
	var logService = $resource("../logController/:method");
	logService.saveLog = function(log,successcb,errorcb){
		$http({
			method:"POST",
			url:"../logController/saveLog",
			data:log
		}).success(successcb).error(errorcb);
	}
	
	logService.getPageList=function(pageIndex,pageSize,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../logController/getPageList",
			data: {'pageIndex':pageIndex,'pageSize':pageSize},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};
	return logService;
}]);