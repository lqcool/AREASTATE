angular.module("landFormModule",[]).
controller("landFormController",["$scope","$state","$stateParams","LandService",function($scope,$state,$stateParams,LandService){
	$scope.id = $stateParams.id;
	$scope.operate = $stateParams.operate;
	
	$scope.init = function(){
		$scope.land = {};
		if($scope.operate == "edit"){
			$("#loading").modal("show");
			LandService.findLandById($scope.id,suc,ero);
			function suc(data){
				$scope.land = data;
				$("#loading").modal("hide");
			}
			
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
		else{
			$scope.land.code = "LAND"+(new Date()).getTime();
		}
		
	}
	
	$scope.cancel = function(){
		$state.go("main.landList");
	}
	
	$scope.saveLand = function(){
		$("#effectiveing").modal("show");
		if($scope.operate=="edit"){
			LandService.updateLand($scope.land,suc,ero);
		}
		else{
			LandService.saveLand($scope.land,suc,ero);
		}
		function suc(data){
			$("#effectiveing").modal("hide");
			$state.go("main.landList");
		}
		
		function ero(){
			$("#errorhapen").modal("show");
		}
	}
}]);
