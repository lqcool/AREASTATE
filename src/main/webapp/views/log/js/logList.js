angular.module("logListModule",[])
.controller("logListController",["$scope","$state","LogService",function($scope,$state,LogService){
	$scope.init = function(){
		$scope.initalPageList();
	}

	$scope.reportData = [];  
	$scope.maxSize = 3;  
	$scope.pageSize = 15;
	$scope.currentPage = 1;  
	
	$scope.nextPage = function (event) { 
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 ++;
		if(couputeResult<$scope.totalPage){
			//禁用按钮
			LogService.getPageList(++$scope.currentPage,$scope.pageSize,suc,ero);
			function suc(data){
				$scope.logList = data.pageList;  
			};
			function ero(error){
				alert(error);
			}
		}
		else{
			alert("最后一页");
		}
	}  
	
	$scope.lastPage = function (event) { 
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 --;
		if(couputeResult>1){
			//禁用按钮
			LogService.getPageList(--$scope.currentPage,$scope.pageSize,suc,ero);
			function suc(data){
				$scope.logList = data.pageList;  
				//$scope.totalItems = data.totalItems;  
			};
			function ero(error){
				alert(error);
			}
		}
		else{
			alert("第一页");
		}
	} 

	$scope.initalPageList = function () {  
		LogService.getPageList($scope.currentPage,$scope.pageSize,suc,ero);
		function suc(data){
			$scope.logList = data.pageList;  
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
		};
		function ero(error){
			alert(error);
		}
	}  
}]);