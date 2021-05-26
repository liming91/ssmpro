package com.annotations;

@MyAnnotation(value = "this class annotation user")
public class Person {

    @MyAnnotation(value = "this method annotation user")
    public void sing(){
        System.out.println("唱歌");
    }

}
