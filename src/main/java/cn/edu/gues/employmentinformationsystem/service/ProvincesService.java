package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.entity.Provinces;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.ProvincesMapper;

import java.util.List;

@Service
public class ProvincesService {

    @Resource
    private ProvincesMapper provincesMapper;

    public List<Provinces> getAllProvence() {
        return provincesMapper.selectAll();
    }

    public Provinces getProvinceById(String employmentProvence) {
        Provinces provinces = new Provinces();
        provinces.setId(employmentProvence);
        return provincesMapper.selectByPrimaryKey(provinces);
    }
}

