package com.test.microservice.tasks;

import com.test.microservice.service.exchangeRates.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ExchangeRateTasks {
    private Logger logger = Logger.getLogger("exchangeRateTasks");
    @Autowired
    private ExchangeRatesService service;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateExchangeRates() {
        logger.info("Updating...");
        try {
            service.updateExchangeRates();
        }catch (Exception e) {
            logger.warning("Error:" + e.getMessage());
            return;
        }
        logger.info("Updated!");
    }

}
