<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聚美装饰管理系统</title>

</head>
<body class="nav-md">
<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>添加用户 </h2>
                    <ul class="nav navbar-right panel_toolbox">
                       <li><a class="close-link" onclick="loadjsp('index')" ><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form class="form-horizontal form-label-left" novalidate>

                      <span class="section">用户信息</span>
                      		
                      <div class="row" >
                      
                      
	                      <div class="item form-group">
	                       
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">用户名： <span class="required">*</span>
	                        </label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" id="username" name="username" class="form-control col-md-7 col-xs-12" required="required" >
	                        </div>
	                      </div>
	                       <div class="item form-group">
	                        <label for="password" class="control-label col-md-3 col-sm-3 col-xs-12">密码：</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="password" id="password1"  name="password"  data-validate-linked="password"  class="form-control col-md-7 col-xs-12" required="required">
	                        </div>
	                      </div>
	                      <div class="item form-group">
	                        <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">确认密码：</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="password" id="password2"  name="password2" data-validate-linked="password" class="form-control col-md-7 col-xs-12" required="required">
	                        </div>
	                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">真实姓名： <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="realame" name="realame" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="website">身份证号： <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" id="peopleid" name="peopleid"   size="16" required="required" placeholder="" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="occupation">性别： <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <input type="radio" name="sex" id="optionsRadios1" value="0" checked class="radio-inline" > 男
                        <input type="radio" name="sex" id="optionsRadios2" value="1" class="radio-inline optional">女
                        </div>
                      </div>
                        <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="telephone">手机号码： <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="tel" id="telephone" name="telephone" required="required" data-validate-length-range="8,20" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label for="password" class="control-label col-md-3 col-sm-3 col-xs-12">职位：</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="job" type="text" name="job"  class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label for="password" class="control-label col-md-3 col-sm-3 col-xs-12">上传照片：</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="file" id="uploadFile"  onchange="uploadPictur(this);" name="uploadFile"  required="required">
                        <input type="hidden" name="avatar" id="avatar">
                         <div>
                  <img src="" id="img" alt="Cinque Terre" width="200" height="200">
                  </div>
                        </div>
                      </div>
                    
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">备注 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <textarea id="remark" required="required" name="remark" class="form-control col-md-7 col-xs-12"></textarea>
                        </div>
                      </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button type="submit" class="btn btn-primary">取消</button>
                          <button id="send" type="submit" class="btn btn-success">保存</button>
                        </div>
                      </div>
                       </div>	
                       <div class="row">
                       
                       </div>
                    </form>
                  </div>
                  <div>
                
                  </div>
                </div>
              </div>
             <!--ajaxfileupload  -->
   <script src="../js/ajaxfileupload.js"></script>  
</body>
</html>