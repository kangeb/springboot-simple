package com.kang.springboot.simple.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.kang.springboot.simple.core.Exception.CustomException;
import com.kang.springboot.simple.core.response.Response;
import com.kang.springboot.simple.domain.Agenda;
import com.kang.springboot.simple.service.impl.AgendaServiceImpl;


@RestController
@RequestMapping("api/agendas/")
public class AgendaController {
	@Resource
	private AgendaServiceImpl agendaServiceImpl;
	
	private static final Logger log = Logger.getLogger(AgendaController.class); 
	
	@RequestMapping(value="agenda",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	public Response saveAgenda(Agenda agenda){	
		try {
			//执行数据库添加操作
			if(agendaServiceImpl.saveAgenda(agenda)>0) {
				return new Response().success("添加成功");
			}else {
				return new Response().failure("添加失败");	
			}						
		} catch (Exception e) {
			return new Response().failure("添加失败");			
		}
	};
	@RequestMapping(value="agenda/{uuid}",method = RequestMethod.DELETE,produces="application/json;charset=utf-8")
	public Response removeAgenda(@PathVariable("uuid") String uuid){			
		try {
			//执行数据库删除操作
			if(agendaServiceImpl.removeAgenda(uuid)>0) {
				return new Response().success("删除成功");
			}else {
				return new Response().failure("删除失败");
			}
		} catch (Exception e) {
			return new Response().failure("删除失败");			
		}
	};
	@RequestMapping(value="agendas",method = RequestMethod.DELETE,produces="application/json;charset=utf-8")
	public Response removeMoreAgenda(String ids){
		try {
			//执行数据库批量删除操作
			if(agendaServiceImpl.removeMoreAgenda(ids)>0) {
				return new Response().success("删除成功");
			}else {
				return new Response().failure("删除失败");
			}		
		} catch (Exception e) {
			return new Response().failure("删除失败");			
		}
	};
	@RequestMapping(value="agenda",method = RequestMethod.PUT,produces="application/json;charset=utf-8")
	public Response modifyAgenda(Agenda agenda){			
		try {
			//执行数据库修改操作
			if(agendaServiceImpl.modifyAgenda(agenda)>0) {
				return new Response().success("修改成功");
			}else {
				return new Response().failure("修改失败");
			}			
		} catch (Exception e) {
			return new Response().failure("修改失败");			
		}
	};
	@RequestMapping(value="agenda/{uuid}",method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public Response queryAgenda(@PathVariable("uuid") String uuid){
		try {
			//执行数据库查询操作
			Agenda agendaResult=agendaServiceImpl.queryAgendaByUuid(uuid);
			if(agendaResult!=null) {
				return new Response().success(agendaResult);
			}else {
				throw new CustomException("未查询到任何相关信息");
			}
			
		} catch (Exception e) {
			return new Response().failure("未查询到任何相关信息");			
		}
	};
	//@RequestParam int currentPage, @RequestParam int pageSize,@RequestParam String date
	@RequestMapping(value="agendaPage",produces="application/json;charset=utf-8")
	public Response selectDocByPage( Agenda agenda){ 
		Page<Agenda> page=agendaServiceImpl.queryAgendaByPage(agenda);
		if(page==null) {
			Map map=new HashMap();
			map.put("pages", page.getPages());
			map.put("pageNum", page.getPageNum());
			map.put("pageSize", page.getPageSize());
			map.put("total", page.getTotal());
			map.put("data", page.getResult());
			return new Response().success(map);
		}else {
			return new Response().failure("未查询到任何相关信息");
		}
		
	}

	
}
