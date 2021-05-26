package com.annotations;



import com.sun.org.glassfish.gmbal.Description;

import javax.management.Descriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 解析注解
 */
public class ParseAnnotation {

    public static void main(String[] args) {
        try {
            //1.使用类加载器加载类
            Class c = Class.forName("com.annotations.Person");
            //2.找到类上面的注解,判断这个注解是否存在
            boolean isExist = c.isAnnotationPresent(MyAnnotation.class);
            if (isExist) {
                //3.拿到注解的实例
                MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
                System.out.println("获取类上面的注解："+myAnnotation.value());
            }
            //4.找到方法上的注解
            Method[] methods = c.getMethods();
            for (Method m :methods){
                boolean isMExist = m.isAnnotationPresent(MyAnnotation.class);
                if(isMExist){
                    MyAnnotation myMethod =  m.getAnnotation(MyAnnotation.class);
                    System.out.println("获取方法上面的注解："+myMethod.value());
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
//            //1.使用类加载器加载类
//            Class c = Class.forName("com.annotations.Person");
//            //2.找到类上面的注解，判断注解是否存在
//            boolean exist = c.isAnnotationPresent(MyAnnotation.class);
//            if (exist) {
//                //3.获取注解的实例
//                MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
//                System.out.println("获取类上面的注解：" + myAnnotation.value());
//                //4.找到方法上面的注解
//                Method[] methods = c.getMethods();
//                for (Method m : methods) {
//                    //5.获取所有的注解
//                    Annotation[] myAnnotation1 = m.getAnnotations();
//                    for (Annotation my : myAnnotation1){
//                        if(my instanceof MyAnnotation){
//                            MyAnnotation mn = (MyAnnotation) my;
//                            System.out.println("获取方法上面的注解："+mn.value());
//                        }
//                    }
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
