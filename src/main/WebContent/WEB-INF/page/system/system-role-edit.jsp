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
<title>编辑角色 - 角色管理</title>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add">
			<input name="id" type="hidden" value="${requestScope.role.id }">
			<input name="sysPower" type="hidden" value="${requestScope.role.sysPower }"/>
			<input name="cusPower" type="hidden" value="${requestScope.role.cusPower }"/>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.role.name }" placeholder="" id="roleName" name="name">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.role.remark }" placeholder="" id="remark" name="remark">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">网站角色：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<dl class="permission-list">
						<dt>
							<label>系统管理</label>
						</dt>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">角色管理</label>
								</dt>
								<dd id="roleList">
									<label class=""> <input type="radio" value="0" name="rolePower" id="role0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="rolePower" id="role1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="rolePower" id="role2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="rolePower" id="role3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="rolePower" id="role4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">用户管理</label>
								</dt>
								<dd id="userList">
									<label class=""> <input type="radio" value="0" name="userPower" id="user0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="userPower" id="user1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="userPower" id="user2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="userPower" id="user3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="userPower" id="role4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">部门管理</label>
								</dt>
								<dd id="deptList">
									<label class=""> <input type="radio" value="0" name="deptPower" id="dept0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="deptPower" id="dept1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="deptPower" id="dept2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="deptPower" id="dept3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="deptPower" id="dept4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
					</dl>
					<dl class="permission-list">
						<dt>
							<label>客户关系管理</label>
						</dt>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">线索管理</label>
								</dt>
								<dd id="clueList">
									<label class=""> <input type="radio" value="0" name="cluePower" id="clue0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="cluePower" id="clue1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="cluePower" id="clue2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="cluePower" id="clue3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="cluePower" id="clue4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">客户管理</label>
								</dt>
								<dd id="customerList">
									<label class=""> <input type="radio" value="0" name="customerPower" id="customer0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="customerPower" id="customer1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="customerPower" id="customer2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="customerPower" id="customer3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="customerPower" id="customer4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
						<dd>
							<dl class="cl permission-list2">
								<dt>
									<label class="">客户联系人</label>
								</dt>
								<dd id="contactList">
									<label class=""> <input type="radio" value="0" name="contactPower" id="contact0" checked="checked"> 无权限  </label> 
									<label class=""> <input type="radio" value="1" name="contactPower" id="contact1"> 查看  </label> 
									<label class=""> <input type="radio" value="2" name="contactPower" id="contact2"> 查看增加  </label> 
									<label class=""> <input type="radio" value="3" name="contactPower" id="contact3"> 查看增加修改  </label> 
									<label class=""> <input type="radio" value="4" name="contactPower" id="contact4"> 查看增加修改删除  </label> 
								</dd>
							</dl>
						</dd>
					</dl>
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
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			function check(){
				var sysVal = Number($(":input[name='sysPower']").val());
				$(":input[name='rolePower']").eq(Math.floor((sysVal/100))%10).attr("checked","checked");
				$(":input[name='userPower']").eq(Math.floor((sysVal/10))%10).attr("checked","checked");
				$(":input[name='deptPower']").eq(sysVal%10).attr("checked","checked");
				
				var cusVal = Number($(":input[name='cusPower']").val());
				$(":input[name='cluePower']").eq(Math.floor((cusVal/100))%10).attr("checked","checked");
				$(":input[name='customerPower']").eq(Math.floor((cusVal/10))%10).attr("checked","checked");
				$(":input[name='contactPower']").eq(cusVal%10).attr("checked","checked");
			}
			check();
			function confirm(){
				//系统管理值
				var roleVal = $(":input[name='rolePower']:checked").val();
				var userVal = $(":input[name='userPower']:checked").val();
				var deptVal = $(":input[name='deptPower']:checked").val();
				var systemPowerVal = $(":input[name='sysPower']").val(userVal+roleVal+deptVal).val();
				//客户管理值
				var clueVal = $(":input[name='cluePower']:checked").val();
				var customerVal = $(":input[name='customerPower']:checked").val();
				var contactVal = $(":input[name='contactPower']:checked").val();
				var cusPowerVal = $(":input[name='cusPower']").val(clueVal+customerVal+contactVal).val();
			};
			$("#form-admin-add").validate({
				rules:{
					name:{
						required:true,
						minlength:1,
						maxlength:16
					},
					remark:{
						maxlength:200
					},
				},
				onkeyup:false,
				focusCleanup:true,
				success:"valid",
				submitHandler:function(form){
					confirm();
					$(form).ajaxSubmit({
						async:false,
						type: 'post',
						url: "${applicationScope.path }/role/editAfter",
						success: function(data){
							if(data){
								layer.msg('添加成功!',{icon:1,time:1000});
							}else{
								layer.msg('添加失败!',{icon: 2,time:1000});
							}
						},
		                error: function(XmlHttpRequest, textStatus, errorThrown){
							layer.msg('error!',{icon:2,time:1000});
						}
					});
					setTimeout(function() {
						var index = parent.layer.getFrameIndex(window.name);
						parent.$('#shuaxin').click();
						parent.layer.close(index);
					}, "1000");
				}
			});
		});
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>