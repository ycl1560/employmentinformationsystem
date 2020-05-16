package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "resumes")
public class Resumes {
    /**
     * 简历id
     */
    @Id
    @Column(name = "resume_id")
    private String resumeId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 简历名称
     */
    @Column(name = "resume_name")
    private String resumeName;

    /**
     * 简历路劲
     */
    @Column(name = "resume_path")
    private String resumePath;

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