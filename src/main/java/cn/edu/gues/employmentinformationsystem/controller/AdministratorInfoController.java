package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.AdministratorInfo;
import cn.edu.gues.employmentinformationsystem.service.AdministratorInfoService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministratorInfoController {
    @Autowired
    private AdministratorInfoService administratorInfoService;
    @RequestMapping("/queryAdministratorInfoById")
    public JsonResult queryAdministratorInfo(AdministratorInfo administrator){
        AdministratorInfo administratorInfoList =administratorInfoService.queryAdministratorInfoById(administrator);
        return JsonResult.ok(administratorInfoList,null);
    }


}
