<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>新建参数</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <input type="hidden" id="catalogId" name="deviceCatalog.id" value="${catalogId}">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="名称">
        </div>

        <div class="form-group">
            <label for="label">标签</label>
            <input type="text" class="form-control" id="label" name="label" placeholder="标签">
        </div>

        <div class="form-group">
            <label for="unit">单位</label>
            <input type="text" class="form-control" id="unit" name="unit" placeholder="单位">
        </div>

        <div class="form-group">
            <label for="minValue">最小值</label>
            <input type="text" class="form-control" id="minValue" name="minValue" placeholder="最小值">
        </div>

        <div class="form-group">
            <label for="maxValue">最大值</label>
            <input type="text" class="form-control" id="maxValue" name="maxValue" placeholder="最大值">
        </div>

        <div class="form-group">
            <label>是否启用</label>
            <label class="radio-inline">
                <input type="radio" id="enableCheck1" name="enableCheck" value="1" checked="checked"> 启用
            </label>
            <label class="radio-inline">
                <input type="radio" id="enableCheck2" name="enableCheck" value="0"> 停用
            </label>
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
    <a href="javascript:postAjaxForm();" class="btn btn-primary">保存</a>
</div>