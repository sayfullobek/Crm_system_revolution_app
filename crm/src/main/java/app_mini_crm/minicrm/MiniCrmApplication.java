package app_mini_crm.minicrm;

import app_mini_crm.minicrm.component.DataLoader;
import lombok.Builder;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MiniCrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniCrmApplication.class, args);
    }
}


