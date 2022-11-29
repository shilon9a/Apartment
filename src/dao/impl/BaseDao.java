package dao.impl;


import entity.Apartment;
import util.JDBCUtil;
import util.ORM;
import util.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.AbstractPreferences;

public abstract class BaseDao<T>{
    private Statement statement;
    public BaseDao(){
        //获取statement
        try{
            Connection connection = JDBCUtil.getConnection();
            statement=connection.createStatement();
        }catch (SQLException e) {
            System.out.println("BaseDao连接出现异常");
        }
    }

    /**
     * 查询单个数据
     * @param clazz
     * @return
     */
    public T queryOne(T clazz) {
        T t=null;
        try{
            String sql= SQL.QuerySQL(clazz);
            ResultSet query=statement.executeQuery(sql);
            if(query.next()) {
                t=ORM.get(clazz,query);
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 保存数据
     * @param clazz
     * @return
     */
    public boolean save(T clazz){
        try{
            String sql=SQL.SaveSQL(clazz);
            int i = statement.executeUpdate(sql);
            if(i>0){
                return true;
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * 根据id删除数据
     * @param clazz
     * @param id
     * @return
     */
    public boolean removeById(T clazz,Integer id){
        try{
            String sql=SQL.DeleteSQL(clazz,id);
            int i=statement.executeUpdate(sql);
            if(i>0){
                return true;
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 更新数据
     * @param clazz
     * @return
     */
    public boolean update(T clazz){
        try{
            String updateSQL=SQL.UpdateSQL(clazz);
            int i=statement.executeUpdate(updateSQL);
            if(i>0){
                return true;
            }
        }catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * 查询多条数据
     * @param clazz
     * @return
     */
    public List<T> queryList(T clazz){
        List<T> list=new ArrayList<>();

        try{
            String querySQL=SQL.QuerySQL(clazz);
            ResultSet resultSet=statement.executeQuery(querySQL);
            while(resultSet.next()) {
                list.add(ORM.get(clazz, resultSet));
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * 查询所有的数据
     * @return
     */
    public List<T> queryAll(T clazz){
        List<T> list=new ArrayList<>();
        try{
            String querySQL=SQL.QuerySQL(clazz);
            ResultSet resultSet=statement.executeQuery(querySQL);
            while(resultSet.next()){
                list.add(ORM.get(clazz,resultSet));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<T> queryLike(T clazz){
        List<T> list=new ArrayList<>();

        try {
            String sql=SQL.LikeSQL(clazz);
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(ORM.get(clazz,resultSet));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<T> Max(T clazz,Double max){
        List<T> list=new ArrayList<>();
        String sql="select * from Apartment where avgPrice <= "+max+";";
        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(ORM.get(clazz,resultSet));
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<T> Min(T clazz,Double min){
        List<T> list=new ArrayList<>();
        String sql="select * from Apartment where avgPrice >= "+min+";";
        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(ORM.get(clazz,resultSet));
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<T> Between(T clazz,Double min,Double max){
        List<T> list=new ArrayList<>();
        String sql="select * from Apartment where avgPrice between "+min+" and "+max;
        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(ORM.get(clazz,resultSet));
            }
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
