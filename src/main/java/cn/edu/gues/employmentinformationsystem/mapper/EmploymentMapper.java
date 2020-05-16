package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Employment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface EmploymentMapper extends Mapper<Employment> {
    List<Employment> selectEmploymentByInfo(Employment employment);
}