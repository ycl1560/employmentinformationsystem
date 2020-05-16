package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Resumes;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ResumesMapper extends Mapper<Resumes> {
    List<Resumes> selectResumeByInfo(Resumes resume);
}