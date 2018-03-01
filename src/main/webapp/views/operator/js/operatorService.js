angular.module("OperatorServiceModule",[])
	.factory("OperatorService",["$resource","$http",function($resource,$http)
	{
		var operatorService = $resource("../userController/:method", {});
		operatorService.registe=function(newUser,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/saveUser",
                 data: newUser
             }).success(successcb).error(errorcb);
		};
		
		/**
		 * 用户名称是否被引用
		 */
		operatorService.checkLoginUser=function(user,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/checkLoginUser",
                 data: user
             }).success(successcb).error(errorcb);
		};
		
		operatorService.findUserById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../userController/findUserById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		operatorService.updateUser=function(user,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/updateUser",
                 data: user
             }).success(successcb).error(errorcb);
		};
		
		operatorService.loginOut=function(successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/loginOut",
             }).success(successcb).error(errorcb);
		};
		
		operatorService.changePwd=function(id,oldpwd,newpwd,successcb,errorcb)//传入的两个方法
		{
			 $http({
                method: "POST",
                url: "../userController/changePwd",
                headers: {'Content-type': 'application/x-www-form-urlencoded'},
                data: {'id':id,"oldPwd":oldpwd,"newPwd":newpwd},
                transformRequest:function (data) {return $.param(data);}
            }).success(successcb).error(errorcb);
		};
		
		operatorService.readedAnouncement=function(loginNo,successcb,errorcb)//传入的两个方法
		{
			 $http({
               method: "POST",
               url: "../userController/readedAnouncement",
               headers: {'Content-type': 'application/x-www-form-urlencoded'},
               data: {'loginNo':loginNo},
               transformRequest:function (data) {return $.param(data);}
           }).success(successcb).error(errorcb);
		};
		
		operatorService.getSearchPageList=function(pageIndex,pageSize,searchCondition,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../userController/getSearchPageList",
				data: {'pageIndex':pageIndex,'pageSize':pageSize,"searchCondition":searchCondition},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		operatorService.updateUserRole=function(id,role,successcb,errorcb)//传入的两个方法
		{
			$http({
				method: "POST",
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				url: "../userController/updateUserRole",
				data: {'id':id,'role':role},
				transformRequest:function (data) {return $.param(data);}
			}).success(successcb).error(errorcb);
		};
		
		return operatorService;
    
}]);