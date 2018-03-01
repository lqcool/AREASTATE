angular.module("LandStateServiceModule",[])
.factory("LandStateService",["$resource","$http",function($resource,$http)
                             {
	var landStateService = $resource("../landStateCreaterController/:method", {});

	landStateService.getLandDailyState=function(landId,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../landStateCreaterController/getLandDailyState",
			data: {'landId':landId},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};

	return landStateService;

}]);