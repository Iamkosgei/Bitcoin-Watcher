package me.kosgei.BitcoinSms;


import me.kosgei.BitcoinSms.controller.RetrofitController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {
    @Autowired
    private RetrofitController retrofitController;

    //120000
    @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
        retrofitController.start();
    }
}
