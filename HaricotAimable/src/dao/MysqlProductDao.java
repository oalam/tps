/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adminl
 */
public class MysqlProductDao implements ProductDao {

    @Override
    public void create(Product p) {
        Connection conn = MysqlUtilities.openConnection();
        Savepoint sp = null;
        try {

            // begin transaction
            conn.setAutoCommit(false);
            sp = conn.setSavepoint();

            String insertProduct = "INSERT INTO haricot.product "
                    + "(category_id, `name`, price, stock_quantity, "
                    + "description, photo_url) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(insertProduct,
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, p.getCategory().getId());
            stmt.setString(2, p.getName());
            stmt.setDouble(3, p.getPrice());
            stmt.setInt(4, p.getStockQuantity());
            stmt.setString(5, p.getDescription());
            stmt.setString(6, p.getPhotoUrl());
            /* Date d = new java.util.Date();
             stmt.setTimestamp(1, new Timestamp(d.getTime()));
             */
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                long id = rs.getLong(1);
                p.setId(id);
                System.out.println("inserted product with id = " + id);
            }

            // end transaction and commit data
            conn.commit();

        } catch (SQLException ex) {
            try {
                // end transaction and rollback to save point
                conn.rollback(sp);
                MysqlUtilities.printSQLException(ex);
                Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                MysqlUtilities.closeConnection(conn);
            }
        }
    }

    @Override
    public Product read(Long id) {
        Product p = new Product();
        try {
            Connection conn = MysqlUtilities.openConnection();

            String selectProduct = "SELECT * FROM haricot.product "
                    + "WHERE id=" + p.getId();



            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();



            ResultSet rs = stmt.executeQuery(selectProduct);

            while (rs.next()) {

                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setPhotoUrl(rs.getString("photo_url"));
                p.setDescription(rs.getString("description"));

                long categoryId = rs.getLong("category_id");

                String selectCategory = "SELECT * FROM haricot.category "
                        + "WHERE id=" + categoryId;

                ResultSet rs2 = stmt2.executeQuery(selectCategory);
                Category c = new Category();
                while (rs2.next()) {
                    c.setId(rs2.getInt("id"));
                    c.setName(rs2.getString("name"));
                }

                p.setCategory(c);
                c.getProducts().add(p);

                System.out.println("read product " + p.toString());
            }
            System.out.println("read product with id = " + p.getId());

            MysqlUtilities.closeConnection(conn);
        } catch (SQLException ex) {
            MysqlUtilities.printSQLException(ex);
            Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void update(Product p) {
        try {
            Connection conn = MysqlUtilities.openConnection();

            String sqlUpdate = "UPDATE haricot.product "
                    + "SET `name` = ?, `price` = ?, `stock_quantity` = ?, "
                    + "`description` = ?, `photo_url` = ?, category_id = ?"
                    + " WHERE id = ?;";

            PreparedStatement stmt = conn.prepareStatement(sqlUpdate,
                    Statement.RETURN_GENERATED_KEYS);


            stmt.setString(1, p.getName());
            stmt.setDouble(2, p.getPrice());
            stmt.setInt(3, p.getStockQuantity());
            stmt.setString(4, p.getDescription());
            stmt.setString(5, p.getPhotoUrl());
            stmt.setLong(6, p.getCategory().getId());
            stmt.setLong(7, p.getId());
            /* Date d = new java.util.Date();
             stmt.setTimestamp(1, new Timestamp(d.getTime()));
             */
            stmt.executeUpdate();


            MysqlUtilities.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Product p) {
        try {
            Connection conn = MysqlUtilities.openConnection();

            String deleteProduct = "DELETE FROM haricot.product "
                    + "WHERE id=" + p.getId();

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(deleteProduct);
            System.out.println("deleted product with id = " + p.getId());

            MysqlUtilities.closeConnection(conn);
        } catch (SQLException ex) {
            MysqlUtilities.printSQLException(ex);
            Logger.getLogger(MysqlProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // public List<Product> find

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductById(int productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
