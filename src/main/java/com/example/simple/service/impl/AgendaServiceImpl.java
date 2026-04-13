package com.example.simple.service.impl;

import com.example.simple.Mapper.AgendaMapper;
import com.example.simple.core.service.RedisService;
import com.example.simple.domain.Agenda;
import com.example.simple.service.IAgendaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日程服务实现类
 * 实现日程相关的业务逻辑
 */
@Service("agendaServiceImpl")
public class AgendaServiceImpl implements IAgendaService {

    @Resource
    private AgendaMapper agendaMapper;

    @Resource
    private RedisService redisServiceImpl;

    /**
     * 保存日程
     * 保存成功后同时更新Redis缓存
     *
     * @param agenda 要保存的日程对象
     * @return 影响的行数
     */
    @Override
    public Integer saveAgenda(Agenda agenda) {
        Integer result = agendaMapper.addAgenda(agenda);
        if (result > 0) {
            redisServiceImpl.set(agenda.getUuid(), agenda);
        }
        return result;
    }

    /**
     * 删除日程
     *
     * @param uuid 日程UUID
     * @return 影响的行数
     */
    @Override
    public Integer removeAgenda(String uuid) {
        return agendaMapper.deleteAgenda(uuid);
    }

    /**
     * 修改日程
     *
     * @param agenda 要修改的日程对象
     * @return 影响的行数
     */
    @Override
    public Integer modifyAgenda(Agenda agenda) {
        return agendaMapper.updateAgenda(agenda);
    }

    /**
     * 根据UUID查询日程
     * 优先从Redis缓存中获取，缓存不存在时从数据库查询并存入缓存
     *
     * @param uuid 日程UUID
     * @return 查询到的日程对象
     */
    @Override
    public Agenda queryAgendaByUuid(String uuid) {
        if (redisServiceImpl.get(uuid) != null) {
            return (Agenda) redisServiceImpl.get(uuid);
        } else {
            Agenda agenda = agendaMapper.selectAgendaByUuid(uuid);
            redisServiceImpl.set(uuid, agenda);
            return agenda;
        }
    }

    /**
     * 批量删除日程
     *
     * @param ids 要删除的日程UUID列表，逗号分隔
     * @return 影响的行数
     */
    @Override
    public Integer removeMoreAgenda(String ids) {
        String[] strArray = ids.split(",");
        return agendaMapper.deleteMoreAgenda(strArray);
    }
}
