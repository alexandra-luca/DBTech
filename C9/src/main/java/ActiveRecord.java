import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ActiveRecord {
    public boolean delete(int id) {
        return false;
    }

    public boolean insert() throws SQLException, IllegalAccessException, NoSuchFieldException {
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();
        ActiveRecordEntity arAnnotation = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        Field[] fields = c.getFields();
        String sqlQuery = "INSERT INTO " + arAnnotation.tableName() + " ( ";
        // avem primary key cu auto increment
        ArrayList<String> myFields = new ArrayList<>();

//        int fieldCount = 0;
        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(arAnnotation.keyColumnName()) && f.getType() == int.class) {
                continue;
            }
//            fieldCount ++;
//            sqlQuery += f.getName() + ", ";
            myFields.add(f.getName());
        }

        sqlQuery += myFields.toString().substring(1, myFields.toString().length() - 1) + ") values ( ";
        for (String s: myFields) {
            sqlQuery += "?, ";
        }

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
            count ++;
        }

        int insertCount = st.executeUpdate();


        System.out.println(this);

        Field primaryKey = c.getField(arAnnotation.keyColumnName());
        if (primaryKey.getType() == int.class) {
            ResultSet keys = st.getGeneratedKeys();
            keys.next();

            primaryKey.setInt(this, keys.getInt(1));

            System.out.println(this);
        }

        if (insertCount > 0) {
            return true;
        }

        return false;
    }

    public boolean update() {
        return false;
    }

    public T getById(int id) { // TODO return object
        return null;
    }

    public<T> List<T> getAll() throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<T> result = new ArrayList<>();

        // imi trebuie clasa Customer -> extends ActiveRecord
        Class<ActiveRecord> c = (Class<ActiveRecord>) this.getClass();

        // imi trebuie adnotarile de pe Customer (tabela, primary key name)
        ActiveRecordEntity arAnnotations = (ActiveRecordEntity) c.getAnnotation(ActiveRecordEntity.class);
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        Statement st = connection.createStatement();

        // rulam un select * from tabela din adnotare
        ResultSet resultSet = st.executeQuery("SELECT * FROM " + arAnnotations.tableName());

        // pt fiecare linie din ResultSet trebuie sa facem un Customer -> potrivim atributele din Customer cu coloanele din tabela
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            T myObj = (T)c.newInstance();
            // pentru fiecare coloana din resultSet trebuie sa gasesc atributul asociat in clasa generica
            for (int i = 1; i < columnCount + 1; i ++) {
                String myColumn = metaData.getColumnName(i);
                Field f = c.getField(myColumn);
                if (f.getType() == int.class) {
                    f.setInt(myObj, resultSet.getInt(i)); // myObj[f] = resultSet.getInt(i) -> myObj["id"], myObj["code"], myObj["first_name"]
                } else if (f.getType() == String.class) {
                    f.set(myObj, resultSet.getString(i));
                } else if (f.getType() == float.class) {
                    f.setFloat(myObj, resultSet.getFloat(i));
                }
                // TODO pentru alte tipuri de date
            }
            result.add(myObj);
        }

        return result;
    }
}
