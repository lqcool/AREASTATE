angular.module("landDisplayModule",[]).
controller("landDisplayController",["$scope","$state","$stateParams","LandService",function($scope,$state,$stateParams,LandService){
	$scope.id = $stateParams.id;
	
	$scope.init = function(){
		LandService.findLandById($scope.id,suc,ero);
		function suc(data){
			$scope.land = data;
		}
		function ero(error){
			alert(error);
		}
		
	}
	
	$scope.cancel = function(){
		$state.go("main.landList");
	}
}]);
