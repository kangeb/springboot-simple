package com.example.simple.service;

import com.example.simple.domain.Agenda;

/**
 * 日程服务接口
 * 定义日程相关的业务操作方法
 */
public interface IAgendaService {

    /**
     * 保存日程
     * @param agenda 日程对象
     * @return 影响的行数
     */
    Integer saveAgenda(Agenda agenda);

    /**
     * 删除日程
     * @param uuid 日程唯一标识
     * @return 影响的行数
     */
    Integer removeAgenda(String uuid);

    /**
     * 修改日程
     * @param agenda 日程对象
     * @return 影响的行数
     */
    Integer modifyAgenda(Agenda agenda);

    /**
     * 根据UUID查询日程
     * @param uuid 日程唯一标识
     * @return 日程对象
     */
    Agenda queryAgendaByUuid(String uuid);

    /**
     * 批量删除日程
     * @param ids 日程ID字符串，多个ID用逗号分隔
     * @return 影响的行数
     */
    Integer removeMoreAgenda(String ids);
}
