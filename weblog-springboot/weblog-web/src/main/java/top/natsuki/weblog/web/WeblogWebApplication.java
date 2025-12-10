package top.natsuki.weblog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"top.natsuki.weblog.*"})
public class WeblogWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(WeblogWebApplication.class, args);
    }

}