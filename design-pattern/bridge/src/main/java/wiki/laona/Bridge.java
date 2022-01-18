package wiki.laona;

import java.sql.*;

/**
 * @author laona
 * @description 桥接模式
 * @date 2022-01-18 09:26
 **/
public class Bridge {

    /**
     * 数据库连接
     *
     * @throws ClassNotFoundException 找不到类异常
     * @throws SQLException           sql 异常
     */
    private void jdbcConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.Driver");
        String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=123";
        Connection connection = DriverManager.getConnection(url);
        Statement stmt = connection.createStatement();
        @SuppressWarnings("all")
        String querySql = "select * from test";
        ResultSet resultSet = stmt.executeQuery(querySql);
        while (resultSet.next()) {
            String str = resultSet.getString(1);
            int num = resultSet.getInt(2);
            System.out.println("str = " + num);
        }
    }
}
