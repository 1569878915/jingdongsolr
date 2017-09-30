<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
</head>
<body>

<table class="table"
			style="margin-left: 30px; margin-right: 30px; width: 1200px;">
			<thead>
				<tr>
					<th>序号</th>
					<th>书名</th>
					<th>内容</th>
					<th>路径</th>
					<th>长度</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="list" items="${list}" varStatus="status">
					<tr>
						<td scope="row">${status.count}</td>
				<td>${list.fileName }</td> 
						<td>
						<c:choose> 
	      <c:when test="${fn:length(list.fileContent) > 25}"> 
	        ${ fn:substring(list.fileContent, 0, 25) }...
	       </c:when> 
	       <c:otherwise> 
	      ${list.fileContent}
	       </c:otherwise>
	     </c:choose>
						
						
						</td>
						<td>${list.filePath }</td>
						<td>${list.fileSize }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


 





</body>
</html>