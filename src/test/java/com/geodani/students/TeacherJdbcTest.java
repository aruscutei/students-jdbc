package com.geodani.students;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class TeacherJdbcTest {
    @Test
    public void testFindAll() throws SQLException {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        //try -catch with resources =Java7
        //try (Connection,Statement,ResultSet){}
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
            st = conn.createStatement();
            String sqlQuery = "SELECT * FROM teacher";
            rs = st.executeQuery(sqlQuery);

            while(rs.next()){
                System.out.println("id ==" +rs.getInt(1)+
                                    "  firstname == "+ rs.getString("first_name")+
                                     "  lastname == "+ rs.getString("last_name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Eliberez resursele
            if (null != conn) {
                conn.close();
            }

            if (null != st) {
                st.close();

            }
            if (null != rs) {
                rs.close();
            }
        }
    }

    @Test

    public void testUpdateTeacher() throws SQLException
    {Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        //try -catch with resources =Java7
        //try (Connection,Statement,ResultSet){}
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
            conn.setAutoCommit (false);
            st = conn.createStatement();
            String sqlQuery = "UPDATE teacher SET first_name ='Alexandru'  WHERE ID=1";
            int noRowsUpdated = st.executeUpdate(sqlQuery);

            conn.commit();

            Assert.assertEquals(1,noRowsUpdated);

        } catch (SQLException e) {
            if(conn != null){
                conn.rollback();
            }
            e.printStackTrace();
        } finally {
            //Eliberez resursele
            if (null != conn) {
                conn.close();
            }

            if (null != st) {
                st.close();

            }
            if (null != rs) {
                rs.close();
            }
        }

    }@Test

    public void testPrepareStatement() throws SQLException
    {Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        //try -catch with resources =Java7
        //try (Connection,Statement,ResultSet){}
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);

            String sqlQuery = "SELECT * FROM teacher WHERE first_name = ? ";
            st = conn.prepareStatement(sqlQuery);
            st.setString(1, "Alexandru");
            rs= st.executeQuery();

          while(rs.next()){
              System.out.println("FirstName ==" +rs.getString("first_name"));
          }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Eliberez resursele
            if (null != conn) {
                conn.close();
            }

            if (null != st) {
                st.close();

            }
            if (null != rs) {
                rs.close();
            }
        }

    }


}