angular.module("operatorListModule",[]).
controller("operatorListController",["$scope","$state","OperatorService",function($scope,$state,OperatorService){
	$scope.pageSize = 10;
	$scope.currentPage = 1;  
	$scope.searchCondition = "";
	$scope.init = function(){
		$("#loading").modal("show");
		OperatorService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.operatorList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.editOperator = function(id){
		$state.go("main.OperatorEditForm",{"id":id,"operate":"edit"});
	}
	
	$scope.updateUserRole = function(id,role){
		$("#effectiveing").modal("show");
		OperatorService.updateUserRole(id,role,suc,ero);
		function suc(data){
			$("#effectiveing").modal("hide");
			$scope.init();
		};
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
			OperatorService.getSearchPageList(++$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.operatorList = data.pageList;
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
			OperatorService.getSearchPageList(--$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.operatorList = data.pageList;
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
		OperatorService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.operatorList = data.pageList;
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
		OperatorService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.operatorList = data.pageList;
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
		OperatorService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.operatorList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	} 
	
	
	$scope.openConfirmDialog = function(mes,type){
		$("#updateRoleConfirm").modal("show");
		$("#updateRoleConfirmContent").html(mes+"?");
		$scope.type = type;
	}
}]);
