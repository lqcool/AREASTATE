angular.module("landDisplayModule",[]).
controller("landDisplayController",["$scope","$state","$stateParams","LandService",function($scope,$state,$stateParams,LandService){
	$scope.id = $stateParams.id;
	
	$scope.init = function(){
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
	
	$scope.cancel = function(){
		$state.go("main.landList");
	}
}]);
