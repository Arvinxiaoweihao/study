layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#inputDate', //指定元素
    type: 'date',
    max: 0
  });
});