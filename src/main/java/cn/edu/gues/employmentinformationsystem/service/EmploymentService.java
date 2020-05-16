package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.EnploymentDto;
import cn.edu.gues.employmentinformationsystem.dto.Salary;
import cn.edu.gues.employmentinformationsystem.entity.Employment;
import cn.edu.gues.employmentinformationsystem.entity.Provinces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.EmploymentMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmploymentService{

    @Resource
    private EmploymentMapper employmentMapper;
    @Autowired
    private ProvincesService provincesService;
    public List<EnploymentDto> getEmploymentPlaceInfo() {
        List<Employment> employments = employmentMapper.selectAll();
        List<EnploymentDto> enploymentDtos = new ArrayList();
        List<Provinces> provinces = provincesService.getAllProvence();

        for (Provinces province : provinces) {
            int number = 0;
            EnploymentDto enploymentDto = new EnploymentDto();
            enploymentDto.setName(province.getProvince());
            for (Employment employment : employments) {
                if (employment.getEmploymentProvence().equals(province.getId().toString())){
                    number++;
                }
            }
            enploymentDto.setValue(number);
            if (number != 0) {
                enploymentDtos.add(enploymentDto);
            }
        }
        return enploymentDtos;

    }
    public List<Salary> getEmploymentSalaryInfo() {
        List<Employment> employments = employmentMapper.selectAll();
        List<Salary> salaries = new ArrayList();
        int number02 = 0;
        int number24 = 0;
        int number46 = 0;
        int number68 = 0;
        int number81 = 0;
        int number10 = 0;
        for (Employment employment : employments) {
            if(employment.getMonthlySalary().equals("0-2K")){
                number02++;
            }if(employment.getMonthlySalary().equals("2-4K")){
                number24++;
            }if(employment.getMonthlySalary().equals("4-6K")){
                number46++;
            }if(employment.getMonthlySalary().equals("6-8K")){
                number68++;
            }if(employment.getMonthlySalary().equals("8-10K")){
                number81++;
            }if(employment.getMonthlySalary().equals("10K+")){
                number10++;
            }
        }

        for(int i=0;i<6;i++){
            Salary salary = new Salary();
            if(i==0){
                salary.setSalary("0-2K");
                salary.setValue(number02);
                salaries.add(salary);
            }if(i==1){
                salary.setSalary("2-4K");
                salary.setValue(number24);
                salaries.add(salary);
            }if(i==2){
                salary.setSalary("4-6K");
                salary.setValue(number46);
                salaries.add(salary);
            }if(i==3){
                salary.setSalary("6-8K");
                salary.setValue(number68);
                salaries.add(salary);
            }if(i==4){
                salary.setSalary("8-10K");
                salary.setValue(number81);
                salaries.add(salary);
            }if(i==5){
                salary.setSalary("10K+");
                salary.setValue(number10);
                salaries.add(salary);
            }
        }

    return salaries;

    }

    public  List<EnploymentDto> getEmploymentByInfo(Employment employmentInfo) {
        List<Employment> employments = employmentMapper.selectEmploymentByInfo(employmentInfo);
        List<EnploymentDto> enploymentDtos = new ArrayList();
        for (Employment enployment : employments) {
            //省份查询
            Provinces provinces = provincesService.getProvinceById(enployment.getEmploymentProvence());
            //实体转换
            EnploymentDto enploymentDto = new EnploymentDto();
            BeanUtils.copyProperties(enployment,enploymentDto);
            //设置省份和省份ID
            enploymentDto.setEmploymentProvence(provinces.getProvince());
            enploymentDto.setProvinceId(provinces.getId());
            enploymentDtos.add(enploymentDto);
        }
        return enploymentDtos;



    }

    public int addEmployment(Employment employment) {
        List<Employment> employments = employmentMapper.selectEmploymentByInfo(employment);
        if(employments.size()>0){
            employment.setEmploymentId(employments.get(0).getEmploymentId());
            return employmentMapper.updateByPrimaryKeySelective(employment);
        }
        else {
            employment.setEmploymentId(UUID.randomUUID().toString());
            return employmentMapper.insertSelective(employment);
        }
    }
}
