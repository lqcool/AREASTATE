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
			"angularUIBootstrap":"../js/ui-bootstrap/ui-bootstrap-tpls-0.14.2",
			"bootstrap":"../css/bootstrap/js/bootstrap.min",
			'md5':"../js/md5/2.1/md5",
			"allDirective":"../views/directive/js/allDirective",
			"bootstrap-collapse":"../css/bootstrap/js/bootstrap-collapse",
			"ZeroClipboard":'../css/editer/third-party/zeroclipboard/ZeroClipboard.min',
			"ueditor":'../css/editer/angular-ueditor',
			"ueditorConf":'../css/editer/ueditor.config',
			'ueditorAll':'../css/editer/ueditor.all',
			"introJs":"../plugin/intro/intro",
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
	        'angularUIBootstrap':['angular'],
	        'bootstrap':['jquery'],
	        'bootstrap-collapse':['jquery'],
	        "angularFileUpload":["angular"],
	        "bootstrap-table":["bootstrap"],
	        "allDirective":["angular"],
	        'ueditor':['angular'],
	        'ueditorAll':['ueditorConf'],
	    },
	    //deps:用来指定依赖模块，requireJS会加载这个文件并执行。
	    deps : ['app']
	});
require( ['md5','bootstrap-collapse']);

require(['jquery','ZeroClipboard','introJs'],function($,ZeroClipboard,introJs){
	window.$ = $;
	window.ZeroClipboard = ZeroClipboard;
	window.introJs = introJs;
});