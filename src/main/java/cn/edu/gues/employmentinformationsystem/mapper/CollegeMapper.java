package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.College;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CollegeMapper extends Mapper<College> {
    List<College> selectAllCollegeByInfo(College college);
}