package part01.chapt03.service;

import part01.chapt03.interfaces.BufferReadProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lssemail on 2017/9/11.
 */
public class ReadFile {

    private static final String folder = "D:\\project\\IdeaProject\\java8\\src\\chapt03\\service\\";

    public static void main(String[] args) {
        try {
            String data = processFile((BufferedReader br) -> br.readLine());
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String processFile() throws Exception{

        try(BufferedReader br = new BufferedReader(new FileReader(folder + "data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferReadProcess p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(folder + "data.txt"))) {
            return p.process(br);
        }
    }
}
