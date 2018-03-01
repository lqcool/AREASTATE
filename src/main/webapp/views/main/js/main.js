angular.module("mainModule",["ui.bootstrap"])
.controller("mainController",["$rootScope","$timeout","$scope","$state","$uibModal","$window","RegisterAndLoginService",function($rootScope,$timeout,$scope,$state, $uibModal,$window,RegisterAndLoginService){
	$scope.init = function(){
		$scope.innitWindowStyle();
		$rootScope.usr = angular.fromJson(sessionStorage.getItem("currentUser"));
		$scope.items = [{"name":"用地状态一览表","url":"",childItems:[{"name":"用地状态列表","url":"main.landStateList"}]},
		                {"name":"我的用地锁定记录","url":"",childItems:[{"name":"我的用地锁定记录管理","url":"main.lockingRecordList"},{"name":"用地锁定申请","url":"main.lockingRecordForm"}]},
		                {"name":"公告记录","url":"",childItems:[{"name":"公告历史记录","url":"main.anouncementList"}]},
		                {"name":"个人中心","url":"",childItems:[{"name":"个人中心","url":"main.personnalCenter"}]}];
		$scope.topnavItems = [{"name":"用地状态列表","url":"main.landStateList"},
		                      {"name":"我的用地锁定记录管理","url":"main.lockingRecordList"},
		                      {"name":"公告历史记录","url":"main.anouncementList"},
		                      {"name":"个人中心","url":"main.personnalCenter"}];
		if($rootScope.usr&&$rootScope.usr.role=="admin"){
			$scope.items = [
			                {"name":"系统配置","url":"",childItems:[{"name":"系统参数配置列表","url":"main.sysConfigList"},{"name":"新增系统配置","url":"main.sysConfigAddForm"}]},
			                {"name":"用地管理","url":"",childItems:[{"name":"用地列表","url":"main.landList"},{"name":"新建用地","url":"main.landAddForm"}]},
			                {"name":"用户管理","url":"",childItems:[{"name":"用户列表","url":"main.operatorList"}]},
			                {"name":"用地状态一览表","url":"",childItems:[{"name":"用地状态列表","url":"main.landStateList"}]},
			                {"name":"用地分配与解除管理","url":"",childItems:[{"name":"用地分配与解除管理","url":"main.landAssignedAndReliveList"}]},
			                {"name":"我的用地锁定记录","url":"",childItems:[{"name":"我的用地锁定记录管理","url":"main.lockingRecordList"},{"name":"用地锁定申请","url":"main.lockingRecordForm"}]},
			                {"name":"公告管理","url":"",childItems:[{"name":"公告记录","url":"main.anouncementList"},{"name":"发布新公告","url":"main.anouncementAddForm"}]},
			                {"name":"个人中心","url":"",childItems:[{"name":"个人中心","url":"main.personnalCenter"}]}];
			$scope.topnavItems = [{"name":"系统配置","url":"main.sysConfigList"},
			                     // {"name":"用地管理","url":"main.landList"},
			                     // {"name":"用户管理","url":"main.operatorList"},
			                      {"name":"用地分配与解除管理","url":"main.landAssignedAndReliveList"},
			                      {"name":"我的用地锁定记录管理","url":"main.lockingRecordList"},
			                      {"name":"公告历史记录","url":"main.anouncementList"},
			                      {"name":"个人中心","url":"main.personnalCenter"},
			                      ];
		}
		//初始化引导
		$scope.initIntro();
		$scope.showIntroduce();
		//获取公告信息
		$timeout(function(){
			$scope.showNoReadAnouncement();
		},0);
		//路由到场地状态列表页面
		$state.go("main.landStateList");
	}

	$scope.goAim = function (url){
		if(url){
			$state.go(url);
		}
	}

	$scope.loginOut = function(){
		RegisterAndLoginService.loginOut(suc,ero);
		function suc(data){
			$state.go("login");
		};
		function ero(){
			$("#errorhapen").modal("show");
		};
	}

	/**
	 * 适应屏幕高度
	 */
	$scope.innitWindowStyle = function (){
		$("#leftnav").css("height",($rootScope.wHeight - $("#navb").height()-10) + "px");
		$("#rightctex").css("height",($rootScope.wHeight - $("#navb").height()-10) + "px");
	}
	
	window.onresize = function(){
		//获取浏览器的高度与宽度
		$rootScope.wHeight = $window.innerHeight;
		$("#leftnav").css("height",($rootScope.wHeight - $("#navb").height()-10) + "px");
		$("#rightctex").css("height",($rootScope.wHeight - $("#navb").height()-10) + "px");
	}

	$scope.showNoReadAnouncement = function(){
		if ($rootScope.usr.noReadAnouncement!=null){
			$("#anouncementWindow").modal("show");
			var anouncement = $rootScope.usr.noReadAnouncement;
			$("#anouncementTitle").html(anouncement.anouncementTitle);
			$("#anouncementContent").html(anouncement.anouncementContent);
			if(anouncement.urgency=="特急"){
				$("#mestype").css("background","#ff1717");
				$("#knowthatbtn").css({"background":"#ff1717","border":"none"});
			}
			else if(anouncement.urgency=="紧急"){
				$("#mestype").css("background","rgb(243, 167, 96)");
				$("#knowthatbtn").css({"background":"rgb(243, 167, 96)","border":"none"});
			}
			else {
				$("#mestype").css("background","#1fad09");
				$("#knowthatbtn").css({"background":"#1fad09","border":"none"});
			}
		}
	}

	/**读取公告**/
	$scope.readedIt = function(){
		RegisterAndLoginService.readedAnouncement($rootScope.usr.loginNo,suc,ero);
		function suc(data){
			$rootScope.usr.noReadAnouncement = null;
			sessionStorage.setItem("currentUser", JSON.stringify($rootScope.usr));
			$("#anouncementWindow").modal("hide");
		};
		function ero(){
			$("#errorhapen").modal("show");
		};
	}

	$scope.initIntro = function(){
		$scope.intro = introJs();
		$scope.intro.setOptions({
			steps: [
			        { 
			        	intro: "<h5 style='color:red;'>欢迎查看系统使用引导</h5>"
			        },
			        { 
			        	intro: "You <b>don't need</b> to define element to focus, this is a floating tooltip."
			        },
			        {
			        	element: document.querySelector('#leftnavbar'),
			        	intro: "This is a tooltip."
			        },
			        {
			        	//element: document.querySelectorAll('#step2')[0],
			        	intro: "Ok, wasn't that fun?",
			        	position: 'right'
			        },
			        {
			        	//element: '#step3',
			        	intro: 'More features, more fun.',
			        	position: 'left'
			        },
			        {
			        	//element: '#step4',
			        	intro: "Another step.",
			        	position: 'bottom'
			        },
			        {
			        	//element: '#step5',
			        	intro: 'Get it, use it.'
			        }
			        ]
		});
	}

	$scope.showIntroduce = function(){
		$scope.intro.start();
	}
}]);
