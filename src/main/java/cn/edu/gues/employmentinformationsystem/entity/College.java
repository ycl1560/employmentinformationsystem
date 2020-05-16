package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "college")
public class College {
    /**
     * 学院id
     */
    @Id
    @Column(name = "college_id")
    private String collegeId;

    /**
     * 学院名称
     */
    @Column(name = "college_name")
    private String collegeName;

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