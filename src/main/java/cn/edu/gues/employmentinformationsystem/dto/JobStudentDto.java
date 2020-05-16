package cn.edu.gues.employmentinformationsystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "job_student")
public class JobStudentDto {
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
     * 工作名称
     */
    @Column(name = "job_name")
    private String jobName;
    /**
     * 创建的用户id
     */
    @Column(name = "user_id")
    private String userId;
    /**
     * 创建的单位名字
     */
    private String unitName;


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