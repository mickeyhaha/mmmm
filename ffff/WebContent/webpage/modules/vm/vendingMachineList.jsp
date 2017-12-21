<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>售货机管理管理</title>
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
		<h5>售货机管理列表 </h5>
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
	<form:form id="searchForm" modelAttribute="vendingMachine" action="${ctx}/vm/vendingMachine/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>分组编号：</span>
				<sys:gridselect url="${ctx}/vm/vendingMachine/selectvmGroup" id="vmGroup" name="vmGroup"  value="${vendingMachine.vmGroup.id}"  title="选择分组编号" labelName="vmGroup.name" 
					labelValue="${vendingMachine.vmGroup.name}" cssClass="form-control required" fieldLabels="分组名" fieldKeys="name" searchLabel="分组名" searchKey="name" ></sys:gridselect>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="vm:vendingMachine:add">
				<table:addRow url="${ctx}/vm/vendingMachine/form" title="售货机管理"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vm:vendingMachine:edit">
			    <table:editRow url="${ctx}/vm/vendingMachine/form" title="售货机管理" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vm:vendingMachine:del">
				<table:delRow url="${ctx}/vm/vendingMachine/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vm:vendingMachine:import">
				<table:importExcel url="${ctx}/vm/vendingMachine/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vm:vendingMachine:export">
	       		<table:exportExcel url="${ctx}/vm/vendingMachine/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column vmNo">售货机编号</th>
				<th  class="sort-column name">售货机名称</th>
				<th  class="sort-column type">售货机型号</th>
				<th  class="sort-column readerNo">RFID读写器序列号</th>
				<th  class="sort-column province">投放省</th>
				<th  class="sort-column city">投放城市</th>
				<th  class="sort-column area">投放地区</th>
				<th  class="sort-column address">投放详细地址</th>
				<th  class="sort-column platformState">平台商状态</th>
				<th  class="sort-column supplierState">运营商状态</th>
				<th  class="sort-column vmState">售货机状态(在线，离线，停用)</th>
				<th  class="sort-column createTime">创建时间</th>
				<th  class="sort-column barCode">二维码</th>
				<th  class="sort-column standardStock">标准库存</th>
				<th  class="sort-column vmGroup.id">分组编号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="vendingMachine">
			<tr>
				<td> <input type="checkbox" id="${vendingMachine.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看售货机管理', '${ctx}/vm/vendingMachine/form?id=${vendingMachine.id}','800px', '500px')">
					${vendingMachine.vmNo}
				</a></td>
				<td>
					${vendingMachine.name}
				</td>
				<td>
					${vendingMachine.type}
				</td>
				<td>
					${vendingMachine.readerNo}
				</td>
				<td>
					${vendingMachine.province}
				</td>
				<td>
					${vendingMachine.city}
				</td>
				<td>
					${vendingMachine.area}
				</td>
				<td>
					${vendingMachine.address}
				</td>
				<td>
					${vendingMachine.platformState}
				</td>
				<td>
					${vendingMachine.supplierState}
				</td>
				<td>
					${vendingMachine.vmState}
				</td>
				<td>
					<fmt:formatDate value="${vendingMachine.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${vendingMachine.barCode}
				</td>
				<td>
					${vendingMachine.standardStock}
				</td>
				<td>
					${vendingMachine.vmGroup.name}
				</td>
				<td>
					<shiro:hasPermission name="vm:vendingMachine:view">
						<a href="#" onclick="openDialogView('查看售货机管理', '${ctx}/vm/vendingMachine/form?id=${vendingMachine.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="vm:vendingMachine:edit">
    					<a href="#" onclick="openDialog('修改售货机管理', '${ctx}/vm/vendingMachine/form?id=${vendingMachine.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="vm:vendingMachine:del">
						<a href="${ctx}/vm/vendingMachine/delete?id=${vendingMachine.id}" onclick="return confirmx('确认要删除该售货机管理吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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