package spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = new SpringApplicationBuilder(DemoApp.class)
                .run(args);
        SubTest bean = run.getBean(SubTest.class);
        bean.a();
    }
}
