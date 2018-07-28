package learn.mybatis;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018-7-24.
 */
public interface UserAnnoMapper {

    @Select("select * from tbl_user where id = #{id}")
    User findOneById(Long id);
}
