//采用angularAMD规范写
define(["angular","angularAMD","angular-ui-router","angularResource","angularUIBootstrap","bootstrap","treeControl","ngFileUpload","angularFileUpload"],function(angular,angularAMD){
	//实例化angularJS
	var app = angular.module("app",['ui.router','ngResource',"ui.bootstrap.tpls","ui.bootstrap","treeControl","ngFileUpload","angularFileUpload"]);

	//all scope , it can use at any where in the project . by 李桥
	app.run(["$rootScope","$state","$stateParams","Upload","FileUploader",function($rootScope, $state, $stateParams,Upload,FileUploader) {
		$rootScope.treeOptions = {
				nodeChildren: "children",
				dirSelectable: true,
				injectClasses: {
					ul: "a1",
					li: "a2",
					liSelected: "a7",
					iExpanded: "a3",
					iCollapsed: "a4",
					iLeaf: "a5",
					label: "a6",
					labelSelected: "a8"
				}
		}

		$rootScope.dataForTheTree =
			[
			 // {folderName:"我的文件",extrcode:"0000",children:[{folderName:'图片',children:[]}]}
			 ];
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

		.state("login",angularAMD.route({
			url:"/login",
			controller:"login_registeController",
			templateUrl:"../views/login_register/login.html",
			controllerUrl:["../views/login_register/js/login_registerService.js",
			               "../views/login_register/js/login_registerForm.js"]//切记，这里一定是一个数组
		}))
		.state("regist",angularAMD.route({
			url:"/regist",
			controller:"login_registeController",
			templateUrl:"../views/login_register/regist.html",
			controllerUrl:["../views/login_register/js/login_registerService.js",
			               "../views/login_register/js/login_registerForm.js"]//切记，这里一定是一个数组
		}))

		.state("main",angularAMD.route({
			url:"/main",
			templateUrl:"../views/main/html/main.html",
			controller:"mainController",
			controllerUrl:["../views/main/js/main.js",
			               "../css/bootstrap/js/bootstrap.min.js",
			               "../js/ng-file-upload/ng-file-upload.js",
			               "../js/ng-file-upload/ng-file-upload-shim.js",
			               "../views/myFolder/js/myFolderService.js",
			               "../views/login_register/js/login_registerService.js"]
		}))
		.state("main.myFolderForm",angularAMD.route({
			url:"/myFolderForm",
			templateUrl:"../views/myFolder/html/myFolderForm.html",
			controller:'mainController',
			controllerUrl:["../views/myFolder/js/myFolderForm.js",
			               "../views/myFolder/js/myFolderService.js"]
		}))
		.state("main.mainTable",angularAMD.route({
			url:"/mainTable/:extrcode/:folderName",
			templateUrl:"../views/main/html/mainTable.html",
			controller:'mainTableController',
			controllerUrl:["../views/main/js/mainTable.js",
			               "../css/bootstrap/js/bootstrap.min.js",
			               "../js/ng-file-upload/ng-file-upload.js",
			               "../js/ng-file-upload/ng-file-upload-shim.js",
			               "../views/myFolder/js/myFolderService.js",
			               "../views/myFile/js/myFileService.js"]
		}))
		.state("main.myFileList",angularAMD.route({
			url:"/myFileList/:searchCondition",
			templateUrl:"../views/myFile/html/myFileList.html",
			controller:'myFileListController',
			controllerUrl:["../views/myFile/js/myFileList.js",
			               "../views/myFile/js/myFileService.js"],
		}))
		.state("main.logList",angularAMD.route({
			url:"/logList",
			templateUrl:"../views/log/html/logList.html",
			controller:'logListController',
			controllerUrl:["../views/log/js/logList.js",
			               "../views/log/js/logService.js"],
		}))
		.state("main.personnalCenter",angularAMD.route({
			url:"/personnalCenter/:id",
			templateUrl:"../views/personnal/html/personnalCenter.html",
			controller:"personnalCenterController",
			controllerUrl:["../views/personnal/js/personnalCenter.js",
			               "../views/login_register/js/login_registerService.js"],
		}))
	});
	return angularAMD.bootstrap(app);
});