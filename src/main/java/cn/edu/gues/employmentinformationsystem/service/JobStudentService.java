package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.JobDto;
import cn.edu.gues.employmentinformationsystem.dto.JobStudentDto;
import cn.edu.gues.employmentinformationsystem.dto.StudentAttentionJobs;
import cn.edu.gues.employmentinformationsystem.dto.UserDto;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.entity.JobStudent;
import cn.edu.gues.employmentinformationsystem.entity.Resumes;
import cn.edu.gues.employmentinformationsystem.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.JobStudentMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JobStudentService{

    @Resource
    private JobStudentMapper jobStudentMapper;
    @Resource
    private UserService userService;
    @Resource
    private JobService jobService;
    @Resource
    private ResumesService resumesService;

    public List<JobStudent> getStudentAttentionJos(JobStudent jobStudent) {
        return jobStudentMapper.getStudentAttentionJos(jobStudent);
    }

    public int addStudentAttentionJob(JobStudent jobStudent) {
        return jobStudentMapper.insertSelective(jobStudent);
    }

    public int updataStudentAttentionJob(JobStudent jobStudent) {
        return jobStudentMapper.updateByUserIdAndJobId(jobStudent);
    }

    public List<JobStudent> getStudentAttentionJobByUserIdAndJobId(String userId, String jobId) {
        JobStudent jobStudent = new JobStudent();
        jobStudent.setJobId(jobId);
        jobStudent.setUserId(userId);
        List<JobStudent> jobStudentList = this.getStudentAttentionJos(jobStudent);
        return jobStudentList;
    }


    public int addStudentAttentionJob(String userId, String jobId) {
        JobStudent jobStudent = new JobStudent();
        jobStudent.setJobId(jobId);
        jobStudent.setUserId(userId);
        if (this.getStudentAttentionJos(jobStudent).size() > 0) {
            jobStudent.setStatus("0");
            return this.updataStudentAttentionJob(jobStudent);
        }
        else
        {
            jobStudent.setJobStudentId(UUID.randomUUID().toString());
            return this.addStudentAttentionJob(jobStudent);
        }

    }

    public int delStudentAttentionJob(String userId, String jobId) {
        JobStudent jobStudent = new JobStudent();
        jobStudent.setJobId(jobId);
        jobStudent.setUserId(userId);
        jobStudent.setStatus("1");
        return this.updataStudentAttentionJob(jobStudent);
    }

    public List<JobStudentDto> getAllStudentAttentionJobsByUserId(String userId) {
        JobStudent jobStudent = new JobStudent();
        jobStudent.setUserId(userId);
        List<JobStudent> jobStudents = jobStudentMapper.getStudentAttentionJos(jobStudent);
        List<JobStudentDto> jobStudentDtos = new ArrayList();
        for (JobStudent jobStudent1 : jobStudents) {
            List<JobDto> jobDtos = jobService.getAllJobsDto();
            for (JobDto jobDto : jobDtos) {
                if(jobDto.getJobId().equals(jobStudent1.getJobId())){
                    JobStudentDto jobStudentDto = new JobStudentDto();
                    BeanUtils.copyProperties(jobDto,jobStudentDto);
                    jobStudentDto.setJobStudentId(jobStudent1.getJobStudentId());
                    jobStudentDto.setUpdateTime(jobStudent1.getUpdateTime());
                    jobStudentDto.setCreateTime(jobStudent1.getCreateTime());
                    if(jobStudent1.getIsQualified()==null){
                        jobStudentDto.setIsQualified("待回复");
                    }
                    else {
                        jobStudentDto.setIsQualified(jobStudent1.getIsQualified());
                    }
                    jobStudentDtos.add(jobStudentDto);
                }
            }

        }
        return jobStudentDtos;
    }

    public List<StudentAttentionJobs> getAttentionMyJobStudents(JobStudent jobStudent) {
        List<JobStudent> jobStudents = this.getStudentAttentionJos(jobStudent);
        List<StudentAttentionJobs> studentAttentionJobs = new ArrayList();
        for (JobStudent student : jobStudents) {
            StudentAttentionJobs studentAttentionJobs1 = new StudentAttentionJobs();
            BeanUtils.copyProperties(student,studentAttentionJobs1);
            User user = new User();
            user.setUserId(student.getUserId());
            List<UserDto> studentUserByUserInfo = userService.getStudentUserByUserInfo(user);
            if(studentUserByUserInfo.size()>0){
                //设置学生的名字
                studentAttentionJobs1.setName(studentUserByUserInfo.get(0).getName());
                //设置简历路径
                Resumes resumes = new Resumes();
                resumes.setUserId(student.getUserId());
                Resumes resumesByUserId = resumesService.getResumesByUserId(resumes);
                if(resumesByUserId!=null){
                    studentAttentionJobs1.setResumePath(resumesByUserId.getResumePath());
                }
                studentAttentionJobs.add(studentAttentionJobs1);
            }


        }
        return studentAttentionJobs;
    }

    public int updataJobStudent(JobStudent jobStudent) {
        return jobStudentMapper.updateByPrimaryKeySelective(jobStudent);
    }
}
