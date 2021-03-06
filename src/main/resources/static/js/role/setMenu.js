//@sourceURL=/js/role/setMenu.js
$(function() {

    // 移除tree图标
    $('#permission_tree').find("span.tree-icon").removeClass('tree-icon tree-folder tree-folder-open');
    $('#permission_tree').find("span.tree-hit").removeClass('tree-expanded');
    $('#permission_tree').find("span.tree-file").removeClass('tree-file');
    $("#permission_tree span[class^='tree-icon tree-file']").remove();

    var roleId = $("#roleId").val();
    $('#permission_tree').tree({
        url: "/role/getRoleMenuTree?roleId=" + roleId,
        method: "GET",
        animate: true,
        lines: true,
        onClick: function(node) {
            if (node.state == 'closed' && (!$("#permission_tree").tree('isLeaf', node.target))) { // 状态为关闭而且非叶子节点
                $(this).tree('expand', node.target); // 点击文字展开菜单
                if (node.attributes && node.attributes.url) {
                    openPanel(node.attributes.url, node.text);
                }
            } else {
                if ($("#permission_tree").tree('isLeaf', node.target)) { // 状态为打开而且为叶子节点
                    if (node.attributes && node.attributes.url) {
                        openPanel(node.attributes.url, node.text);
                    }
                } else {
                    $(this).tree('collapse', node.target); // 点击文字关闭菜单
                }
            }
        },
        onCheck: function(node, checked) {
            var childList = $(this).tree('getChildren', node.target);
            if (childList.length > 0) { // 有子菜单，点击的时候级联子菜单
                var checkedTrue = function() {
                    childList.map(function(currentValue) {
                        $("#" + currentValue.domId).parent().find(".tree-checkbox").removeClass("tree-checkbox0").removeClass("tree-checkbox2").addClass("tree-checkbox1");
                    });
                };
                var checkedFalse = function() {
                    $.each(childList, function(index, currentValue) {
                        $("#" + currentValue.domId).parent().find(".tree-checkbox").removeClass("tree-checkbox1").removeClass("tree-checkbox2").addClass("tree-checkbox0");
                    });
                };
                var checkChangeProperties = checked == true ? checkedTrue() : checkedFalse();
            } else { // 没有子菜单，即为叶子节点，点击的时候级联父节点
                var parentNode = $('#permission_tree').tree('getParent', node.target); //得到父节点
                if (checked == true) { // 选中子节点
                    var checkBoxList = $("#" + node.domId).parent().parent().find(".tree-checkbox");
                    for (var i=0; i<checkBoxList.length; i++) {
                        if ($(checkBoxList[i]).hasClass("tree-checkbox0")) {
                            $("#" + parentNode.domId).find(".tree-checkbox").removeClass("tree-checkbox0").removeClass("tree-checkbox1").addClass("tree-checkbox2");
                            return;
                        }
                    }
                    $("#" + parentNode.domId).find(".tree-checkbox").removeClass("tree-checkbox0").removeClass("tree-checkbox2").addClass("tree-checkbox1");
                } else { // 取消选中子节点
                    var checkBoxList = $("#" + node.domId).parent().parent().find(".tree-checkbox");
                    for (var i=0; i<checkBoxList.length; i++) {
                        if ($(checkBoxList[i]).hasClass("tree-checkbox1")) {
                            $("#" + parentNode.domId).find(".tree-checkbox").removeClass("tree-checkbox0").removeClass("tree-checkbox1").addClass("tree-checkbox2");
                            return;
                        }
                    }
                }
            }
        }
    });

    /**
     * 确认事件
     */
    $(".layui-btn").on("click",function() {
        var list = $('#permission_tree').find(".tree-checkbox"); // 不是获取选中的，而是获取所有节点
        var data = [];
        for (var i=0; i<list.length; i++) {
            var menuId = $("#permission_tree").tree("getNode", $(list[i]).parent()).id;
            if ($(list[i]).hasClass("tree-checkbox2") || $(list[i]).hasClass("tree-checkbox1")) {
                data.push(menuId);
            }
        }
        $.ajax({
            url: '/role/setRoleMenu',
            type: 'POST',
            async: true,
            data: {
                "menuIds": data.toString(),
                "roleId": roleId
            },
            dataType: "json",
            success: function(result) {
                if (result.code != 200) {
                    layer.open({
                        title: '系统提示',
                        content: result.data,
                        btnAlign: 'c'
                    });
                    return;
                }
                window.parent.mainFrm.location.href= "/role/index";
            }
        });
        return false;
    })
});