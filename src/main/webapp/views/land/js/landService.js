angular.module("LandServiceModule",[])
	.factory("LandService",["$resource","$http",function($resource,$http)
	{
		var landService = $resource("../landController/:method", {});
		landService.saveLand=function(newLand,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../landController/saveLand",
                 data: newLand
             }).success(successcb).error(errorcb);
		};
		
		landService.findLandById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../landController/findLandById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		landService.deleteLand=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../landController/deleteLand",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		landService.updateLand=function(Land,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../landController/updateLand",
                 data: Land
             }).success(successcb).error(errorcb);
		};
		
		landService.findAllLands=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../landController/findAllLands",
			}).success(successcb).error(errorcb);
		};
		
		landService.findAllLandsByState=function(successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../landController/findAllLandsByState",
			}).success(successcb).error(errorcb);
		};
		
		landService.getSearchPageList=function(pageIndex,pageSize,searchCondition,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../landController/getSearchPageList",
				data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		return landService;
    
}]);