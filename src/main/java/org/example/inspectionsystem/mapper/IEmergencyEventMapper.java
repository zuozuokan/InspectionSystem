package org.example.inspectionsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.inspectionsystem.entity.EmergencyEvent;

@Mapper
public interface IEmergencyEventMapper extends BaseMapper<EmergencyEvent> {
}
