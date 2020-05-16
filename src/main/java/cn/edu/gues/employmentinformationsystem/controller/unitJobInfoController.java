package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.UnitJobInfo;
import cn.edu.gues.employmentinformationsystem.dto.UserDto;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.entity.User;
import cn.edu.gues.employmentinformationsystem.service.JobService;
import cn.edu.gues.employmentinformationsystem.service.UserService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class unitJobInfoController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有的单位招聘信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/getUnitJobInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getUnitJobInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer limit){
        Page<UnitJobInfo> info = PageHelper.startPage(page, limit);
        List<UnitJobInfo> unitJobInfos = userService.getUnitJobInfo();
        if (unitJobInfos!=null)
        return JsonResult.ok(unitJobInfos,(int)info.getTotal());
        else
            return JsonResult.errorMsg("单位职位信息查询出错");

    }

    /**
     * 通过单位名称查询招聘信息
     * @param page
     * @param limit
     * @param name
     * @return
     */
    @RequestMapping(value = "/getUnitJobInfoByName", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getUnitJobInfoByName(@RequestParam(required = false,defaultValue = "1") Integer page,
                                     @RequestParam(required = false,defaultValue = "15") Integer limit,@RequestParam("name") String name){
        Page<UnitJobInfo> info = PageHelper.startPage(page, limit);
        List<UnitJobInfo> unitJobInfos = userService.getUnitJobInfoByName(name);
        if (unitJobInfos!=null)
        return JsonResult.ok(unitJobInfos,(int)info.getTotal());
        else
            return JsonResult.errorMsg("单位职位信息查询出错");

    }


}
