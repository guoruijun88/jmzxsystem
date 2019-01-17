//根据页面名字加载页面
function loadjsp(strhtml) {
	$.ajax({
		url : strhtml,
		cache : true,
		success : function(result) {
			$("#right_col").html(result);
		}
	});
}
function uploadPictur(){
	
	 $.ajaxFileUpload({
		url : "/pic/upload",
		 type:'POST',  /*提交方式*/
		  dataType: "json",
		 fileElementId:"uploadFile",
		  success: function(result){
              if(result.code == 0) {
                  alert("上传成功");
                  alert(result.data.url);
                  //图片显示
                  $("#img").attr("value",result.data.url);
                  $("#img").attr("src",result.data.url);
              }
          },
          error: function () {
              alert("上传失败11111");
          },
	});
}

/*function uploadPictur(obj) {
    ajax_upload(obj.id, function(data) { //function(data)是上传图片的成功后的回调方法
        var isrc = data.relatPath.replace(/\/\//g, '/'); //获取的图片的绝对路径
        $('#img-responsive').attr('src', isrc).data('img-src', isrc); //给<input>的src赋值去显示图片
    });
}
function ajax_upload(feid, callback) { //具体的上传图片方法
    if (image_check(feid)) { //自己添加的文件后缀名的验证
        $.ajaxFileUpload({
            fileElementId: feid,    //需要上传的文件域的ID，即<input type="file">的ID。
            url: '/pic/upload', //后台方法的路径
            type: 'post',   //当要提交自定义参数时，这个参数要设置成post
            dataType: 'json',   //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
            secureuri: false,   //是否启用安全提交，默认为false。
            async : true,   //是否是异步
            success: function(data) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                if (callback) callback.call(this, data);
            },
            error: function(data, status, e) {  //提交失败自动执行的处理函数。
                console.error(e);
            }
        });
    }
}
function image_check(feid) { //自己添加的文件后缀名的验证
    var img = document.getElementById(feid);
    return /.(jpg|png|gif|bmp)$/.test(img.value)?true:(function() {
        modals.info('图片格式仅支持jpg、png、gif、bmp格式，且区分大小写。');
        return false;
    })();
}*/
