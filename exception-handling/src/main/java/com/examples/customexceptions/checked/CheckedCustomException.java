package com.examples.customexceptions.checked;

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
public class CheckedCustomException {

    public static void main(String[] args) throws SQLCustomException, ClassNotFoundCustomException {
        /* IOException & FileNotFoundException */
        fileNotFoundAndIOException();

        /* SQLException */
        exceptionExample("org.postgresql.Driver", "jdbc:postgresql://localhost:5435/DemoApp",
                "postgres", "pgsql");

        /* ClassNotFoundException */
        exceptionExample("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/classroom",
               "root", "mysql");

    }

    /* IOException & FileNotFoundException */
    private static void fileNotFoundAndIOException() {
        FileInputStream fileInputStream = null;
        String filename = "file11.txt";

        try {
            fileInputStream = new FileInputStream("C://"+filename);
            System.out.println("File found successfully");

        } catch (IOException e) {
            try {
                throw new FileNotFoundCustomException("Incorrect filename : "+ filename);
            } catch (FileNotFoundCustomException ex) {
                throw new RuntimeException(ex);
            }
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


    /* SQLException or ClassNotFoundException*/
    private static void exceptionExample(String driver, String url, String username, String password) throws ClassNotFoundCustomException, SQLCustomException {
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
            throw new ClassNotFoundCustomException("JDBC driver not found.");
        } catch (SQLException e) {
            throw new SQLCustomException("An SQL exception occurred:");
        }
    }

}
