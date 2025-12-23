package org.example.inspectionsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("inspection_task")
public class InspectionTask {

    @TableId(value = "task_id", type = IdType.AUTO)
    private Long taskId;

    @TableField("task_name")
    private String taskName;

    @TableField("route")
    private String route;

    @TableField("due_time")
    private Date dueTime;

    /**
     * 状态：待执行、进行中、已完成
     */
    @TableField("status")
    private String status;

    /**
     * 优先级：低、中、高
     */
    @TableField("priority")
    private String priority;

    @TableField("created_at")
    private Date createdAt;

    @TableField("updated_at")
    private Date updatedAt;
}
