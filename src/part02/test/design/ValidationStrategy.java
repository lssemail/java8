package part02.test.design;

/**
 * Created by lssemail on 2018/3/30.
 */
@FunctionalInterface
public interface ValidationStrategy {

    boolean excute(String s);
}
