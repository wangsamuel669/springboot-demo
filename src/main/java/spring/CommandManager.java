package spring;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

//@Component
public abstract class CommandManager {

    public void execute() {
        Command command = command();
        String execute = command.execute();
        System.out.println(execute);
    }

    public Command newInstance() {
        return command();
    }

//    @Lookup
    public abstract Command command();
}
