Redis连接工厂会生成到Redis数据库服务器的连接。Spring Data Redis为四种Redis客户端实现提供了连接工厂：
JedisConnectionFactory
JredisConnectionFactory
LettuceConnectionFactory
SrpConnectionFactory


Spring Data Redis提供了两个模板：
RedisTemplate
StringRedisTemplate

RedisTemplate可以极大地简化Redis数据访问，能够让我们持久化各种类型的key和value，并不局限于字节数组。
在认识到key和value通常是String类型之后，StringRedisTemplate扩展了RedisTemplate，只关注String类型。





            　RedisTemplate的很多功能是以子API的形式提供的，它们区分了单个值和集合值的场景
方　　法                                    子API接口                                      描　　述
opsForValue()                               ValueOperations<K, V>                          操作具有简单值的条目
opsForList()                                ListOperations<K, V>                           操作具有list值的条目
opsForSet()                                 SetOperations<K, V>                            操作具有set值的条目
opsForZSet()                                ZSetOperations<K, V>                           操作具有ZSet值（排序的set）的条目
opsForHash()                                HashOperations<K, HK, HV>                      操作具有hash值的条目
boundValueOps(K)                            BoundValueOperations<K,V>                      以绑定指定key的方式，操作具有简单值的条目
boundListOps(K)                             BoundListOperations<K,V>                       以绑定指定key的方式，操作具有list值的条目
boundSetOps(K)                              BoundSetOperations<K,V>                        以绑定指定key的方式，操作具有set值的条目
boundZSet(K)                                BoundZSetOperations<K,V>                       以绑定指定key的方式，操作具有ZSet值（排序的set）的条目
boundHashOps(K)                             BoundHashOperations<K,V>                       以绑定指定key的方式，操作具有hash值的条目

当某个条目保存到Redis key-value存储的时候，key和value都会使用Redis的序列化器（serializer）进行序列化。
Spring Data Redis提供了多个这样的序列化器，包括：
    GenericToStringSerializer：使用Spring转换服务进行序列化；
    JacksonJsonRedisSerializer：使用Jackson 1，将对象序列化为JSON；
    Jackson2JsonRedisSerializer：使用Jackson 2，将对象序列化为JSON；
    JdkSerializationRedisSerializer：使用Java序列化；
    OxmSerializer：使用Spring O/X映射的编排器和解排器（marshaler和unmarshaler）实现序列化，用于XML序列化；
    StringRedisSerializer：序列化String类型的key和value。