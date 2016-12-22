import com.jms.config.Config;
import com.jms.pojo.Order;
import com.jms.service.OrderService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    private OrderService orderService;

    @org.junit.Test
    public void test() throws InterruptedException {
        orderService.sendOrder(new Order(1, "许金鑫"));
        Thread.sleep(Integer.MAX_VALUE);
    }
}
