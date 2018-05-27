<div>
    <ul class="breadcrumb">
        <li>
            <a href="#">设备管理</a>
        </li>
        <li>
            <a href="#">告警信息</a>
        </li>
    </ul>
</div>
<div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> 告警信息</h2>
        <div class="box-icon">
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
            <a href="#" class="btn btn-close btn-round btn-default"><i
                    class="glyphicon glyphicon-remove"></i></a>
        </div>
    </div>
</div>
<div class="box-content">
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
                "url":"warningMsg/list",
                "dataSrc": "data",
                "data": function ( d ) {
                    //添加额外的参数传给服务器
                    d.name = $("#name").val();
                }
            },
            "order": [[5, 'desc']], // 默认排序(第三列降序, asc升序)
            "columns": [
                { "title": "UID", "data" : "uid", "orderable": true, "searchable": false },
                { "title": "NUM", "data" : "num", "orderable": true, "searchable": false },
                { "title": "告警项", "data" : "itemName", "orderable": true, "searchable": false },
                { "title": "告警值", "data" : "itemValue", "orderable": false, "searchable": false },
                { "title": "标志", "data" : function (data) {
                        return data.flag == 1 ? "过高" : "过低";
                    }, "orderable": false, "searchable": false },
                { "title": "发生时间", "data" : "createTime", "orderable": true, "searchable": false },
                { "title": "是否己读", "data" : function (data) {
                        return data.hasRead == 1 ? "己读" : "未读";
                    }, "orderable": false, "searchable": false },
                { "title": "阅读者", "data" : "userName", "orderable": true, "searchable": false },
                { "title": "阅读时间", "data" : "readTime", "orderable": true, "searchable": false }
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
    });

</script>