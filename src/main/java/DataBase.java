import java.sql.*;

public class DataBase {
    private String url="jdbc:postgresql://localhost:5432/computer_db";
    private String dbUser = "db_user";
    private String dbPassword = "db_password";

    public void getProduts(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);

            Statement statement = connection.createStatement();
            String sql = "select * from product";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String maker= resultSet.getString("model");
                String model= resultSet.getString("maker");
                String type= resultSet.getString("type");

               Product product = new Product(maker, model, type);

                System.out.println(product);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
