package spring.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author wanglei
 * @date 2021/12/9 18:52
 **/
@Component
@Eng
public class EngFood implements Food {

    @Override
    public String name() {
        return "eng";
    }
}
