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
<script type="text/javascript" src="/shop/resource/front/js/shoppingCart.js"></script>
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
      <dt><s:a action="market">华氏超市</s:a></dt>
      <dt><font class="tr-bottomtb"><s:a action="shoppingCart">购物车</s:a></font></dt>
      <dt><a href="#">经典推荐</a></dt>
      <dt>特价专区</dt>
      <dt><a href="#">翡翠课堂</a></dt>
      <dt><a href="#">华氏沙龙</a></dt>
      </div>
    </div>
  </div>
  <div class="top02">
    <div class="mk">
      <label for="textfield02"></label>
      <label for="select"></label>

      <table width="700" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="165"><li>所有分类</li></td>
          <td width="165"><li>所有分类</li></td>
          <td width="198"><label for="textfield02"></label>
          <input type="text" name="textfield02" class="textfield04" /></td>
          <td><img src="resource/front/images/homehl_3.jpg"  onMouseOver="this.src='resource/front/images/homehl_3over.jpg';" onMouseOut="this.src='resource/front/images/homehl_3.jpg'" onClick="this.src='resource/front/images/homehl_3click.jpg'"></td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </div>
    
    <div class="keywords">热门搜索：<a href="#">观音</a>　<font class="yellow"><a href="#">玉佛</a></font>　<a href="#">戒指</a>　 <a href="#">生肖</a>　<a href="#">手链</a>　<a href="#">吊坠</a> 　<a href="#">手镯</a>　<font class="yellow"><a href="#">摆件</a></font>　<a href="#">貔貅</a>　</div>
  </div>
  
  
  <div class="main">
    <div class="mainunit01">
      <div class="main02leftadd">
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>个人资料</h1>
          </div>
        <dt><a href="#">个人信息</a></dt>
        <dt><a href="#">修改密码</a></dt>
      </div>
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>消费明细</h1>
          </div>
        <dt><a href="#">我的购物车</a></dt>
        <dt><a href="#">账目明细</a></dt>
        <dt><a href="#">收货地址</a></dt>
      </div>
      <div class="mainunit010-l">
        <div class="ml-top05">
          <h1>互动社区</h1>
          </div>
        <dt><a href="#">玉友沙龙</a></dt>
        <dt><a href="#">我的留言</a></dt>
        <dt><a href="#">我的帖子</a></dt>
        <dt><a href="#">在线咨询</a></dt>
      </div>
      </div>
      <div class="main02right">
        <div class="listtitle04">　<a href="#">购物清单</a>　&gt;　<font class="ganlan">订单确认</font>　&gt;　<a href="#">支付贷款</a></div>   
        <div class="gwqdtitle05">
          <div class="gl">购物清单</div>
          
          <div class="gr"><a href="#">更新购物清单</a></div>
        </div>
        <div class="kuang">
          <div class="ddqrtitle">
          订单确认　　　　　　　　　　　　　　　　　　　　　　　　   　　　　　　　　　　　　　　　<a href="#">修改</a></div>
         <s:iterator value="#session.SHOPPINGCART_IN_SESSION.goodsMap">
        <div class="listunit">
         <a href="#">
         <img src="resource/front/images/fc02_26.jpg" alt="" width="170" height="120" class="listunitpic" />
        <dl>
        <div class="bottonunit02">
        <img src="resource/front/images/qrdd_7.jpg"  
        onMouseOver="this.src='resource/front/images/qrdd_7ov.jpg';" 
        onMouseOut="this.src='resource/front/images/qrdd_7.jpg'" 
        onClick="deleteGoods(this)"></div>
        <h1>产品名称：<s:property value="value.goodsName"/></h1>
        <dt>售价：<font class="orange08">￥<s:property value="value.goodsSalePrice"/></font></dt>
        <dt>数　　量：<s:textfield name="value.goodsNum" size="15" placeholder="请输入数量" style="background-color:#F0F0F0 !important;" onchange="changeNum(this)"/><s:hidden  name="key" /></dt>
        </dl>
        </a>
        </div>
        </s:iterator>
        
        </div>
        <div class="gwje">总共：<span id="zj" class="orange03">￥<s:property  value="#session.SHOPPINGCART_IN_SESSION.totalPrice"/></span></div>
        <div class="tjan"><img src="resource/front/images/gwc_15.jpg"  onmouseover="this.src='resource/front/images/gwc_15over.jpg';" onmouseout="this.src='resource/front/images/gwc_15.jpg'" onclick="this.src='resource/front/images/gwc_15.jpg'" /><img src="resource/front/images/gwc_17.jpg"  onmouseover="this.src='resource/front/images/gwc_17over.jpg';" onmouseout="this.src='resource/front/images/gwc_17.jpg'" onclick="this.src='resource/front/images/gwc_17.jpg'" /></div>
        
      </div>
      
    </div>
    <div class="kfzx">
       <div class="kf01">
         <div class="kf01s">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td width="46"><img src="resource/front/images/fc_111.jpg" height="59" alt="" /></td>
               <td>在线MSN：<img src="resource/front/images/fc_108.jpg" width="73" height="17" alt="" /><br />
                 在线QQ： <img src="resource/front/images/fc_117.jpg" width="73" height="21" alt="" /><br />
                 在线客服：<img src="resource/front/images/fc_127.jpg" width="77" height="18" alt="" /></td>
             </tr>
           </table>
         </div>
         
         <div class="tel02">
         <li>客服电话<font class="green">：0692-4118235</font></li>
         <li>手机短信：<font class="orange">13099491279</font></li>
         <li>CEO信箱：pxsilling@vip.qq.com</li>
         </div>
       </div>
       
       <div class="kf02"><img src="resource/front/images/fc_93.jpg" width="109" height="45" alt="" /><br />
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>

       </div>
       <div class="kf02"><img src="resource/front/images/fc_95.jpg" width="121" height="45" alt="" /><br />
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>

       </div>
       <div class="kf02"><img src="resource/front/images/fc_97.jpg" width="124" height="45" alt="" /><br />
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>

       </div>
       <div class="kf02"><img src="resource/front/images/fc_99.jpg" width="129" height="45" alt="" /><br />
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>

       </div>
       <div class="kf03"><img src="resource/front/images/fc_101.jpg" width="119" height="45" alt="" /><br />
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>
<li><a href="#">网上下单</a></li>

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
