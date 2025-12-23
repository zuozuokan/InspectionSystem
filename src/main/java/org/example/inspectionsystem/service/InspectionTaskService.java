package org.example.inspectionsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.inspectionsystem.entity.InspectionTask;

import java.util.List;

public interface InspectionTaskService {
    // FR2.1: 创建并分配任务
    void assignTask(InspectionTask task, Long inspectorId);

    // FR2.2: 巡检员查询自己的任务列表
    List<InspectionTask> getTasksByInspector(Long inspectorId, String status);
}
