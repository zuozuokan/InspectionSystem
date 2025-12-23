package org.example.inspectionsystem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@TableName("inspector")
@Data
public class Inspector {

    @TableId(value = "inspector_id", type = IdType.AUTO)
    private String id;

    @TableField("name")
    private String name;

    @TableField("contact_info")
    private String contactInfo;

    @TableField("created_at")
    private Date createdAt;


}
