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
<title>添加客户联系人 - 客户联系人管理</title>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-contact-edit">
			<input type="hidden" value="${requestScope.contactPage.id }" name="id"/>
			<input type="hidden" value="${requestScope.contactPage.role }" id="role"/>
			<input type="hidden" value="${requestScope.contactPage.sex }" id="sex"/>
			<input type="hidden" value='${requestScope.contactPage.address }' id="address" name="address"/>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" autocomplete="off" disabled="disabled" value="${requestScope.contactPage.companyName }" onclick="customer_select('选择客户','${path}/customer/select','600','400')" placeholder="" name="companyName" id="companyName">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人姓名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contactPage.contactName }" placeholder="" id="" name="contactName">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" id="" name="role" size="1">
						<option value="0">决策人</option>
						<option value="1">普通人</option>
						<option value="2">分项决策人</option>
						<option value="3">商务决策</option>
						<option value="4">技术决策</option>
						<option value="5">财务决策</option>
						<option value="6">使用人</option>
						<option value="7">意见影响人</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>职位：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contactPage.position }" placeholder="" id="" name="position">
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
						<input type="radio" id="sex-3" name="sex" value="2"> <label for="sex-3">保密</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contactPage.phone }" placeholder="" id="phone" name="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@" value="${requestScope.contactPage.email }" name="email" id="email">
				</div>
			</div>
			<div class="row clearfix" data-toggle="distpicker">
				<label class="form-label col-xs-3"><span class="c-red">*</span>地址：</label>
				<div class="formControls col-xs-9">
					<div class="row clearfix" style="margin-top: 0" id="distpicker">
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="province"></select>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="city"></select>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="district"></select>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"></label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="详细地址" id="detail">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contactPage.remark }" placeholder="" id="remark" name="remark">
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
	<script type="text/javascript" src="${applicationScope.path }/lib/dist/distpicker.data.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/dist/distpicker.js"></script>
	<script type="text/javascript">
		$(function() {
			//表单填充
			function fill(){
				//来源
				var roleVal = $("#role").val();
				$("select[name='role'] option").eq(roleVal).attr("selected","selected");
				var sexVal = $("#sex").val();
				$(":radio[name='sex']").eq(sexVal).attr("checked","checked");
				var addressStr = $("#address").val();
				var address = JSON.parse(addressStr);
				$('#distpicker').distpicker(address);
				var detail = $("#detail").val(address["detail"]);
			}
			fill();
			//单选格式
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			//日期选择
			laydate.render({
				elem : '#nxtm',
				type : 'datetime'
			});
			//地址选择
			$('#distpicker').distpicker({
				//autoSelect: false
			});
			
			//填写地址
			function submit(){
				var province = $("#province").val();
				var city = $("#city").val();
				var district = $("#district").val();
				var detail = $("#detail").val();
				var address = {"province":province,"city":city,"district":district,"detail":detail};
				var str = JSON.stringify(address);
				$("#address").val(str);
				/* console.log(address);
				console.log(str);
				var parse = JSON.parse(str);
				console.log(parse); */
			}
			//表单验证
			$("#form-contact-edit").validate({
			    rules: {
			        contactName: {
			            required: true,
			        },
			        companyName: {
			            required: true,
			        },
			        role: {
			            required: true,
			        },
			        position: {
			        	required: true,
			        },
			        sex: {
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
			    },
			    onkeyup: false,
			    focusCleanup: true,
			    success: "valid",
			    submitHandler: function(form) {
			    	submit();
			        $(form).ajaxSubmit({
			            async: false,
			            type: 'post',
			            url: "${applicationScope.path }/contact/editAfter",
			            success: function(data) {
			                if (data) {
			                    layer.msg('修改成功!', {
			                        icon: 1,
			                        time: 1000
			                    });
			                } else {
			                    layer.msg('修改失败!', {
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