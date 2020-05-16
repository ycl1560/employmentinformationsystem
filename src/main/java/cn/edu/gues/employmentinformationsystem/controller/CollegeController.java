package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.College;
import cn.edu.gues.employmentinformationsystem.service.CollegeService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    @RequestMapping(value = "/getAllCollege",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllColleges(){
        List<College> colleges = collegeService.getAllCollegeByInfo(new College());
        if(colleges!=null){
            return JsonResult.ok(colleges,null);
        }
        return JsonResult.errorMsg("学院信息获取失败");
    }
    @RequestMapping(value = "/getAllCollegeByInfo",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllCollegeByInfo(College college){
        List<College> colleges = collegeService.getAllCollegeByInfo(college);
        if(colleges!=null){
            return JsonResult.ok(colleges,null);
        }
        return JsonResult.errorMsg("学院信息获取失败");
    }

    @RequestMapping(value = "/getCollegeById",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getCollegeById(College college){
        List<College> colleges = collegeService.getAllCollegeByInfo(college);
        if(colleges!=null){
            return JsonResult.ok(colleges.get(0),null);
        }
        return JsonResult.errorMsg("学院信息获取失败");
    }

    @RequestMapping(value = "/addCollege",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult addCollege(College college){
        int mark = collegeService.addCollege(college);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败");
    }

    @RequestMapping(value = "/delCollegeByCollegeId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult delCollegeById(College college){
        int mark = collegeService.delCollegeByCollegeId(college);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败");
    }

    @RequestMapping(value = "/updataCollegeByCollegeId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult updataCollegeByCollegeId(@RequestBody College college){
        int mark = collegeService.updataCollegeByCollegeId(college);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败");
    }
}
