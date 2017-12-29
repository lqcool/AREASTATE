angular.module("directiveModel",[])
.directive("leftnav",function(){
	return{
		restrict:"EA",
		replace:true,
		scope:{
			items:'='
		},
		controller:function($scope,$element,$state){
			$scope.expand = function(self){
				var target = $(self.target);
				var ngClickEle = target.parent(".ev");
				var subMenuEle = ngClickEle.next();
				subMenuEle.slideToggle("fast");
				$(".sub").not(subMenuEle).slideUp("fast");
			}
			
			$scope.goAim = function(url){
				$state.go(url);
			}
		},
		templateUrl:'../views/directive/html/leftnavTemp.html'
	}
});