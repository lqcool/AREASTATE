angular.module("landListModule",[]).
controller("landListController",["$scope","$state","LandService",function($scope,$state,LandService){
	$scope.pageSize = 10;
	$scope.currentPage = 1;  
	$scope.searchCondition = "";
	
	$scope.init = function(){
		$("#loading").modal("show");
		LandService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.landList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.toAddForm = function(){
		$state.go("main.landAddForm");
	}

	$scope.editLand = function(id){
		$state.go("main.landEditForm",{"id":id,"operate":"edit"});
	}

	$scope.displayLand = function(id){
		$state.go("main.landDisplay",{"id":id});
	}

	$scope.deleteLand = function(id){
		$("#effectiveing").modal("show");
		LandService.deleteLand(id,suc,ero);
		function suc(data){
			$("#effectiveing").modal("hide");
			$scope.init();
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}

	/**
	 * 下一页
	 */
	$scope.nextPage = function () { 
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 ++;
		if(couputeResult<$scope.totalPage){
			$("#loading").modal("show");
			//禁用按钮
			LandService.getSearchPageList(++$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.landList = data.pageList;
				$scope.totalItems = data.totalItems;  
				$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
				$("#loading").modal("hide");
			};
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
		else{
			alert("最后一页");
		}
	}  

	$scope.lastPage = function () { 
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 --;
		if(couputeResult>1){
			$("#loading").modal("show");
			//禁用按钮
			LandService.getSearchPageList(--$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.landList = data.pageList;
				$scope.totalItems = data.totalItems;  
				$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
				$("#loading").modal("hide");
			};
			function ero(error){
				$("#errorhapen").modal("show");
			}
		}
		else{
			alert("第一页");
		}
	} 


	/**
	 * 首页
	 */
	$scope.firstPage = function () { 
		$("#loading").modal("show");
		$scope.currentPage=1;
		LandService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.landList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	} 

	$scope.endPage = function () {
		$("#loading").modal("show");
		$scope.currentPage=1;
		$scope.currentPage=$scope.totalPage;
		LandService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.landList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	} 

	$scope.initalPageList = function () {  
		$("#loading").modal("show");
		$scope.currentPage = 1;
		LandService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.landList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	} 
	
	$scope.changePageSize = function(){
		$("#loading").modal("show");
		$scope.currentPage = 1;
		LandService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.landList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
}]);
