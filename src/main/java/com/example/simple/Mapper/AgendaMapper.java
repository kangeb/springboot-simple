package com.example.simple.Mapper;

import com.example.simple.domain.Agenda;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AgendaMapper {

	Integer addAgenda(Agenda agenda);

	Integer deleteAgenda(String uuid);

	Integer updateAgenda(Agenda agenda);

	Agenda selectAgendaByUuid(String uuid);

	Integer deleteMoreAgenda(String[] ids);

}
