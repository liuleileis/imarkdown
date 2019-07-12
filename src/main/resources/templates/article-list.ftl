<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>article list</title>
    <link rel="stylesheet" href="${re.contextPath}/layui/css/layui.css" media="all">
</head>
<body>

<table class="layui-hide" id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="${re.contextPath}/layui/layui.js"></script>
<script>


    layui.use([ 'laypage', 'layer', 'table'], function(){
        var laypage = layui.laypage //分页
                ,layer = layui.layer //弹层
                ,table = layui.table;//表格


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 700
            ,url: '/imarkdown/show-all' //数据接口
            ,title: '文章列表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', width:'5%', fixed: 'left'}
                ,{field: 'articleId', title: '编号', width:'10%', sort: true, fixed: 'left'}
                ,{field: 'articleTitle', title: '标题', width:'40%'}
                // ,{field: 'articleContent', title: '内容', width: 90}
                // ,{field: 'articleHtml', title: 'HTML', width:80}
                ,{field: 'articleAuthor', title: '作者', width: '15%'}
                ,{field: 'articleTime', title: '时间', width:'15%', sort: true}
                ,{fixed: 'right', title: '操作',width: "15%", align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                    ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.msg('添加');
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        console.log(data[0].articleId);
                        layui.jquery.get("/imarkdown/edit/" + data[0].articleId);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                    ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
            }
        });


        //分页
        laypage.render({
            elem: 'demo' //分页容器的id
            ,count: 100 //总页数
            ,skin: '#1E9FFF' //自定义选中色值
            ,skip: true //开启跳页
            ,id:'article_id'
            ,limit:5
            ,limits:[3,5,10,15]
            ,jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页', {offset: 'b'});
                }
            }
        });




    });
</script>
</body>
</html>
