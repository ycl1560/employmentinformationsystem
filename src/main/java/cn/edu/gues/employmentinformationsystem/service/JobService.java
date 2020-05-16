package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.JobDto;
import cn.edu.gues.employmentinformationsystem.dto.UnitJobInfo;
import cn.edu.gues.employmentinformationsystem.dto.UserDto;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.JobMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JobService {

    @Resource
    private JobMapper jobMapper;
    @Resource
    private UserService userService;

    public List<Job> getAllJobs() {
        return jobMapper.selectAll();
    }

    public List<JobDto> getAllJobsDto() {
        List<Job> jobs = jobMapper.selectAllJobsDto();
        List<JobDto> jobDtos = new ArrayList();
        for (Job job : jobs) {
            JobDto jobDto = new JobDto();
            BeanUtils.copyProperties(job, jobDto);
            if (job.getJobType().equals("1")) {
                jobDto.setJobType("实习");
            }
            if (job.getJobType().equals("2")) {
                jobDto.setJobType("全职");
            }
            if (job.getJobType().equals("3")) {
                jobDto.setJobType("兼职");
            }
            //工作名称放入
            User user = userService.getUserById(job.getUserId());
            jobDto.setUnitName(user.getName());
            jobDtos.add(jobDto);

        }
        return jobDtos;
    }

    public List<JobDto> getJobByJobNameOrUnitName(String jobName, String unitName, String userId) {
        List<JobDto> jobDtos = new ArrayList();
        List<Job> jobs = jobMapper.getJobByJobNameOrUnitName(jobName, unitName, userId);
        for (Job job : jobs) {
            JobDto jobDto = new JobDto();
            BeanUtils.copyProperties(job, jobDto);
            if (job.getJobType().equals("1")) {
                jobDto.setJobType("实习");
            }
            if (job.getJobType().equals("2")) {
                jobDto.setJobType("全职");
            }
            if (job.getJobType().equals("3")) {
                jobDto.setJobType("兼职");
            }
            //工作名称放入
            User user = userService.getUserById(job.getUserId());
            jobDto.setUnitName(user.getName());
            jobDtos.add(jobDto);

        }
        return jobDtos;
    }

    public int updataJobByJobId(Job job) {
        return jobMapper.updateByPrimaryKeySelective(job);
    }
    public int addJob(Job job) {
        job.setJobId(UUID.randomUUID().toString());
        return jobMapper.insertSelective(job);
    }

    public int delJobByJobId(String jobId) {
        Job job = new Job();
        job.setJobId(jobId);
        job.setStatus("1");
        return jobMapper.updateByPrimaryKeySelective(job);
    }

    public List<Job> getJobByJobInfo(Job job) {
        return jobMapper.selectJobByJobInfo(job);
    }


}


