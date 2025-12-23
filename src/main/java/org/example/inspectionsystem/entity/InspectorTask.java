package org.example.inspectionsystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("inspector_task")
public class InspectorTask {

    @TableField("task_id")
    private Long taskId;

    @TableField("inspector_id")
    private Long inspectorId;

    @TableField("assigned_time")
    private Date assignedTime;
}
