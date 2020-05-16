package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.NoticeDto;
import cn.edu.gues.employmentinformationsystem.entity.Notice;
import cn.edu.gues.employmentinformationsystem.service.NoticeService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    /**
     * 查询所有通知公告信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/getAllNotice", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getAllNotice(@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(required = false,defaultValue = "15") Integer limit,Notice notice){
        Page<Notice> page1 = PageHelper.startPage(page,limit);
        List<NoticeDto> noticeDto =  noticeService.getAllNotice(notice);
        if(noticeDto!=null){
            return JsonResult.ok(noticeDto,(int)page1.getTotal());
        }
        return JsonResult.errorMsg("无法获取数据");

    }

    /**
     * 查询公告信息ByName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/getNoticeByName", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public JsonResult getNoticeByName(@RequestParam(required = false,defaultValue = "1") Integer page,
                                      @RequestParam(required = false,defaultValue = "15") Integer limit,
                                      @RequestParam("noticeName") String noticeName){
        Page<Notice> page1 = PageHelper.startPage(page,limit);
        List<NoticeDto> noticeDto =  noticeService.getNoticeByName(noticeName);
        if(noticeDto!=null){
            return JsonResult.ok(noticeDto,(int)page1.getTotal());
        }
        return JsonResult.errorMsg("无法获取数据");

    }

    /**
     * 编辑公告信息ById
     * @param notice
     * @return
     */
    @RequestMapping(value = "/updataNoticeById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult updataNoticeById(@RequestBody Notice notice){
        int mark = noticeService.updataNoticeById(notice);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("更新失败！");

    }

    /**
     * 删除公告信息ById
     * @param noticeId
     * @return
     */
    @RequestMapping(value = "/delNoticeById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult delNoticeById(@RequestParam("noticeId") String noticeId){
        int mark = noticeService.delNoticeById(noticeId);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("删除失败！");

    }

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @RequestMapping(value = "/addNotice", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult addNotice(@RequestBody Notice notice){
        int mark = noticeService.addNotice(notice);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败！");

    }


}
