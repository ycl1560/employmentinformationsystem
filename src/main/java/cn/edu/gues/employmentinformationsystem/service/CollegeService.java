package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.College;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.CollegeMapper;

import java.util.List;
import java.util.UUID;

@Service
public class CollegeService{

    @Resource
    private CollegeMapper collegeMapper;

    public College getCollegeById(String collegeId) {
        College college = new College();
        college.setCollegeId(collegeId);
        return collegeMapper.selectByPrimaryKey(college);
    }

    public List<College> getAllCollegeByInfo(College college) {
        List<College> colleges = collegeMapper.selectAllCollegeByInfo(college);
        return colleges;
    }

    public int addCollege(College college) {
        college.setCollegeId(UUID.randomUUID().toString());
        return collegeMapper.insertSelective(college);
    }

    public int delCollegeByCollegeId(College college) {
        college.setStatus("1");
        return collegeMapper.updateByPrimaryKeySelective(college);
    }

    public int updataCollegeByCollegeId(College college) {
        return collegeMapper.updateByPrimaryKeySelective(college);
    }
}
