@Document注解定义如下：
    @Persistent
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface Document {
     
    String indexName();//索引库的名称，个人建议以项目的名称命名
     
    String type() default "";//类型，个人建议以实体的名称命名
     
    short shards() default 5;//默认分区数
     
    short replicas() default 1;//每个分区默认的备份数
     
    String refreshInterval() default "1s";//刷新间隔
     
    String indexStoreType() default "fs";//索引文件存储类型
 }


@Field注解的定义如下：

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @Documented
    @Inherited
    public @interface Field {
     
    FieldType type() default FieldType.Auto;#自动检测属性的类型
     
    FieldIndex index() default FieldIndex.analyzed;#默认情况下分词
     
    DateFormat format() default DateFormat.none;
     
    String pattern() default "";
     
    boolean store() default false;#默认情况下不存储原文
     
    String searchAnalyzer() default "";#指定字段搜索时使用的分词器
     
    String indexAnalyzer() default "";#指定字段建立索引时指定的分词器
     
    String[] ignoreFields() default {};#如果某个字段需要被忽略
     
    boolean includeInParent() default false;
    }
