package dao;

import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FilterDao {
    private static final String GET_ALL_PRODUCTS;
    private static final String GET_ALL_COLORS;
    private static final String GET_ALL_CALIBRES;
    private static final String GET_ALL_TYPE;


    static {
        GET_ALL_PRODUCTS = "select producer from product";
        GET_ALL_COLORS = "select color from product";
        GET_ALL_CALIBRES = "select calibre from product";
        GET_ALL_TYPE = "select type from product";
    }

    public static List<Integer> getAllCalibres() throws SQLException {
        ResultSet resultSet = JDBCUtils.getConnection().prepareStatement(GET_ALL_CALIBRES).executeQuery();
        List<Integer> integerList = new LinkedList<>();
        while (resultSet.next()) {
            if (!integerList.contains(resultSet.getInt("calibre"))) {
                integerList.add(resultSet.getInt("calibre"));
            }
        }
        return integerList;
    }

    public static List<String> getAllColors() throws SQLException {
        ResultSet resultSet = JDBCUtils.getConnection().prepareStatement(GET_ALL_COLORS).executeQuery();
        List<String> integerList = new LinkedList<>();
        while (resultSet.next()) {
            if (!integerList.contains(resultSet.getString("color"))) {
                integerList.add(resultSet.getString("color"));
            }
        }
        return integerList;
    }

    public static List<String> getAllType() throws SQLException {
        ResultSet resultSet = JDBCUtils.getConnection().prepareStatement(GET_ALL_TYPE).executeQuery();
        List<String> integerList = new LinkedList<>();
        while (resultSet.next()) {
            if (!integerList.contains(resultSet.getString("type"))) {
                integerList.add(resultSet.getString("type"));
            }
        }
        return integerList;
    }

    public static List<String> getAllProducers() throws SQLException {
        ResultSet resultSet = JDBCUtils.getConnection().prepareStatement(GET_ALL_PRODUCTS).executeQuery();
        List<String> integerList = new LinkedList<>();
        while (resultSet.next()) {
            if (!integerList.contains(resultSet.getString("producer"))) {
                integerList.add(resultSet.getString("producer"));
            }
        }
        return integerList;
    }

}
