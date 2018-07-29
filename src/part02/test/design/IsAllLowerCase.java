package part02.test.design;

/**
 * Created by lssemail on 2018/3/30.
 */

public class IsAllLowerCase implements ValidationStrategy{

    @Override
    public boolean excute(String s) {
        return s.matches("[a-z]+");
    }
}
