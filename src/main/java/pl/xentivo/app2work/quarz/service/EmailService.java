package pl.xentivo.app2work.quarz.service;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Service;
import pl.xentivo.app2work.quarz.config.QuartzConfig;
import pl.xentivo.app2work.quarz.job.BuJob;
import pl.xentivo.app2work.quarz.job.EmailJob;

import java.util.Date;

/**
 * Created by gkatzioura on 6/7/16.
 */
@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private SchedulerFactoryBean schedFactory;



    public void createUserforUser(String tmp) throws SchedulerException {
        Date date=new Date();
        JobDetailFactoryBean jdfb = QuartzConfig.createJobDetail(EmailJob.class);
        jdfb.getJobDataMap().put("W1",tmp);
        jdfb.setBeanName("dynamicJobBean"+date.getTime()+"home");
        jdfb.afterPropertiesSet();

        SimpleTriggerFactoryBean stfb = QuartzConfig.createTrigger(jdfb.getObject(),5000L);
        stfb.setBeanName("dynamicJobBeanTrigger"+ date.getTime()+"home");
        stfb.afterPropertiesSet();

        schedFactory.getScheduler().scheduleJob(jdfb.getObject(), stfb.getObject());

    }

    public void sendSpam(String tmp,String tmp2) {

        LOGGER.info(tmp+tmp2);
    }







}
