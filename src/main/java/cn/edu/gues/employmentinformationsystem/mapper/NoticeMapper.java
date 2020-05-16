package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.Notice;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface NoticeMapper extends Mapper<Notice> {
    List<Notice> selectAllNotice(Notice notice);

    List<Notice> selectNoticeByName(String noticeName);
}