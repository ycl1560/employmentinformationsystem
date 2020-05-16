package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.EnploymentDto;
import cn.edu.gues.employmentinformationsystem.dto.Salary;
import cn.edu.gues.employmentinformationsystem.entity.Employment;
import cn.edu.gues.employmentinformationsystem.service.EmploymentService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmploymentController {
    @Autowired
    private EmploymentService employmentService;

    /**
     * 就业省份统计
     * @return
     */
    @RequestMapping(value = "/getEmploymentPlaceInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getEmploymentPlaceInfo(){
        List<EnploymentDto> employmentDto =   employmentService.getEmploymentPlaceInfo();
        return JsonResult.ok(employmentDto,null);
    }

    /**
     * 就业薪资统计
     * @return
     */
    @RequestMapping(value = "/getEmploymentSalaryInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getEmploymentSalaryInfo(){
        List<Salary> employmentDto =   employmentService.getEmploymentSalaryInfo();
        return JsonResult.ok(employmentDto,null);
    }

    /**
     * 所有就业信息查询
     * @return
     */
    @RequestMapping(value = "/getEmploymentByInfo",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getEmploymentByInfo(Employment employment){
        List<EnploymentDto> employmentDto =   employmentService.getEmploymentByInfo(employment);
        return JsonResult.ok(employmentDto,null);
    }

    /**
     * 就业信息填报
     * @return
     */
    @RequestMapping(value = "/addEmployment",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult addEmployment(@RequestBody Employment employment){
        int mark = employmentService.addEmployment(employment);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("填报失败");

    }

}
