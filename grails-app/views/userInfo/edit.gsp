<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">×</button>

    <h3>编辑客户信息</h3>
</div>

<div class="modal-body">
    <form id="infoForm" role="form">
        <input type="hidden" id="id" name="id" value="${userInfo.id}">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="name"  value="${userInfo.name}">
        </div>

        <div class="form-group">
            <label for="code">编号</label>
            <input type="text" class="form-control" id="code" name="code"  value="${userInfo.code}">
        </div>

        <div class="form-group">
            <label for="mobile">手机号</label>
            <input type="number" class="form-control" id="mobile" name="mobile" value="${userInfo.mobile}">
        </div>

        <div class="form-group">
            <label for="password">密码(不小于6位)</label>
            <input type="password" class="form-control" id="password" name="password" value="${userInfo.password}">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${userInfo.email}">
        </div>

        <div class="form-group">
            <label for="company">公司</label>
            <input type="text" class="form-control" id="company" name="company" value="${userInfo.company}">
        </div>

        <div class="form-group">
            <label for="sideNum">站点数量</label>
            <input type="number" class="form-control" id="sideNum" name="sideNum" value="${userInfo.sideNum}">
        </div>

        <div class="form-group">
            <label for="installedCapacity">装机容量(kWh)</label>
            <input type="number" class="form-control" id="installedCapacity" name="installedCapacity"
                    value="${userInfo.installedCapacity}">
        </div>
    </form>
</div>

<div class="modal-footer">
    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
    <a href="javascript:postAjaxForm();" class="btn btn-primary">更新</a>
</div>