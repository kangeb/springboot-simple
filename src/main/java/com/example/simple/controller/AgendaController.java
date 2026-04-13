package com.example.simple.controller;

import com.example.simple.core.Exception.CustomException;
import com.example.simple.core.response.Response;
import com.example.simple.domain.Agenda;
import com.example.simple.service.impl.AgendaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "日程管理接口")
@RestController
@RequestMapping("api/agendas/")
public class AgendaController {

	@Resource
	private AgendaServiceImpl agendaServiceImpl;

	private static final Logger log = Logger.getLogger(AgendaController.class);

	@ApiOperation("添加日程")
	@PostMapping(value="agenda", produces="application/json;charset=utf-8")
	public Response saveAgenda(@ApiParam("日程信息") Agenda agenda){
		try {
			if(agendaServiceImpl.saveAgenda(agenda) > 0) {
				return new Response().success("添加成功");
			}else {
				return new Response().failure("添加失败");
			}
		} catch (Exception e) {
			log.error("添加日程失败", e);
			return new Response().failure("添加失败");
		}
	}

	@ApiOperation("删除单个日程")
	@DeleteMapping(value="agenda/{uuid}", produces="application/json;charset=utf-8")
	public Response removeAgenda(@ApiParam("日程UUID") @PathVariable("uuid") String uuid){
		try {
			if(agendaServiceImpl.removeAgenda(uuid) > 0) {
				return new Response().success("删除成功");
			}else {
				return new Response().failure("删除失败");
			}
		} catch (Exception e) {
			log.error("删除日程失败", e);
			return new Response().failure("删除失败");
		}
	}

	@ApiOperation("批量删除日程")
	@DeleteMapping(value="agendas", produces="application/json;charset=utf-8")
	public Response removeMoreAgenda(@ApiParam("日程ID数组，逗号分隔") String ids){
		try {
			if(agendaServiceImpl.removeMoreAgenda(ids) > 0) {
				return new Response().success("删除成功");
			}else {
				return new Response().failure("删除失败");
			}
		} catch (Exception e) {
			log.error("批量删除日程失败", e);
			return new Response().failure("删除失败");
		}
	}

	@ApiOperation("修改日程")
	@PutMapping(value="agenda", produces="application/json;charset=utf-8")
	public Response modifyAgenda(@ApiParam("日程信息") Agenda agenda){
		try {
			if(agendaServiceImpl.modifyAgenda(agenda) > 0) {
				return new Response().success("修改成功");
			}else {
				return new Response().failure("修改失败");
			}
		} catch (Exception e) {
			log.error("修改日程失败", e);
			return new Response().failure("修改失败");
		}
	}

	@ApiOperation("根据UUID查询日程详情")
	@GetMapping(value="agenda/{uuid}", produces="application/json;charset=utf-8")
	public Response queryAgenda(@ApiParam("日程UUID") @PathVariable("uuid") String uuid){
		try {
			Agenda agendaResult = agendaServiceImpl.queryAgendaByUuid(uuid);
			if(agendaResult != null) {
				return new Response().success(agendaResult);
			}else {
				throw new CustomException("未查询到任何相关信息");
			}
		} catch (Exception e) {
			log.error("查询日程失败", e);
			return new Response().failure("未查询到任何相关信息");
		}
	}
}
