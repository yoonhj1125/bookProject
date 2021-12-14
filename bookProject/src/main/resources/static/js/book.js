let index = {
		init: function(){
			$("#btn-search").on("click", ()=>{ 
				this.search(1);
			});
			$("#previous").on("click", ()=>{ 
				var pg =  $('#pageNumber').val();
				if(pg=='1'){
					alert('첫 번째 페이지입니다.');
					return false; 
				}
				pg--;
				$('#pageNumber').val(pg);
				
				
				this.search(2);
			});
			$("#next").on("click", ()=>{ 
				var pg =  $('#pageNumber').val();
				pg++;
				$('#pageNumber').val(pg);
				this.search(2);
			});
			
		},

		  search: function(gubun) {
		  
		  	if(gubun=='1'){
		        $('#pageNumber').val(1);
		    }
	        var keyword = $('#searchKeyword').val();
		        if(keyword == ''){
		      		alert("검색어를 입력하세요");
		       		return false;
	        	}
	        
		        $(".temp").remove();
		        $(".book").remove();
		        $("#bookContents").show();
		        $(".pagination").show();
		      
		        $.ajax({
		            url: "/book/searchBooks",
		            data: $('#mainForm').serialize(),
		            beforeSend: function () {},
		            success: function (res) {
		            	console.log(res.documents);
		            	if (res.meta.total_count < 1) {
									$("#noBook").show();
									$("#bookContents").hide();
						}else{
						
						$("#noBook").hide();
						$("#bookContents").show();
							
						var html = "";
							$(res.documents)
								.each(
									function(idx){
										var authors = "", trans = "", thumbnail = "", isbn = "";
										$(this.authors)
												.each(
														function() {
															authors += (this + " ")
														});
										$(this.translators)
												.each(
														function() {
															trans += (this + " ")
														});
										if (this.thumbnail) {
											thumbnail = "<img src='"+this.thumbnail+"' width='100'>";
										}
										
										var arr_isbn = this.isbn.split(" ");
										
										if(this.sale_price == '-1'){
											this.sale_price = '판매종료';
										}
										
										if(arr_isbn.length>1){
											isbn = arr_isbn[1];
										}else{
											isbn = arr_isbn[0];
										}
										var datetime = this.datetime.substring(0,10);
										
									
										html += "<tr onClick='showDetail("+idx+");' class='temp'>";
										html += "<td>"+authors+"</td>";
										html += "<td>"+this.title+"</td>";
										html += "<td>"+this.publisher+"</td>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th style='height: 138px !important;'>썸네일</th>";
										html += "<th colspan='2'><img src="+this.thumbnail+"></th>";
										html += "</tr>";

										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>소개</th>";
										html += "<th colspan='2'>"+this.contents+"</th>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>ISBN</th>";
										html += "<th colspan='2'>"+isbn+"</th>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>출판사</th>";
										html += "<th colspan='2'>"+this.publisher+"</th>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>출판일</th>";
										html += "<th colspan='2'>"+datetime+"</th>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>정가(단위 : 원)</th>";
										html += "<th colspan='2'>"+this.price+"</th>";
										html += "</tr>";
										
										html += "<tr style='display:none' class='book detail"+idx+"'>";
										html += "<th>판매가(단위 : 원)</th>";
										html += "<th colspan='2'>"+this.sale_price+"</th>";
										html += "</tr>";
										
										
									});
							$("#show").append(html);
							
							if(gubun!= 1 && res.meta.is_end == true){
								$("#next").hide();
							}else{
								$("#next").show();
							
							}	
						}
		            
		            }
		        });
		 },
	
		
}

function showDetail(index) {
	
	if($('.detail'+index).is(':visible')){
		$('.detail'+index).hide();
	}else{
		$('.detail'+index).show();
	}
}

index.init();
