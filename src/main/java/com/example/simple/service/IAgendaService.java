package com.example.simple.service;

import com.example.simple.domain.Agenda;

/**
 * 日程服务接口
 * 定义日程相关的业务逻辑操作
 */
public interface IAgendaService {

    /**
     * 保存日程
     *
     * @param agenda 要保存的日程对象
     * @return 影响的行数
     */
    Integer saveAgenda(Agenda agenda);

    /**
     * 删除日程
     *
     * @param uuid 日程UUID
     * @return 影响的行数
     */
    Integer removeAgenda(String uuid);

    /**
     * 修改日程
     *
     * @param agenda 要修改的日程对象
     * @return 影响的行数
     */
    Integer modifyAgenda(Agenda agenda);

    /**
     * 根据UUID查询日程
     *
     * @param uuid 日程UUID
     * @return 查询到的日程对象
     */
    Agenda queryAgendaByUuid(String uuid);

    /**
     * 批量删除日程
     *
     * @param ids 要删除的日程UUID列表，逗号分隔
     * @return 影响的行数
     */
    Integer removeMoreAgenda(String ids);
}
