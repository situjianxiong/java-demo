//@sourceURL=/js/user/update.js

layui.use(['form', 'layedit', 'laydate'], function() {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    // 监听提交
    form.on('submit(user-update-submit)', function(data) {
        $.ajax({
            url: '/user/doUpdate',
            type: 'POST',
            data: data.field,
            dataType: 'json',
            success: function(result) {
                if (result.code != 200) {
                    layer.open({
                        title: '系统提示',
                        content: result.data,
                        btnAlign: 'c'
                    });
                    return;
                }
                window.location.href= "/user/index";
            }
        });
        return false;
    });
});
