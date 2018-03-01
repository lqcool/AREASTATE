angular.module("login_registeModule",[]).
controller("login_registeController",["$scope","$state","$cacheFactory","RegisterAndLoginService",function($scope,$state,$cacheFactory,RegisterAndLoginService){

	$scope.go = function(){
		$state.go("default");
	}

	$scope.init = function(){
		$scope.no = "";
		$scope.pwd = "";
		console.clear();
		$scope.todoSomething=function($event){
			if($event.keyCode==13){//回车
				if($scope.user.loginPwd.length < 32){
					$scope.user.loginPwd = hex_md5($scope.user.loginPwd);
				}
				RegisterAndLoginService.checkLoginUser($scope.user,suc,ero);
				function suc(data, status, headers, config){
					if(data.state === true){
						sessionStorage.setItem("currentUser", JSON.stringify(data.mes));
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
		}
	}

	$scope.create = function(){
		$scope.user = {};
		$scope.init();
	}
	//键盘事件


	//登陆
	$scope.checkLoginUser = function(){
		if($scope.user.loginPwd.length < 32){
			$scope.user.loginPwd = hex_md5($scope.user.loginPwd);
		}
		RegisterAndLoginService.checkLoginUser($scope.user,suc,ero);
		function suc(data, status, headers, config){
			if(data.state === true){
				sessionStorage.setItem("currentUser", JSON.stringify(data.mes));
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
		if(!$scope.no==null||$scope.no==""){
			$scope.eroMesage += " [账号不能为空] ";
		}
		if(!$scope.pwd==null||$scope.pwd==""){
			$scope.eroMesage += " [密码不能为空] ";
		}

		if($scope.eroMesage==""){
			$scope.user.loginNo = $scope.no;
			$scope.user.loginPwd = $scope.pwd;
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
