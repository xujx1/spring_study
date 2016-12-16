配置缓存管理器
Spring 3.1内置了五个缓存管理器实现，如下所示：
        SimpleCacheManager 
        NoOpCacheManager
        ConcurrentMapCacheManager
        CompositeCacheManager
        EhCacheCacheManager
Spring 3.2引入了另外一个缓存管理器，这个管理器可以用在基于JCache（JSR-107）的缓存提供商之中。
除了核心的Spring框架，Spring Data又提供了两个缓存管理器：
        RedisCacheManager（来自于Spring Data Redis项目）
        GemfireCacheManager（来自于Spring Data GemFire项目）
        
        
        
ehcache直接在jvm虚拟机中缓存，速度快，效率高；但是缓存共享麻烦，集群分布式应用不方便。
redis是通过socket访问到缓存服务，效率比ecache低，比数据库要快很多，处理集群和分布式缓存方便，有成熟的方案。
        
如果是单个应用或者对缓存访问要求很高的应用，用ehcache。
如果是大型系统，存在缓存共享、分布式部署、缓存内容很大的，建议用redis。



                Spring提供了四个注解来声明缓存规则
注　　解                    描　　述
@Cacheable                  表明Spring在调用方法之前，首先应该在缓存中查找方法的返回值。如果这个值能够找到，就会返回缓存的值。否则的话，这个方法就会被调用，返回值会放到缓存之中
@CachePut                   表明Spring应该将方法的返回值放到缓存中。在方法的调用前并不会检查缓存，方法始终都会被调用
@CacheEvict                 表明Spring应该在缓存中清除一个或多个条目
@Caching                    这是一个分组的注解，能够同时应用多个其他的缓存注解


@Cacheable首先在缓存中查找条目，如果找到了匹配的条目，那么就不会对方法进行调用了。如果没有找到匹配的条目，方法会被调用并且返回值要放到缓存之中。
而@CachePut并不会在缓存中检查匹配的值，目标方法总是会被调用，并将返回值添加到缓存之中。


                    Spring提供了多个用来定义缓存规则的SpEL扩展
表　达　式                       描　　述
#root.args                  传递给缓存方法的参数，形式为数组
#root.caches                该方法执行时所对应的缓存，形式为数组
#root.target                目标对象
#root.targetClass           目标对象的类，是#root.target.class的简写形式
#root.method                缓存方法
#root.methodName            缓存方法的名字，是#root.method.name的简写形式
#result                     方法调用的返回值（不能用在@Cacheable注解上）
#Argument                   任意的方法参数名（如#argName）或参数索引（如#a0或#p0）