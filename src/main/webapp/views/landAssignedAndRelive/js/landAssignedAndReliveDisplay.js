angular.module("landAssignedAndReliveDisplayModule",[]).
controller("landAssignedAndReliveDisplayController",["$scope","$state","$stateParams","LockingRecordService",function($scope,$state,$stateParams,LockingRecordService){
	$scope.code = $stateParams.code;
	
	$scope.init = function(){
		$("#loading").modal("show");
		LockingRecordService.findLockingRecordByCode($scope.code,suc,ero);
		function suc(data){
			$scope.lockingRecords = data;
			$("#loading").modal("hide");
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
		
	}
	
	$scope.cancel = function(){
		$state.go("main.landAssignedAndReliveList");
	}
}]);
