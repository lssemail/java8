package tuling;

import tuling.utils.HttpUtils;

/**
 * Created by lssemail on 2017/10/12.
 */
public class Main {

    static String url = "http://www.tuling123.com/openapi/api";
    static String apiKey = "0555253453d14fc38eab6ce9b4321fa5";
    public static void main(String[] args) {
        String params = "info=小狗的图片&userid=12345678&key=0555253453d14fc38eab6ce9b4321fa5";
        String result = HttpUtils.sendPost(url, params);
        System.out.println(result);
    }
}
