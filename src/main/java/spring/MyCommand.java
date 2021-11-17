package spring;

import org.springframework.stereotype.Component;

@Component
public class MyCommand implements Command {

    public void init() {
        System.out.println(">>>>>>>INIT");
    }

    public void destroy() {
        System.out.println("<<<<<<<<DESTORY");
    }

    @Override
    public String execute() {
        return this.toString();
    }
}
