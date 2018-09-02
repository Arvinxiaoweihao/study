<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/shop/resource/front/css/fc.css" rel="stylesheet" type="text/css" />
<link href="/shop/resource/front/css/fc02.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/shop/resource/front/js/jquery.js"></script>
<script type="text/javascript" src="/shop/resource/front/js/superMarket.js"></script>
<style type="text/css">
/* 类选择器 */
.toHand{
    cursor:pointer;
    float:left;
    padding-right: 10px;
}
</style>
</head>

<body>
<div id="box">
  <div class="top">
    <div class="top-left"></div>
    <div class="top-right">
       <div class="tr-top">
                    <font class="ts"><a href="<%=request.getContextPath() + "/shoppingCart.action"%> ">购物车</a></font>　|　<a
                        href="<%=request.getContextPath() + "/system/logout.action"%> "
                        target="_blank">后台登录</a>　|　<a href="#">繁体中文</a>　|　<a href="#">English</a>
                </div>
      <div class="tr-mid">
        <div class="trm-l">缅甸翡翠全球配送</div>
        <div class="trm-r">
          <label for="button"></label>
          <label for="button"></label>
          <img src="resource/front/images/fc_13.jpg"  onMouseOver="this.src='resource/front/images/fc_13over.jpg';" onMouseOut="this.src='resource/front/images/fc_13.jpg'" onClick="this.src='resource/front/images/fc_13click.jpg'">
          <img src="resource/front/images/fc_15.jpg"  onMouseOver="this.src='resource/front/images/fc_15over.jpg';" onMouseOut="this.src='resource/front/images/fc_15.jpg'" onClick="this.src='resource/front/images/fc_15click.jpg'">
          <label for="button2"></label>
        </div>
      </div>
      
      <div class="tr-bottom">
      <dt><s:a action="navigate">首页</s:a></dt>
      <dt><font class="tr-bottomtb"><a href="#">华氏超市</a></font></dt>
      <dt><s:a action="shoppingCart">购物车</s:a></dt>
      <dt><a href="#">经典推荐</a></dt>
      <dt>特价专区</dt>
      <dt><a href="#">翡翠课堂</a></dt>
      <dt><a href="#">华氏沙龙</a></dt>
      </div>
    </div>
  </div>
  <div class="top02">
    <div class="mk">
      <s:form id="productSearchForm" method="post" action="market" enctype="multipart/form-data">
      <s:hidden id="currentPage" name="productQuery.pageQuery.currentPage"></s:hidden>
      <table  border="0" cellspacing="0" cellpadding="0">
          <tr>
              <td >商品分类：</td>
              <td >
              <s:select name="productQuery.productDirId" listKey="id" listValue="name" 
                  headerKey="-1" headerValue="-----请选择-----" list="%{#productDirList}" >
              </s:select>
              </td>
              <td style="padding-left:20px">销售价：</td>
              <td >
                  <s:textfield id="salePriceStart" name="productQuery.salePriceStart" size="15" />
                  -
                  <s:textfield id='salePriceEnd' name="productQuery.salePriceEnd"  size="15" />
              </td>
              <td style="padding-left:20px">关键字：</td>
              <td > <s:textfield id="seachKey" name="productQuery.seachKey" size="15" /></td>
              <td style="padding-left:20px"><img src="resource/front/images/homehl_3.jpg"
                  onMouseOver="this.src='resource/front/images/homehl_5.jpg';"
                  onMouseOut="this.src='resource/front/images/homehl_3.jpg'"
                  onmousedown="this.src='resource/front/images/homehl_4.jpg'"
                  onmouseup="this.src='resource/front/images/homehl_3.jpg'"
                  onclick="productQuery()"></td>
              <td>&nbsp;</td>
          </tr>
      </table>
      </s:form>
    </div>
    
    <div class="keywords">热门搜索：<a href="#">观音</a>　<font class="yellow"><a href="#">玉佛</a></font>　<a href="#">戒指</a>　 <a href="#">生肖</a>　<a href="#">手链</a>　<a href="#">吊坠</a> 　<a href="#">手镯</a>　<font class="yellow"><a href="#">摆件</a></font>　<a href="#">貔貅</a>　</div>
  </div>
  
  
  <div class="main">
    <div class="mainunit01">
      <div class="main02leftadd">
      <div class="mainunit01-l">
        <div class="ml-top">
          <h1>玉品类别</h1>
          <h2><a href="#">详细&gt;&gt;</a></h2>
        </div>
        <s:iterator value="#productDirList" status="state">
            <s:if test="#state.isOdd()">
                <dt><a href="#"><s:property value="name"/> 　　<s:property value="englishName"/></a></dt>
            </s:if>
            <s:else>
                <dd><a href="#"><s:property value="name"/> 　　<s:property value="englishName"/></a></dd>
            </s:else>
        </s:iterator>
      </div>
      
      <div class="woman"><img src="resource/front/images/woman_3.jpg"  onMouseOver="this.src='resource/front/images/woman_3over.jpg';" onMouseOut="this.src='resource/front/images/woman_3.jpg'" onClick="this.src='resource/front/images/woman_3.jpg'"></div>
     </div>
      
      <div class="main02right">
        <div class="m02r-top">首页 &gt; 玉品类别 &gt; 玉品类别 &gt; <font class="orange03">挂件吊坠</font></div>
        
        <div class="m02r-mid"><a href="#">平安扣(<span class="green02">24</span>件)</a>    　<a href="#">吉祥如意(<span class="green02">59</span>件)</a>　    <a href="#">观音、佛陀、财神、罗汉生肖(<span class="green02">222</span>件)</a>    　　貔貅(<span class="green02">116</span>件)     　　金蟾(<span class="green02">20</span>件)     　　麒麟(<span class="green02">7</span>件)
<br />
<a href="#">龙凤(<span class="green02">3</span>件)</a>       　　　<a href="#">仙鹤(<span class="green02">18</span>件)</a>        　　　<a href="#">花草虫鱼(<span class="green02">18</span>件)</a>　　　　<a href="#">玉珠子(<span class="green02">1</span>件)</a>       　　　<a href="#">情侣佩(<span class="green02">1</span>件）</a>　　　其它（<span class="green02">0</span>件）</div>

        <div class="listtitle">
          <div class="rtitle-l">排序方式：
            <label for="select02"></label>
            <select name="select02" id="select02">
            </select>
           <img src="resource/front/images/fc02_14.jpg"  onMouseOver="this.src='resource/front/images/fc02_14over.jpg';" onMouseOut="this.src='resource/front/images/fc02_14.jpg'" onClick="this.src='resource/front/images/fc02_14.jpg'">         </div>
          
          <div class="rtitle-r">
          <dd><img src="resource/front/images/fc02_17.jpg"  onMouseOver="this.src='resource/front/images/fc02_17over.jpg';" onMouseOut="this.src='resource/front/images/fc02_17.jpg'" onClick="this.src='resource/front/images/fc02_17.jpg'"> </dd>
          <dt><a href="#">1</a></dt>
          <dt><a href="#">2</a></dt>
          <dt><a href="#">3</a></dt>
          <dt><a href="#">4</a></dt>
          <dt><a href="#">5</a></dt>
          <dd><img src="resource/front/images/fc02_19.jpg"  onMouseOver="this.src='resource/front/images/fc02_19over.jpg';" onMouseOut="this.src='resource/front/images/fc02_19.jpg'" onClick="this.src='resource/front/images/fc02_19.jpg'"></dd>
          </div>
        </div>  
        
         <s:iterator value="productList">
            <div class="listunit">
                <img src="resource/front/images/fc02_26.jpg" alt="" width="170" height="120" class="listunitpic" />
                <dl>
	                <h1>产品名称：<s:property value="name"/> </h1>
			        <dt>市场价格<font class="black">：￥<s:property value="marketPrice"/></font>　　
			        华氏实价：<font class="orange08">￥<s:property value="salePrice"/></font></dt>
			        <dt> 产　　地：<s:property value="place" /></dt>       
			        <dt> 规　　格：<s:property value="model" /></dt>
			        <dt>编　　号：<font> <s:property value="sn" /> </font></dt>
			        <div class="bottonunit">
				        <img src="resource/front/images/fc02_36.jpg"  
				        onmouseover="this.src='resource/front/images/fc02_36o.jpg';"
				        onmouseout="this.src='resource/front/images/fc02_36.jpg'" 
				        onmousedown="this.src='resource/front/images/fc02_36c.jpg'"
	                    onmouseup="this.src='resource/front/images/fc02_36.jpg'"
				        onclick="addGoodsToShoppingCart(this)" />
			         </div>
				     <dt>数　　量：<input  size="15" placeholder="请输入数量" style="background-color:#F0F0F0 !important;"/></dt>
		        </dl>
	        </div>
         </s:iterator>
        
        

<!-- 分页开始 -->
<div class="listtitle">
            <div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.firstPage"/>)">首页</div>
            <div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.upPage"/>)">上一页 </div>
                    <div class="toHand" >|</div>
                    <div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.downPage"/>)">下一页</div>
                    <div class="toHand" onclick="upPage(<s:property value="productQuery.pageQuery.endPage"/>)">尾页</div>
          
          <div class="rtitle-r">
          <dd>当前第<s:property value="productQuery.pageQuery.currentPage"/>页&nbsp;/&nbsp;
                    共<s:property value="productQuery.pageQuery.totalPages"/>页
                    &nbsp;一共有<s:property value="productQuery.pageQuery.totalCount"/>条数据</dd>
          </div>
        </div>
      </div>
      
    </div>
    <div class="mainbottom">
      <dt><a href="#">关于华氏</a>　|  　<a href="#">工作机会</a>　|  　<a href="#">联系我们</a>　|  　<a href="#">推荐产品</a>　|  　<a href="#">网站声明</a>　|  　<a href="#"> 隐私权政策</a>　|  　<a href="#">合作伙伴</a></dt>
     <dd>Copyright 2008-2009 www.chinadrtv.com All Rights Reserved
     华氏珠宝版权所有<br />
ICP证:沪ICP备05041682号
增值电信业务经营许可证　编号：B2-20050374</dd>    </div>
  </div>
</div>
</body>
</html>