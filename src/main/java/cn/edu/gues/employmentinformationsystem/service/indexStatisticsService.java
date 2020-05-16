package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.IndexStatistics;
import cn.edu.gues.employmentinformationsystem.entity.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class indexStatisticsService {
    @Resource
    UserService userService;
    @Resource
    NoticeService noticeService;
    @Resource
    JobService jobService;
    public IndexStatistics getInfo() {
        IndexStatistics indexStatistics = new IndexStatistics();
        indexStatistics.setNumber_user(userService.getAllUserInfo());
        indexStatistics.setNumber_gonggao(noticeService.getAllNotice(new Notice()).size());
        indexStatistics.setNumber_job(jobService.getAllJobs().size());
        return indexStatistics;
    }
}
