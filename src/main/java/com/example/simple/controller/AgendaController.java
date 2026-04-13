package com.example.simple.controller;

import com.example.simple.core.Exception.CustomException;
import com.example.simple.core.response.Response;
import com.example.simple.domain.Agenda;
import com.example.simple.service.impl.AgendaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日程控制器
 * 提供日程相关的REST API接口
 */
@RestController
@RequestMapping("api/agendas/")
@Api(tags = "日程管理接口")
public class AgendaController {

    @Resource
    private AgendaServiceImpl agendaServiceImpl;

    private static final Logger log = Logger.getLogger(AgendaController.class);

    /**
     * 新增日程
     * @param agenda 日程对象
     * @return 响应结果
     */
    @RequestMapping(value = "agenda", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "新增日程", notes = "创建新的日程记录")
    public Response saveAgenda(Agenda agenda) {
        try {
            if (agendaServiceImpl.saveAgenda(agenda) > 0) {
                return new Response().success("添加成功");
            } else {
                return new Response().failure("添加失败");
            }
        } catch (Exception e) {
            return new Response().failure("添加失败");
        }
    }

    /**
     * 删除日程
     * @param uuid 日程唯一标识
     * @return 响应结果
     */
    @RequestMapping(value = "agenda/{uuid}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除日程", notes = "根据UUID删除日程")
    public Response removeAgenda(@PathVariable("uuid") String uuid) {
        try {
            if (agendaServiceImpl.removeAgenda(uuid) > 0) {
                return new Response().success("删除成功");
            } else {
                return new Response().failure("删除失败");
            }
        } catch (Exception e) {
            return new Response().failure("删除失败");
        }
    }

    /**
     * 批量删除日程
     * @param ids 日程ID字符串，多个ID用逗号分隔
     * @return 响应结果
     */
    @RequestMapping(value = "agendas", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "批量删除日程", notes = "根据多个UUID批量删除日程")
    public Response removeMoreAgenda(String ids) {
        try {
            if (agendaServiceImpl.removeMoreAgenda(ids) > 0) {
                return new Response().success("删除成功");
            } else {
                return new Response().failure("删除失败");
            }
        } catch (Exception e) {
            return new Response().failure("删除失败");
        }
    }

    /**
     * 修改日程
     * @param agenda 日程对象
     * @return 响应结果
     */
    @RequestMapping(value = "agenda", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "修改日程", notes = "更新日程信息")
    public Response modifyAgenda(Agenda agenda) {
        try {
            if (agendaServiceImpl.modifyAgenda(agenda) > 0) {
                return new Response().success("修改成功");
            } else {
                return new Response().failure("修改失败");
            }
        } catch (Exception e) {
            return new Response().failure("修改失败");
        }
    }

    /**
     * 查询日程
     * @param uuid 日程唯一标识
     * @return 响应结果
     */
    @RequestMapping(value = "agenda/{uuid}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ApiOperation(value = "查询日程", notes = "根据UUID查询日程详情")
    public Response queryAgenda(@PathVariable("uuid") String uuid) {
        try {
            Agenda agendaResult = agendaServiceImpl.queryAgendaByUuid(uuid);
            if (agendaResult != null) {
                return new Response().success(agendaResult);
            } else {
                throw new CustomException("未查询到任何相关信息");
            }
        } catch (Exception e) {
            return new Response().failure("未查询到任何相关信息");
        }
    }
}
