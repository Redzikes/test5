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
import pl.xentivo.app2work.quarz.service.EmailService;

import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() throws SchedulerException {
        String tmp="asdadsa";
        emailService.createUserforUser(tmp);
        return "index";
    }
}
