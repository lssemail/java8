package learn.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by Administrator on 2018-7-24.
 */
public class Test01 {

    public static void main(String[] args) throws Exception{

        method01();
    }

    public static void method01() throws Exception{
        String resource = "learn/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().addMapper(UserAnnoMapper.class);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User)session.selectOne("learn.mybatis.UserMapper.findOneById", 1L);
            System.out.println(user.toString());

//            UserAnnoMapper mapper = session.getMapper(UserAnnoMapper.class);
//            User user1 = mapper.findOneById(1L);
//            System.out.println(user1.toString());

        }finally {
            session.close();
        }


    }
}
