package pl.xentivo.app2work.quarz.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xentivo.app2work.quarz.service.EmailService;


public class BuJob implements Job {

    @Autowired
    private EmailService cronService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap detail=jobExecutionContext.getJobDetail().getJobDataMap();
        String m1=detail.getString("W1");
        String m2=detail.getString("W2");
      cronService.sendSpam(m1,m2);
    }
}
