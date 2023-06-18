package eu.epfc.j6077.contactapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiaryDao implements IDiaryDao {
    private final String connectionString;

    public DiaryDao(String connectionString) {
        this.connectionString = connectionString;
        initialize();
    }

    public void add(Diary diary) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "insert into CONTACT (FIRSTNAME, LASTNAME, EMAIL, PHONE) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getFirstName());
            preparedStatement.setString(2, diary.getLastName());
            preparedStatement.setString(3, diary.getEmail());
            preparedStatement.setString(4, diary.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Diary diary) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "update CONTACT set FIRSTNAME=?, LASTNAME=?, EMAIL=?, PHONE=? where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, diary.getFirstName());
            preparedStatement.setString(2, diary.getLastName());
            preparedStatement.setString(3, diary.getEmail());
            preparedStatement.setString(4, diary.getPhone());
            preparedStatement.setInt(5, diary.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sql = "delete CONTACT where ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Diary> fetch() {
        List<Diary> diarys = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionString)){
            String sql = "select ID, FIRSTNAME, LASTNAME, EMAIL, PHONE from CONTACT";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                String email = resultSet.getString("EMAIL");
                String phone = resultSet.getString("PHONE");
                Diary diary = new Diary(id, firstName, lastName, email, phone);
                diarys.add(diary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return diarys;
    }

    private void initialize() {
        String sql = "create table if not exists CONTACT (" +
                "  ID integer primary key auto_increment," +
                "  FIRSTNAME varchar(32) not null," +
                "  LASTNAME varchar(32) not null," +
                "  EMAIL varchar(128)," +
                "  PHONE varchar(20)" +
                ")";
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}