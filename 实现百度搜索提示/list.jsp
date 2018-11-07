<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table width="100%">
	<c:forEach items="${wordslist }" var="wordBean">
		<tr>
			<td>${wordBean.word }</td>
		</tr>
	</c:forEach>
	
</table>
