import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ActiveRecord {

    public boolean delete(int id) throws SQLException {

        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        ActiveRecordEntity arAnnotation = c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = c.getFields();
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        String idForEveryTable = "id";
        if (this.getClass().getSimpleName().equals("Product")) {
            idForEveryTable = "code"; // Din cauza ca tabela ID nu exista in tabela product am schimbat clauza WHERE in loc de ID sa caute dupa Code
        }
        PreparedStatement preparedStatement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("DELETE FROM " + arAnnotation.tableName() + " WHERE " + idForEveryTable + "=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
        preparedStatement.executeUpdate();


        return true;
    }

    public boolean insert() throws SQLException, IllegalAccessException, NoSuchFieldException {
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        ActiveRecordEntity arAnnotation = c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = c.getFields();

        String sqlQuery = "INSERT INTO " + arAnnotation.tableName() + " ( ";
        ArrayList<String> myFields = new ArrayList<>();

        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(arAnnotation.keyColumnName()) && f.getType() == int.class) {
                continue;
            }
            myFields.add(f.getName());
        }
        sqlQuery += myFields.toString().substring(1, myFields.toString().length() - 1) + ") values ( ";
        for (String s : myFields) {
            sqlQuery += "?, ";
        }
        System.out.println(sqlQuery);

        sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2) + ");";
        System.out.println(sqlQuery);
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        PreparedStatement st = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

        int count = 1;

        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(arAnnotation.keyColumnName()) && f.getType() == int.class) {
                continue;
            }
            if (f.getType() == int.class) {
                st.setInt(count, f.getInt(this));
            } else if (f.getType() == String.class) {
                st.setString(count, (String) f.get(this));
            } else if (f.getType() == float.class) {
                st.setFloat(count, f.getFloat(this));
            }
            count++;
        }
        System.out.println(sqlQuery);

        int insertCount = st.executeUpdate();

        Field primaryKey = c.getField(arAnnotation.keyColumnName());
        if (primaryKey.getType() == int.class) {
            ResultSet key = st.getGeneratedKeys();
            key.next();

            primaryKey.setInt(this, key.getInt(1));
        }

        if (insertCount > 0) {
            return true;
        }


        return false;
    }

    public boolean update() throws SQLException, IllegalAccessException, NoSuchFieldException {

        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        ActiveRecordEntity arAnnotation = c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = c.getFields();
        String sqlQuery = "UPDATE " + arAnnotation.tableName() + " SET ";
        ArrayList<String> myFields = new ArrayList<>();
        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(arAnnotation.keyColumnName()) && f.getType() == int.class) {
                continue;
            }

            myFields.add(f.getName());

        }
        for (String s : myFields) {
            if (s.equals("code") || s.equals("id")) {
                continue;
            }
            sqlQuery += s;
            sqlQuery += "=?, ";
        }
        sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
        sqlQuery+=" ";
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();


        String idForEveryTable = "id";
        if (this.getClass().getSimpleName().equals("Product")) {
            idForEveryTable = "code";
        }
        sqlQuery += "WHERE " + idForEveryTable + "=?;";

      //  System.out.println(sqlQuery);

        PreparedStatement st = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

        int count = 1;

        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(arAnnotation.keyColumnName()) && f.getType() == int.class) {
                st.setInt(fields.length,f.getInt(this));
                continue;
            }
            if (f.getType() == int.class) {
                st.setInt(count, f.getInt(this));
            } else if (f.getType() == String.class) {
                st.setString(count, (String) f.get(this));
            } else if (f.getType() == float.class) {
                st.setFloat(count, f.getFloat(this));
            }
            count++;

        }


        int insertCount = st.executeUpdate();


        return true;
    }

    public <T> T getById(int id) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        T myObj = null;

        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        String idForEveryTable = "id";
        if (this.getClass().getSimpleName().equals("Product")) {
            idForEveryTable = "code"; // Din cauza ca tabela ID nu exista in tabela product am schimbat clauza WHERE in loc de ID sa caute dupa Code
        }

        ActiveRecordEntity arAnnotation = c.getAnnotation(ActiveRecordEntity.class);
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + arAnnotation.tableName() + " WHERE " + idForEveryTable + "=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            myObj = (T) c.newInstance();

            for (int i = 1; i < columnCount + 1; i++) {
                String myColumn = metaData.getColumnName(i);
                Field f = c.getField(myColumn);

                if (f.getType() == int.class) {
                    f.setInt(myObj, resultSet.getInt(i));
                } else if (f.getType() == String.class) {
                    f.set(myObj, resultSet.getString(i));
                } else if (f.getType() == float.class) {
                    f.setFloat(myObj, resultSet.getFloat(i));
                }

            }

        }


        return myObj;
    }

    public <T> List<T> getAll() throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<T> result = new ArrayList<>();

        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        ActiveRecordEntity arAnnotation = c.getAnnotation(ActiveRecordEntity.class);
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM " + arAnnotation.tableName());
        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            T myObj = (T) c.newInstance();

            for (int i = 1; i < columnCount + 1; i++) {
                String myColumn = metaData.getColumnName(i);
                Field f = c.getField(myColumn);

                if (f.getType() == int.class) {
                    f.setInt(myObj, resultSet.getInt(i));
                } else if (f.getType() == String.class) {
                    f.set(myObj, resultSet.getString(i));
                } else if (f.getType() == float.class) {
                    f.setFloat(myObj, resultSet.getFloat(i));
                }

            }
            result.add(myObj);

        }
        return result;

    }

}
