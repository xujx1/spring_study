import com.cache.config.Config;
import com.cache.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }

    @org.junit.Test
    public void test() {
        System.out.println(userService.findAll());
    }


    @org.junit.Test
    public void test1() {
        System.out.println(userService.findByUsername("admin"));
    }


    @org.junit.Test
    public void test2() {
        userService.updateByUsername("admin");
    }
}
