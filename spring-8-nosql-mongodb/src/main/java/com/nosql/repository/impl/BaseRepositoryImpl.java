package com.nosql.repository.impl;

import com.nosql.repository.BaseRepository;
import com.nosql.util.Pager;
import com.nosql.util.PaginationContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

    private Class<T> clazz;

    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings("unchecked")
    /**
     * 初始化时获取继承此类的当前对象
     */
    BaseRepositoryImpl() {
        if (null == this.clazz) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            this.clazz = (Class<T>) type.getActualTypeArguments()[0];
        }
    }


    @Override
    public List<T> list(Query query) {
        return mongoTemplate.find(query, this.clazz);
    }

    @Override
    public List<T> list() {
        return mongoTemplate.findAll(this.clazz);
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.clazz);
    }

    @Override
    public void update(Query query, Update update) {
        mongoTemplate.findAndModify(query, update, this.clazz);
    }

    //TODO 建议继承重写
    @Override
    public void update(T entry) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        String id = "";
        Update update = new Update();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();

            Object obj = field.get(entry);
            String value = obj != null ? String.valueOf(obj) : "";

            if ("id".equals(name)) {
                id = value;
            } else {
                update.set(name, value);
            }

        }
        if (StringUtils.isNotEmpty(id)) {
            Query query = new Query(Criteria.where("id").is(Integer.parseInt(id)));
            mongoTemplate.updateFirst(query, update, this.clazz);
        }
    }

    @Override
    public void save(T entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public T load(Integer id) {
        T t = null;
        if (null != id) {
            t = mongoTemplate.findById(id, this.clazz);
        }
        return t;
    }

    @Override
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.clazz, collectionName);
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, this.clazz);
    }

    @Override
    public long count() {
        Query query = new Query(Criteria.where("").is(""));
        return this.count(query);
    }

    @Override
    public void delete(Integer id) {
        if (null != id) {
            Query query = new Query(Criteria.where("id").is(id));
            mongoTemplate.findAndRemove(query, this.clazz);
        }
    }


    /**
     * @since jdk 8
     * parallel()
     * 开启平行处理能力
     * filter(integer -> null != integer)
     * 拦截数组里面的所有null
     * collect(Collectors.toList())
     * 转成list对象
     * forEach(this::delete)
     * 遍历掉delete方法
     */
    @Override
    public void deletes(Integer[] ids) {
        Stream<Integer> stream = Stream.of(ids);

        stream.parallel().filter(integer -> null != integer).collect(Collectors.toList()).forEach(this::delete);
    }

    @Override
    public void delete(T entry) {
        mongoTemplate.remove(entry);
    }

    @Override
    public Pager<T> queryByPager() {
        return this.queryByPager(new Query(Criteria.where("").is("")));
    }

    @Override
    public Pager<T> queryByPager(Query query) {
        Integer offset = PaginationContext.getOffset();
        Integer pageSize = PaginationContext.getPageSize();
        Integer pageNow = (offset - 1) / pageSize;

        Integer count = new Long(this.count(query)).intValue();
        Integer pageCount = (count - 1) / pageSize + 1;
        query.skip(offset).limit(pageSize);
        List<T> data = mongoTemplate.find(query, this.clazz);
        return new Pager<>(pageSize, pageNow, pageCount, count, data);
    }

    /**
     * Stream 测试类
     */
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 0, 4, 3, null, null};
        Stream<Integer> stream = Stream.of(integers);
        stream.parallel().filter(integer -> null != integer).collect(Collectors.toList()).forEach(System.out::println);
    }
}
