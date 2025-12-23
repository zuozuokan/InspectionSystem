package org.example.inspectionsystem.controller;

import org.example.inspectionsystem.entity.EmergencyEvent;
import org.example.inspectionsystem.entity.InspectionReport;
import org.example.inspectionsystem.service.InspectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class InspectionReportController {

    @Autowired
    private InspectionReportService reportService;

    /**
     * FR3.1 & FR3.2: 巡检员上报巡检点信息
     * 系统会自动记录 GPS 和 时间（在 Service 层已实现）
     */
    @PostMapping("/submit")
    public ResponseEntity<String> submitReport(@RequestBody InspectionReport report) {
        reportService.submitNormalReport(report);
        return ResponseEntity.ok("巡检数据上报成功");
    }

    /**
     * FR3.3: 紧急事件上报（火情、盗伐等）
     */
    @PostMapping("/emergency")
    public ResponseEntity<String> submitEmergency(@RequestBody EmergencyEvent event) {
        reportService.submitEmergency(event);
        return ResponseEntity.ok("紧急事件已上报，后台将收到显著警示");
    }
}

