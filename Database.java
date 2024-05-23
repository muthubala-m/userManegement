import java.sql.*;

public class Database {

    private final String url = "jdbc:mysql://localhost:3306/bala";
    private final String userName = "root";
    private final String passWord = "2004";
    private Connection connection = null ;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private String query = null;
    private ResultSet resultSet = null;

    public Database(){
        try{
            this.connection = DriverManager.getConnection(url, userName, passWord);
            this.statement = connection.createStatement();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // insert a single user from database

    public void insertUser(int userId,String userName,String email,String passWord){
        this.query = "insert into users values (?,?,?,?);";
        try{
            this.preparedStatement = this.connection.prepareStatement(this.query);
            this.preparedStatement.setInt(1, userId);
            this.preparedStatement.setString(2, userName);
            this.preparedStatement.setString(3, email);
            this.preparedStatement.setString(4, passWord);
            this.preparedStatement.executeUpdate();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // update a user from database

    public void updateUser(int id,String userName,String email,String passWord){
        this.query = "update users set userName=?,email=?,password=? where userId=?";
        try{
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setString(1, userName);
            this.preparedStatement.setString(2, email);
            this.preparedStatement.setString(3, passWord);
            this.preparedStatement.setInt(4, id);
            this.preparedStatement.executeUpdate();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    // show a single user

    public ResultSet getSingleUser(int id){
        this.query = "select * from users where userId = "+id+"";
        try{
            resultSet = this.statement.executeQuery(this.query);
            resultSet.next();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    // show all users 

    public ResultSet getAllUsers(){
        this.query = "select * from users";
        try{
            resultSet = this.statement.executeQuery(this.query);
            resultSet.next();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    // delete user from database

    public void deleteUser(int id){
        this.query = "delete from users where userId="+id+"";
        try{
            this.statement.executeUpdate(query);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
