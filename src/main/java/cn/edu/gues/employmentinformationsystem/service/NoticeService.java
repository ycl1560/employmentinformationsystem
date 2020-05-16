package cn.edu.gues.employmentinformationsystem.service;

import cn.edu.gues.employmentinformationsystem.dto.NoticeDto;
import cn.edu.gues.employmentinformationsystem.entity.Notice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.edu.gues.employmentinformationsystem.mapper.NoticeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NoticeService{

    @Resource
    private NoticeMapper noticeMapper;

    public List<NoticeDto> getAllNotice(Notice notice1) {
        List<Notice> list = noticeMapper.selectAllNotice(notice1);
        List<NoticeDto> noticeDtoList = new ArrayList();
        for (Notice notice : list) {
            NoticeDto noticeDto = new NoticeDto();
            BeanUtils.copyProperties(notice,noticeDto);
            if(notice.getType().equals("1")){
                noticeDto.setType("学校公告");
            }
            if(notice.getType().equals("2")){
                noticeDto.setType("工作动态");
            }
            noticeDtoList.add(noticeDto);
        }
        return noticeDtoList;
    }
    public List<NoticeDto> getNoticeByName(String noticeName) {
        List<Notice> list = noticeMapper.selectNoticeByName(noticeName);
        List<NoticeDto> noticeDtoList = new ArrayList();
        for (Notice notice : list) {
            NoticeDto noticeDto = new NoticeDto();
            BeanUtils.copyProperties(notice,noticeDto);
            if(notice.getType().equals("1")){
                noticeDto.setType("学校公告");
            }
            if(notice.getType().equals("2")){
                noticeDto.setType("工作动态");
            }
            noticeDtoList.add(noticeDto);
        }
        return noticeDtoList;
    }

    public int updataNoticeById(Notice notice) {
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public int delNoticeById(String noticeId) {
        Notice notice = new Notice();
        notice.setNoticeId(noticeId);
        notice.setStatus("1");
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public int addNotice(Notice notice) {
        notice.setNoticeId(UUID.randomUUID().toString());
        return noticeMapper.insertSelective(notice);
    }
}
