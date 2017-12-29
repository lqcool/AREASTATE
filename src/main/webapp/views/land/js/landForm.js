angular.module("landFormModule",[]).
controller("landFormController",["$scope","$state","$stateParams","LandService",function($scope,$state,$stateParams,LandService){
	$scope.id = $stateParams.id;
	$scope.operate = $stateParams.operate;
	
	$scope.init = function(){
		$scope.land = {};
		if($scope.operate == "edit"){
			LandService.findLandById($scope.id,suc,ero);
			function suc(data){
				$scope.land = data;
			}
			function ero(error){
				alert(error);
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
		if($scope.operate=="edit"){
			LandService.updateLand($scope.land,suc,ero);
		}
		else{
			LandService.saveLand($scope.land,suc,ero);
		}
		function suc(data){
			$state.go("main.landList");
		}
		
		function ero(){
			
		}
	}
}]);
