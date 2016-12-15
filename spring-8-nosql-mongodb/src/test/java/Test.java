import com.nosql.config.Config;
import com.nosql.pojo.User;
import com.nosql.service.UserService;
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
    public void user() throws Exception {
        User user = new User(0, "许金鑫", "password");
        userService.addUser(user);
        System.out.println(userService.list());
        user.setPassword("testUpdate");
        userService.updateUser(user);
        System.out.println(userService.findOne(0));
        System.out.println(userService.findUserName("许金鑫"));
        System.out.println(userService.findByUserNameLike("鑫"));
        userService.deletesUser(new Integer[]{0});
        System.out.println(userService.list("许金鑫"));

    }
}
