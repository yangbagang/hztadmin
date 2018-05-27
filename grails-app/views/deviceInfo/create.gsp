<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>新建设备</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="名称">
        </div>

        <div class="form-group">
            <label for="uid">uid</label>
            <input type="text" class="form-control" id="uid" name="uid" placeholder="uid">
        </div>

        <div class="form-group">
            <label for="installedCapacity">容量(kWh)</label>
            <input type="number" class="form-control" id="installedCapacity" name="installedCapacity" placeholder="容量">
        </div>

        <div class="form-group">
            <label for="catalogId">分类</label>
            <select name="deviceCatalog.id" id="catalogId">
                <g:each in="${catalogList}" var="catalog">
                    <option value="${catalog.id}">${catalog.name}</option>
                </g:each>
            </select>
        </div>

    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
    <a href="javascript:postAjaxForm();" class="btn btn-primary">保存</a>
</div>