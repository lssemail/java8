package part02.test.design;

/**
 * Created by lssemail on 2018/3/30.
 */
public class Test {

    public static void main(String[] args) {

        Validator numericValidator = new Validator(new IsAllLowerCase());
        System.out.println(numericValidator.validate("Abs"));

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(lowerCaseValidator.validate("abs"));
    }
}
