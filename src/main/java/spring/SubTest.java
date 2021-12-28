package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.util.Eng;
import spring.util.Food;
import spring.util.Han;

/**
 * @author wanglei
 * @date 2021/12/1 14:16
 **/
@Component
public class SubTest extends Test {

    @Override
    @Autowired
    @Han
    public void setFood(Food food) {
        super.setFood(food);
    }

    public void test() {
        a();
    }
}
