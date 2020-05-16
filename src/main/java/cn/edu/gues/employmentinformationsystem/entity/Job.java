package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "job")
public class Job {
    /**
     * 工作id
     */
    @Id
    @Column(name = "job_id")
    private String jobId;

    /**
     * 创建的用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 工作名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 工作类型：实习、全职、兼职
     */
    @Column(name = "job_type")
    private String jobType;

    /**
     * 工作年限
     */
    @Column(name = "job_years")
    private String jobYears;

    /**
     * 专业要求
     */
    @Column(name = "job_major")
    private String jobMajor;

    /**
     * 工作性别
     */
    @Column(name = "job_sex")
    private String jobSex;

    /**
     * 年龄要求
     */
    @Column(name = "age")
    private String age;

    /**
     * 学历
     */
    @Column(name = "academic_qualifications")
    private String academicQualifications;

    /**
     * 月薪
     */
    @Column(name = "monthly_salary")
    private String monthlySalary;

    /**
     * 招聘人数
     */
    @Column(name = "recruits_number")
    private String recruitsNumber;

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

    /**
     * 职位详情描述
     */
    @Column(name = "job_detail")
    private String jobDetail;
}