package com.app.warrantychecker.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyHealthIndicator implements HealthIndicator {

    // Docs: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#writing-custom-healthindicators
    // The identifier is the name of the bean without the HealthIndicator suffix.
    // In this example, the health information is available in an entry named 'my'.
    // http://localhost:8080/actuator/health

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check

        // There are 4 status types:
        // Up: Http 200
        // Down: Http 503
        // Unknown Http 200
        // Out of Service: Http 503

        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        Random random = new Random();
        return random.nextInt(1);
    }

}
