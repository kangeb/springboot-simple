package com.example.simple.Mapper;

import com.example.simple.domain.Agenda;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;



@MapperScan
public interface AgendaMapper {
	@Insert("insert into ssmapi_agenda(uuid,name,title,details,date,remark) values(uuid(),#{name},#{title},#{details},#{date},#{remark})")
	Integer addAgenda(Agenda agenda);
	@Delete("DELETE FROM ssmapi_agenda WHERE uuid=#{uuid}")
	Integer deleteAgenda(String uuid);
	@Update("UPDATE ssmapi_agenda  SET   name=#{name},title=#{title},details=#{details},date=#{date},remark=#{remark} WHERE uuid=#{uuid}")
	Integer updateAgenda(Agenda agenda);
	@Select("select uuid,name,title,details,date,remark from ssmapi_agenda where uuid=#{uuid}")
	Agenda selectAgendaByUuid(String uuid);
//	@Select("<script>"
//			+" select uuid,name,title,details,date,remark"
//			+" from ssmapi_agenda"
//			+" <where>"
//			+" <if test=\"date!=null\">"
//			+" and date=#{date}"
//			+" </if>"
//			+" </where>"
//			+" order by date desc"
//			+" </script>")
//	Page<Agenda> selectByPage(Agenda agenda);
	@Delete("<script>"
			+" DELETE FROM ssmapi_agenda WHERE uuid in "
			+" <foreach collection=\"array\" item=\"uuid\" index=\"index\" "
			+" open=\"(\" close=\")\" separator=\",\"> " 
			+" #{uuid} " 
			+" </foreach>"
			+" </script>")
	Integer deleteMoreAgenda(String[] ids);

}
