package lesson_2;

import java.sql.*;

public class Main {
//    В чем разница между SQL и MySQL/PostgreSQL/OracleQL

//    Команды DML и DDL

//    CRUD-операции

//    соединения (Join)

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        try {
//            statement.execute("INSERT INTO students (id, name, score) VALUES (4, 'ALEX1', 3)");

//            statement.execute("UPDATE students SET score = 100");

//            statement.execute("DELETE from students");

//            statement.execute("drop table if exists students");

            /*statement.execute("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT, " +
                    "score INTEGER)");*/

            long time = System.currentTimeMillis();
            connection.setAutoCommit(false);

           /* for (int i = 0; i < 1000; i++) {
                String name = String.format("Alex%d", i);
                statement.execute(String.format("INSERT INTO students (name, score) VALUES ('%s', 3)", name));
            }*/

            /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
            preparedStatement.setString(1, "Bob");
            preparedStatement.setInt(2, 200);*/

//            preparedStatement.execute();

            /*ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("name") + " " + resultSet.getInt(3));
            }*/

            for (int i = 0; i < 1000; i++) {
                String name = String.format("Alex%d", i);
                String sql = String.format("INSERT INTO students (name, score) VALUES ('%s', 3)", name);
                statement.addBatch(sql);
            }
            statement.executeBatch();

            connection.setAutoCommit(true);
            System.out.println(System.currentTimeMillis() - time);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void connect() throws ClassNotFoundException, SQLException {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:students.db");
            statement = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

}
