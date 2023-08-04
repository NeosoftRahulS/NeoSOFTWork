package com.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/*
   Checked Exception
   ------------------
   IOException
   FileNotFoundException
   SQLException
   ClassNotFoundException

*/
public class CheckedExceptions {

    public static void main(String[] args) {
        /* IOException & FileNotFoundException */
        fileNotFoundAndIOException();

        /* SQLexception */
        exceptionExample("org.postgresql.Driver", "jdbc:postgresql://localhost:5435/DemoApp",
                "postgres", "pgsql");

        /* ClassNotFoundException */
        exceptionExample("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/classroom",
                "root", "mysql");

    }

    /* IOException & FileNotFoundException */
    private static void fileNotFoundAndIOException() {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("C://file11.txt");
            System.out.println("File found successfully");

        } catch (IOException e) {
            System.err.println("File Not Found");
            e.printStackTrace();
        }

        finally {
            if(fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /* SQLexception or ClassNotFoundException*/
    private static void exceptionExample(String driver, String url, String username, String password) {
        try
        {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            String sqlQuery = "SELECT * FROM my_table";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = statement.executeQuery();

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("An SQL exception occurred:");
            e.printStackTrace();
        }
    }

}
