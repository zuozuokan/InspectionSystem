package org.example.inspectionsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("emergency_event")
public class EmergencyEvent {

    @TableId(value = "event_id", type = IdType.AUTO)
    private Long eventId;

    @TableField("task_id")
    private Long taskId;

    @TableField("inspector_id")
    private Long inspectorId;

    /**
     * 事件类型：火情、盗伐、其他
     */
    @TableField("event_type")
    private String eventType;

    @TableField("event_description")
    private String eventDescription;

    @TableField("report_time")
    private Date reportTime;

    /**
     * 事件状态：待处理、处理中、已处理
     */
    @TableField("status")
    private String status;
}
