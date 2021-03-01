package com.camel.microservices.camelmicroservices.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    GetCurrentTimeBean timeClass;

    @Override
    public void configure() throws Exception {
        // timer
        // transformation
        // log

        // timer endpoint:"timer:first-timer"
        from("timer:first-timer")
                // .transform().constant("My Constant
                // Message").to("log:first-timer");
                // .transform().constant("My is Message:" +
                // LocalDateTime.now()).to("log:first-timer");
                // .bean(timeClass,
                // "getCurrentTime2").to("direct:first-timer2");
                .bean(timeClass, "getCurrentTime2").to("log:first-timer2");

        from("direct:first-timer2").transform().constant("My direct").to("log:loggingDirect");
    }

}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }

    public String getCurrentTime2() {
        return "It's " + LocalDateTime.now();
    }
}
