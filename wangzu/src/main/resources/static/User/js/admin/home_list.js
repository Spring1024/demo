//后台请求数据, 进行分页
function postAjavGetData(value){
	 //向后台请求数据
	 $.ajax({
		 url : value,
		 data : {},
		 type : "get",
		 datatype : "json",
		 async : false,// 是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		 cache : false,
		 success : function(pb){
			 
			 var html = "";
			 if(pb.beanList== null){
			 } else{
				 	html+="<div class='well'>";
				 	html+="<table class='table'><thead><tr><th>标题</th><th>地区</th><th>类型</th><th>户型</th><th>联系方式</th><th>费用</th><th style='width: 26px;'></th></tr></thead>";
				 $(pb.beanList).each(function(){
					 html+="<tbody>";
					 html+="<tr>";
					 html+="<td>"+this.hname+"</td>";
					 html+="<td>"+this.hposition+"</td>";
					 switch(this.htype){
					 case 0: 
						 html += "<td>短租</td>"
						 break;
					 case 1:
						 html += "<td>长租</td>"
						 break;
					 case 2:
						 html += "<td>出售</td>"
						 break;
					 default:
						 break;
					 }
					 html+="<td>"+this.hmodel+"</td>";
					 html+="<td>"+this.htele+"</td>";
					 switch(this.htype){
					 case 0: 
						 html += "<td>"+this.hprice+"元/日</td>"
						 break;
					 case 1:
						 html += "<td>"+this.hprice+"元/月</td>"
						 break;
					 case 2:
						 html += "<td>"+(this.hprice/10000)+"万</td>"
						 break;
					 default:
						 break;
					 }
					 html+="<td><a href='#'><i class='icon-pencil'></i></a><a href='#' role='button' data-toggle='modal'><i class='icon-remove'></i></a></td>";
					 html+="</tr>";
					 html="</tbody>";
				 });
				 	 html+="</table>";
				 	 html+="</div>";
			 }
			 
			 //进行分页
			 var page = '<div class="pagination">';
			 page += '<nav>';
			 page += '<ul>';
			 
			 if(pb.pc == 1){
				 page += '<li><a href="javascript:void(0);">上一页</a></li>';
			 }else{
				 var value = pb.url + "&pc=" + (pb.pc-1);
				 page += '<li onclick=postAjavGetData('+ '"' + value + '"' + ')><a>上一页</a></li>';
			 }
			 
		 	/*计算页码列表的开始和结束位置，即两个变量begin和end
			计算它们需要通过当前页码！
			1. 总页数不足6页--> begin=1, end=最大页
			2. 通过公式设置begin和end，begin=当前页-1，end=当前页+3
			3. 如果begin<1，那么让begin=1，end=6
			4. 如果end>tp, 让begin=tp-5, end=tp*/
			
			var begin;
			var end;
			if(pb.tp <=6){
				begin = 1;
				end = pb.tp;
			}else{
				begin = pb.pc-2;
				end = pb.pc+3;
				if(begin < 1){
					begin = 1;
					end = 6;
				}
				if(end > pb.tp){
					end = pb.tp;
					begin = pb.tp-5;
				}
			}
			
			for(var i=begin; i <=end; i++){
				if(i== pb.pc){
					page += '<li><a href="javascript:void(0);"style="background: orange">' + i + '</a></li>';
				}else{
					var value = pb.url + "&pc=" + i;
					page += '<li onclick=postAjavGetData('+ '"' + value + '"' + ')><a>' + i + '</a></li>';
				}
			}
			
			if(end > pb.tp){
				page += '<span>...</span>';
			}
			
			if(pb.pc == pb.tp){
				page += '<li><a href="javascript:void(0);">下一页</a></li>';
			}else{
				var value = pb.url + "&pc=" + (pb.pc+1);
				page += '<li onclick=postAjavGetData('+ '"' + value + '"' + ')><a>下一页</a></li>';
			}
			
			page += '</ul>';
			page += '</nav>';
			page += '</div>';
			 
			 $("#list").html(html+page);
		 }
	 });
}