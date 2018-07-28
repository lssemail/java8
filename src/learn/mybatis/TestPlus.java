package learn.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

/**
 * Created by Administrator on 2018-7-24.
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "select",
        args = {MappedStatement.class,Object.class})})
public class TestPlus implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("intercept");
        return null;
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("plugin");
        System.out.println(o.toString());
        return o;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties");
        System.out.println(properties.getProperty("defaultVal"));
    }
}
