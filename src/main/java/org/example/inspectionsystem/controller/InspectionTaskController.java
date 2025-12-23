package org.example.inspectionsystem.controller;

import org.example.inspectionsystem.entity.InspectionTask;
import org.example.inspectionsystem.service.InspectionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class InspectionTaskController {

    @Autowired
    private InspectionTaskService taskService;

    /**
     * FR2.1: 管理员创建巡检任务并分配给巡检员
     * URL: POST /api/tasks/assign?inspectorId=1
     */
    @PostMapping("/assign")
    public ResponseEntity<String> assignTask(@RequestBody InspectionTask task, @RequestParam Long inspectorId) {
        taskService.assignTask(task, inspectorId);
        return ResponseEntity.ok("任务分配成功");
    }

    /**
     * FR2.2: 巡检员查看分配给自己的任务列表
     * URL: GET /api/tasks/my?inspectorId=1&status=待执行
     */
    @GetMapping("/my")
    public ResponseEntity<List<InspectionTask>> getMyTasks(
            @RequestParam Long inspectorId,
            @RequestParam(required = false) String status) {
        List<InspectionTask> tasks = taskService.getTasksByInspector(inspectorId, status);
        return ResponseEntity.ok(tasks);
    }
}

