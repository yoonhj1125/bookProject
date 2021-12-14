<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<head>
	<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
</head>

<div class="container">
	<form id="mainForm" name="mainForm" >
	  <input id="pageNumber" type="hidden" name="page" value="1">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="책 제목을 입력 하세요." id="searchKeyword" name="searchWord">
		</div>

	</form>
	<button id="btn-search" class="btn btn-primary" style=ce;">검색</button>
</div>

<div id="bookContents" class="container" style="display: none">
	<div class="card m-2">
		<div class="card-body">
			<table id="show">
			  <tr>
			    <th style="width: 400px;">제목</th>
			    <th>저자</th>
			    <th>출판사</th>
			  </tr>
			</table>
		</div>
	</div>
</div>


<div class="container" id="noBook" style="display:none">
	<div class="card m-2">
		<div class="card-body">
			<h4 class="card-title">책이 존재하지않습니다. </h4>
		</div>
	</div>
</div>
<!-- 페이징 영역 -->
<ul class="pagination justify-content-center" style="display:none">
  		<li class="page-item"><a id="previous"class="page-link">Previous</a></li>
  		<li class="page-item"><a id="next"  class="page-link" >Next</a></li>
</ul>
<script src="/js/book.js"></script>
<%@ include file="../layout/footer.jsp"%>


