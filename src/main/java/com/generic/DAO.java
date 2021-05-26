package com.generic;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataBase access object 数据库访问对象
 *
 *
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * T get(String id)：从 map 中获取 id 对应的对象
 * void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * List<T> list()：返回 map 中存放的所有 T 对象
 * void delete(String id)：删除指定 id 对象
 * @param <T>
 */
public class DAO<T> {

    Map<String,T> map = new HashMap<String,T>();

    public  void saveUser(String id,T t){
        map.put(id,t);
    }

    public T getUser(String id){
        return map.get(id);
    }

    public void updateUser(String id,T t){
        map.put(id,t);
    }

    public List<T> getListUser(){
        List<T> li = new ArrayList<>();
        for (Map.Entry<String,T> entry : map.entrySet()){
            li.add(entry.getValue());
        }
        return  li;
    }

    public void deleteUser(String id){
        map.remove(id);
    }
    public void add(T t) {
    }

    public T get(int index) {
        return null;
    }

    public List<T> getForList(int index) {
        return null;
    }

    public void delete(int index) {

    }
}
