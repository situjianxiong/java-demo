package com.oven.contants;

/**
 * Reids缓存使用的key定义类
 *
 * @author Oven
 */
public class RedisCacheKey {

    // 用户实体类缓存key定义
    public static final String USER_PREFIX = "user_";
    public static final String USER_GET_ALL = "user_getAll";
    public static final String USER_GET_BY_ID = "user_getById_";
    public static final String USER_GET_BY_PAGE = "user_getByPage_";
    public static final String USER_GET_BY_USERNAME = "user_getByUserName_";
    public static final String USER_GET_TOTAL_NUM = "user_getTotalNum_";

    // 员工实体类缓存key定义
    public static final String EMPLOYEE_PREFIX = "employee_";
    public static final String EMPLOYEE_GET_BY_ID = "employee_getById_";
    public static final String EMPLOYEE_GET_BY_PAGE = "employee_getByPage_";
    public static final String EMPLOYEE_GET_TOTAL_NUM = "employee_getTotalNum_";

    // 工地实体类缓存定义
    public static final String WORKSITE_PREFIX = "worksite_";
    public static final String WORKSITE_GET_BY_ID = "worksite_getById_";
    public static final String WORKSITE_GET_BY_PAGE = "worksite_getByPage_";
    public static final String WORKSITE_GET_TOTAL_NUM = "worksite_getTotalNum_";

    // 角色实体类缓存key定义
    public static final String ROLE_PREFIX = "role_";
    public static final String ROLE_GET_BY_ID = "role_getById_";
    public static final String ROLE_GET_BY_PAGE = "role_getByPage_";
    public static final String ROLE_GET_ALL = "role_getAll_";
    public static final String ROLE_GET_BY_USERNAME = "role_getByUserName_";
    public static final String ROLE_GET_TOTAL_NUM = "role_getTotalNum_";

    // 日志实体类缓存key定义
    public static final String LOG_PREFIX = "log_";
    public static final String LOG_GET_BY_ID = "log_getById_";
    public static final String LOG_GET_BY_PAGE = "log_getByPage_";
    public static final String LOG_GET_TOTAL_NUM = "log_getTotalNum_";

    // 菜单实体类缓存key定义
    public static final String MENU_PREFIX = "menu_";
    public static final String MENU_GET_BY_ID = "menu_getById_";
    public static final String MENU_GET_BY_PID = "menu_getByPid_";
    public static final String MENU_GET_MENU_TREE_BY_USERID = "menu_getMenuTreeByUserId_";
    public static final String MENU_GET_MENU_TREE_DATLE_DATA = "menu_getMenuTreeTableData";
    public static final String MENU_GET_BY_PID_AND_HASPERMISSION = "menu_getByPidAndHasPermission_";

    // 用户角色关系实体类缓存key定义
    public static final String USERROLE_PREFIX = "userRole_";
    public static final String USERROLE_GET_BY_USERID = "userRole_getByUserId_";
    public static final String USERROLE_GET_BY_USERID_AND_ROLEID = "userRole_getByUserIdAndRoleId_";
    public static final String USERROLE_GET_ROLE_BY_USERID = "userRole_getRoleByUserId_";

    // 角色菜单关系实体类缓存key定义
    public static final String ROLEMENU_PREFIX = "roleMenu_";
    public static final String ROLEMENU_GET_BY_ROLEID = "roleMenu_getByRoleId_";
    public static final String ROLEMENU_GET_BY_ROLEID_AND_MENUID = "roleMenu_getByRoleIdAndMenuId_";

    // 用户菜单编码
    public static final String USER_MENU_CODES = "userMenuCodes_";

}
