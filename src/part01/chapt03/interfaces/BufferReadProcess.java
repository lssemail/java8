package part01.chapt03.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lssemail on 2017/9/11.
 */
@FunctionalInterface
public interface BufferReadProcess {

    String process(BufferedReader br) throws IOException;
}
