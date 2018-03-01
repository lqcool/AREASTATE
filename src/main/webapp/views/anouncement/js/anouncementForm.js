angular.module("announcementFormModule",[]).
controller("announcementFormController",["$scope","$timeout","$state","$stateParams","AnouncementService",function($scope,$timeout,$state,$stateParams,AnouncementService){
	
	$scope.id = $stateParams.id;
	$scope.operate = $stateParams.operate;
	
	$scope.init = function(){
		$scope.anouncement = {};
		if($scope.operate == "edit"){
			$("#loading").modal("show");
			AnouncementService.findAnouncementById($scope.id,suc,ero);
			function suc(data){
				$scope.anouncement = data;
				$("#loading").modal("hide");
			}
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
	}
	
	$scope.cancel = function(){
		$state.go("main.anouncementList");
	}

	$scope.saveAnouncement = function(){
		$("#confirmpublish").modal("hide");
		$("#effectiveing").modal("show");
		if($scope.operate=="edit"){
			AnouncementService.updateAnouncement($scope.anouncement,suc,ero);
		}
		else{
			AnouncementService.saveAnouncement($scope.anouncement,suc,ero);
		}
		function suc(data){
			$("#effectiveing").modal("hide");
			$state.go("main.anouncementList");
		}
		function ero(){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.openConfirm = function(){
		$timeout(function(){$("#confirmpublish").modal("show")},0);
	}
}]);
