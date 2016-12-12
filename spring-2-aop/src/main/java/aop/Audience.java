package aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* service.IPerformance.show(String))&&args(name)")
    public void performance(String name) {
        assert StringUtils.isNotEmpty(name);
    }

    @Before("performance(name)")
    public void before(String name) {
        System.out.println("wait==" + name);
    }

    @After("performance(name)")
    public void after(String name) {
        System.out.println("see==" + name);
    }

    /**
     * 需要注意的是，别忘记调用proceed()方法。如果不调这个方法的话，那么你的通知实际上
     * 会阻塞对被通知方法的调用。有可能这就是你想要的效果，但更多的情况是你希望在某个点
     * 上执行被通知的方法。
     * <p>
     * 可以对方法访问进行控制
     * <p>
     * 多次调用进行重复尝试
     *
     * @param joinPoint
     * @throws Throwable
     */

    @Around("performance(name)")
    public Object around(ProceedingJoinPoint joinPoint, String name) throws Throwable {
        //可以对方法访问进行控制
        Object obj = null;
        if ("许金鑫".equals(name)) {
            obj = joinPoint.proceed();
        }
        //多次调用进行重复尝试
       /* for (int i = 0; i < 10; i++) {
            joinPoint.proceed();
        }*/
        System.out.println("around==" + name);
        return obj;
    }
}
