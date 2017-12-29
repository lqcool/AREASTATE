angular.module("landListModule",[]).
controller("landListController",["$scope","$state","LandService",function($scope,$state,LandService){
	
	$scope.init = function(){
		LandService.findAllLands(suc,ero);
		function suc(data){
			$scope.landList = data;
		}
		function ero(error){
			alert(error);
		}
	}
	
	$scope.editLand = function(id){
		$state.go("main.landEditForm",{"id":id,"operate":"edit"});
	}
	
	$scope.displayLand = function(id){
		$state.go("main.landDisplay",{"id":id});
	}
	
	$scope.deleteLand = function(id){
		LandService.deleteLand(id,suc,ero);
		function suc(data){
			alert("删除成功");
			$scope.init();
		}
		function ero(error){
			alert(error);
		}
	}
}]);
