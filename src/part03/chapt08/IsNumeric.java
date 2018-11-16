package part03.chapt08;

/**
 * Created by Administrator on 2018-11-12.
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
