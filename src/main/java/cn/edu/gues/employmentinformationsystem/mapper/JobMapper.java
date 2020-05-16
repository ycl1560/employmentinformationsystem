package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Job;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface JobMapper extends Mapper<Job> {
    List<Job> getJobByJobNameOrUnitName(@Param("jobName") String jobName, @Param("unitName") String unitName, @Param("userId") String userId);

    List<Job> selectAllJobsDto();

    List<Job> selectJobByJobInfo(Job job);
}