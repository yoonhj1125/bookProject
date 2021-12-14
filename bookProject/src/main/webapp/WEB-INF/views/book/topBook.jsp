<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container">
<h4>TOP 10</h4>
<c:if test="${empty resultData }">
	<div class="card m-2">
		<div class="card-body">
			검색 기록이 없습니다. 
		</div>
	</div>
</c:if>
<c:forEach var="b" items="${resultData }">
	<div class="card m-2">
		<div class="card-body">
			<li class="list-group-item">
				<dl>
					<dt style="font-size: 15pt;">
					</dt>
						검색어: ${b.search_word }
						조회수: ${b.CNT }
					<dd>
					</dd>
				</dl>
			</li>
		</div>
	</div>
</c:forEach>
</div>
<%@ include file="../layout/footer.jsp"%>


