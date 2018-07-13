package pl.xentivo.app2work.quarz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xentivo.app2work.quarz.service.EmailService;


public class BuJob implements Job {

    @Autowired
    private EmailService cronService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
      cronService.sendSpam();
    }
}
