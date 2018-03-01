angular.module("sysConfigDisplayModule",[]).
controller("sysConfigDisplayController",["$scope","$state","$stateParams","SysConfigService",function($scope,$state,$stateParams,SysConfigService){
	$scope.id = $stateParams.id;
	
	$scope.init = function(){
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
	
	$scope.cancel = function(){
		$state.go("main.sysConfigList");
	}
}]);
