angular.module("mainTableModule",["ui.bootstrap","ngFileUpload","angularFileUpload"])
.controller("mainTableController",["$http","$stateParams","$rootScope","$scope","$state","MyFolderService","MyFileService","$uibModal","Upload","FileUploader",function($http,$stateParams,$rootScope,$scope,$state,MyFolderService,MyFileService, $uibModal,Upload,FileUploader){
	$scope.extrcode = $stateParams.extrcode;
	$scope.folderName = $stateParams.folderName;
	$scope.init = function(){
		if($stateParams.extrcode){
			MyFolderService.findChildFolderByExtrcode($stateParams.extrcode,suc,ero);
			function suc(data){
				//获取文件夹
				$scope.childFolders = data.childFolders;
				//获取文件
				//$scope.childFiles = data.childFiles;
				$scope.initalPageList();
			};
			function ero(error){
				alert(error);
			}
		}
	}

	$scope.goAimFolder = function(node){
		$rootScope.folderName = node.folderName;
		$state.go("main.mainTable",{"extrcode":node.extrcode});
	}

	$scope.reportData = [];  
	$scope.maxSize = 3;  
	$scope.pageSize = 3;
	$scope.currentPage = 1;  

	$scope.next = function(){
		alert("dfdfjdlk");
	}


	$scope.nextPage = function (event) { 
		console.log(event);
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 ++;
		if(couputeResult<$scope.totalPage){
			//禁用按钮
			MyFileService.getPageList(++$scope.currentPage,$scope.pageSize,$stateParams.extrcode,suc,ero);
			function suc(data){
				$scope.childFiles = data.pageList;  
				//$scope.totalItems = data.totalItems;  
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
		console.log(event);
		var computeAtr1 = $scope.currentPage;
		var couputeResult = computeAtr1 --;
		if(couputeResult>1){
			//禁用按钮
			MyFileService.getPageList(--$scope.currentPage,$scope.pageSize,$stateParams.extrcode,suc,ero);
			function suc(data){
				$scope.childFiles = data.pageList;  
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
		MyFileService.getPageList($scope.currentPage,$scope.maxSize,$stateParams.extrcode,suc,ero);
		function suc(data){
			$scope.childFiles = data.pageList;  
			$scope.totalItems = data.totalItems;  
			$scope.totalPage = Math.ceil($scope.totalItems/$scope.pageSize);
		};
		function ero(error){
			alert(error);
		}
	}  

	$scope.deleteFile = function(id){
		MyFileService.deleteFile(id,suc,ero);
		function suc(data){
			if(data > 0){
				$scope.init();
			}
			else{
				alert("由于某些原因，未能够正确删除！");
			}
		};
		function ero(error){
			alert(error);
		}
	}

	//下载功能
	$scope.download = function(resourceurl){
		window.open("/AREASTATE/com/frame/servlet/FileDownloadServlet?resourceurl="+resourceurl);
	}
	
	//打开dialog的函数
	$scope.openRenameFileDialog= function(file){
		$uibModal.open({
			size:"sm",
			animation:true,  
			templateUrl:"renameFile1.html",//dialog的id，与html建立的template的id一致
			controller:"renameFileController1",//指定dialog的controller
			resolve: {    
				file:function(){  
                   return angular.copy(file);
               }  
			} ,
		});
	};
	
	//打开删除文件确认框
	$scope.openConfirmDialog = function(id){
		$uibModal.open({
			size:"sm",
			animation:true,  
			templateUrl:"confirm.html",//dialog的id，与html建立的template的id一致
			controller:"deleteConfirmDialogCtrl",//指定dialog的controller
		}).result.then(function (result) {  
			console.log(result);
			MyFileService.deleteFile(id,suc,ero);
			function suc(data){
				if(data > 0){
					$scope.init();
				}
				else{
					alert("由于某些原因，未能够正确删除！");
				}
			};
			function ero(error){
				alert(error);
			}
		}, function (reason) {    
			console.log(reason);//点击空白区域，总会输出backdrop click，点击取消，则会暑促cancel    

		});  
	}
}]).controller("renameFileController1",function($scope,$rootScope,$modalInstance,file,MyFileService){
	console.log($modalInstance);
	$scope.file = file;
	$scope.fileName = file.fileName.substr(0,file.fileName.lastIndexOf("."));
	$scope.subFex = file.fileName.substr(file.fileName.lastIndexOf("."));
	$scope.newFileName = "";
	//定义dialog中的取消按钮的点击事件的处理函数
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};

	$scope.renameFile = function(){
		var currentUser = localStorage.getItem("currentUser");
		if($scope.newFileName.length!=0){
			MyFileService.renameFile($scope.newFileName + $scope.subFex,$scope.file.id,suc,ero);
			function suc(data){
				$modalInstance.dismiss('cancel');
			};
			function ero(error){
				alert(error);
			}
		}
		else{
			alert("请输入文件名称");
		}
	}
}).controller("deleteConfirmDialogCtrl",function($scope,$modalInstance){
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};
	
	$scope.confirm = function(){
		$modalInstance.close("确认删除");
	}
});