import java.sql.*;

public class CRUD{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int updateSuccess = 0;
    public void getEmployee(String url, String username, String password,int empId) throws SQLException {
        try {
            connection = DriverManager.getConnection(url,username,password);
            preparedStatement = connection.prepareStatement("SELECT * FROM employees " +
                    "WHERE id = ?");
            preparedStatement.setInt(1,empId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("name")+" "+
                        resultSet.getString("dept")+"  R"+resultSet.getDouble("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                connection.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
        }
    }
    public int insertEmployee(String url, String username, String password, int empId, String empName, String empDept, Double empSalary) throws SQLException {
        try {
            connection = DriverManager.getConnection(url,username, password);

            preparedStatement = connection.prepareStatement("INSERT INTO employees(id, name, dept, salary) " +
                    "VALUES(?,?,?,?)");

            preparedStatement.setInt(1,empId);
            preparedStatement.setString(2,empName);
            preparedStatement.setString(3,empDept);
            preparedStatement.setDouble(4,empSalary);

            updateSuccess = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                connection.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
        }
        return updateSuccess;
    }
    public int deleteEmployee(String url, String username, String password, int empId) throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement("DELETE FROM employees " +
                    "WHERE id = ?");
            preparedStatement.setInt(1,empId);
            updateSuccess = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(connection!=null){
                connection.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
        }

        return updateSuccess;
    }
    public int updateEmployee(String url, String username, String password, int empId, String empName, String empDept, Double empSalary){
        try {
            connection = DriverManager.getConnection(url,username,password);
            preparedStatement = connection.prepareStatement("UPDATE employees " +
                    "SET name=?, dept=?, salary=? " +
                    "WHERE id =?");
            preparedStatement.setString(1,empName);
            preparedStatement.setString(2,empDept);
            preparedStatement.setDouble(3,empSalary);
            preparedStatement.setInt(4,empId);

            updateSuccess = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateSuccess;
    }
}
