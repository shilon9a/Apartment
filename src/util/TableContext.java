package util;

import entity.Apartment;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

public class TableContext {
    public static Object[][] getContext(List<Apartment> apartments) throws IllegalAccessException {
        Object[][] context=new Object[apartments.size()][5];
        for(int i=0;i< apartments.size();i++){
            Field[] fields=apartments.get(i).getClass().getDeclaredFields();
            for(int j=0;j<5;j++){
                fields[j+1].setAccessible(true);
                context[i][j]=fields[j+1].get(apartments.get(i));
            }
        }
        return context;
    }
}
