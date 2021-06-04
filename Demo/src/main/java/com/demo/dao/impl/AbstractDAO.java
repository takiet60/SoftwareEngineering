package com.demo.dao.impl;

import com.demo.dao.IGenericDAO;
import com.demo.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements IGenericDAO<T> {
    ResourceBundle myBunble = ResourceBundle.getBundle("db");

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/new_java_servlet";
        String user = "root";
        String password = "12345";
//        Class.forName(myBunble.getString("driverName"));
//        String url = myBunble.getString("url");
//        String user = myBunble.getString("user");
//        String password = myBunble.getString("password");
        return DriverManager.getConnection(url, user, password);
    }


    @Override
    public List<T> query(String sql, RowMapper rowMapper, Object... parameters) {
        List<T> result = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add((T) rowMapper.mapRow(resultSet));
            }
            return result;
        }catch (SQLException | ClassNotFoundException e){
            return null;
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void setParameter(PreparedStatement statement, Object... parameters){
        try {
            for(int i = 0; i < parameters.length; i++) {
                Object param = parameters[i];
                int index = i + 1;
                if (param instanceof Long) {
                    statement.setLong(index, (Long) param);
                }else if(param instanceof String){
                    statement.setString(index, (String) param);
                }else if(param instanceof Integer){
                    statement.setInt(index, (Integer)param);
                }else if(param instanceof Timestamp){
                    statement.setTimestamp(index, (Timestamp) param);
                }else if(param instanceof Double){
                    statement.setDouble(index, (Double) param);
                }
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            Long id = null;
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                id  = resultSet.getLong(1);
            }
            connection.commit();
        } catch (SQLException throwables) {
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        List<T> result = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            int count = 0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt(1);
            }
            return count;
        }catch (SQLException | ClassNotFoundException e){
            return 0;
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
