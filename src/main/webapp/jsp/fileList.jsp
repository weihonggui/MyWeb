<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>下载文件显示页面</title>
  </head>
  
  <body>
    <c:out value="${message}"></c:out>
      <!-- 遍历Map集合 -->
    <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/upload/download" var="downurl">
            <c:param name="filename" value="${me.key}"></c:param>
        </c:url>
        ${me.value}<a href="${downurl}">下载</a>
        <br/>
    </c:forEach>
  </body>
</html>