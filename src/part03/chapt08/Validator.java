package part03.chapt08;

/**
 * Created by Administrator on 2018-11-12.
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy){
        this.strategy = strategy;
    }

    public boolean validate(String s){

        return strategy.execute(s);
    }
}
