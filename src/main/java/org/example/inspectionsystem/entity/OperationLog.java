package org.example.inspectionsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("operation_log")
public class OperationLog {

    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @TableField("operation_type")
    private String operationType;

    @TableField("operator_id")
    private Long operatorId;

    @TableField("description")
    private String description;

    @TableField("created_at")
    private Date createdAt;
}
