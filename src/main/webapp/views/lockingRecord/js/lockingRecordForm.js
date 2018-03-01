angular.module("lockingRecordFormModule",[]).
controller("lockingRecordFormController",["$scope","$state","$stateParams","LockingRecordService","LandService","LandStateService",function($scope,$state,$stateParams,LockingRecordService,LandService,LandStateService){
	$scope.id = $stateParams.id;
	$scope.operate = $stateParams.operate;
	
	$scope.init = function(){
		$scope.lockingRecord = {};
		$scope.landDailyStates = {};
		$scope.lands = {};
		$scope.landDailyStatesDate = [];
		if($scope.operate == "edit"){
			
		}
		else{
			$("#loading").modal("show");
			//根据状态启用查询所有场地
			LandService.findAllLandsByState(suc,ero);
			function suc(data){
				$scope.lands = data;
				//绑定默认值
				$scope.lockingRecord.land = $scope.lands[0];
				$("#loading").modal("hide");
				//默认值
				$scope.getLandDailyState(0);
			}
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
		
	}
	
	$scope.getLandDailyState = function(number){
		$("#loading").modal("show");
		LandStateService.getLandDailyState($scope.lands[number].id,suc,ero);
		function suc(data){
			$scope.landDailyStates = data;
			$scope.landDailyStatesDate = [];
			for (var i = 0; i < $scope.landDailyStates.length; i++) {
				$scope.landDailyStatesDate.push({"text":$scope.fmtDate($scope.landDailyStates[i].date),"date":$scope.landDailyStates[i].date})
			}
			//绑定默认值
			$scope.lockingRecord.lockDate = $scope.fmtDate($scope.landDailyStates[0].date);
			$("#loading").modal("hide");
			//默认值
			$scope.getlandDailyStatesTimeQuantum(0);
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.getlandDailyStatesTimeQuantum = function(number){
		var index = 0;
		$scope.landDailyStatesTimeQuantum = [];
		
		if($scope.landDailyStates[number].amState == "可用"){
			$scope.landDailyStatesTimeQuantum[index++] = "上午";
		}
		if($scope.landDailyStates[number].pmState == "可用"){
			$scope.landDailyStatesTimeQuantum[index++] = "下午";
		}
		if($scope.landDailyStates[number].nightState == "可用"){
			$scope.landDailyStatesTimeQuantum[index++] = "晚上";
		}
		//绑定默认值
		$scope.lockingRecord.timeQuantum = $scope.landDailyStatesTimeQuantum[0];
	}
	
	$scope.$watch("lockingRecord.land", function(newValue, oldValue){
		if(newValue == oldValue){
			return;
		}
		$scope.myselect = document.getElementById('landSelect');
	    $scope.index = $scope.myselect.selectedIndex;
		$scope.getLandDailyState($scope.index);
	});
	
	$scope.$watch("lockingRecord.lockDate", function(newValue, oldValue){
		if(newValue == oldValue){
			return;
		}
		var myselect = document.getElementById('lockDateSelect');
		var index = myselect.selectedIndex;
		$scope.getlandDailyStatesTimeQuantum(index);
	});
	
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
	
	$scope.saveLockingRecord = function(){
		$("#effectiveing").modal("show");
		if($scope.operate=="edit"){
			LockingRecordService.updateLockingRecord($scope.lockingRecord,suc,ero);
		}
		else{
			LockingRecordService.saveLockingRecord($scope.lockingRecord,suc,ero);
		}
		function suc(data){
			$("#effectiveing").modal("hide");
			$state.go("main.lockingRecordList");
		}
		
		function ero(){
			$("#errorhapen").modal("show");
		}
	}
}]);
