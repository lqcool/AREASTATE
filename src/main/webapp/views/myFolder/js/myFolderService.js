angular.module("myFolderServiceModule",[])
	.factory("MyFolderService",["$resource","$http",function($resource,$http)
	{
		var myFolderService = $resource("../myFolderController/:method", {});
		myFolderService.saveMyFolder=function(newFolder,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../myFolderController/saveMyFolder",
                 data: newFolder
             }).success(successcb).error(errorcb);
		};
		
		myFolderService.findChildFolderByExtrcode=function(preExtrcode,successcb,errorcb)//传入的两个方法
		{
			// $http.post('../myFolderController/findChildFolderByExtrcode', {'preExtrcode':preExtrcode}, postCfg).success(successcb).error(errorcb);
			 $http({
                 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../myFolderController/findChildFolderByExtrcode",
                 data: {'preExtrcode':preExtrcode},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		myFolderService.findChildFolderByExtrcode2=function(preExtrcode,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../myFolderController/findChildFolderByExtrcode2",
                 data: {'preExtrcode':preExtrcode},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		myFolderService.findAllFoldersByUserId=function(id,successcb,errorcb)//传入的两个方法
		{
			// $http.post('../myFolderController/findChildFolderByExtrcode', {'preExtrcode':preExtrcode}, postCfg).success(successcb).error(errorcb);
			 $http({
                 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../myFolderController/findAllFoldersByUserId",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		myFolderService.findFirstLayerfolderFoldersByUserId=function(id,successcb,errorcb)//传入的两个方法
		{
			// $http.post('../myFolderController/findChildFolderByExtrcode', {'preExtrcode':preExtrcode}, postCfg).success(successcb).error(errorcb);
			 $http({
                 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../myFolderController/findFirstLayerfolderFoldersByUserId",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		/**
		 * 用户名称是否被引用
		 *//*
		registerAndLoginService.checkLoginUser=function(user,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/checkLoginUser",
                 data: user
             }).success(successcb).error(errorcb);
			//registerAndLoginService.save({method:"checkLoginUser"},{loginNo:"dddd"},success,error);
		};*/
		return myFolderService;
    
}]);