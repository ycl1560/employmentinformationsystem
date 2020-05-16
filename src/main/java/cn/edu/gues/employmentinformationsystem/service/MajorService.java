package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.Major;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.MajorMapper;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MajorService{

    @Resource
    private MajorMapper majorMapper;

    public List<Major> getAllMajors() {
        return majorMapper.selectAll();
    }

    public List<Major> getMajorByCollegeId(int collegeId) {
        return majorMapper.selectMajorByCollegeId(collegeId);
    }

    public Major getMajorById(String majorId) {
        Major major = new Major();
        major.setMajorId(majorId);
        return majorMapper.selectByPrimaryKey(major);
    }

    public List<Major> getMajorByInfo(Major major) {
        List<Major> majors =  majorMapper.selectMajorByInfo(major);
        return majors;
    }

    public int addMajor(Major major) {
        major.setMajorId(UUID.randomUUID().toString());
        return majorMapper.insertSelective(major);
    }

    public int updateMajorByMajorId(Major major) {
        return majorMapper.updateByPrimaryKeySelective(major);
    }

    public int delMajorByMajorId(Major major) {
        major.setStatus("1");
        return majorMapper.updateByPrimaryKeySelective(major);
    }

    public Major getMajorByName(String majorName) {
        return  majorMapper.selectMajorByName(majorName);
    }
}
