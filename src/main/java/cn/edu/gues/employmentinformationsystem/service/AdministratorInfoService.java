package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.AdministratorInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.AdministratorInfoMapper;

import java.util.List;

@Service
public class AdministratorInfoService{

    @Resource
    private AdministratorInfoMapper administratorInfoMapper;

    public AdministratorInfo queryAdministratorInfoById(AdministratorInfo administratorId) {
        AdministratorInfo administratorInfo = administratorInfoMapper.selectByPrimaryKey(administratorId);
        return administratorInfo;
    }
}
