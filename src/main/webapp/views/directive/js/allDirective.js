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
				$(".sul").not(subMenuEle).slideUp("fast");
			}
			
			$scope.goAim = function(url,$event){
				var target = $event.target;
				target.style.background="#009688";
				target.style.color = "white";
				var slis = $(".sli").not(target);
				angular.forEach(slis,function(data){
					$(data).css({"background":"",color:"black"});
				});
				$state.go(url);
			}
		},
		templateUrl:'../views/directive/html/leftnavTemp.html'
	}
});