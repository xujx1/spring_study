import com.rpc.config.ClientConfigure;
import com.rpc.config.ServerConfigure;
import com.rpc.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ClientConfigure.class)
public class ClientTest {

    @Autowired
    private RmiProxyFactoryBean rmiProxyFactoryBean;

    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }

    @org.junit.Test
    public void testRmi() throws RemoteException, NotBoundException, MalformedURLException {
        UserService userService = (UserService) rmiProxyFactoryBean.getObject();
        System.out.println(userService.findByUsername("许金鑫"));
    }
}
