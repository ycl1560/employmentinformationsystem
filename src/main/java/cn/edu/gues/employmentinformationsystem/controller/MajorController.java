package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.Major;
import cn.edu.gues.employmentinformationsystem.service.MajorService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MajorController {
    @Autowired
    private MajorService majorService;

    /**
     * 查询所有专业
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllMajors",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getAllMajors(){
        List<Major> majors = majorService.getMajorByInfo(new Major());
        if(majors!=null){
            return JsonResult.ok(majors,null);
        }
        return JsonResult.errorMsg("获取专业信息失败！");
    }

    /**
     * 查询该专业所属学院
     * @param major
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMajorByCollegeId",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getMajorByCollegeId(Major major){
       List<Major> majorInfo = majorService.getMajorByInfo(major);
        if(majorInfo!=null){
            return JsonResult.ok(majorInfo,null);
        }
        return JsonResult.errorMsg("获取专业信息失败！");
    }

    /**
     * 主键查询专业
     * @param major
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMajorById",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getMajorById(Major major){
        List<Major> majorInfo = majorService.getMajorByInfo(major);
        if(majorInfo!=null){
            return JsonResult.ok(majorInfo,null);
        }
        return JsonResult.errorMsg("获取专业信息失败！");
    }

    /**
     * 查询专业ByInfo
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMajorByInfo",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getMajorByInfo(Major major){
        List<Major> majorInfo = majorService.getMajorByInfo(major);
        if(majorInfo!=null){
            return JsonResult.ok(majorInfo,null);
        }
        return JsonResult.errorMsg("获取专业信息失败！");
    }

    /**
     * 增加专业
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addMajor",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult addMajor(Major major){
        int mark = majorService.addMajor(major);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败！");
    }

    /**
     * 更新专业
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateMajorByMajorId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult updateMajorByMajorId(@RequestBody Major major){
        int mark = majorService.updateMajorByMajorId(major);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败！");
    }

       /**
     * 删除专业
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delMajorByMajorId",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult delMajorByMajorId(Major major){
        int mark = majorService.delMajorByMajorId(major);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("删除失败！");
    }




}
