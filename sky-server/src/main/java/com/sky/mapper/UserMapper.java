package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Map;

=======
>>>>>>> 0f072ba3d2d02569e1f4491320f94ea9a1d01214
@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入用户数据
     * @param user
     */
    void insert(User user);
<<<<<<< HEAD

    /**
     * 根据日期统计用户数量
     * @param map
     * @return
     */
    Integer countByDate(Map map);
=======
>>>>>>> 0f072ba3d2d02569e1f4491320f94ea9a1d01214
}
