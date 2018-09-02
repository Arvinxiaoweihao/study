//页面加载完后执行
window.onload = function(){
	
}
function productQuery(){
	document.getElementById("productSearchForm").submit();
}

function upPage(page){
	document.getElementById("currentPage").value = page;
	document.getElementById("productSearchForm").submit();
}

function addGoodsToShoppingCart(e){
	
	var sn = e.parentNode.previousSibling.previousSibling.lastChild.innerText;
//	document.getElementById("goodsSn").value = sn;
	
	var num = e.parentNode.nextSibling.nextSibling.lastChild.value;
	if(num === ''){
		num = 1;
	}
//	document.getElementById("goodsNum").value = num;
	var params = {'goodsSn':sn,'goodsNum':num};
	$.ajax({
		   url:'market_addGoods.action'
		   ,type:'POST'
		   ,data:params
		   ,success:function(data){
			   alert(data.result);
		   }
		   ,error:function(){alert('发生错误');}
		});
	
} 