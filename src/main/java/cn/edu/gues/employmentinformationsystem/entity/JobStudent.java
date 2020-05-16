package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "job_student")
public class JobStudent {
    /**
     * 主键id
     */
    @Id
    @Column(name = "job_student_id")
    private String jobStudentId;

    /**
     * 职位id
     */
    @Column(name = "job_id")
    private String jobId;

    /**
     * 学生用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 是否合格
     */
    @Column(name = "is_qualified")
    private String isQualified;

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
     * 状态0正常1删除
     */
    @Column(name = "`status`")
    private String status;
}