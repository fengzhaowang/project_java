package Quartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class HelloJob implements Job {

    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext context){
        System.out.println("-----------start-------------");
        System.out.println("Hello World! - " + new Date());
        System.out.println("-----------end-------------");
    }

}
