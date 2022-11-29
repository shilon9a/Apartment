package util;

import entity.Apartment;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

public class TableContext {
    public static Object[][] getContext(List<Apartment> apartments) throws IllegalAccessException {
        Object[][] context=new Object[apartments.size()][6];
        for(int i=0;i< apartments.size();i++){
            Field[] fields=apartments.get(i).getClass().getDeclaredFields();
            for(int j=0;j<6;j++){
                fields[j].setAccessible(true);
                context[i][j]=fields[j].get(apartments.get(i));
            }
        }
        return context;
    }
}
