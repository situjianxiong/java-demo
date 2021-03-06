package com.oven.controller;

import com.alibaba.fastjson.JSONObject;
import com.oven.contants.PermissionCode;
import com.oven.enumerate.ResultEnum;
import com.oven.exception.MyException;
import com.oven.service.LogService;
import com.oven.service.UserService;
import com.oven.vo.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志控制层
 *
 * @author Oven
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    @Resource
    private LogService logService;
    @Resource
    private UserService userService;

    /**
     * 去到日志管理页面
     */
    @RequestMapping("/index")
    @RequiresPermissions(PermissionCode.LOG_MANAGER)
    public String index() {
        return "log/log";
    }

    /**
     * 通过ID获取日志
     *
     * @param id 日志ID
     */
    @RequestMapping("/getById")
    @RequiresPermissions(PermissionCode.LOG_MANAGER)
    @ResponseBody
    public Object getById(Integer id) throws MyException {
        try {
            return super.success(logService.getById(id));
        } catch (Exception e) {
            throw new MyException(ResultEnum.SEARCH_ERROR.getCode(), ResultEnum.SEARCH_ERROR.getValue(), e);
        }
    }

    /**
     * 分页获取日志
     *
     * @param page  页码
     * @param limit 每页显示数量
     */
    @RequestMapping("/getByPage")
    @RequiresPermissions(PermissionCode.LOG_MANAGER)
    @ResponseBody
    public Object getByPage(Integer page, Integer limit, Log logVo) throws MyException {
        try {
            JSONObject result = new JSONObject();
            List<Log> list = logService.getByPage(page, limit, logVo);
            Long totalNum = logService.getTotalNum(logVo);
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", totalNum);
            result.put("data", list);
            return result;
        } catch (Exception e) {
            throw new MyException(ResultEnum.SEARCH_PAGE_ERROR.getCode(), ResultEnum.SEARCH_PAGE_ERROR.getValue(), e);
        }
    }

}
