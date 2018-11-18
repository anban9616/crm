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
<title>编辑客户 - 客户管理</title>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-customer-add">
			<input type="hidden" id="sourceVal" value="${requestScope.customer.source }"/>
			<input type="hidden" id="cusStatusVal" value="${requestScope.customer.cusStatus }"/>
			<input type="hidden" id="employeesVal" value="${requestScope.customer.employees }"/>
			<input type="hidden" id="rankVal" value="${requestScope.customer.rank }"/>
			<input type="hidden" id="tradeVal" value="${requestScope.customer.trade }"/>
			<input type="hidden" id="roleVal" value="${requestScope.contact.role }"/>
			<input type="hidden" id="sexVal" value="${requestScope.contact.sex }"/>
			<input type="hidden" name="customerId1" value="${requestScope.customer.id }"/>
			<input type="hidden" name="contactId1" value="${requestScope.contact.id }"/>
			<input type="hidden" name="chatId1" value="${requestScope.chat.id }"/>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>来源：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="source" id="source" size="1">
						<option value="0">网络营销</option>
						<option value="1">公开媒体</option>
						<option value="2">合作伙伴</option>
						<option value="3">员工介绍</option>
						<option value="4">广告</option>
						<option value="5">推销电话</option>
						<option value="6">其他</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公司名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.customer.companyName }" placeholder="" id="" name="companyName">
				</div>
			</div>
			<input id="address" name="address" type="hidden" value='${requestScope.customer.address }'>
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
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户状态：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="cusStatus" id="cusStatus" size="1">
						<option value="0">意向客户</option>
						<option value="1">交易成功的客户</option>
						<option value="2">交易失败的客户</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>员工数量：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="employees" id="employees" size="1">
						<option value="0">10人以下</option>
						<option value="1">10-20人</option>
						<option value="2">20-50人</option>
						<option value="3">50人以上</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户等级：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="rank" id="rank" size="1">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户行业：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="trade" id="trade" size="1">
						<option value="0">IT教育</option>
						<option value="1">电子商务</option>
						<option value="2">对外贸易</option>
						<option value="3">酒店旅游</option>
						<option value="4">金融保险</option>
						<option value="5">房产行业</option>
						<option value="6">医疗保健</option>
						<option value="7">政府机关</option>
						<option value="8">其他</option>
					</select>
					</span> 
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>客户编号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.customer.number }" placeholder="" id="" name="number">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">客户备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.customer.remark }" placeholder="" id="remark" name="remark">
				</div>
			</div>
			<br><hr><br>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下次联系时间：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value='<fmt:formatDate value="${requestScope.chat.nxtm }" pattern="yyyy-MM-dd hh:mm:ss"/>' placeholder="" id="nxtm" name="nxtmStr">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下次联系内容：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.chat.content }" placeholder="" id="" name="content">
				</div>
			</div>
			<br><hr><br>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系人姓名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contact.contactName }" placeholder="" id="" name="contactName">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
				<div class="formControls col-xs-8 col-sm-9"> 
					<span class="select-box" style="width:150px;">
					<select class="select" name="role" id="role" size="1">
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
					<input type="text" class="input-text" value='${requestScope.contact.position }' placeholder="" id="" name="position">
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
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contact.phone }" placeholder="" id="phone" name="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="@" name="email" id="email" value="${requestScope.contact.email }">
				</div>
			</div>
			<input id="address1" name="address1" type="hidden" value='${requestScope.contact.address }'>
			<div class="row clearfix" data-toggle="distpicker">
				<label class="form-label col-xs-3"><span class="c-red">*</span>地址：</label>
				<div class="formControls col-xs-9">
					<div class="row clearfix" style="margin-top: 0" id="distpicker1">
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="province1"></select>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="city1"></select>
							</span>
						</div>
						<div class="col-xs-4">
							<span class="select-box">
								<select class="select" size="1" id="district1"></select>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"></label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder="详细地址" id="detail1">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">联系人备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="${requestScope.contact.remark }" placeholder="" id="remark1" name="remark1">
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
				var sourceVal = $("#sourceVal").val();
				$("#source option").eq(sourceVal).attr("selected","selected");
				
				var cusStatusVal = $("#cusStatusVal").val();
				$("#cusStatus option").eq(cusStatusVal).attr("selected","selected");
				
				var employeesVal = $("#employeesVal").val();
				$("#employees option").eq(employeesVal).attr("selected","selected");
				
				var rankVal = $("#rankVal").val();
				$("#rank option").eq(rankVal-1).attr("selected","selected");
				
				var tradeVal = $("#tradeVal").val();
				$("#trade option").eq(tradeVal).attr("selected","selected");
				
				var roleVal = $("#roleVal").val();
				$("#role option").eq(roleVal).attr("selected","selected");
				
				var sexVal = $("#sexVal").val();
				$(":radio[name='sex']").eq(sexVal).attr("checked","checked");
				
				var addressStr = $("#address").val();
				var address = JSON.parse(addressStr);
				$('#distpicker').distpicker(address);
				var detail = $("#detail").val(address["detail"]);
				
				var addressStr1 = $("#address1").val();
				try {
					var address1 = JSON.parse(addressStr1);
					$('#distpicker1').distpicker(address1);
					var detail1 = $("#detail1").val(address1["detail"]);
				} catch (e) {
					
				};
				
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
			$('#distpicker1').distpicker({
				//autoSelect: false
			});
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
				
				var province1 = $("#province1").val();
				var city1 = $("#city1").val();
				var district1 = $("#district1").val();
				var detail1 = $("#detail1").val();
				var address1 = {"province":province1,"city":city1,"district":district1,"detail":detail1};
				var str1 = JSON.stringify(address1);
				$("#address1").val(str1);
			}
			
			//表单验证
			$("#form-customer-add").validate({
			    rules: {
			        source: {
			            required: true,
			        },
			        companyName: {
			            required: true,
			        },
			        cusStatus: {
			            required: true,
			        },
			        employees: {
			            required: true,
			        },
			        rank: {
			            required: true,
			        },
			        trade: {
			            required: true,
			        },
			        number: {
			            required: true,
			        },
			        nxtmStr: {
			            required: true,
			        },
			        content: {
			            required: true,
			        },
			        contactName: {
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
			            url: "${applicationScope.path }/customer/editAfter",
			            success: function(data) {
			                if (data) {
			                    layer.msg('编辑成功!', {
			                        icon: 1,
			                        time: 1000
			                    });
			                } else {
			                    layer.msg('编辑失败!', {
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