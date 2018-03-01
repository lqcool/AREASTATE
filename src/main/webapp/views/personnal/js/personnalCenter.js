angular.module("personnalModule",[])
.controller("personnalCenterController",["$scope","$state","RegisterAndLoginService",function($scope,$state,RegisterAndLoginService){

	$scope.init = function(){
		var user=JSON.parse(sessionStorage.getItem("currentUser"));
		$("#loading").modal("show");
		RegisterAndLoginService.findUserById(user.id,suc,ero);
		function suc(data){
			$scope.user = data;
			$("#loading").modal("hide");
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.changePwd = function(){
		var user=JSON.parse(sessionStorage.getItem("currentUser"));
		if($scope.oldPwd.length < 32){
			$scope.oldPwd = hex_md5($scope.oldPwd);
		}
		RegisterAndLoginService.changePwd(user.id,$scope.oldPwd,$scope.newPwd,suc,ero);
		function suc(data){
			if(data.state==true){
				alert(data.mes);
				RegisterAndLoginService.loginOut(suc1,ero1);
				function suc1(dat){
					$state.go("login");
				}
				function ero1(esr){
					alert(esr);
				}
			}
			else{
				alert(data.mes);
			}
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.toLandStateList = function(){
		$state.go("main.landStateList");
	}
	
	$scope.modifyInformation=function(){
		$state.go("main.personnalCenterEditForm");
	}
	$scope.modifyPassword=function(){
		$state.go("main.personnalCenterModifyPass");
	}
	
}]);