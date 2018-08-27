package review;

/**
 * Created by lssemail on 2017/10/9.
 */
public class Test03 implements IPrint {

    public static void main(String[] args) {

        Test03 test03 = new Test03();
        test03.print("hello java 8");
        test03.read();

    }

    @Override
    public void print(String string) {
        System.out.println("Good !" + string);
    }
}
