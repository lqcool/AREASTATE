$(function () {
    $(".content .con_right .left").click(function (e) {
        $(this).css({ "color": "#333333", "border-bottom": "2px solid #2e558e" });
        $(".content .con_right .right").css({ "color": "#999999", "border-bottom": "2px solid #dedede" });
        $(".content .con_right ul .con_r_left").css("display", "block");
        $(".content .con_right ul .con_r_right").css("display", "none");
    });
    $(".content .con_right .right").click(function (e) {
        $(this).css({ "color": "#333333", "border-bottom": "2px solid #2e558e" });
        $(".content .con_right .left").css({ "color": "#999999", "border-bottom": "2px solid #dedede" });
        $(".content .con_right ul .con_r_right").css("display", "block");
        $(".content .con_right ul .con_r_left").css("display", "none");
    });

    $('#btn_Login').click(function () {
        if ($.trim($('#userid').val()) == '') {
            alert('请输入您的用户名');
        } else if ($.trim($('#pwd').val()) == '') {
            alert('请输入密码');
        } else {
        	 var user = {};
             user.loginNo = $('#uesrid').val();
             user.loginPwd = $('#pwd').val();
             log_res(user,'login');
        }
    });
    
    $('#btn_registe').click(function(){
    	 if ($.trim($('#r_uid').val()) == '') {
             alert('请输入您的用户名');
         } else if ($.trim($('#r_pwd').val()) == '') {
             alert('请输入密码');
         } else {
             var user = {};
             user.loginNo = $('#r_uid').val();
             user.loginPwd = $('#r_pwd').val();
             log_res(user,'registe');
         }
    });
    
})

function log_res(user,method){
    $.ajax({
    	url:"/AREASTATE/LogResgServlet",
	    contentType: "application/json;charest=utf-8",
	    dataType:"JSON",   //返回格式为json
	    type:"POST",   //请求方式
	    data:{'loginNo':user.loginNo,'loginPwd':user.loginPwd,'method':method},
	    success:function(data){
	    	console.log(JSON.parse(data));
	    	alert("注册成功");
	        //请求成功时处理
	    },
	    error:function(error){
	    	console.log(error);
	        //请求出错处理
	    }
	});
}

