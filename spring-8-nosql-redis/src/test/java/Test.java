import com.nosql.redis.config.Config;
import com.nosql.redis.pojo.Order;
import com.nosql.redis.service.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {
    @Autowired
    private OrderService orderService;

    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }


    @org.junit.Test
    public void test() throws Exception {
        Order order = new Order();
        order.setId(1);
        order.setUsername("许金鑫");
        order.setUserId(1);
        order.setProductName("NB");
        order.setProductId(2);
        orderService.setCache(order.getUsername(), order, 300, TimeUnit.SECONDS);

        System.out.println( orderService.getCache(order.getUsername()));
        System.out.println("=====================================");
        order.setProductName("新百伦");
        orderService.updateCache(order.getUsername(), order, 300, TimeUnit.SECONDS);
        System.out.println( orderService.getCache(order.getUsername()));
        System.out.println("=====================================");
        orderService.deleteCache(order.getUsername());
        System.out.println( orderService.getCache(order.getUsername()));
        System.out.println("=====================================");
    }

}
