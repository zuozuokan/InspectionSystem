package org.example.inspectionsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.inspectionsystem.entity.InspectionTask;
import org.example.inspectionsystem.entity.InspectorTask;
import org.example.inspectionsystem.mapper.IInspectionTaskMapper;
import org.example.inspectionsystem.mapper.IInspectorTaskMapper;
import org.example.inspectionsystem.service.InspectionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class InspectionTaskServiceImpl implements InspectionTaskService {

    @Autowired
    private IInspectionTaskMapper taskMapper;

    @Autowired
    private IInspectorTaskMapper relationMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void assignTask(InspectionTask task, Long inspectorId) {
        // 1. 插入任务表
        taskMapper.insert(task);

        // 2. 建立关联关系 (FR2.1)
        InspectorTask relation = new InspectorTask();
        relation.setTaskId(task.getTaskId());
        relation.setInspectorId(inspectorId);
        relation.setAssignedTime(new Date());
        relationMapper.insert(relation);
    }

    @Override
    public List<InspectionTask> getTasksByInspector(Long inspectorId, String status) {
        // 为了提高处理效率，此处采用 LambdaQuery 避免硬编码字段名
        // 先从关联表中找到该巡检员的所有任务ID
        List<Long> taskIds = relationMapper.selectList(new LambdaQueryWrapper<InspectorTask>()
                        .eq(InspectorTask::getInspectorId, inspectorId))
                .stream().map(InspectorTask::getTaskId).toList();

        if (taskIds.isEmpty()) return Collections.emptyList();

        // 根据任务ID和状态查询任务详情 (FR2.2)
        return taskMapper.selectList(new LambdaQueryWrapper<InspectionTask>()
                .in(InspectionTask::getTaskId, taskIds)
                .eq(status != null, InspectionTask::getStatus, status));
    }
}

