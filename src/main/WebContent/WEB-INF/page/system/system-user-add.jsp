<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<%@include file="/WEB-INF/page/common/header.jsp"%>
<title>添加用户 - 用户管理 - H-ui.admin v3.1</title>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id="adminName" name="name">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off" value="" placeholder="密码" id="password" name="password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" autocomplete="off" placeholder="确认新密码" id="password2" name="password2">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id="phone" name="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@" name="email" id="email">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
				<div class="formControls col-xs-8 col-sm-9 skin-minimal">
					<div class="radio-box">
						<input type="radio" id="sex-1" name="sex" value="0"> <label for="sex-1">男</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex-2" name="sex" value="1"> <label for="sex-2">女</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex-3" name="sex" value="2" checked> <label for="sex-3">保密</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>生日：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id="birth" name="birthStr">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">角色：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box" style="width: 150px;">
						<select class="select" name="roleId" size="1">
							<c:forEach var="item" items="${requestScope.roleList }">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">部门：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box" style="width: 150px;">
						<select class="select" name="deptId" size="1">
							<c:forEach var="item" items="${requestScope.deptList }">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="" id="remark" name="remark">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<%@include file="/WEB-INF/page/common/footer.jsp"%>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${applicationScope.path }/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function() {
		    $('.skin-minimal input').iCheck({
		        checkboxClass: 'icheckbox-blue',
		        radioClass: 'iradio-blue',
		        increaseArea: '20%'
		    });
		    laydate.render({
		        elem: '#birth',
		        type: 'date'
		    });
		    $("#form-admin-add").validate({
		        rules: {
		            name: {
		                required: true,
		                minlength: 4,
		                maxlength: 16
		            },
		            password: {
		                required: true,
		            },
		            password2: {
		                required: true,
		                equalTo: "#password"
		            },
		            sex: {
		                required: true,
		            },
		            birthStr: {
		                required: true,
		            },
		            phone: {
		                required: true,
		                isPhone: true,
		            },
		            email: {
		                required: true,
		                email: true,
		            },
		            roleId: {
		                required: true,
		            },
		            deptId: {
		                required: true,
		            },
		        },
		        onkeyup: false,
		        focusCleanup: true,
		        success: "valid",
		        submitHandler: function(form) {
		            $(form).ajaxSubmit({
		                async: false,
		                type: 'post',
		                url: "${applicationScope.path }/user/addAfter",
		                success: function(data) {
		                    if (data) {
		                        layer.msg('添加成功!', {
		                            icon: 1,
		                            time: 1000
		                        });
		                    } else {
		                        layer.msg('添加失败!', {
		                            icon: 2,
		                            time: 1000
		                        });
		                    }
		                },
		                error: function(XmlHttpRequest, textStatus, errorThrown) {
		                    layer.msg('error!', {
		                        icon: 2,
		                        time: 1000
		                    });
		                }
		            });
		            setTimeout(function() {
		                var index = parent.layer.getFrameIndex(window.name);
		                parent.$('#shuaxin').click();
		                parent.layer.close(index);
		            },
		            "1000");
		        }
		    });
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>