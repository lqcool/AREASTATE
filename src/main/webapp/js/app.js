//采用angularAMD规范写
define(["angular","angularAMD","allDirective","angular-ui-router","angularResource","angularUIBootstrap","bootstrap","ueditorAll","ueditor","ZeroClipboard","introJs"],function(angular,angularAMD){
	//实例化angularJS
	var app = angular.module("app",['ui.router','ngResource',"ui.bootstrap.tpls","ui.bootstrap","directiveModel","ng.ueditor"]);

	//all scope , it can use at any where in the project . by 李桥
	app.run(["$rootScope","$state","$stateParams","$window",function($rootScope, $state, $stateParams,$window) {
		//获取浏览器的高度与宽度
		$rootScope.wHeight = $window.innerHeight;
		
		$rootScope.pageSizesAry = [{size:5},
		                           {size:10},
		                           {size:15}];
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
			controllerUrl:["../views/main/js/main.js",
			               "../views/login_register/js/login_registerService.js"]
		}))
		//日志列表
		.state("main.logList",angularAMD.route({
			url:"/logList",
			templateUrl:"../views/log/html/logList.html",
			controller:'logListController',
			controllerUrl:["../views/log/js/logList.js",
			               "../views/log/js/logService.js"],
		}))
		/****************************************operator Start****************************************************/
		//操作员列表
		.state("main.operatorList",angularAMD.route({
			url:"/operatorList",
			templateUrl:"../views/operator/html/operatorList.html",
			controller:"operatorListController",
			controllerUrl:["../views/operator/js/operatorList.js",
			               "../views/operator/js/operatorService.js"]
		}))
		/****************************************operator End****************************************************/
		/****************************************PersonnalCenter Start****************************************************/
		//个人中心
		.state("main.personnalCenter",angularAMD.route({
			url:"/personnalCenter",
			templateUrl:"../views/personnal/html/personnalCenter.html",
			controller:"personnalCenterController",
			controllerUrl:["../views/personnal/js/personnalCenter.js",
			               "../views/login_register/js/login_registerService.js"],
		}))
		/****************************************Personnalcenter End****************************************************/
		/****************************************Land Start****************************************************/
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
		/****************************************Land End****************************************************/
		/****************************************SysConfig Start****************************************************/
		//系统配置咧白哦
		.state("main.sysConfigList",angularAMD.route({
			url:"/sysConfigList",
			templateUrl:"../views/sysConfig/html/sysConfigList.html",
			controller:"sysConfigListController",
			controllerUrl:["../views/sysConfig/js/sysConfigList.js",
			               "../views/sysConfig/js/sysConfigService.js"]
		}))
		//新增系统配置
		.state("main.sysConfigAddForm",angularAMD.route({
			url:"/sysConfigAddForm",
			templateUrl:"../views/sysConfig/html/sysConfigForm.html",
			controller:"sysConfigFormController",
			controllerUrl:["../views/sysConfig/js/sysConfigForm.js",
			               "../views/sysConfig/js/sysConfigService.js"]
		}))
		//编辑系统配置
		.state("main.sysConfigEditForm",angularAMD.route({
			url:"/sysConfigEditForm/:id/:operate",
			templateUrl:"../views/sysConfig/html/sysConfigForm.html",
			controller:"sysConfigFormController",
			controllerUrl:["../views/sysConfig/js/sysConfigForm.js",
			               "../views/sysConfig/js/sysConfigService.js"]
		}))
		//查看系统配置
		.state("main.sysConfigDisplay",angularAMD.route({
			url:"/sysConfigDisplay/:id",
			templateUrl:"../views/sysConfig/html/sysConfigDisplay.html",
			controller:"sysConfigDisplayController",
			controllerUrl:["../views/sysConfig/js/sysConfigDisplay.js",
			               "../views/sysConfig/js/sysConfigService.js"]
		}))
		/****************************************SysConfig End****************************************************/
		/****************************************LandState Start****************************************************/
		//状态一览
		.state("main.landStateList",angularAMD.route({
			url:"/landStateList",
			templateUrl:"../views/landState/html/landStateList.html",
			controller:"landStateListController",
			controllerUrl:["../views/landState/js/landStateList.js",
			               "../views/landState/js/landStateService.js",
			               "../views/land/js/landService.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		/****************************************LandState End****************************************************/
		/****************************************lockingRecord Start****************************************************/
//		状态一览
		.state("main.lockingRecordForm",angularAMD.route({
			url:"/lockingRecordForm",
			templateUrl:"../views/lockingRecord/html/lockingRecordForm.html",
			controller:"lockingRecordFormController",
			controllerUrl:["../views/lockingRecord/js/lockingRecordForm.js",
			               "../views/lockingRecord/js/lockingRecordService.js",
			               "../views/land/js/landService.js",
			               "../views/landState/js/landStateService.js"]
		}))
		.state("main.lockingRecordList",angularAMD.route({
			url:"/lockingRecordList",
			templateUrl:"../views/lockingRecord/html/lockingRecordList.html",
			controller:"lockingRecordListController",
			controllerUrl:["../views/lockingRecord/js/lockingRecordList.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		.state("main.lockingRecordDisplay",angularAMD.route({
			url:"/lockingRecordDisplay/:code",
			templateUrl:"../views/lockingRecord/html/lockingRecordDisplay.html",
			controller:"lockingRecordDisplayController",
			controllerUrl:["../views/lockingRecord/js/lockingRecordDisplay.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		.state("main.lockingRecordEditForm",angularAMD.route({
			url:"/lockingRecordEditForm/:id/:operate",
			templateUrl:"../views/lockingRecord/html/lockingRecordForm.html",
			controller:"lockingRecordFormController",
			controllerUrl:["../views/lockingRecord/js/lockingRecordForm.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		/****************************************lockingRecord End****************************************************/
		.state("main.landAssignedAndReliveList",angularAMD.route({
			url:"/landAssignedAndReliveList",
			templateUrl:"../views/landAssignedAndRelive/html/landAssignedAndReliveList.html",
			controller:"landAssignedAndReliveListController",
			controllerUrl:["../views/landAssignedAndRelive/js/landAssignedAndReliveList.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		.state("main.landAssignedAndReliveDisplay",angularAMD.route({
			url:"/landAssignedAndReliveDisplay/:code",
			templateUrl:"../views/landAssignedAndRelive/html/landAssignedAndReliveDisplay.html",
			controller:"landAssignedAndReliveDisplayController",
			controllerUrl:["../views/landAssignedAndRelive/js/landAssignedAndReliveDisplay.js",
			               "../views/lockingRecord/js/lockingRecordService.js"]
		}))
		/****************************************anouncement Start****************************************************/
		.state("main.anouncementAddForm",angularAMD.route({
			url:"/anouncementAddForm",
			templateUrl:"../views/anouncement/html/anouncementForm.html",
			controller:"announcementFormController",
			controllerUrl:["../views/anouncement/js/anouncementForm.js",
			               "../views/anouncement/js/anouncementService.js"]
		}))
		.state("main.anouncementEditForm",angularAMD.route({
			url:"/anouncementEditForm/:operate/:id",
			templateUrl:"../views/anouncement/html/anouncementForm.html",
			controller:"announcementFormController",
			controllerUrl:["../views/anouncement/js/anouncementForm.js",
			               "../views/anouncement/js/anouncementService.js"]
		}))
		.state("main.anouncementList",angularAMD.route({
			url:"/anouncementList",
			templateUrl:"../views/anouncement/html/anouncementList.html",
			controller:"anouncementListController",
			controllerUrl:["../views/anouncement/js/anouncementList.js",
			               "../views/anouncement/js/anouncementService.js"]
		}))
		/****************************************anouncement End****************************************************/
	});
	return angularAMD.bootstrap(app);
});