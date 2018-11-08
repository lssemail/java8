package test;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Administrator on 2018-10-24.
 */
public class JobTest {

    public static void main(String[] args) {

        Job job = new Job() {
            @Override
            public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
                System.out.println("this is job");
            }
        };


    }
}
