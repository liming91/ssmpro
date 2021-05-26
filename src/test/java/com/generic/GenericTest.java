package com.generic;

import com.generic.Order;
import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 */
public class GenericTest {

    /**
     * 在集合中没有使用泛型的情况下
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(65);
        list.add(89);
        list.add(78);
        //1.没有使用泛型，任何Object及其子类的对象都可以添加进来
        list.add(new String("AA"));
        for (int i = 0; i < list.size(); i++) {
            //2.获取元素的时候，需要强转int可能会出现java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
            int score = (Integer) list.get(i);
            System.out.println(score);
        }
    }

    /**
     * 在集合中使用泛型，解决类型转换问题和数据存储不安全性问题
     */
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(65);
        list.add(89);
        list.add(78);
        //list.add("AA");
//        for (int i = 0; i < list.size(); i++) {
//            int score = list.get(i);
//            System.out.println(score);
//        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("AA", 89);
        map.put("BB", 67);
        map.put("CC", 90);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for (Map.Entry en : entry) {
            System.out.println("key==:" + en.getKey());
            System.out.println("value==:" + en.getValue());
        }

//        for (String key : map.keySet()) {
//            System.out.println(key);
//        }
//        for (Integer value : map.values()) {
//            System.out.println(value);
//        }

//   Iterator<Map.Entry<String, Integer>> iterator =  map.entrySet().iterator();
//   while (iterator.hasNext()){
//      Map.Entry<String,Integer> integerEntry = iterator.next();
//       System.out.println(integerEntry.getKey());
//       System.out.println(integerEntry.getValue());
//   }

    }

    /**
     * 自定义泛型类
     */
    @Test
    public void test4() {
        //1.当实例化泛型类的对象时，指明泛型的类型。
        //指明以后对应的类中所有使用泛型的位置，都变为实例化中指定的泛型的类型。
        //2.如果我们自定义了泛型类，但是在实例化的时候没有使用，默认是Object类型
        Order<Boolean> order = new Order<Boolean>();
        order.setT(true);
        System.out.println(order.getT());
        order.add();
        List<Boolean> list = order.list;
        System.out.println(list);

        SubOrder subOrder = new SubOrder();
        List<Integer> list1 = subOrder.list;
        System.out.println(list1);
    }

    /**
     * 继承泛型类或接口时，可以指明泛型的类型
     */
    class SubOrder extends Order<Integer> {

    }

    /**
     * 类似于list继承collection接口
     *
     * @param <T>
     */
    class SubOrder2<T> extends Order<T> {

    }

    /**
     * 泛型方法的使用测试
     */
    @Test
    public void genericMethodTest() {
        Order<Integer> order = new Order<>();
        //当通过对象调泛型方法时，指明泛型方法的类型
        String s = order.getE("4");
        System.out.println(s);
        //将数组的元素复制到集合中
        Integer[] a = new Integer[]{2, 3};
        List<Integer> list = new ArrayList<>();
        List<Integer> li = order.toArray(a, list);
        System.out.println(li);
    }

    /**
     * 泛型与继承的关系
     * 若类A是类B的子类，那么List<A>不是List<B>的子接口
     */
    @Test
    public void extendsTest() {
        Object obj = null;
        String str = "AA";
        obj = str;

        Object[] obj1 = null;
        String[] str1 = new String[]{"AA", "BB", "CC"};
        obj1 = str1;

        List<Object> list = null;
        List<String> list1 = new ArrayList<String>();
        //list = list1;
        //反正法：假设list = list1满足
        //list.add(10);
        //String str = list1.get(0);//出现问题假设不满足，添加的是Integer类型取出的是String类型
        //泛型就是为了限制集合中元素的类型
    }

    /**
     * 通配符 ？
     * List<A>、List<B>。。等都是List< ?>的子类
     * <p>
     * boolean addAll(Collection<? extends E> c);
     * ? extends A : 可以存放A及其子类
     * <p>
     * ? supper A:可以存放及其父类
     */
    @Test
    public void commonTest() {
        List<?> list = null;
        List<Object> objectList = new ArrayList<>();
        list = objectList;
        List<String> stringList = new ArrayList<>();
        list = stringList;
        //只能存放Object类型的集合
        show(objectList);
        //show(stringList);//报错
        //任何类型的集合都可以存放，因为使用了通配符List<?>
        show1(objectList);
        show1(stringList);
    }

    public void show(List<Object> li) {
    }

    //使用通配符
    public void show1(List<?> li) {
    }

    /**
     * boolean addAll(Collection<? extends E> c);
     * <p>
     * ? extends A : 可以存放A及其子类
     * ? supper A :可以存放A及其父类
     */
    @Test
    public void commonExtendsTest() {
        List<? extends Number> list = null;
        List<Integer> list1 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        list = list1;
        //list = list2;报错
        List<? super Number> listSuper = null;
        listSuper = list3;
    }

    /**
     * 通配符的使用
     */
    @Test
    public void commentUseTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("aa");
        stringList.add("bb");
        List<?> list = null;
        list = stringList;
        //可以声明读取通配符的集合类的对象
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //不允许向声明为通配符的集合类中写入对象,唯一例外的是可以存放null
//        list.add("cc");
//        list.add("dd");
        list.add(null);
    }

}
