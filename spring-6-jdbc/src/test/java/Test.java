import com.config.Config;
import com.pojo.User;
import com.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
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
    public void users() {
        System.out.println(userService.findUsers());
    }

    @org.junit.Test
    public void add() {
        User user = new User();
        user.setUsername("test");
        System.out.println(userService.findUsers());
        userService.addUser(user);
        System.out.println(userService.findUsers());
    }
}
