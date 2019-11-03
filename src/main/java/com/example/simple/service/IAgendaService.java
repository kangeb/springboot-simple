package com.example.simple.service;


import com.example.simple.domain.Agenda;

public interface IAgendaService {
	Integer saveAgenda(Agenda agenda);
	Integer removeAgenda(String uuid);
	Integer modifyAgenda(Agenda agenda);
	Agenda queryAgendaByUuid(String uuid);
	Integer removeMoreAgenda(String ids) ;
	//public Page<Agenda> queryAgendaByPage( Integer currentPage,  Integer pageSize);
}
