<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>补货单管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		var validateForm;
		function doSubmit(){//回调函数，在编辑和保存动作时，供openDialog调用提交表单。
		  if(validateForm.form()){
			  $("#inputForm").submit();
			  return true;
		  }
	
		  return false;
		}
		$(document).ready(function() {
			validateForm = $("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
			
		});
	</script>
</head>
<body class="hideScroll">
		<form:form id="inputForm" modelAttribute="productPut" action="${ctx}/productput/productPut/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td class="width-15 active"><label class="pull-right">货物ID：</label></td>
					<td class="width-35">
						<sys:gridselect url="${ctx}/productput/productPut/selectproduct" id="product" name="product.id"  value="${productPut.product.id}"  title="选择货物ID" labelName="product.name" 
						 labelValue="${productPut.product.name}" cssClass="form-control required" fieldLabels="商品编号-商品名称" fieldKeys="productNo-name" searchLabel="商品名称" searchKey="name" ></sys:gridselect>
					</td>
					<td class="width-15 active"><label class="pull-right">货物数量：</label></td>
					<td class="width-35">
						<form:input path="productAmount" htmlEscape="false"    class="form-control "/>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">仓库编号：</label></td>
					<td class="width-35">
						<form:input path="repositoryNo" htmlEscape="false"    class="form-control "/>
					</td>
					<td class="width-15 active"><label class="pull-right">补货状态：</label></td>
					<td class="width-35">
						<form:select path="state" class="form-control ">
							<form:option value="" label=""/>
							<form:options items="${fns:getDictList('ProductPutState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td class="width-15 active"><label class="pull-right">售货机ID：</label></td>
					<td class="width-35">
						<sys:gridselect url="${ctx}/productput/productPut/selectvendingMachine" id="vendingMachine" name="vendingMachine.id"  value="${productPut.vendingMachine.id}"  title="选择售货机ID" labelName="vendingMachine.name" 
						 labelValue="${productPut.vendingMachine.name}" cssClass="form-control required" fieldLabels="售货机名称-售货机编号" fieldKeys="name-vmNo" searchLabel="售货机名称" searchKey="name" ></sys:gridselect>
					</td>
					<td class="width-15 active"><label class="pull-right">补货员ID：</label></td>
					<td class="width-35">
						<sys:gridselect url="${ctx}/productput/productPut/selectuser" id="user" name="user.id"  value="${productPut.user.id}"  title="选择补货员ID" labelName="user.name" 
						 labelValue="${productPut.user.name}" cssClass="form-control required" fieldLabels="补货员登陆名-姓名" fieldKeys="loginName-name" searchLabel="姓名" searchKey="name" ></sys:gridselect>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form:form>
</body>
</html>