<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>编辑分类信息</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <input type="hidden" name="id" id="id" value="${deviceCatalog.id}">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name"  value="${deviceCatalog.name}">
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
    <a href="javascript:postAjaxForm();" class="btn btn-primary">更新</a>
</div>