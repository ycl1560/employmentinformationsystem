package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.Resumes;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.ResumesMapper;

import java.util.List;
import java.util.UUID;

@Service
public class ResumesService{

    @Resource
    private ResumesMapper resumesMapper;

    public int addResumes(Resumes resume) {
        List<Resumes> resumes = resumesMapper.selectAll();
        for (Resumes resume1 : resumes) {
            if(resume1.getUserId().equals(resume.getUserId())){
                resume.setResumeId(resume1.getResumeId());
                return resumesMapper.updateByPrimaryKeySelective(resume);
            }
        }
        resume.setResumeId(UUID.randomUUID().toString());
       return resumesMapper.insertSelective(resume);
    }

    public Resumes getResumesByUserId(Resumes resume) {
        List<Resumes> resumes = resumesMapper.selectResumeByInfo(resume);
        if(resumes.size()>0){
           return resumes.get(0);
        }
        return null;
    }
}
