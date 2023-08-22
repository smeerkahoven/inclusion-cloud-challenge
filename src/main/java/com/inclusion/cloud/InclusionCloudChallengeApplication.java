package com.inclusion.cloud;

import com.inclusion.cloud.component.ConsoleComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class InclusionCloudChallengeApplication  {

    public static void main(final String[] args) {
        final ApplicationContext context = SpringApplication.run(InclusionCloudChallengeApplication.class, args);
        final ConsoleComponent consoleComponent = context.getBean(ConsoleComponent.class);
        try {
            consoleComponent.startConsole();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
