package cn.edu.gues.employmentinformationsystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class UserDto {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 父用户Id
     */
    @Column(name = "parent_user_id")
    private String parentUserId;

    /**
     * 专业id
     */
    @Column(name = "major_id")
    private String majorId;

    //就业信息是否已上传
    private String isUploadEmploymentInfo;

    /**
     * 专业名称
     */
    @Column(name = "major_id")
    private String majorName;



    /**
     * 学院名称
     */
    private String collegeId;

    /**
     * 学院名称
     */
    private String collegeName;




    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;


    /**
     * 学号
     */
    @Column(name = "sno")
    private String sno;

    /**
     * 教师号
     */
    @Column(name = "tno")
    private String tno;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 年龄
     */
    @Column(name = "age")
    private String age;

    /**
     * 年级
     */
    @Column(name = "yearschool")
    private String yearschool;

    /**
     * 班级
     */
    @Column(name = "student_class")
    private String studentClass;

    /**
     * 电话
     */
    @Column(name = "phonenumber")
    private String phonenumber;

    /**
     * 从事行业
     */
    @Column(name = "industry")
    private String industry;

    /**
     * 单位名称
     */
    @Column(name = "institution_name")
    private String institutionName;

    /**
     * 单位地址
     */
    @Column(name = "institution_address")
    private String institutionAddress;

    /**
     * 单位电话
     */
    @Column(name = "institution_phonenumber")
    private String institutionPhonenumber;

    /**
     * 法人代表
     */
    @Column(name = "legal_representative")
    private String legalRepresentative;

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
     * 类型：0管理员1学生2教师3企业
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 状态：0正常1删除
     */
    @Column(name = "`status`")
    private String status;

}