package org.example.inspectionsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.inspectionsystem.entity.OperationLog;

@Mapper
public interface IOperationLogMapper extends BaseMapper<OperationLog> {
}
