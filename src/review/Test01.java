package review;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by lssemail on 2017/10/9.
 */
public class Test01 {

    public static void main(String[] args) {
        //传统写法
        File[] files = new File(".").listFiles(File::isHidden);


        System.out.println(files.length);
        for(File file : files){
            System.out.println(file.getName());
        }
    }
}
