angular.module("personnalCenterFormModule",[])
//这里注入service服务
.controller("personnalCenterFormController",["$scope","$state","RegisterAndLoginService",function($scope,$state,RegisterAndLoginService){
	//首先可以把用户id取出来，两种方式，第一通过跳到这个页面的路由传入参数；第二取出缓存里面的用户id
	$scope.goAim=function(){
		$state.go("main.personnalCenter");
	}
	
	/**
	 * personnalCenterForm.html加载的时候会调用init方法进行初始化，里面查询用户信息
	 */
	$scope.init = function (){
		//取缓存里面的用户id
		var user = JSON.parse(sessionStorage.getItem("currentUser"));
		if(user){
			$("#loading").modal("show");
			RegisterAndLoginService.findUserById(user.id,suc,ero);
			function suc(data){
				$scope.currentUser = data;
				$("#loading").modal("hide");
			}
			
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
	}
	/****更新个人信息**/
	
	$scope.updateUser=function(){
		$("#effectiveing").modal("show");
		RegisterAndLoginService.updateUser($scope.currentUser,suc,err);
		function suc(data){
			if(data!=null){
				$("#effectiveing").modal("hide");
				$state.go("main.personnalCenter");
			}
		}
		function err(error){
			$("#errorhapen").modal("show");
		}
	}
	
	
}]);