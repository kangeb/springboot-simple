package com.example.simple.service.impl;

import com.example.simple.Mapper.AgendaMapper;
import com.example.simple.core.service.RedisService;
import com.example.simple.domain.Agenda;
import com.example.simple.service.IAgendaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日程服务实现类
 * 实现日程相关的业务逻辑，包含Redis缓存功能
 */
@Service("agendaServiceImpl")
public class AgendaServiceImpl implements IAgendaService {

    @Resource
    private AgendaMapper agendaMapper;

    @Resource
    private RedisService redisServiceImpl;

    /**
     * 保存日程，同时缓存到Redis
     * @param agenda 日程对象
     * @return 影响的行数
     */
    public Integer saveAgenda(Agenda agenda) {
        Integer result = agendaMapper.addAgenda(agenda);
        if (result > 0) {
            redisServiceImpl.set(agenda.getUuid(), agenda);
        }
        return result;
    }

    /**
     * 删除日程
     * @param uuid 日程唯一标识
     * @return 影响的行数
     */
    public Integer removeAgenda(String uuid) {
        return agendaMapper.deleteAgenda(uuid);
    }

    /**
     * 修改日程
     * @param agenda 日程对象
     * @return 影响的行数
     */
    @Override
    public Integer modifyAgenda(Agenda agenda) {
        return agendaMapper.updateAgenda(agenda);
    }

    /**
     * 根据UUID查询日程，优先从Redis缓存获取
     * @param uuid 日程唯一标识
     * @return 日程对象
     */
    @Override
    public Agenda queryAgendaByUuid(String uuid) {
        if (redisServiceImpl.get(uuid) != null) {
            return (Agenda) redisServiceImpl.get(uuid);
        } else {
            redisServiceImpl.set(uuid, agendaMapper.selectAgendaByUuid(uuid));
            return agendaMapper.selectAgendaByUuid(uuid);
        }
    }

    /**
     * 批量删除日程
     * @param ids 日程ID字符串，多个ID用逗号分隔
     * @return 影响的行数
     */
    public Integer removeMoreAgenda(String ids) {
        String[] strArray = ids.split(",");
        return agendaMapper.deleteMoreAgenda(strArray);
    }
}
