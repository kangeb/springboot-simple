package com.kang.springboot.simple.service;


import com.github.pagehelper.Page;
import com.kang.springboot.simple.domain.Agenda;

public interface IAgendaService {
	public Integer saveAgenda(Agenda agenda);
	public Integer removeAgenda(String uuid);
	public Integer modifyAgenda(Agenda agenda);
	public Agenda queryAgendaByUuid(String uuid);
	public Page<Agenda> queryAgendaByPage(Agenda agenda);
	public Integer removeMoreAgenda(String ids) ;
	//public Page<Agenda> queryAgendaByPage( Integer currentPage,  Integer pageSize);
}
