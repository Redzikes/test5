package pl.xentivo.app2work.quarz.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xentivo.app2work.quarz.config.QuartzConfig;
import pl.xentivo.app2work.quarz.job.BuJob;
import pl.xentivo.app2work.quarz.job.EmailJob;

@Controller
public class BuController {

    @Autowired
    private SchedulerFactoryBean schedFactory;

    @GetMapping("/bu")
    public String home() throws SchedulerException {
        JobDetailFactoryBean jdfb = QuartzConfig.createJobDetail(BuJob.class);
        jdfb.setBeanName("dynamicJobBean5");
        jdfb.afterPropertiesSet();

        SimpleTriggerFactoryBean stfb = QuartzConfig.createTrigger(jdfb.getObject(),5000L);
        stfb.setBeanName("dynamicJobBeanTrigger5");
        stfb.afterPropertiesSet();

        schedFactory.getScheduler().scheduleJob(jdfb.getObject(), stfb.getObject());
        return "index";
    }
}
