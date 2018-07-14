package pl.xentivo.app2work.quarz.controller;

import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.quartz.impl.JobExecutionContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xentivo.app2work.quarz.config.QuartzConfig;
import pl.xentivo.app2work.quarz.job.BuJob;
import pl.xentivo.app2work.quarz.job.EmailJob;
import pl.xentivo.app2work.quarz.service.BuService;
import pl.xentivo.app2work.quarz.service.EmailService;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class BuController {

    @Autowired
    private BuService buService;

    @GetMapping("/bu")
    public String home() throws SchedulerException {

        buService.createTriggerandJobDetailForUserBu();
        return "index";
    }
}
