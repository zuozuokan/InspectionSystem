package org.example.inspectionsystem.service;

import org.example.inspectionsystem.entity.EmergencyEvent;
import org.example.inspectionsystem.entity.InspectionReport;

public interface InspectionReportService {
    // FR3.1 & 3.2: 提交常规巡检报告
    void submitNormalReport(InspectionReport report);

    // FR3.3: 提交紧急事件
    void submitEmergency(EmergencyEvent event);
}
