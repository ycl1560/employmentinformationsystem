package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.Provinces;
import cn.edu.gues.employmentinformationsystem.service.ProvincesService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProvinceController {
    @Autowired
    ProvincesService provincesService;
    @RequestMapping(value = "/getAllProvince",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllProvince(){
        List<Provinces> allProvence = provincesService.getAllProvence();
        if(allProvence!=null){
            return JsonResult.ok(allProvence,null);
        }
        return JsonResult.errorMsg("查询省份出错");

    }
}
