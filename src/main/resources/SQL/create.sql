# 巡检员表 (inspector)
CREATE TABLE if not exists inspector
(
    inspector_id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 巡检员ID
    name         VARCHAR(255) NOT NULL,              -- 巡检员姓名
    contact_info VARCHAR(255),                       -- 联系信息
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 创建时间
);
# 巡检任务表 (inspection_task)
CREATE TABLE if not exists inspection_task
(
    task_id    BIGINT AUTO_INCREMENT PRIMARY KEY,                                                        -- 任务ID
    task_name  VARCHAR(255) NOT NULL,                                                                    -- 任务名称
    route      VARCHAR(255) NOT NULL,                                                                    -- 任务路线
    due_time   DATETIME     NOT NULL,                                                                    -- 任务完成时间
    status     ENUM ('待执行', '进行中', '已完成') DEFAULT '待执行',                                     -- 任务状态
    priority   ENUM ('低', '中', '高')             DEFAULT '中',                                         -- 任务优先级
    created_at TIMESTAMP                           DEFAULT CURRENT_TIMESTAMP,                            -- 创建时间
    updated_at TIMESTAMP                           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
);

# 巡检员任务关联表 (inspector_task)
CREATE TABLE if not exists inspector_task
(
    task_id       BIGINT,                              -- 任务ID
    inspector_id  BIGINT,                              -- 巡检员ID
    assigned_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 任务分配时间
    PRIMARY KEY (task_id, inspector_id)                -- 联合主键
);
# 巡检数据表 (inspection_report)
CREATE TABLE if not exists inspection_report
(
    report_id     BIGINT AUTO_INCREMENT PRIMARY KEY,      -- 上报ID
    task_id       BIGINT,                                 -- 任务ID
    inspector_id  BIGINT,                                 -- 巡检员ID
    tree_species  VARCHAR(255)                  NOT NULL, -- 树种
    health_status ENUM ('健康', '病害', '虫害') NOT NULL, -- 健康状况
    photo_url     VARCHAR(255),                           -- 现场照片URL
    gps_location  VARCHAR(255),                           -- GPS位置
    report_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,    -- 上报时间
    emergency     BOOLEAN   DEFAULT FALSE,                -- 是否为紧急事件
    remarks       TEXT                                    -- 备注
);
# 紧急事件表 (emergency_event)
CREATE TABLE if not exists emergency_event
(
    event_id          BIGINT AUTO_INCREMENT PRIMARY KEY,                             -- 事件ID
    task_id           BIGINT,                                                        -- 任务ID
    inspector_id      BIGINT,                                                        -- 巡检员ID
    event_type        ENUM ('火情', '盗伐', '其他') NOT NULL,                        -- 事件类型
    event_description TEXT,                                                          -- 事件描述
    report_time       TIMESTAMP                           DEFAULT CURRENT_TIMESTAMP, -- 上报时间
    status            ENUM ('待处理', '处理中', '已处理') DEFAULT '待处理'           -- 事件状态
);
# 日志表 (operation_log)
CREATE TABLE  if not exists operation_log
(
    log_id         BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 日志ID
    operation_type VARCHAR(255) NOT NULL,              -- 操作类型
    operator_id    BIGINT       NOT NULL,              -- 操作人ID
    description    TEXT,                               -- 操作描述
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 操作时间
);


