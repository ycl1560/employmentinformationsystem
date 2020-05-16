package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Provinces;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ProvincesMapper extends Mapper<Provinces> {

    List<Provinces> selectProvinceByInfo(Provinces provinces);
}