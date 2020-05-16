package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "major")
public class Major {
    /**
     * 专业id
     */
    @Id
    @Column(name = "major_id")
    private String majorId;

    /**
     * 学院id
     */
    @Column(name = "college_id")
    private String collegeId;

    /**
     * 专业名称
     */
    @Column(name = "major_name")
    private String majorName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 状态0删除1正常
     */
    @Column(name = "`status`")
    private String status;
}