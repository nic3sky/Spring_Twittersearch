package masterSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;


@ConditionalOnClass(DispatcherServlet.class)
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication

public class MasterSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterSpringApplication.class, args);
    }
}
