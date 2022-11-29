package util;

import entity.Apartment;

import java.lang.reflect.Field;
import java.util.List;

public class SQL {
    private static StringBuffer stringBuffer;

    public static <T> String QuerySQL(T clazz) throws IllegalAccessException {
        stringBuffer=new StringBuffer();
        String tableName=clazz.getClass().getName();
        String[] temp=tableName.split("\\.");
        tableName=temp[temp.length-1];
        stringBuffer.append("select * from "+tableName+"\t");
        Field[] fields=clazz.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            fields[i].setAccessible(true);
            if(fields[i].get(clazz)!=null && fields[i].getType().getName().equals("java.lang.String")){
                stringBuffer.append("where "+fields[i].getName()+"="+"\'"+fields[i].get(clazz)+"\'"+"\t");
            } else if (fields[i].get(clazz)!=null) {
                stringBuffer.append("where "+fields[i].getName()+"="+fields[i].get(clazz)+"\t");
            }
        }
        stringBuffer.append(";");
        return stringBuffer.toString();
    }

    public static <T> String UpdateSQL(T clazz) throws IllegalAccessException {
        stringBuffer=new StringBuffer();
        String tableName=clazz.getClass().getName();
        String[] temp=tableName.split("\\.");
        tableName=temp[temp.length-1];

        Field[] fields=clazz.getClass().getDeclaredFields();
        stringBuffer.append("update "+tableName+" set ");
        for(int i=1;i<fields.length;i++){
            fields[i].setAccessible(true);
            if(fields[i].get(clazz)!=null && fields[i].getType().getName().equals("java.lang.String")){
                stringBuffer.append(fields[i].getName()+"='"+fields[i].get(clazz)+"\'\t");
                if(i!= fields.length-1){
                    stringBuffer.append(",");
                }
            }
            else if (fields[i].get(clazz)!=null) {
                stringBuffer.append(fields[i].getName()+"="+fields[i].get(clazz)+"\t");
                if(i!= fields.length-1){
                    stringBuffer.append(",");
                }
            }

        }

        fields[0].setAccessible(true);
        stringBuffer.append("where id="+fields[0].get(clazz));
        stringBuffer.append(";");

        return stringBuffer.toString();
    }

    public static <T> String SaveSQL(T clazz) throws IllegalAccessException {
        stringBuffer=new StringBuffer();
        String tableName=clazz.getClass().getName();
        String[] temp=tableName.split("\\.");
        tableName=temp[temp.length-1];

        Field[] fields=clazz.getClass().getDeclaredFields();
        stringBuffer.append("insert into "+tableName+" values(null,");
        for(int i=1;i<fields.length;i++){
            fields[i].setAccessible(true);
            if(fields[i].getType().getName().equals("java.lang.String")){
                stringBuffer.append("\'"+fields[i].get(clazz)+"\'");
                if(i!= fields.length-1){
                    stringBuffer.append(",");
                }
            }
            else {
                stringBuffer.append(fields[i].get(clazz));
                if(i!= fields.length-1){
                    stringBuffer.append(",");
                }
            }


        }
        stringBuffer.append(");");
        return stringBuffer.toString();
    }

    public static <T> String DeleteSQL(T clazz,Integer id) throws IllegalAccessException {
        stringBuffer=new StringBuffer();
        String tableName=clazz.getClass().getName();
        String[] temp=tableName.split("\\.");
        tableName=temp[temp.length-1];

        stringBuffer.append("delete from "+tableName+" where id="+id);
        stringBuffer.append(";");
        return stringBuffer.toString();
    }

    public static <T> String LikeSQL(T clazz) throws IllegalAccessException {
        stringBuffer=new StringBuffer();
        Field[] fields=clazz.getClass().getDeclaredFields();
        String tableName=clazz.getClass().getName();
        String[] temp=tableName.split("\\.");
        tableName=temp[temp.length-1];
        stringBuffer.append("select * from "+tableName+" where ");

        for(int i=0;i< fields.length;i++){
            fields[i].setAccessible(true);
            if(fields[i].get(clazz)!=null){
                stringBuffer.append(fields[i].getName()+" like '%"+fields[i].get(clazz)+"%'");
                break;
            }
        }

        stringBuffer.append(";");
        return stringBuffer.toString();
    }

}
