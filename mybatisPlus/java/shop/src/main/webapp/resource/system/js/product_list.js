//注册点击查询事件
var searchButton = document.getElementById("search");
searchButton.onclick = function(){
//	var dataTable=document.getElementById("dataTable");
//	var tbody=document.getElementById("dataBody"); 
//	dataTable.removeChild(tbody);
	
	document.getElementById("currentPage").value = 1;
	document.getElementById("productSearchForm").submit();
}

function clearBaseQuery(){
    document.getElementById("seachKey").value="";
}

function clearMoreQuery(){
	document.getElementById("productDirId").value="-1";
	document.getElementById("salePriceStart").value="";
	document.getElementById("salePriceEnd").value="";
	document.getElementById("recommended").value="-1";
}

function clearAllQuery(){
   clearBaseQuery();
   clearMoreQuery();
}

function showMoreQuery(){
	var showQuery = document.getElementById("showMoreQueryz_text").value;
	if(showQuery==1){
		document.getElementById("showMoreQuery").src="/shop/resource/system/images/bag_open.gif";
		document.getElementById("moreQuery").style.display ="none"; 
		document.getElementById("showMoreQueryz_text").value=0; 
		clearMoreQuery();
	}else{
		var c =document.getElementById("showMoreQuery");
		c.src="/shop/resource/system/images/bag_close.gif";
		document.getElementById("moreQuery").style.display ="block"; 
		document.getElementById("showMoreQueryz_text").value=1; 
	}
}

function upPage(page){
	document.getElementById("currentPage").value = page;
	document.getElementById("productSearchForm").submit();
}
