package com.example.simple.Mapper;

import com.example.simple.domain.Agenda;
import org.springframework.stereotype.Repository;

/**
 * 日程数据访问接口
 * 使用MyBatis XML配置方式实现
 */
@Repository
public interface AgendaMapper {

    /**
     * 添加日程
     *
     * @param agenda 要添加的日程对象
     * @return 影响的行数
     */
    Integer addAgenda(Agenda agenda);

    /**
     * 根据UUID删除日程
     *
     * @param uuid 日程UUID
     * @return 影响的行数
     */
    Integer deleteAgenda(String uuid);

    /**
     * 更新日程
     *
     * @param agenda 要更新的日程对象
     * @return 影响的行数
     */
    Integer updateAgenda(Agenda agenda);

    /**
     * 根据UUID查询日程
     *
     * @param uuid 日程UUID
     * @return 查询到的日程对象
     */
    Agenda selectAgendaByUuid(String uuid);

    /**
     * 批量删除日程
     *
     * @param ids 要删除的日程UUID数组
     * @return 影响的行数
     */
    Integer deleteMoreAgenda(String[] ids);
}
