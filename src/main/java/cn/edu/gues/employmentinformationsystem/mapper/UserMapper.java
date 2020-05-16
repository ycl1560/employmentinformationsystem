package cn.edu.gues.employmentinformationsystem.mapper;

import cn.edu.gues.employmentinformationsystem.entity.User;
import org.apache.ibatis.annotations.Param;import tk.mybatis.mapper.common.Mapper;import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    List<User> selectUserByUserInfo(User user);

}