angular.module("mainModule",["ui.bootstrap","ngFileUpload","angularFileUpload"])
.controller("mainController",["$rootScope","$scope","$state","MyFolderService","$uibModal","Upload","FileUploader","RegisterAndLoginService",function($rootScope,$scope,$state,MyFolderService, $uibModal,Upload,FileUploader,RegisterAndLoginService){
	$scope.searchCondition = "";
	$rootScope.folderName = "";
	$scope.init = function(){
		$scope.currentUser = JSON.parse(localStorage.getItem("currentUser"));
		MyFolderService.findFirstLayerfolderFoldersByUserId($scope.currentUser.id,suc1,ero1);
		function suc1(data){
			$rootScope.dataForTheTree = data;
			$scope.firstLayerFolder = data;
			$rootScope.perFolderLength = $rootScope.dataForTheTree.length;
		};
		function ero1(error){
			alert(error);
		}
		
		MyFolderService.findAllFoldersByUserId($scope.currentUser.id,suc2,ero2);
		function suc2(data){
			$rootScope.currentUserAllFolders = data;
		};
		function ero2(error){
			alert(error);
		}
	}
	
	$scope.goPersonnalCenter = function(){
		$state.go("main.personnalCenter",{id:JSON.parse(localStorage.getItem("currentUser")).id});
	}
	
	$scope.goAimFolder = function(node){
		$state.go("main.mainTable",{"extrcode":node.extrcode});
	}

	$rootScope.$on("NEWFOLDERSAVED",function(event){
		$scope.init();
	});
	
	$scope.loginOut = function(){
		RegisterAndLoginService.loginOut(suc,ero);
		function suc(data){
			$state.go("login");
		}
		function ero(error){
			alert(error);
		}
	}

	$scope.openFileDialog= function(){
		$uibModal.open({
			size:"lg",
			animation:true,  
			templateUrl:"myModalContent.html",//dialog的id，与html建立的template的id一致
			controller:"ModalController",//指定dialog的controller
			resolve: {    
			}  
		});
	};

	//打开dialog的函数
	$scope.openNewFolderDialog= function(){
		$uibModal.open({
			size:"md",
			animation:true,  
			templateUrl:"myFolderForm.html",//dialog的id，与html建立的template的id一致
			controller:"newFolderModalController",//指定dialog的controller
			resolve: {    
				/*nodes:function(){  
                   return $scope.nodes;  
               }  */
			} ,
		});
	};

	$scope.onTreeLeafItemClickFunction = function(sel) {  
		$scope.selectedNode = sel; 
		if(sel.folderName=="我的文件"){
			MyFolderService.findChildFolderByExtrcode(sel.extrcode,suc,ero);
			function suc(data){
				for(var i = 0; i < data.length; i ++){
					$rootScope.dataForTheTree[0].children.push(data[i]);
				}
				console.log(data);
			};
			function ero(error){
				alert(error);
			}
		}
	}; 

	/**
	 * 展开节点
	 */
	$rootScope.expandNode = function(node,expanded){
		console.log(expanded);
		if(expanded){
			$rootScope.folderName = node.folderName;
			$state.go("main.mainTable",{"extrcode":node.extrcode,"folderName":node.folderName});
		}
		/**
		 * 为node对象定义属性
		 */
		if(!node.children){
			Object.defineProperty(node,"children",{
				value:[]
			});
		}
		MyFolderService.findChildFolderByExtrcode2(node.extrcode,suc,ero);
		function suc(data){
			node.children.length = 0;// = [];
			//获取文件夹
			var childFolders = data.childFolders;
			for(var i = 0; i < childFolders.length; i ++){
				node.children.push(childFolders[i]);
			}
			
			
/*			//获取文件，在左边操作栏树中添加文件名称列表，这里功能需要屏蔽掉
			var childFiles = data.childFiles;
			//清空
			for(var i = 0; i < childFiles.length; i ++){
				if(!childFiles[i].type){
					Object.defineProperty(childFiles[i],"type",{
						value:"file"
					});
				}
				node.children.push(childFiles[i]);
			}*/
		};
		function ero(error){
			console.log(error);
		}
	}
	
	$scope.back = function (){
		history.back(-1);
	}
	
	$scope.search = function(){
		$state.go("main.myFileList",{"searchCondition":$scope.searchCondition});
	}
}]).controller("ModalController",["$scope","$state","$rootScope","Upload","$modalInstance","FileUploader",function($scope,$state,$rootScope,Upload,$modalInstance,FileUploader){
	$scope.folderId = 49;
	//定义dialog中的取消按钮的点击事件的处理函数
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};

	var uploader = $scope.uploader = new FileUploader({
		url: '/AREASTATE/com/frame/servlet/FileUploadServlet',
	});
	
	$scope.chgF = function(){
		console.log($scope.folderId);
		//额外的数据
		uploader.formData=[{"folderId":$scope.folderId}]
	}
	
	
	$scope.setFolderExtrCode = function(self){
		console.log(self);
	}

	$scope.uploader.filters.push({
		name: 'customFilter',
		fn: function(item /*{File|FileLikeObject}*/, options) {
			return this.queue.length < 10;
		}
	});

	$scope.uploader.onWhenAddingFileFailed = function(item /*{File|FileLikeObject}*/, filter, options) {
		//console.info('onWhenAddingFileFailed', item, filter, options);
	};
	$scope.uploader.onAfterAddingFile = function(fileItem) {
		//console.info('onAfterAddingFile', fileItem);
	};
	$scope.uploader.onAfterAddingAll = function(addedFileItems) {
		//console.info('onAfterAddingAll', addedFileItems);
	};
	$scope.uploader.onBeforeUploadItem = function(item) {
		item.formData = [{"folderId":$scope.folderId}];
	};
	$scope.uploader.onProgressItem = function(fileItem, progress) {
		//console.info('onProgressItem', fileItem, progress);
	};
	$scope.uploader.onProgressAll = function(progress) {
		//console.info('onProgressAll', progress);
	};
	$scope.uploader.onSuccessItem = function(fileItem, response, status, headers) {
		//console.info('onSuccessItem', fileItem, response, status, headers);
	};
	$scope.uploader.onErrorItem = function(fileItem, response, status, headers) {
		//console.info('onErrorItem', fileItem, response, status, headers);
	};
	$scope.uploader.onCancelItem = function(fileItem, response, status, headers) {
		//console.info('onCancelItem', fileItem, response, status, headers);
	};
	$scope.uploader.onCompleteItem = function(fileItem, response, status, headers) {
		//console.info('onCompleteItem', fileItem, response, status, headers);
	};
	//上传完成
	$scope.uploader.onCompleteAll = function() {
		if(uploader.progress==100){
			$modalInstance.close();
			console.info('onCompleteAll');
			$state.reload("main.myFileList");
		}
	};
	console.info('uploader', uploader);
}]).controller("newFolderModalController",["$scope","$rootScope","$modalInstance","MyFolderService",function($scope,$rootScope,$modalInstance,MyFolderService){
	//定义dialog中的取消按钮的点击事件的处理函数
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};

	$scope.myFolder = {};

	$scope.createNewFolder = function(){
		var currentUser = localStorage.getItem("currentUser");
		if($scope.myFolder.folderName&&$scope.myFolder.folderName.length!=0){
			if(currentUser){
				var user = {};
				user.id = JSON.parse(currentUser).id;
				$scope.myFolder.user = user;
				MyFolderService.saveMyFolder($scope.myFolder,suc,ero);
				function suc(data){
					//通知事件
					$scope.$emit("NEWFOLDERSAVED");
					$modalInstance.dismiss('cancel');
				};
				function ero(ero){
					console.log(ero);
				}
			}
			else{
				alert("请重新登陆！！");
				$state.go("log_res");
			}
		}
		else{
			alert("请输入文件夹名称");
		}
	}
}]);
