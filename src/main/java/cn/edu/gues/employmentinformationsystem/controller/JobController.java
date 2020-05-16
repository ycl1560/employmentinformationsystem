package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.JobDto;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.service.JobService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {
    @Autowired
    private JobService jobService;

    /**
     * 获取所有职位
     * @return
     */
    @RequestMapping(value = "/getAllJob",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllJob(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "15") Integer limit){
        Page<JobDto> page1 = PageHelper.startPage(page,limit);
        List<JobDto> jobDtos = jobService.getAllJobsDto();
        return JsonResult.ok(jobDtos,(int)page1.getTotal());
    }

    /**
     * 条件查询职位ByJobNameOrUnitName
     * @return
     */
    @RequestMapping(value = "/getJobByJobNameOrUnitNameOrUserId",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getJobByJobNameOrUnitName(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      @RequestParam("jobName") String jobName,
                                      @RequestParam("unitName") String unitName,
                                                @RequestParam("userId")String userId){
        Page<JobDto> page1 = PageHelper.startPage(page,limit);
        List<JobDto> jobDtos = jobService.getJobByJobNameOrUnitName(jobName,unitName,userId);
        return JsonResult.ok(jobDtos,(int)page1.getTotal());
    }

    /**
     * 更新职位
     * @return
     */
    @RequestMapping(value = "/updataJobByJobId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult updataJobByJobId(@RequestBody Job job){
        int mark = jobService.updataJobByJobId(job);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("更新失败");
    }

    /**
     * 添加职位
     * @return
     */
    @RequestMapping(value = "/addJob",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult addJob(@RequestBody Job job){
        int mark = jobService.addJob(job);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("更新失败");
    }
    /**
     * 删除职位
     * @return
     */
    @RequestMapping(value = "/delJobByJobId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult delJobByJobId(@RequestParam("jobId") String jobId){
        int mark = jobService.delJobByJobId(jobId);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("删除失败");
    }
}
