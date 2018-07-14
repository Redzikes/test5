package pl.xentivo.app2work.quarz.service;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Service;
import pl.xentivo.app2work.quarz.config.QuartzConfig;
import pl.xentivo.app2work.quarz.job.BuJob;

import java.util.Date;

@Service
public class BuService {

    @Autowired
    private SchedulerFactoryBean schedFactory;

    public void createTriggerandJobDetailForUserBu() throws SchedulerException {
        Date date=new Date();
        JobDetailFactoryBean jdfb = QuartzConfig.createJobDetail(BuJob.class);
        jdfb.getJobDataMap().put("W1","Wiadomosc 1 ");
        jdfb.getJobDataMap().put("W2",date.toString());
        jdfb.setBeanName("dynamicJobBean"+date.getTime()+"bu");
        jdfb.afterPropertiesSet();

        SimpleTriggerFactoryBean stfb = QuartzConfig.createTrigger(jdfb.getObject(),5000L);
        stfb.setBeanName("dynamicJobBeanTrigger"+ date.getTime()+"bu");
        stfb.afterPropertiesSet();

        schedFactory.getScheduler().scheduleJob(jdfb.getObject(), stfb.getObject());
    }

    public void sendSpam(String tmp,String tmp2) {

        System.out.println(tmp+"  "+tmp2);
    }
}
