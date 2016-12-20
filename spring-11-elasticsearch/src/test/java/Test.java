import com.elasticsearch.config.Config;
import com.elasticsearch.pojo.User;
import com.elasticsearch.service.UserService;
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
        System.out.println(userService.findByName("金"));
    }


    @org.junit.Test
    public void testAdd() {
        userService.findAll().forEach(System.out::println);
        System.out.println("=====================================");
        userService.addUser(new User(1L, "许金鑫"));
        System.out.println("=====================================");
        userService.findAll().forEach(System.out::println);
        System.out.println("=====================================");
    }

    @org.junit.Test
    public void testDelete() {
        userService.findAll().forEach(System.out::println);
        System.out.println("=====================================");
        userService.deleteUser("金");
        System.out.println("=====================================");
        userService.findAll().forEach(System.out::println);
        System.out.println("=====================================");
    }

    @org.junit.Test
    public void testSearch() {
        userService.findAll().forEach(System.out::println);
        System.out.println("=====================================");
        userService.search("1").forEach(System.out::println);
    }


    @org.junit.Test
    public void testUpdate() {
        Iterable<User> users = userService.findAll();
        users.forEach(System.out::println);
        System.out.println("=====================================");
        User user = users.iterator().next();
        user.setName("许金鑫2");
        //update不能实时的跟新数据有3s多的延迟
        userService.updateUser(user);
        userService.findAll().forEach(System.out::println);
    }
}
