function changeNum(e){
	var num = e.value;
	if(num < 0){
		num = 0;
		e.value = 0;
	}
	var nextE = e.nextSibling;
	var sn = nextE.value;
	var params = {'goodsSn':sn,'goodsNum':num};
	$.ajax({
		   url:'market_updateGoods.action'
		   ,async: false
		   ,type:'POST'
		   ,data:params
		   ,success:function(data){
			   document.getElementById("zj").innerText = data.result;
		   }
		   ,error:function(){alert('发生错误');}
		});
}

function deleteGoods(e){
	var div = e.parentNode;
	var dl = div.parentNode;
	var sn = dl.lastElementChild.lastChild.value;
	var params = {'goodsSn':sn};
	$.ajax({
		url:'market_deleteGoods.action'
			,async: false
			,type:'POST'
				,data:params
				,success:function(data){
					document.getElementById("zj").innerText = data.result;
					var div_parent = dl.parentNode.parentNode;
					div_parent.parentNode.removeChild(div_parent);
				}
	,error:function(){alert('发生错误');}
	});
}

