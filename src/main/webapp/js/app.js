//采用angularAMD规范写
define(["angular","angularAMD","allDirective","angular-ui-router","angularResource","angularUIBootstrap","bootstrap"],function(angular,angularAMD){
	//实例化angularJS
	var app = angular.module("app",['ui.router','ngResource',"ui.bootstrap.tpls","ui.bootstrap","directiveModel"]);

	//all scope , it can use at any where in the project . by 李桥
	app.run(["$rootScope","$state","$stateParams",function($rootScope, $state, $stateParams) {

	}]);

	/**
	 *  拦截器 拦截所有的HTTP请求
	 */
	app.factory('httpInterceptor', [ '$q', '$injector',function($q, $injector) {
		var httpInterceptor = {
				'responseError' : function(response) {
					if (response.status == 401) {
						var state = $injector.get('$state');
						//alert("登陆过时!");
						state.go("login");
						return true;
					} else if (response.status === 404) {
						return $q.reject(response);
					}else{
						if(String(response.status).charAt(0) == "5"){
							return $q.reject(response);
						}
					}
				},
				'response' : function(response) {
					return response;
				},
				'request':function(config){
					return config;
				}
		}
		return httpInterceptor;
	}]).config([ '$httpProvider', function($httpProvider) {
		$httpProvider.interceptors.push('httpInterceptor');
	}])

	/**
	 *  拦截器 拦截所有的HTTP请求
	 */
	app.factory('primaryDataInterceptor', [ '$q', '$injector',
	                                        function($q, $injector) {
		var primaryDataInterceptor = {
				'response' : function(response) {

				}
		}
		return primaryDataInterceptor;
	}]);


	//配置
	app.config(function($stateProvider, $urlRouterProvider,$rootScopeProvider){
		$urlRouterProvider.otherwise("/login");
		$stateProvider

		//登陆
		.state("login",angularAMD.route({
			url:"/login",
			controller:"login_registeController",
			templateUrl:"../views/login_register/loginForm.html",
			controllerUrl:["../views/login_register/js/login_registerService.js",
			               "../views/login_register/js/login_registerForm.js"]
		}))
		//注册
		.state("regist",angularAMD.route({
			url:"/regist",
			controller:"login_registeController",
			templateUrl:"../views/login_register/regist.html",
			controllerUrl:["../views/login_register/js/login_registerService.js",
			               "../views/login_register/js/login_registerForm.js"]
		}))
		.state("main",angularAMD.route({
			url:"/main",
			templateUrl:"../views/main/html/main.html",
			controller:"mainController",
			controllerUrl:["../views/main/js/main.js"]
		}))
		//mainTable
		.state("main.mainTable",angularAMD.route({
			url:"/mainTable/:extrcode/:folderName",
			templateUrl:"../views/main/html/mainTable.html",
			controller:'mainTableController',
			controllerUrl:["../views/main/js/mainTable.js",
			               "../css/bootstrap/js/bootstrap.min.js"]
		}))
		//日志列表
		.state("main.logList",angularAMD.route({
			url:"/logList",
			templateUrl:"../views/log/html/logList.html",
			controller:'logListController',
			controllerUrl:["../views/log/js/logList.js",
			               "../views/log/js/logService.js"],
		}))
		//个人中心
		.state("main.personnalCenter",angularAMD.route({
			url:"/personnalCenter/:id",
			templateUrl:"../views/personnal/html/personnalCenter.html",
			controller:"personnalCenterController",
			controllerUrl:["../views/personnal/js/personnalCenter.js",
			               "../views/login_register/js/login_registerService.js"],
		}))
		//用地列表
		.state("main.landList",angularAMD.route({
			url:"/landList",
			templateUrl:"../views/land/html/landList.html",
			controller:"landListController",
			controllerUrl:["../views/land/js/landList.js",
			               "../views/land/js/landService.js"]
		}))
		//用地新增
		.state("main.landAddForm",angularAMD.route({
			url:"/landAddForm",
			templateUrl:"../views/land/html/landForm.html",
			controller:"landFormController",
			controllerUrl:["../views/land/js/landForm.js",
			               "../views/land/js/landService.js"]
		}))
		//用地编辑
		.state("main.landEditForm",angularAMD.route({
			url:"/landEditForm/:id/:operate",
			templateUrl:"../views/land/html/landForm.html",
			controller:"landFormController",
			controllerUrl:["../views/land/js/landForm.js",
			               "../views/land/js/landService.js"]
		}))
		//用地查看
		.state("main.landDisplay",angularAMD.route({
			url:"/landDisplay/:id",
			templateUrl:"../views/land/html/landDisplay.html",
			controller:"landDisplayController",
			controllerUrl:["../views/land/js/landDisplay.js",
			               "../views/land/js/landService.js"]
		}))
	});
	return angularAMD.bootstrap(app);
});