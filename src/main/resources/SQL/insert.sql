-- 1. 插入巡检员表 (inspector)
INSERT INTO inspector (name, contact_info)
VALUES ('张三', '13800138001'),
       ('李四', '13900139002'),
       ('王五', '13700137003'),
       ('赵六', '13600136004'),
       ('钱七', '13500135005');

-- 2. 插入巡检任务表 (inspection_task)
INSERT INTO inspection_task (task_name, route, due_time, status, priority)
VALUES ('西山林区防火巡查', '路线A-01: 山脚到山顶观察站', '2025-06-01 18:00:00', '待执行', '高'),
       ('东湖湿地树木健康普查', '路线B-05: 环湖步道全线', '2025-05-20 12:00:00', '进行中', '中'),
       ('南岭病虫害抽样检测', '路线C-03: 松树密集林区', '2025-04-15 17:30:00', '已完成', '高'),
       ('北坡古树名木日常养护', '路线D-02: 古树群落落区', '2025-07-10 10:00:00', '待执行', '中'),
       ('中心公园绿化维护巡检', '路线E-01: 公园内环线', '2025-05-01 16:00:00', '进行中', '低');

-- 3. 插入巡检员任务关联表 (inspector_task)
-- 假设将前5个任务分别分配给前5个巡检员
INSERT INTO inspector_task (task_id, inspector_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

-- 4. 插入巡检数据表 (inspection_report)
INSERT INTO inspection_report (task_id, inspector_id, tree_species, health_status, photo_url, gps_location, emergency,
                               remarks)
VALUES (2, 2, '油松', '健康', 'http://oss.system.com/p1.jpg', '116.397, 39.908', FALSE, '长势良好'),
       (3, 3, '侧柏', '病害', 'http://oss.system.com/p2.jpg', '116.401, 39.912', FALSE, '疑似落叶病，需进一步化验'),
       (2, 2, '香樟', '健康', 'http://oss.system.com/p3.jpg', '116.395, 39.905', FALSE, '正常'),
       (5, 5, '垂柳', '虫害', 'http://oss.system.com/p4.jpg', '116.410, 39.920', TRUE, '发现大量美国白蛾幼虫，建议喷药'),
       (3, 3, '银杏', '健康', 'http://oss.system.com/p5.jpg', '116.405, 39.915', FALSE, '初夏生长旺盛');

-- 5. 插入紧急事件表 (emergency_event)
INSERT INTO emergency_event (task_id, inspector_id, event_type, event_description, status)
VALUES (1, 1, '火情', '西山3号观察点发现零星烟雾', '处理中'),
       (4, 4, '盗伐', '北坡古树群发现新鲜伐木痕迹', '待处理'),
       (1, 1, '其他', '由于暴雨导致山路A-01段塌方', '已处理'),
       (5, 5, '火情', '垃圾桶由于未熄灭烟头起火', '已处理'),
       (2, 2, '其他', '发现大量不明外来入侵植物', '待处理');

-- 6. 插入日志表 (operation_log)
INSERT INTO operation_log (operation_type, operator_id, description)
VALUES ('LOGIN', 1, '巡检员张三登录系统'),
       ('TASK_ASSIGN', 1001, '管理员分配了西山巡查任务'),
       ('REPORT_SUBMIT', 2, '李四提交了东湖巡检报告'),
       ('EMERGENCY_ALARM', 1, '系统自动触发火情预警'),
       ('UPDATE_STATUS', 1001, '手动更新任务3为已完成状态');
