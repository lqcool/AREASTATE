	//config配置模块
	
	require.config({
		//baseUrl:用来指定加载模块的目录
		//baseUrl:"js/injs",
		//paths，是指定模块的加载路径。
		paths:{
			"jquery":"../js/jquery-2.1.1/jquery",
			"angular":"../js/angular/angular",
			"angularAMD":"../js/angular/angularAMD",
			"angular-ui-router":"../js/angular/angular-ui-router",
			"ngload":"../js/angular/ngload",
			"angularResource":"../js/angular/angular-resource",
			"treeControl":"../js/angular-tree/angular-tree-control",
			"ngFileUpload":"../js/ng-file-upload/ng-file-upload",
			"ngFileUploadShim":"../js/ng-file-upload/ng-file-upload-shim",
			"angularUIBootstrap":"../js/ui-bootstrap/ui-bootstrap-tpls-0.14.2",
			"bootstrap":"../css/bootstrap/js/bootstrap.min",
			"angularFileUpload":"../js/angular/angular-file-upload",
			//"bootstrap-table":"../js/bootstrap-table/bootstrap-table",
		},
		//shim:是配置不兼容的模块。
	    shim : {
	        "angular" : {
	            exports : "angular"
	        },
	        "angular-ui-router":["angular"],
	        "angularAMD":["angular"],
	        "ngload":["angularAMD"],
	        "ngResource":["angular"],
	        'angularResource': ['angular'],
	        'treeControl':['angular'],
	        'ngFileUpload':['angular'],
	        'ngFileUploadShim':['angular'],
	        'angularUIBootstrap':['angular'],
	        'bootstrap':['jquery'],
	        "angularFileUpload":["angular"],
	        "bootstrap-table":["bootstrap"]
	    },
	    //deps:用来指定依赖模块，requireJS会加载这个文件并执行。
	    deps : ['app']
	});

require(['jquery'],function($){
	window.$ = $;
});