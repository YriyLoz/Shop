package dao;


import models.Product;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDao implements Dao<Product> {
    private static final String SELECT_ALL_PRODUCTS;
    private static final String INSERT_PRODUCT;
    private static final String SELECT_PRODUCT_BY_ID;
    private static final String DELETE_PRODUCT_BY_ID;
    private static final String UPDATE_PRODUCT;


    static {
        SELECT_ALL_PRODUCTS = "select * from product";
        INSERT_PRODUCT = "insert into product (name,type,calibre,color,price,producer) VALUES (?, ?, ?, ?, ?, ?);";
        SELECT_PRODUCT_BY_ID = "select id,name,type,calibre,color,price,producer from product where id =?";
        DELETE_PRODUCT_BY_ID = "delete from product where id = ?;";
        UPDATE_PRODUCT = "update product set name = ?, type= ?,calibre =?,color =?,price = ?,producer=?";

    }

    @Override
    public void insert(Product object) {
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            addProduct(preparedStatement, object);
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public Product selectById(int objectId) {
        Product product = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, objectId);
            product = getProduct(preparedStatement);
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> list = null;
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            list = getListProduct(preparedStatement);
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return list;
    }


    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement preparedStatement = JDBCUtils.getConnection().prepareStatement(DELETE_PRODUCT_BY_ID);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Product object) throws SQLException {
        PreparedStatement preparedStatement = JDBCUtils.getConnection().prepareStatement(UPDATE_PRODUCT);
        return addProduct(preparedStatement, object);
    }

    //---------------------------------------------------------------------------------------------
    private boolean addProduct(PreparedStatement preparedStatement, Product object) throws SQLException {
        preparedStatement.setString(1, object.getName());
        preparedStatement.setString(2, object.getType());
        preparedStatement.setInt(3, object.getCaliber());
        preparedStatement.setString(4, object.getColor());
        preparedStatement.setInt(5, object.getPrice());
        preparedStatement.setString(6, object.getProducer());
        return preparedStatement.executeUpdate() > 0;
    }

    private Product getProduct(PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = preparedStatement.executeQuery();
        Product product = new Product();
        while (rs.next()) {
            makeProduct(rs, product);
        }
        return product;
    }

    private List<Product> getListProduct(PreparedStatement preparedStatement) throws SQLException {
        List<Product> list = new LinkedList<>();
        Product product;
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            product = new Product();
            makeProduct(rs, product);
            list.add(product);
        }
        return list;
    }

    private void makeProduct(ResultSet rs, Product product) throws SQLException {
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setType(rs.getString("type"));
        product.setCaliber(rs.getInt("calibre"));
        product.setColor(rs.getString("color"));
        product.setPrice(rs.getInt("price"));
        product.setProducer(rs.getString("producer"));
    }

}
