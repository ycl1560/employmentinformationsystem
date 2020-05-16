package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Major;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MajorMapper extends Mapper<Major> {
    List<Major> selectMajorByCollegeId(int collegeId);

    List<Major> selectMajorByInfo(Major major);

    Major selectMajorByName(String majorName);
}