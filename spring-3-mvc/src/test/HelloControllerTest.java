import com.web.HelloController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 不过从Spring 3.2开始，我们可以按照控制器的方式来测试Spring MVC中的控制器了，
 * 而不仅仅是作为POJO进行测试。Spring现在包含了一种mock Spring MVC并针对控制器执行HTTP请求的机制。
 * 这样的话，在测试控制器的时候，就没有必要再启动Web服务器和Web浏览器了
 * <p>
 * <p>
 * 1、mockMvc.perform执行一个请求；
 * <p>
 * 2、MockMvcRequestBuilders.get("/hello")构造一个请求
 * <p>
 * 3、ResultActions.andExpect添加执行完成后的断言
 * <p>
 * 4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
 * <p>
 * 5、ResultActions.andReturn表示执行完成后返回相应的结果。
 */

public class HelloControllerTest {

    @Test
    public void test() throws Exception {
        HelloController helloController = new HelloController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").characterEncoding("UTF-8")).andDo(MockMvcResultHandlers.print());
      /*  System.out.println(helloController.hello());
        assert "hello".equals(helloController.hello());*/
    }
}
