angular.module("sysConfigFormModule",[]).
controller("sysConfigFormController",["$scope","$state","$stateParams","SysConfigService",function($scope,$state,$stateParams,SysConfigService){
	$scope.id = $stateParams.id;
	$scope.operate = $stateParams.operate;
	
	$scope.init = function(){
		$scope.sysConfig = {};
		if($scope.operate == "edit"){
			$("#loading").modal("show");
			SysConfigService.findSysConfigById($scope.id,suc,ero);
			function suc(data){
				$scope.sysConfig = data;
				$("#loading").modal("hide");
			}
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
	}
	
	$scope.cancel = function(){
		$state.go("main.sysConfigList");
	}
	
	$scope.saveSysConfig = function(){
		$("#effectiveing").modal("show");
		if($scope.operate=="edit"){
			SysConfigService.updateSysConfig($scope.sysConfig,suc,ero);
		}
		else{
			$scope.sysConfig.inputDate = new Date();
			SysConfigService.saveSysConfig($scope.sysConfig,suc,ero);
		}
		function suc(data){
			$("#effectiveing").modal("hide");
			$state.go("main.sysConfigList");
		}
		
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
}]);
