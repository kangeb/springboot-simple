package com.example.simple.Mapper;

import com.example.simple.domain.Agenda;
import org.springframework.stereotype.Repository;

/**
 * 日程数据访问层接口
 * 提供日程相关的数据库操作方法
 */
@Repository
public interface AgendaMapper {

    /**
     * 新增日程
     * @param agenda 日程对象
     * @return 影响的行数
     */
    Integer addAgenda(Agenda agenda);

    /**
     * 根据UUID删除日程
     * @param uuid 日程唯一标识
     * @return 影响的行数
     */
    Integer deleteAgenda(String uuid);

    /**
     * 更新日程信息
     * @param agenda 日程对象
     * @return 影响的行数
     */
    Integer updateAgenda(Agenda agenda);

    /**
     * 根据UUID查询日程
     * @param uuid 日程唯一标识
     * @return 日程对象
     */
    Agenda selectAgendaByUuid(String uuid);

    /**
     * 批量删除日程
     * @param ids 日程UUID数组
     * @return 影响的行数
     */
    Integer deleteMoreAgenda(String[] ids);

}
