angular.module("landStateListModule",["ui.bootstrap"]).
controller("landStateListController",["$scope","$state","$rootScope","$uibModal","LandStateService","LandService","LockingRecordService",function($scope,$state,$rootScope,$uibModal,LandStateService,LandService,LockingRecordService){
	
	$scope.init = function(){
		$scope.applyList = [];
		$("#loading").modal("show");
		LandService.findAllLandsByState(suc1,ero1);
		function suc1(data){
			$scope.landList = data;
			$scope.landAvailable = ($scope.landList.length != 0) ? true : false;
			if($scope.landAvailable){
				$scope.currentLand = $scope.landList[0];
				LandStateService.getLandDailyState($scope.landList[0].id,suc2,ero2);
				function suc2(landDailyStates){
					$scope.landDailyStates = landDailyStates;
					$("#loading").modal("hide");
				}
				function ero2(error){
					$("#errorhapen").modal("show");
				}
			}
		}
		function ero1(error){
			$("#errorhapen").modal("show");
		}
	}

	$scope.getLandDailyState = function(land,self){
		var targetEle = $(self.target);
		targetEle.attr("class", "landAClick"); 
		var siblingsEle = targetEle.siblings("a");
		for(var i = 0; i < siblingsEle.length; i ++){
			var ele = $(siblingsEle[i]);
			ele.attr("class","landAinit");
		}
		$("#loading").modal("show");
		$scope.currentLand = land;
		LandStateService.getLandDailyState(land.id,suc,ero);
		function suc(data){
			$scope.applyList = [];
			$scope.landDailyStates = data;
			$("#loading").modal("hide");
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.usrselect = function(land,date,dateStage,flag){
		if(flag==true){
			var newAply = {"land":land,"lockDate":date,"timeQuantum":dateStage};
			$scope.applyList.push(newAply);
		}
		else{
			for(var i = 0; i < $scope.applyList.length; i ++){
				if($scope.applyList[i].land.landName==land.landName&&$scope.applyList[i].lockDate==date&&$scope.applyList[i].timeQuantum==dateStage){
					$scope.applyList.splice(i,1);
				}
			}
		}
	}
	
	/**
	 * 保存多条数据
	 */
	$scope.saveLockingRecords = function(){
		$("#effectiveing").modal("show");
		LockingRecordService.saveLockingRecords($scope.applyList,suc,ero);
		function suc(data){
			$("#effectiveing").modal("hide");
			$scope.init();
			$scope.code = data.code;
			$("#codeResult").modal("show");
		}
		
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.cancel = function(){
		$scope.init();
	}

	//打开dialog的函数
//	$scope.newapplycation= function(land,date,dateStage){
//		$scope.lockingRecord = {};
//		$scope.lockingRecord.land = land;
//		$scope.lockingRecord.timeQuantum = dateStage;
//		$scope.lockingRecord.lockDate = date;
//		$uibModal.open({
//			size:"md",
//			animation:true,  
//			templateUrl:"newapplycation.html",//dialog的id，与html建立的template的id一致
//			controller:"applylocklandcontroller",//指定dialog的controller
//			resolve: {    
//				lockingRecord:function(){  
//					return angular.copy($scope.lockingRecord);
//				}  
//			} ,
//		});
//	};
}])
.controller("applylocklandcontroller",function($scope,$state,$rootScope,$modalInstance,lockingRecord,LockingRecordService){
	$scope.lockingRecord = lockingRecord;
	//定义dialog中的取消按钮的点击事件的处理函数
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};

	$scope.saveLockingRecord = function(){
		$modalInstance.dismiss('cancel');
		$("#effectiveing").modal("show");
		LockingRecordService.saveLockingRecord($scope.lockingRecord,suc,ero);
		function suc(data){
			$("#effectiveing").modal("hide");
			$state.go("main.lockingRecordList");
		}

		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
});
