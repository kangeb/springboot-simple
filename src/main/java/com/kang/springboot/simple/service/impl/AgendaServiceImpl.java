package com.kang.springboot.simple.service.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kang.springboot.simple.Mapper.AgendaMapper;
import com.kang.springboot.simple.core.service.RedisService;
import com.kang.springboot.simple.domain.Agenda;
import com.kang.springboot.simple.service.IAgendaService;
@Service("agendaServiceImpl")
public class AgendaServiceImpl implements IAgendaService{
	@Resource
	private AgendaMapper agendaMapper;
	@Resource
    private RedisService redisServiceImpl ;
	
	public Integer saveAgenda(Agenda agenda) {
		Integer result=agendaMapper.addAgenda(agenda);
		if(result>0) {
			redisServiceImpl.set(agenda.getUuid(),agenda);
		}
		return result;
		
	}

	public Integer removeAgenda(String uuid) {
		return agendaMapper.deleteAgenda(uuid);	
	}

	@Override
	public Integer modifyAgenda(Agenda agenda) {
		return agendaMapper.updateAgenda(agenda);
	}

	@Override
	public Agenda queryAgendaByUuid(String uuid) {
		if(redisServiceImpl.get(uuid)!=null) {
			return (Agenda) redisServiceImpl.get(uuid);
		}else {
			redisServiceImpl.set(uuid,agendaMapper.selectAgendaByUuid(uuid));
			return agendaMapper.selectAgendaByUuid(uuid);			
		}				
	}

	@Override
	public Page<Agenda> queryAgendaByPage(Agenda agenda) {
		int currentPage= Integer.parseInt(agenda.getCurrentPage());
		int pageSize=Integer.parseInt(agenda.getPageSize());
		PageHelper.startPage(currentPage,pageSize );
		Page<Agenda> pageInfo = agendaMapper.selectByPage(agenda);
        return pageInfo;
		
	}

	public Integer removeMoreAgenda(String ids) {
		String[] strArray=ids.split(",");
		return agendaMapper.deleteMoreAgenda(strArray);
		
	}


}
