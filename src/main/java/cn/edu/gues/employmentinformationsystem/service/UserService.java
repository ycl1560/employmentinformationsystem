package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.UnitJobInfo;
import cn.edu.gues.employmentinformationsystem.dto.UserDto;
import cn.edu.gues.employmentinformationsystem.entity.*;
import cn.edu.gues.employmentinformationsystem.utils.MD5Utils;
import cn.edu.gues.employmentinformationsystem.utils.date.DateFormatUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.xml.crypto.Data;

import cn.edu.gues.employmentinformationsystem.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private CollegeService collegeService;
    @Resource
    private MajorService majorService;
    @Resource
    private JobService jobService;
    @Resource
    private JobStudentService jobStudentService;

    @Resource
    private EmploymentService employmentService;

    public UserDto queryUserInfo(User user) {
        user.setPassword(MD5Utils.createMd5(user.getPassword()));
        //查询所有用户
        List<User> users = userMapper.selectUserByUserInfo(user);
        //验证用户名和密码
        for (User user1 : users) {
            if (user1.getUserName().equals(user.getUserName()) && user1.getPassword().equals(user.getPassword()) && user1.getType().equals(user.getType())) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user1,userDto);
                return userDto;
            }
        }
        return null;
    }

    public List<UserDto> getAllStudentUserInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        user1.setType("1");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            //获取专业名称
            for (Major major : majors) {
                if (major.getMajorId().equals(user.getMajorId())) {
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }
            Employment employment = new Employment();
            employment.setUserId(user.getUserId());
            if(employmentService.getEmploymentByInfo(employment).size()!=0){
                userDto.setIsUploadEmploymentInfo("已上报");
            }
            if(employmentService.getEmploymentByInfo(employment).size()==0){
                userDto.setIsUploadEmploymentInfo("未上报");
            }

            userDto.setType("学生");
            userResult.add(userDto);
        }
        return userResult;

    }

    public List<UserDto> getAllTeacherUserInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        user1.setType("2");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        //List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
           /* //获取专业名称
            for (Major major : majors) {
                if(major.getMajorId().equals(user.getMajorId())){
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }*/
            userDto.setType("老师");
            userResult.add(userDto);
        }
        return userResult;

    }

    public List<UserDto> getAllUnitUserInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        user1.setType("3");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        //List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
           /* //获取专业名称
            for (Major major : majors) {
                if(major.getMajorId().equals(user.getMajorId())){
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }*/
            userDto.setType("单位");
            userResult.add(userDto);
        }
        return userResult;

    }

    public List<UserDto> getStudentUserByUserInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        //条件查询
        user1.setType("1");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            //获取专业名称
            for (Major major : majors) {
                if (major.getMajorId().equals(user.getMajorId())) {
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }
            userDto.setType("学生");
            userResult.add(userDto);
        }
        return userResult;
    }

    public List<UserDto> getTeacherUserByInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        //条件查询
        user1.setType("2");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        //List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
           /* //获取专业名称
            for (Major major : majors) {
                if(major.getMajorId().equals(user.getMajorId())){
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }*/
            userDto.setType("老师");
            userResult.add(userDto);
        }
        return userResult;
    }

    public List<UserDto> getUnitUserByUserInfo(User user1) {
        List<UserDto> userResult = new ArrayList();
        //条件查询
        user1.setType("3");
        List<User> usersList = userMapper.selectUserByUserInfo(user1);
        //List<Major> majors = majorService.getAllMajors();
        for (User user : usersList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
           /* //获取专业名称
            for (Major major : majors) {
                if(major.getMajorId().equals(user.getMajorId())){
                    userDto.setMajorId(major.getMajorId());
                    userDto.setMajorName(major.getMajorName());
                    userDto.setCollegeId(collegeService.getCollegeById(major.getCollegeId()).getCollegeId());
                    userDto.setCollegeName(collegeService.getCollegeById(major.getCollegeId()).getCollegeName());
                }
            }*/
            userDto.setType("单位");
            userResult.add(userDto);
        }
        return userResult;
    }


    public int addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(MD5Utils.createMd5(user.getPassword()));
        return userMapper.insertSelective(user);
    }

    public User getUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        return userMapper.selectByPrimaryKey(user);
    }

    public int updateUserById(User user) {
        if(user.getPassword()!=null){
            user.setPassword(MD5Utils.createMd5(user.getPassword()));
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int delUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setStatus("1");
        return userMapper.updateByPrimaryKeySelective(user);
    }


    public boolean isUserExist(String userName) {
        User user1 = new User();
        user1.setUserName(userName);
        List<User> users = userMapper.selectUserByUserInfo(user1);
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public int getAllUserInfo() {

        return userMapper.selectAll().size();
    }

    public int isUserPwdRight(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(MD5Utils.createMd5(password));
        return userMapper.selectUserByUserInfo(user).size();
    }


    public List<UnitJobInfo> getUnitJobInfo() {
        List<UnitJobInfo> unitJobInfos = new ArrayList();
        List<UserDto> allUnitUserInfo = this.getAllUnitUserInfo(new User());
        int dd = 0;
        for (UserDto userDto : allUnitUserInfo) {
            UnitJobInfo unitJobInfo = new UnitJobInfo();
            Job job = new Job();
            //设置id为查询条件
            job.setUserId(userDto.getUserId());
            //设置该单位职位数量
            List<Job> job1 = jobService.getJobByJobInfo(job);
            int num = job1.size();
            unitJobInfo.setUpdataTime(job1.get(0).getUpdateTime());
            if (num > 0) {
                unitJobInfo.setJobNumber(num);
                //设置单位的用户id
                unitJobInfo.setUserId(userDto.getUserId());
                //设置单位名称
                unitJobInfo.setName(userDto.getName());
                if (dd == 0)
                    unitJobInfos.add(unitJobInfo);

            }

        }
        return unitJobInfos;

    }

    public List<UnitJobInfo> getUnitJobInfoByName(String name) {
        List<UnitJobInfo> unitJobInfos = new ArrayList();
        User user = new User();
        user.setName(name);
        List<UserDto> allUnitUserInfo = this.getUnitUserByUserInfo(user);
        for (UserDto userDto : allUnitUserInfo) {
            UnitJobInfo unitJobInfo = new UnitJobInfo();
            Job job = new Job();
            //设置id为查询条件
            job.setUserId(userDto.getUserId());
            //设置该单位职位数量
            int num = jobService.getJobByJobInfo(job).size();
            if (num > 0) {
                unitJobInfo.setJobNumber(num);
                //设置单位的用户id
                unitJobInfo.setUserId(userDto.getUserId());
                //设置单位名称
                unitJobInfo.setName(userDto.getName());
                unitJobInfos.add(unitJobInfo);
            }

        }
        return unitJobInfos;
    }


}



