package learn.mybatis;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018-7-24.
 */
public class TestConfig {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        InputStream in = TestConfig.class.getClassLoader().getResourceAsStream("learn/joda/config1.properties");
        properties.load(in);
        String url = properties.getProperty("url");
        System.out.println(url);
        System.out.println(properties.getProperty("username"));

    }
}
