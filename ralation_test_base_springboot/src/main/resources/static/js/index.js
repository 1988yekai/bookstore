/**
 * Created by Administrator on 2018-03-31.
 */
var queryParams = {};
$(document).ready(function(){
    //table init
    $('#students-table').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url:"/student/list",//要请求数据的路径
        // height:tableHeight(),//高度调整
        toolbar: '#toolbar',//指定工具栏
        striped: true, //是否显示行间隔色
        //dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的
        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination:true,//是否分页
        queryParamsType:'limit',//查询参数组织方式
        queryParams:queryParams,//请求服务器时所传的参数
        sidePagination:'server',//指定服务器端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign:'right',//工具栏对齐方式
        buttonsAlign:'right',//按钮对齐方式
        toolbar:'#toolbar',//指定工作栏
        columns:[
            {
                title:'全选',
                field:'select',
                //复选框
                checkbox:true,
                width:25,
                align:'center',
                valign:'middle'
            },
            {
                title:'ID',
                field:'sid',
                visible:true
            },
            {
                title:'姓名',
                field:'name',
                sortable:true
            },
            {
                title:'年龄',
                field:'age',
                sortable:true
            },
            {
                title:'班级',
                field:'cid',
                align:'center',
                //列数据格式化
                formatter:function(value,row,index){
                    $.ajax({
                        type: "POST",
                        url: "some.php",
                        data: {cid:value},
                        success: function(msg){
                            alert( "Data Saved: " + msg );
                        }
                    });
                }
            }
        ],
        classes:'table table-striped table-bordered table-hover ',
        //得到查询的参数
        queryParams : function (params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                rows: params.limit,                         //页面大小
                page: (params.offset / params.limit) + 1,   //页码
                sort: params.sort,      //排序列名
                sortOrder: params.order //排位命令（desc，asc）
            };
            return temp;
        },
    });
});