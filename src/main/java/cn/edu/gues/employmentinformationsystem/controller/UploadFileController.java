package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.entity.User;
import cn.edu.gues.employmentinformationsystem.service.UploadFileService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import cn.edu.gues.employmentinformationsystem.utils.StaticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
public class UploadFileController {
    @Autowired
    private UploadFileService uploadFileService;
    //导入简历
    @ResponseBody
    @RequestMapping(value = "/uploadDoc", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult uploadFile(@RequestParam(value = "file") MultipartFile file){

        if(file == null){
            return JsonResult.errorMsg("上传失败");
        }
        else{
            String end = uploadFileService.uploadFile(file, StaticUtil.SAVE_URL, StaticUtil.FILE_TYPE);
            return JsonResult.ok(end,null);
        }
    }
    //导入就业表
    @ResponseBody
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult uploadImg(@RequestParam(value = "file") MultipartFile file){

        if(file == null){
            return JsonResult.errorMsg("上传失败");
        }
        else{
            String end = uploadFileService.uploadImg(file, StaticUtil.SAVE_URL, StaticUtil.FILE_TYPE);
            return JsonResult.ok(end,null);
        }
    }
    //批量导入学生
    @ResponseBody
    @RequestMapping(value = "/uploadExcelForStudent", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult uploadExcelForStudent(@RequestParam(value = "file") MultipartFile file, User user) throws IOException {

        if(file == null){
            return JsonResult.errorMsg("上传失败");
        }
        else{
            int end = uploadFileService.uploadExcelForStudent(file, StaticUtil.SAVE_URL, StaticUtil.FILE_TYPE,user.getUserId());
            if(end==0){
                return JsonResult.errorMsg("请先删除已存在的用户");
            }
            return JsonResult.ok(end,null);
        }
    }


}
