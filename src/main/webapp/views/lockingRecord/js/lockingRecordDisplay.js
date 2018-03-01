angular.module("lockingRecordDisplayModule",[]).
controller("lockingRecordDisplayController",["$scope","$state","$stateParams","LockingRecordService",function($scope,$state,$stateParams,LockingRecordService){
	$scope.code = $stateParams.code;
	
	$scope.init = function(){
		$("#loading").modal("show");
		LockingRecordService.findLockingRecordByCode($scope.code,suc,ero);
		function suc(data){
			$scope.lockingRecords = data;
			//$scope.lockingRecord.lockDate = $scope.fmtDate($scope.lockingRecord.lockDate);
			//$scope.lockingRecord.submitDate = $scope.fmtDate($scope.lockingRecord.submitDate);
			$("#loading").modal("hide");
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
		
	}
	
	/**
	 * 时间戳转换yyyy--mm--dd
	 */
	$scope.fmtDate = function(obj){
	    var date =  new Date(obj);
	    var y = 1900+date.getYear();
	    var m = "0"+(date.getMonth()+1);
	    var d = "0"+date.getDate();
	    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
	}
	
	$scope.cancel = function(){
		$state.go("main.lockingRecordList");
	}
}]);
