<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>客户管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>客户管理列表 </h5>
		<div class="ibox-tools">
			<a class="collapse-link">
				<i class="fa fa-chevron-up"></i>
			</a>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-wrench"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#">选项1</a>
				</li>
				<li><a href="#">选项2</a>
				</li>
			</ul>
			<a class="close-link">
				<i class="fa fa-times"></i>
			</a>
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="customer" action="${ctx}/customer/customer/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="customer:customer:add">
				<table:addRow url="${ctx}/customer/customer/form" title="客户管理"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="customer:customer:edit">
			    <table:editRow url="${ctx}/customer/customer/form" title="客户管理" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="customer:customer:del">
				<table:delRow url="${ctx}/customer/customer/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="customer:customer:import">
				<table:importExcel url="${ctx}/customer/customer/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="customer:customer:export">
	       		<table:exportExcel url="${ctx}/customer/customer/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column customerNo">客户编号</th>
				<th  class="sort-column mobile">手机号码</th>
				<th  class="sort-column name">客户姓名</th>
				<th  class="sort-column fax">传真号码</th>
				<th  class="sort-column address">地址</th>
				<th  class="sort-column alipay">是否开通alipay</th>
				<th  class="sort-column wechatPay">是否开通微信支付</th>
				<th  class="sort-column lastOrderState">上次交易状态：完成，未完成</th>
				<th  class="sort-column regTime">注册时间</th>
				<th  class="sort-column state">客户状态：启用，停用，黑名单</th>
				<th  class="sort-column vmGroup.id">售货机编号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="customer">
			<tr>
				<td> <input type="checkbox" id="${customer.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看客户管理', '${ctx}/customer/customer/form?id=${customer.id}','800px', '500px')">
					${customer.customerNo}
				</a></td>
				<td>
					${customer.mobile}
				</td>
				<td>
					${customer.name}
				</td>
				<td>
					${customer.fax}
				</td>
				<td>
					${customer.address}
				</td>
				<td>
					${customer.alipay}
				</td>
				<td>
					${customer.wechatPay}
				</td>
				<td>
					${customer.lastOrderState}
				</td>
				<td>
					<fmt:formatDate value="${customer.regTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${customer.state}
				</td>
				<td>
					${customer.vmGroup.id}
				</td>
				<td>
					<shiro:hasPermission name="customer:customer:view">
						<a href="#" onclick="openDialogView('查看客户管理', '${ctx}/customer/customer/form?id=${customer.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="customer:customer:edit">
    					<a href="#" onclick="openDialog('修改客户管理', '${ctx}/customer/customer/form?id=${customer.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="customer:customer:del">
						<a href="${ctx}/customer/customer/delete?id=${customer.id}" onclick="return confirmx('确认要删除该客户管理吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>