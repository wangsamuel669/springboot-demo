package spring;

import org.springframework.beans.factory.annotation.Autowired;
import spring.util.Food;
import spring.util.Han;

/**
 * @author wanglei
 * @date 2021/12/1 14:16
 **/
public abstract class Test {

    private Food food;

    protected void setFood(Food food) {
        this.food = food;
    }

    public void a() {
        System.out.println(food.name());
    }
}
