angular.module("login_registeModule",[]).
controller("login_registeController",["$scope","$state","$cacheFactory","RegisterAndLoginService",function($scope,$state,$cacheFactory,RegisterAndLoginService){
	
	$scope.go = function(){
		$state.go("default");
	}
	
	$scope.init = function (){
		console.clear();
	}
	
	$scope.create = function(){
		$scope.user = {};
		$scope.init();
	}
	
	//登陆
	$scope.checkLoginUser = function(){
		RegisterAndLoginService.checkLoginUser($scope.user,suc,ero);
		function suc(data, status, headers, config){
			if(data.state === true){
				localStorage.setItem("currentUser", JSON.stringify(data.mes));
				$state.go("main");
			}
			else{
				alert(data.mes);
			}
		};
		
		function ero(ero){
			alert(ero);
		}
	}
	
	//注册
	$scope.regist = function(){
		$scope.eroMesage = "";
		if(!$scope.user.loginNo||$scope.user.loginNo==""){
			$scope.eroMesage += " [账号不能为空] ";
		}
		if(!$scope.user.loginPwd||$scope.user.loginPwd==""){
			$scope.eroMesage += " [密码不能为空] ";
		}
		if(!$scope.user.userName||$scope.user.userName==""){
			$scope.eroMesage += " [用户名不能为空] ";
		}
		
		if($scope.eroMesage==""){
			RegisterAndLoginService.registe($scope.user,suc,ero);
			function suc(data){
				alert(data[data.state]);
				if(data.state=="success"){
					$state.go("login");
				}
			};
			function ero(ero){
				alert(ero);
			}
		}
		else{
			alert($scope.eroMesage);
		}
	}
}]);
