angular.module("anouncementListModule",[]).
controller("anouncementListController",["$scope","$state","AnouncementService",function($scope,$state,AnouncementService){
	$scope.pageSize = 10;
	$scope.currentPage = 1;  
	$scope.searchCondition = "";
	$scope.init = function(){
/*		$("#loading").modal("show");
		AnouncementService.findAllAnouncements(suc,ero);
		function suc(data){
			$scope.anouncementList = data;
			$("#loading").modal("hide");
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}*/
		
		$("#loading").modal("show");
		AnouncementService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.anouncementList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.editAnouncement = function(id){
		$state.go("main.anouncementEditForm",{"id":id,"operate":"edit"});
	}
	
	
	$scope.toAddForm = function(){
		$state.go("main.anouncementAddForm");
	}
	
	/**
	 * 根据不同的紧急状态显示不同的样式
	 */
	$scope.displayAnouncement = function(anouncement){
		$("#anouncementTitle1").html(anouncement.anouncementTitle);
		$("#anouncementContent1").html(anouncement.anouncementContent);
		if(anouncement.urgency=="特急"){
			$("#mestype1").css("background","#ff1717");
			$("#knowthatbtn1").css({"background":"#ff1717","border":"none"});
		}
		else if(anouncement.urgency=="紧急"){
			$("#mestype1").css("background","rgb(243, 167, 96)");
			$("#knowthatbtn1").css({"background":"rgb(243, 167, 96)","border":"none"});
		}
		else {
			$("#mestype1").css("background","#1fad09");
			$("#knowthatbtn1").css({"background":"#1fad09","border":"none"});
		}
		$("#anouncementWindow1").modal("show");
	}
	
	$scope.deleteAnouncement = function(id){
		$("#effectiveing").modal("show");
		AnouncementService.deleteAnouncement(id,suc,ero);
		function suc(data){
			$("#effectiveing").modal("hide");
			$scope.init();
		}
		function ero(error){
			$("#errorhapen").modal("show");
		}
	}
	
	$scope.publish = function(anouncement){
		$("#effectiveing").modal("show");
		AnouncementService.publish(anouncement,suc,ero);
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
			AnouncementService.getSearchPageList(++$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.anouncementList = data.pageList;
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
			AnouncementService.getSearchPageList(--$scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
			function suc(data){
				$scope.anouncementList = data.pageList;
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
		AnouncementService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.anouncementList = data.pageList;
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
		AnouncementService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.anouncementList = data.pageList;
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
		AnouncementService.getSearchPageList($scope.currentPage,$scope.pageSize,$scope.searchCondition,suc,ero);
		function suc(data){
			$scope.anouncementList = data.pageList;
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
			$("#loading").modal("hide");
		};
		function ero(error){
			$("#errorhapen").modal("show");
		}
	} 
}]);
