package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.IndexStatistics;
import cn.edu.gues.employmentinformationsystem.service.indexStatisticsService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class indexStatisticsController {
    @Autowired
    private indexStatisticsService indexStatisticsService;

    /**
     * 获取主页数据信息
     * @return
     */
    @RequestMapping(value = "/getIndexStatistics",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getIndexStatistics(){
        IndexStatistics indexStatistics = indexStatisticsService.getInfo();
        return JsonResult.ok(indexStatistics,null);
    }

}
