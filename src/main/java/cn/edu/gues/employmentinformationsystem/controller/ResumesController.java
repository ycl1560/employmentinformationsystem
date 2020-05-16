package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.Resumes;
import cn.edu.gues.employmentinformationsystem.service.ResumesService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ResumesController {
    @Autowired
    private ResumesService resumesService;

    /**
     * 添加简历
     * @param resume
     * @return
     */
    @RequestMapping(value = "/addResumes", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult addResumes(@RequestBody Resumes resume){
        if(resumesService.addResumes(resume)>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败");
    }

    /**
     * 获取用户简历
     * @param resume
     * @return
     */
    @RequestMapping(value = "/getResumesByUserId", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getResumesByUserId(Resumes resume){
        Resumes resumes = resumesService.getResumesByUserId(resume);
        if(resumes!=null){
            return JsonResult.ok(resumes,null);
        }
        return JsonResult.errorMsg("添加失败");
    }
}
