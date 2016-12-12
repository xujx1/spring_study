Spring切面可以应用5种类型的通知：
前置通知（Before）：在目标方法被调用之前调用通知功能；
后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么；
返回通知（After-returning）：在目标方法成功执行之后调用通知；
异常通知（After-throwing）：在目标方法抛出异常后调用通知；
环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。


Spring提供了4种类型的AOP支持：
基于代理的经典Spring AOP；
纯POJO切面；
@AspectJ注解驱动的切面；
注入式AspectJ切面（适用于Spring各版本）。

前三种都是Spring AOP实现的变体，Spring AOP构建在动态代理基础之上，因此，Spring对AOP的支持局限于方法拦截。

AspectJ来实现切面可以实现对构造器和属性进行拦截

虽然Spring AOP能够满足许多应用的切面需求。
但是与AspectJ相比，Spring AOP 是一个功能比较弱的AOP解决方案。
AspectJ提供了Spring AOP所不能支持的许多类型的切点。