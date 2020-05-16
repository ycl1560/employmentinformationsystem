package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.JobStudent;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface JobStudentMapper extends Mapper<JobStudent> {
    List<JobStudent> getStudentAttentionJos(JobStudent jobStudent);

    int updateByUserIdAndJobId(JobStudent jobStudent);

}