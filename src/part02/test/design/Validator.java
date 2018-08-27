package part02.test.design;

/**
 * Created by lssemail on 2018/3/30.
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s){

        return strategy.excute(s);
    }

}
