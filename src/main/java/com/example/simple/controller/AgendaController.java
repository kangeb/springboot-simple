package com.example.simple.controller;

import com.example.simple.core.Exception.CustomException;
import com.example.simple.core.response.Response;
import com.example.simple.domain.Agenda;
import com.example.simple.service.impl.AgendaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日程控制器
 * 处理日程相关的HTTP请求
 */
@Api(value = "日程管理", tags = "日程相关接口")
@RestController
@RequestMapping("api/agendas/")
public class AgendaController {

    @Resource
    private AgendaServiceImpl agendaServiceImpl;

    private static final Logger log = Logger.getLogger(AgendaController.class);

    /**
     * 保存日程
     *
     * @param agenda 日程信息
     * @return 保存结果
     */
    @ApiOperation(value = "添加日程", notes = "添加新的日程信息")
    @RequestMapping(value = "agenda", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Response saveAgenda(@ApiParam(value = "日程信息", required = true) Agenda agenda) {
        try {
            // 执行数据库添加操作
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
     *
     * @param uuid 日程UUID
     * @return 删除结果
     */
    @ApiOperation(value = "删除日程", notes = "根据UUID删除日程")
    @RequestMapping(value = "agenda/{uuid}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Response removeAgenda(@ApiParam(value = "日程UUID", required = true) @PathVariable("uuid") String uuid) {
        try {
            // 执行数据库删除操作
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
     *
     * @param ids 日程UUID列表，逗号分隔
     * @return 删除结果
     */
    @ApiOperation(value = "批量删除日程", notes = "批量删除日程信息")
    @RequestMapping(value = "agendas", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Response removeMoreAgenda(@ApiParam(value = "日程UUID列表，逗号分隔", required = true) String ids) {
        try {
            // 执行数据库批量删除操作
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
     *
     * @param agenda 日程信息
     * @return 修改结果
     */
    @ApiOperation(value = "修改日程", notes = "修改日程信息")
    @RequestMapping(value = "agenda", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Response modifyAgenda(@ApiParam(value = "日程信息", required = true) Agenda agenda) {
        try {
            // 执行数据库修改操作
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
     *
     * @param uuid 日程UUID
     * @return 日程信息
     */
    @ApiOperation(value = "查询日程", notes = "根据UUID查询日程详情")
    @RequestMapping(value = "agenda/{uuid}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Response queryAgenda(@ApiParam(value = "日程UUID", required = true) @PathVariable("uuid") String uuid) {
        try {
            // 执行数据库查询操作
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
