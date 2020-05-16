package cn.edu.gues.employmentinformationsystem.dto;

import lombok.Data;

@Data
public class UnitJobInfo {
    //单位用户id
    private String userId;
    //单位名称
    private String name;
    //职位数量
    private int jobNumber;
    //职位更新时间
    private String updataTime;

}
