package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "notice")
public class Notice {
    /**
     * 公告id
     */
    @Id
    @Column(name = "notice_id")
    private String noticeId;

    /**
     * 标题
     */
    @Column(name = "notice_name")
    private String noticeName;

    /**
     * 内容
     */
    @Column(name = "notice_detail")
    private String noticeDetail;

    /**
     * 公告类型
     */
    @Column(name = "`type`")
    private String type;

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