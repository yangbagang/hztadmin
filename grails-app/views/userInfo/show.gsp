<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>客户信息详情</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name" readonly="readonly" value="${userInfo.name}">
        </div>

        <div class="form-group">
            <label for="code">编号</label>
            <input type="text" class="form-control" id="code" name="code" readonly="readonly" value="${userInfo.code}">
        </div>

        <div class="form-group">
            <label for="mobile">手机号</label>
            <input type="number" class="form-control" id="mobile" name="mobile" readonly="readonly"
                   value="${userInfo.mobile}">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" readonly="readonly"
                   value="${userInfo.email}">
        </div>

        <div class="form-group">
            <label for="company">公司</label>
            <input type="text" class="form-control" id="company" name="company" readonly="readonly"
                   value="${userInfo.company}">
        </div>

        <div class="form-group">
            <label for="sideNum">站点数量</label>
            <input type="number" class="form-control" id="sideNum" name="sideNum" readonly="readonly"
                   value="${userInfo.sideNum}">
        </div>

        <div class="form-group">
            <label for="installedCapacity">装机容量(kWh)</label>
            <input type="number" class="form-control" id="installedCapacity" name="installedCapacity"
                   readonly="readonly" value="${userInfo.installedCapacity}">
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
</div>