package spring.util;

import org.springframework.stereotype.Component;

/**
 * @author wanglei
 * @date 2021/12/9 18:51
 **/
@Component
@Han
public class HanFood implements Food {

    @Override
    public String name() {
        return "han";
    }
}
