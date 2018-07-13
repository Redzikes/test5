package pl.xentivo.app2work.quarz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xentivo.app2work.quarz.config.QuartzConfig;
import pl.xentivo.app2work.quarz.job.EmailJob;

@Controller
public class HomeController {

    @Autowired
    private SchedulerFactoryBean schedFactory;

    @GetMapping("/")
    public String home()
    {


        String scheduled = "Job is Scheduled!!";
        try {
            JobDetailFactoryBean jdfb = QuartzConfig.createJobDetail(EmailJob.class);


            SimpleTriggerFactoryBean stfb = QuartzConfig.createTrigger(jdfb.getObject(),5000L);


            schedFactory.getScheduler().scheduleJob(jdfb.getObject(), stfb.getObject());

        } catch (Exception e) {
            scheduled = "Could not schedule a job. " + e.getMessage();
        }




        return "index";
    }
}
