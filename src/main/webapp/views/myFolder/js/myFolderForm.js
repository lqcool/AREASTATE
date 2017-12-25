angular.module("mainModule",['ngFileUpload'])
.controller("mainController",["$scope","$state","MyFolderService",function($scope,$state,MyFolderService,Upload){
	$scope.create = function(){
		$scope.myFolder = {};
	}
	
	$scope.saveMyFolder = function(){
		MyFolderService.saveMyFolder($scope.myFolder,suc,ero);
		function suc(data){
			alert("保存成功");
			$scope.$emit("NEWFOLDERSAVED",$scope.myFolder);
		};
		
		function ero(ero){
			alert(ero);
		}
	}
}]);