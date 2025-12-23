package org.example.inspectionsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName("inspection_report")
public class InspectionReport {

    @TableId(value = "report_id", type = IdType.AUTO)
    private Long reportId;

    @TableField("task_id")
    private Long taskId;

    @TableField("inspector_id")
    private Long inspectorId;

    @TableField("tree_species")
    private String treeSpecies;

    /**
     * 健康状况：健康、病害、虫害
     */
    @TableField("health_status")
    private String healthStatus;

    @TableField("photo_url")
    private String photoUrl;

    @TableField("gps_location")
    private String gpsLocation;

    @TableField("report_time")
    private Date reportTime;

    @TableField("emergency")
    private Boolean emergency;

    @TableField("remarks")
    private String remarks;
}
