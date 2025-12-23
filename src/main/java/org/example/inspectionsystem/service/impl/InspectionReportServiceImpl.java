package org.example.inspectionsystem.service.impl;

import org.example.inspectionsystem.entity.EmergencyEvent;
import org.example.inspectionsystem.entity.InspectionReport;
import org.example.inspectionsystem.mapper.IEmergencyEventMapper;
import org.example.inspectionsystem.mapper.IInspectionReportMapper;
import org.example.inspectionsystem.service.InspectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InspectionReportServiceImpl implements InspectionReportService {

    @Autowired
    private IInspectionReportMapper reportMapper;

    @Autowired
    private IEmergencyEventMapper emergencyMapper;

    @Override
    public void submitNormalReport(InspectionReport report) {
        // FR3.2: 核心逻辑 - 自动记录时间
        // GPS坐标通常由前端传入对象中，此处补充服务端时间
        report.setReportTime(new Date());
        reportMapper.insert(report);
    }

    @Override
    public void submitEmergency(EmergencyEvent event) {
        // FR3.3: 紧急事件处理
        event.setReportTime(new Date());
        event.setStatus("待处理"); // 初始状态

        emergencyMapper.insert(event);

        // 此处可扩展：发送站内信或推送通知给管理员
    }
}
