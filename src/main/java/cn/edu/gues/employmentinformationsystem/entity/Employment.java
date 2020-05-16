package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "employment")
public class Employment {
    /**
     * 就业表id
     */
    @Id
    @Column(name = "employment_id")
    private String employmentId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 职位名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 就业省份
     */
    @Column(name = "employment_provence")
    private String employmentProvence;

    /**
     * 就业时间
     */
    @Column(name = "employment_time")
    private String employmentTime;

    /**
     * 就业城市
     */
    @Column(name = "employment_city")
    private String employmentCity;

    /**
     * 月薪
     */
    @Column(name = "monthly_salary")
    private String monthlySalary;

    /**
     * 就业表的地址
     */
    @Column(name = "employment_table_path")
    private String employmentTablePath;

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