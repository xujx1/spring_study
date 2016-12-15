package com.nosql.repository;

import com.nosql.util.Pager;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 建立公共的BaseRepository接口，所有的Repository都需要继承这个类
 */
public interface BaseRepository<T> {

    /**
     * 通过条件查询实体(集合)
     */
    List<T> list(Query query);

    /**
     * 获取所有的数据
     */
    List<T> list();

    /**
     * 通过一定的条件查询一个实体
     */
    T findOne(Query query);

    /**
     * 通过条件查询更新数据
     */
    void update(Query query, Update update);

    /**
     * 通过给定的对象进行更新
     */
    void update(T entry) throws IllegalAccessException;

    /**
     * 保存一个对象到mongodb
     * 使用的是mongotemplate的insert方法
     * <p>
     * 添加的时候，会制动增长id
     * id  必须是 int  id 字段
     */
    void save(T entity);

    /**
     * 通过ID获取记录
     */
    T load(Integer id);

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     *
     * @return
     */
    T findById(String id, String collectionName);


    /**
     * 求数据总和 ，根据给定的 Query查询
     */
    long count(Query query);

    /**
     * 获取所有数据条数
     */
    long count();

    /**
     * 通过id删除数据
     */
    void delete(Integer id);

    /**
     * 一次删除多条数据
     */
    void deletes(Integer[] ids);

    /**
     * 通过传递过来的 对象来删除数据
     */
    void delete(T entry);

    /**
     * 带分页查询
     */
    Pager<T> queryByPager();

    /**
     * 不带分页的查询方法
     */
    Pager<T> queryByPager(Query query);

}
