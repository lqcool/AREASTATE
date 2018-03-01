/**
 * 
 */
angular.module("personnalCenterModifyPass",[])
.controller("personnalCenterModifyPassController",["$scope","RegisterAndLoginService","$state",function($scope,RegisterAndLoginService,$state){
	
	$scope.oldPwd = "";
	$scope.newPwd = "";
	
	$scope.init = function(){
		var user=JSON.parse(sessionStorage.getItem("currentUser"));
		RegisterAndLoginService.findUserById(user.id,suc,ero);
		function suc(data){
			$scope.user = data;
		}
		function ero(error){
			console.log(error);
		}
	}
	$scope.canEdit = function(){
		$scope.canedit = true;
	}
	
	$scope.back = function(){
		$state.go("main.personnalCenter");
	}
	
	$scope.updateUser = function(){
		if($scope.oldPwd!=$scope.user.loginPwd){
			alert("旧密码输入不正确");
			return;
		}
		else if($scope.newPwd === ""){
			alert("密码不能为空");
			return ;
		}
		else {
			$scope.user.loginPwd = $scope.newPwd;
			RegisterAndLoginService.updateUser($scope.user,suc,ero);
			
			function suc(data){
				if(data!=null){
					alert("修改成功");
					$state.go("login");
				}
				else{
					alert("修改失败，请联系管理员");
				}
			}
			
			function ero(error){
				console.log(error);
			}
		}
		
	}
}]);