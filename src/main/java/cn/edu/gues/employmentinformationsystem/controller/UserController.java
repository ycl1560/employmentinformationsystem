package cn.edu.gues.employmentinformationsystem.controller;

import cn.edu.gues.employmentinformationsystem.dto.UserDto;
import cn.edu.gues.employmentinformationsystem.entity.Job;
import cn.edu.gues.employmentinformationsystem.entity.JobStudent;
import cn.edu.gues.employmentinformationsystem.entity.User;
import cn.edu.gues.employmentinformationsystem.service.UserService;
import cn.edu.gues.employmentinformationsystem.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult queryUserInfo(User user){
        UserDto userDto = userService.queryUserInfo(user);
        if(userDto!=null){
            return JsonResult.ok(userDto,null);
        }
        else
            return JsonResult.errorMsg("用户不存在！");
    }

    /**
     * 获取所有学生用户
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllStudentUserInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult queryAllStudentUserInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                       @RequestParam(required = false,defaultValue = "15") Integer limit,User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getAllStudentUserInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }
    /**
     * 获取所有教师用户
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllTeacherUserInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllTeacherUserInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                              @RequestParam(required = false,defaultValue = "15") Integer limit,User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getAllTeacherUserInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }

    /**
     * 获取所有单位用户
     * @param
     * @return
     */
    @RequestMapping(value = "/getAllUnitUserInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getAllUnitUserInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                            @RequestParam(required = false,defaultValue = "15") Integer limit,User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getAllUnitUserInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }
    /**
     * 条件获取学生用户
     * @param
     * @return
     */
    @RequestMapping(value = "/getStudentUserByUserInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getStudentUserByUserInfo(@RequestParam(required = false,defaultValue = "1") Integer page,
                                               @RequestParam(required = false,defaultValue = "15") Integer limit,
                                               User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getStudentUserByUserInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }

    /**
     * 条件获取教师用户
     * @param
     * @return
     */
    @RequestMapping(value = "/getTeacherUserByInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getTeacherUserByUserNameOrNameOrTno(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                          @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                          User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getTeacherUserByInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }

    /**
     * 条件获取单位用户
     * @getUnitUserByUserInfo
     * @return
     */
    @RequestMapping(value = "/getUnitUserByUserInfo", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getUnitUserByUserNameOrNameOrTno(@RequestParam(required = false,defaultValue = "1") Integer page,
                                                          @RequestParam(required = false,defaultValue = "15") Integer limit,
                                                         User user){
        Page<UserDto> info = PageHelper.startPage(page, limit);
        List<UserDto> userList = userService.getUnitUserByUserInfo(user);
        if(userList!=null){
            return JsonResult.ok(userList, (int) info.getTotal());
        }
        else
            return JsonResult.errorMsg("无法获取数据！");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult addUser(@RequestBody User user){
        if(userService.isUserExist(user.getUserName())){
            return JsonResult.errorMsg("userExist");
        }
        int mark = userService.addUser(user);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("添加失败");
    }

    /**
     * 主键查找用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult getUserById(@RequestParam("userId") String userId){
            User user1 = userService.getUserById(userId);
            if(user1!=null)
            return JsonResult.ok(user1,null);
            else
                return JsonResult.errorMsg("查询用户失败");

    }

    /**
     * 编辑用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult updateUserById(@RequestBody User user){
        int mark = userService.updateUserById(user);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("更新失败");
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delUserById", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult delUserById(@RequestParam("userId") String userId){
        int mark = userService.delUserById(userId);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("更新失败");
    }

    /**
     * 判断密码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/isUserPwdRight", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public JsonResult isUserPwdRight(@RequestParam("userId") String userId,@RequestParam("password") String password){
        int mark = userService.isUserPwdRight(userId,password);
        if(mark>0){
            return JsonResult.ok();
        }
        return JsonResult.errorMsg("旧密码错误");
    }






}
