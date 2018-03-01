angular.module("registerAndLoginModule",[])
	.factory("RegisterAndLoginService",["$resource","$http",function($resource,$http)
	{
		var registerAndLoginService = $resource("../userController/:method", {});
		registerAndLoginService.registe=function(newUser,successcb,errorcb)//传入的两个方法
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
		registerAndLoginService.checkLoginUser=function(user,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/checkLoginUser",
                 data: user
             }).success(successcb).error(errorcb);
		};
		
		registerAndLoginService.findUserById=function(id,successcb,errorcb)//传入的两个方法
		{
			 $http({
				 method: "POST",
                 headers: {'Content-type': 'application/x-www-form-urlencoded'},
                 url: "../userController/findUserById",
                 data: {'id':id},
                 transformRequest:function (data) {return $.param(data);}
             }).success(successcb).error(errorcb);
		};
		
		registerAndLoginService.updateUser=function(user,successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/updateUser",
                 data: user
             }).success(successcb).error(errorcb);
		};
		
		registerAndLoginService.loginOut=function(successcb,errorcb)//传入的两个方法
		{
			 $http({
                 method: "POST",
                 url: "../userController/loginOut",
             }).success(successcb).error(errorcb);
		};
		
		registerAndLoginService.changePwd=function(id,oldpwd,newpwd,successcb,errorcb)//传入的两个方法
		{
			 $http({
                method: "POST",
                url: "../userController/changePwd",
                headers: {'Content-type': 'application/x-www-form-urlencoded'},
                data: {'id':id,"oldPwd":oldpwd,"newPwd":newpwd},
                transformRequest:function (data) {return $.param(data);}
            }).success(successcb).error(errorcb);
		};
		
		registerAndLoginService.readedAnouncement=function(loginNo,successcb,errorcb)//传入的两个方法
		{
			 $http({
               method: "POST",
               url: "../userController/readedAnouncement",
               headers: {'Content-type': 'application/x-www-form-urlencoded'},
               data: {'loginNo':loginNo},
               transformRequest:function (data) {return $.param(data);}
           }).success(successcb).error(errorcb);
		};
		return registerAndLoginService;
    
}]);