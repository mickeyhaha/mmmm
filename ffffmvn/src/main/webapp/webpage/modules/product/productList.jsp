<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>产品列表管理</title>
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
		<h5>产品列表列表 </h5>
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
	<form:form id="searchForm" modelAttribute="product" action="${ctx}/product/product/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
			<span>货物名称：</span>
				<form:input path="name" htmlEscape="false" maxlength="64"  class=" form-control input-sm"/>
			<span>批次号：</span>
				<sys:gridselect url="${ctx}/product/product/selectbatch" id="batch" name="batch"  value="${product.batch.id}"  title="选择批次号" labelName="batch.batchNo" 
					labelValue="${product.batch.batchNo}" cssClass="form-control required" fieldLabels="批次号-生产日期" fieldKeys="batchNo-produceDate" searchLabel="批次号" searchKey="batchNo" ></sys:gridselect>
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="product:product:add">
				<table:addRow url="${ctx}/product/product/form" title="产品列表"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="product:product:edit">
			    <table:editRow url="${ctx}/product/product/form" title="产品列表" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="product:product:del">
				<table:delRow url="${ctx}/product/product/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="product:product:import">
				<table:importExcel url="${ctx}/product/product/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="product:product:export">
	       		<table:exportExcel url="${ctx}/product/product/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column name">货物名称</th>
				<th  class="sort-column productNo">货物编号</th>
				<th  class="sort-column barCode">条形码</th>
				<th  class="sort-column batch.id">批次号</th>
				<th  class="sort-column specification">规格</th>
				<th  class="sort-column packingUnit">包装单位</th>
				<th  class="sort-column costPrice">成本价</th>
				<th  class="sort-column description">商品描述</th>
				<th  class="sort-column salePrice">销售价</th>
				<th  class="sort-column expireDate">保质期</th>
				<th  class="sort-column type">货物类别</th>
				<th  class="sort-column createTime">创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="product">
			<tr>
				<td> <input type="checkbox" id="${product.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看产品列表', '${ctx}/product/product/form?id=${product.id}','800px', '500px')">
					${product.name}
				</a></td>
				<td>
					${product.productNo}
				</td>
				<td>
					${product.barCode}
				</td>
				<td>
					${product.type}
				</td>
				<td>
					${product.specification}
				</td>
				<td>
					${product.packingUnit}
				</td>
				<td>
					${product.costPrice}
				</td>
				<td>
					${product.description}
				</td>
				<td>
					${product.salePrice}
				</td>
				<td>
					<fmt:formatDate value="${product.expireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(product.type, 'product_type', '')}
				</td>
				<td>
					<fmt:formatDate value="${product.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="product:product:view">
						<a href="#" onclick="openDialogView('查看产品列表', '${ctx}/product/product/form?id=${product.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="product:product:edit">
    					<a href="#" onclick="openDialog('修改产品列表', '${ctx}/product/product/form?id=${product.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="product:product:del">
						<a href="${ctx}/product/product/delete?id=${product.id}" onclick="return confirmx('确认要删除该产品列表吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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