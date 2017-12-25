angular.module("personnalModule",[])
.controller("personnalCenterController",["$scope","$state","$stateParams","RegisterAndLoginService",function($scope,$state,$stateParams,RegisterAndLoginService){
	$scope.id = $stateParams.id;
	$scope.oldPwd = "";
	$scope.newPwd = "";
	$scope.init = function(){
		RegisterAndLoginService.findUserById($scope.id,suc,ero);
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
		$state.go("main",{reload:true});
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