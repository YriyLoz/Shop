package dao;


import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    void insert(T object) throws SQLException;

    T selectById(int objectId) throws SQLException;

    List<T> selectAll() throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(T object) throws SQLException;

}
