<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<div class="container">
<h4>My HisTory</h4>
<c:if test="${empty searchHistoryPage.content }">
	<div class="card m-2">
		<div class="card-body">
			검색 기록이 없습니다. 
		</div>
	</div>
</c:if>
<c:forEach var="b" items="${searchHistoryPage.content }">
	<div class="card m-2">
		<div class="card-body">
			<li class="list-group-item">
				<dl>
					<dt style="font-size: 15pt;">
						검색어: ${b.search_word }
					</dt>
					<dd>
						<span>검색일자 : <fmt:formatDate value="${b.regdate }" pattern="yyyy. MM. dd HH:mm:ss"/></</span>
					</dd>
				</dl>
			</li>
		</div>
	</div>
</c:forEach>
</div>
<%@ include file="layout/footer.jsp"%>


