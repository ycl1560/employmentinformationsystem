package cn.edu.gues.employmentinformationsystem.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "administrator_info")
public class AdministratorInfo {
    /**
     * 管理员编号
     */
    @Id
    @Column(name = "administrator_id")
    private Integer administratorId;

    /**
     * 管理员用户名
     */
    @Column(name = "administrator_name")
    private String administratorName;

    /**
     * 管理员密码
     */
    @Column(name = "administrator_password")
    private String administratorPassword;

    /**
     * 最后登陆时间
     */
    @Column(name = "login_time")
    private Date loginTime;
}