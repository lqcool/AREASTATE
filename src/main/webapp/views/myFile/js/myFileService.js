angular.module("myFileServiceModule",[])
.factory("MyFileService",["$resource","$http",function($resource,$http)
                          {
	var myFileService = $resource("../myFileController/:method", {});
	myFileService.findAllFiles=function(successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			url: "../myFileController/findAllFiles",
		}).success(successcb).error(errorcb);
	};
	
	myFileService.getPageList=function(pageIndex,pageSize,preExtrcode,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../myFileController/getPageList",
			data: {'pageIndex':pageIndex,'pageSize':pageSize,"preExtrcode":preExtrcode},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};
	
	myFileService.getSearchPageList=function(pageIndex,pageSize,searchCondition,id,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../myFileController/getSearchPageList",
			data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition,"id":id},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};
	
	myFileService.renameFile=function(newFile,id,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../myFileController/renameFile",
			data: {'newFile':newFile,"id":id},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};
	
	myFileService.deleteFile=function(id,successcb,errorcb)//传入的两个方法
	{
		$http({
			method: "POST",
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			url: "../myFileController/deleteFile",
			data: {'id':id},
			transformRequest:function (data) {return $.param(data);}
		}).success(successcb).error(errorcb);
	};
	return myFileService;
}]);