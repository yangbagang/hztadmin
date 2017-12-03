<div>
    <ul class="breadcrumb">
        <li>
            <a href="#">电池管理</a>
        </li>
        <li>
            <a href="#">电池数据</a>
        </li>
    </ul>
</div>
<div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> 电池数据</h2>
        <div class="box-icon">
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
        </div>
    </div>
</div>
<div class="box-content">
    <form class="form-inline" role="form" action="#">
        <div class="form-group">
            <label class="control-label" for="name">名称:</label>
            <input type="text" class="form-control" id="name">
            <input type="button" class="btn btn-primary" value="查询" id="searcher"/>
        </div>
    </form><br />
    <div id="msgInfo" class="box-content alerts"></div>
    <table class="table table-striped table-bordered search_table" id="dataTable"></table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content" id="modal-content">

        </div>
    </div>
</div>

<script>
    var gridTable;
    $(document).ready(function(){
        var table=$('#dataTable').DataTable({
            "bLengthChange": true,
            "bFilter": false,
            "lengthMenu": [10, 20, 50, 100],
            "paginate": true,
            "processing": true,
            "pagingType": "full_numbers",
            "serverSide": true,
            "bAutoWidth": true,
            "ajax": {
                "url":"batteryHistoryData/list",
                "dataSrc": "data",
                "data": function ( d ) {
                    //添加额外的参数传给服务器
                    d.name = $("#name").val();
                }
            },
            "order": [[0, 'asc']], // 默认排序(第三列降序, asc升序)
            "columns": [
                { "title": "站", "data" : "uid", "orderable": true, "searchable": false },
                { "title": "序号", "data" : "num", "orderable": true, "searchable": false },
                { "title": "电压", "data" : "bv", "orderable": true, "searchable": false },
                { "title": "温度", "data" : "bt", "orderable": true, "searchable": false },
                { "title": "内阻", "data" : "br", "orderable": true, "searchable": false },
                { "title": "电流", "data" : "bi", "orderable": true, "searchable": false },
                { "title": "更新时间", "data" : "createTime", "orderable": true, "searchable": false },
                { "title": "操作", "data" : function (data) {
                    return '<a class="btn btn-success" href="javascript:showInfo('+data.id+');" title="查看">' +
                            '<i class="glyphicon glyphicon-zoom-in icon-white"></i></a>&nbsp;&nbsp;';
                }, "orderable": false, "searchable": false }
            ],
            "language": {
                "zeroRecords": "没有数据",
                "lengthMenu" : "_MENU_",
                "info": "显示第 _START_ 至 _END_ 条记录，共 _TOTAL_ 条",
                "loadingRecords": "加载中...",
                "processing": "加载中...",
                "infoFiltered": "",
                "infoEmpty": "暂无记录",
                "paginate": {
                    "first": "首页",
                    "last": "末页",
                    "next": "下一页",
                    "previous": "上一页"
                }
            }
        });
        gridTable = table;
        //查询 重新加载
        $("#searcher").click(function(){
            table.ajax.reload(null, false);
        });

    });

    function showInfo(id) {
        var url = '${createLink(controller: "batteryHistoryData", action: "show")}';
        $.ajax({
            type: "GET",
            url: url,
            data: "id=" + id,
            success: function (result) {
                var content = "" +
                        '<div class="modal-header">' +
                        '<button type="button" class="close" data-dismiss="modal">×</button>' +
                        '<h3>数据详情</h3>' +
                        '</div>' +
                        '<div class="modal-body">' +
                        '<form id="infoForm" role="form">' +
                        '<div class="form-group">' +
                        '<label for="uid">站号</label>' +
                        '<input type="text" class="form-control" id="uid" name="uid" readonly="readonly" value="'+result.uid+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="lac">基站定位</label>' +
                        '<input type="text" class="form-control" id="lac" name="lac" readonly="readonly" value="'+result.lac+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="cid">基站定位</label>' +
                        '<input type="text" class="form-control" id="cid" name="cid" readonly="readonly" value="'+result.cid+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="num">序号</label>' +
                        '<input type="text" class="form-control" id="num" name="num" readonly="readonly" value="'+result.num+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="bv">电压</label>' +
                        '<input type="text" class="form-control" id="bv" name="bv" readonly="readonly" value="'+result.bv+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="bt">温度</label>' +
                        '<input type="text" class="form-control" id="bt" name="bt" readonly="readonly" value="'+result.bt+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="br">内阻</label>' +
                        '<input type="text" class="form-control" id="br" name="br" readonly="readonly" value="'+result.br+'">' +
                        '</div>' +
                        '<div class="form-group">' +
                        '<label for="bi">电流</label>' +
                        '<input type="text" class="form-control" id="bi" name="bi" readonly="readonly" value="'+result.bi+'">' +
                        '</div>' +
                        '</form>' +
                        '</div>' +
                        '<div class="modal-footer">' +
                        '<a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>' +
                        '</div>';
                $("#modal-content").html("");
                $("#modal-content").html(content);
                $('#myModal').modal('show');
            },
            error: function (data) {
                showErrorInfo(data.responseText);
            }
        });
    }

</script>