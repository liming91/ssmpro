package com.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试注解的表
 */
public class TableAnnotationTest {
    public static void main(String[] args) {

        Filter f1 = new Filter();
        f1.setId("10");//查询id为10的用户

        Filter f2 = new Filter();
        f2.setJobName("lucy");//查询名为lucy用户
        f2.setAddress("陆家嘴");
        Filter f3 = new Filter();
        f3.setEmail("li@qq.com,ming@163.com,yuan@sina.com");

        String sql1 = query(f1);

        String sql2 = query(f2);

        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }

    /**
     * 查询sql
     *
     * @param f
     * @return
     */
    private static String query(Object f) {
        //1.获取加载的类
        Class c = f.getClass();
        //2.获取表名，并判断是否存在
        boolean tableExist = c.isAnnotationPresent(Table.class);
        if (!tableExist) {
            return null;
        }
        //3.获取表名注解的实例对象
        Table table = (Table) c.getAnnotation(Table.class);
        //4.获取表名
        String tableName = table.value();
        //5.存放拼装sql
        StringBuffer sb = new StringBuffer();
        sb.append("select * from ").append(tableName).append(" where 1 = 1 ");
        //6.利用反射获取所有的字段
        Field[] files = c.getDeclaredFields();
        for (Field field : files) {
            //7.获取注解的字段实例，并判断是否存在
            boolean columnExist = field.isAnnotationPresent(Column.class);
            if (!columnExist) {
                continue;
            }
            Column column = (Column) field.getAnnotation(Column.class);
            //8.获取所有注解上的字段值
            String columnValue = column.value();
            //9.利用反射获取所有字段名称
            String fieldName = field.getName();
            //10.获取方法名..利用getName
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                //11.获取所有的方法
                Method methods = c.getMethod(getMethodName);
                //12.通过反射调用，传入对象和参数
                fieldValue = methods.invoke(f);
                //拼装sql
                if (fieldValue == null ||
                        (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                    continue;
                }
                sb.append(" and ").append(columnValue);
                //如果拼接的sql的字段的是模糊查询加%
                if (fieldValue instanceof String) {
                    if (((String) fieldValue).contains(",")) {
                        String[] array = ((String) fieldValue).split(",");
                        sb.append(" in(");
                        for (String em : array) {
                            sb.append("'").append(em).append("'").append(",");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(")");
                    } else {
                        sb.append(" = ").append("'" + fieldValue + "'");
                    }
                } else if (fieldValue instanceof Integer) {
                    sb.append(" = ").append(fieldValue);
                } else {
                    sb.append(" = ").append(fieldValue);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
