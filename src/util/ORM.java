package util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ORM {
    public static <T> T get(T tClass,ResultSet resultset) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //新建封装类及其实例
        Class clazz=tClass.getClass().getClassLoader().loadClass(tClass.getClass().getName());
        Object o=clazz.newInstance();
        //封装类中需要注入的字段
        Field[] fields=clazz.getDeclaredFields();

        //对字段进行自动注入
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            fields[i].set(o,resultset.getObject(fields[i].getName()));
        }
        return (T)o;
    }
}
