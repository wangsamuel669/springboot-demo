package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.util.Eng;
import spring.util.Food;
import spring.util.Han;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyCommand implements Command {

    @Autowired
    @Eng
    private Food food;

    @PostConstruct
    public void init() {
        System.out.println(">>>>>>>INIT");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("<<<<<<<<DESTORY");
    }

    @Override
    public String execute() {
        return food.name();
    }
}
