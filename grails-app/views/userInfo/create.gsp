<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>新建客户</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="客户名称">
        </div>

        <div class="form-group">
            <label for="code">编号</label>
            <input type="text" class="form-control" id="code" name="code" placeholder="客户编号">
        </div>

        <div class="form-group">
            <label for="mobile">手机</label>
            <input type="number" class="form-control" id="mobile" name="mobile" placeholder="手机号">
        </div>

        <div class="form-group">
            <label for="password">密码(不小于6位)</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
        </div>

        <div class="form-group">
            <label for="company">公司</label>
            <input type="text" class="form-control" id="company" name="company" placeholder="公司名称">
        </div>

        <div class="form-group">
            <label for="sideNum">站点数量</label>
            <input type="number" class="form-control" id="sideNum" name="sideNum" placeholder="站点数量">
        </div>

        <div class="form-group">
            <label for="installedCapacity">装机容量(kWh)</label>
            <input type="number" class="form-control" id="installedCapacity" name="installedCapacity"
                   placeholder="装机容量">
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
    <a href="javascript:postAjaxForm();" class="btn btn-primary">保存</a>
</div>