package sdccd.edu.cisc191;

import java.sql.*;

    // /usr/local/mysql-8.0.31-macos12-x86_64/bin/mysql -uuser -puser
    // show tables;
    // select * from (course);
    // cd downloads (put .java in downloads folder)
    // java -cp mysql-connector-j-8.0.31.jar Jdbc.java

public class Jdbc {
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException {
            // load jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // connect to database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "user", "user");
        System.out.println("Database connected");

        // create a statement
        Statement statement = connection.createStatement();

        // execute statement
        ResultSet resultSet1 = statement.executeQuery
                ("insert into course (level of fun)" +
                        "values (very!(:);");
        ResultSet resultSet = statement.executeQuery
                ("Select * from course;");


        // iterate through the results and print the course info
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3) +
                    "\t" + resultSet.getString(4) + "\t" +
                    resultSet.getString(5) + "\t" + resultSet.getString(6));
        }
        // close connection
        connection.close();
    }
}