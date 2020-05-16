package cn.edu.gues.employmentinformationsystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
@Data
public class StudentAttentionJobs {
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
     * 学生姓名
     */
    private String name;

    private String resumePath;


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
