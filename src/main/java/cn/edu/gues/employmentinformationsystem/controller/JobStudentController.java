package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.JobStudentDto;
import cn.edu.gues.employmentinformationsystem.dto.StudentAttentionJobs;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.entity.JobStudent;
import cn.edu.gues.employmentinformationsystem.service.JobStudentService;
import cn.edu.gues.employmentinformationsystem.service.UserService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class JobStudentController {
    @Autowired
    private UserService userService;
    @Autowired
    private JobStudentService jobStudentService;
    /**
     * 学生是否关注该职位
     * @param userId
     * @return
     */
    @RequestMapping(value = "/isStudentAttentionJob", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult isStudentAttentionJob(@RequestParam("userId") String userId, @RequestParam("jobId") String jobId){
        List<JobStudent> jobStudents = jobStudentService.getStudentAttentionJobByUserIdAndJobId(userId,jobId);
        if(jobStudents.size()>0){
            return JsonResult.ok("exist",null);
        }
        else {
            return JsonResult.ok("no",null);
        }
    }
    /**
     * 学生添加关注该职位
     * @param userId
     * @return
     */
    @RequestMapping(value = "/addStudentAttentionJobByUserIdAndJobId", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult addStudentAttentionJob(@RequestParam("userId") String userId,@RequestParam("jobId") String jobId){
        int mark = jobStudentService.addStudentAttentionJob(userId,jobId);
        if(mark>0){
            return JsonResult.ok("添加投递记录成功",null);
        }
        else
            return JsonResult.errorMsg("添加投递记录失败");
    }
    /**
     * 学生取消投递该职位
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delStudentAttentionJobByUserIdAndJobId", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult delStudentAttentionJob(@RequestParam("userId") String userId,@RequestParam("jobId") String jobId){
        int mark = jobStudentService.delStudentAttentionJob(userId,jobId);
        if(mark>0){
            return JsonResult.ok("删除投递记录成功",null);
        }
        else
            return JsonResult.errorMsg("删除投递记录失败");
    }

    /**
     * 获取学生所有投递的职位
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getAllStudentAttentionJobsByUserId", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllStudentAttentionJobsByUserId(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                 @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                 @RequestParam("userId") String userId){
        Page<JobStudentDto> page1 = PageHelper.startPage(page,limit);
        List<JobStudentDto> jobStudentDtos = jobStudentService.getAllStudentAttentionJobsByUserId(userId);
        if(jobStudentDtos!=null){
            return JsonResult.ok(jobStudentDtos,(int)page1.getTotal());
        }
        else
            return JsonResult.errorMsg("获取投递记录失败失败");
    }

    /**
     * 获取投递我单位职位的学生
     * @param jobStudent
     * @return
     */
    @RequestMapping(value = "/getAttentionMyJobStudents", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAttentionMyJobStudentsInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                    @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                    JobStudent jobStudent){
        Page<StudentAttentionJobs> page1 = PageHelper.startPage(page,limit);
        List<StudentAttentionJobs> studentAttentionJobs = jobStudentService.getAttentionMyJobStudents(jobStudent);


        if(studentAttentionJobs!=null){
            return JsonResult.ok(studentAttentionJobs,(int)page1.getTotal());
        }
        else
            return JsonResult.errorMsg("获取投递记录失败失败");
    }


    /**
     * 更新投递表
     * @param jobStudent
     * @return
     */
    @RequestMapping(value = "/updataJobStudent", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult updataJobStudent(JobStudent jobStudent){
        int mark  = jobStudentService.updataJobStudent(jobStudent);
        if(mark>0){
            return JsonResult.ok();
        }
        else
            return JsonResult.errorMsg("更新失败");
    }

}
