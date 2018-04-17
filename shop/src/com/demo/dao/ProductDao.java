package com.demo.dao;

import com.demo.domain.Category;
import com.demo.domain.Product;
import com.demo.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * dao
 */
public class ProductDao {
    /**
     * 获取热门商品
     * @return 热门商品
     */
    public List<Product> findHotProductList() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot=? limit ?,?";
        return qr.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
    }

    /**
     * 获取最新商品
     * @return 最新商品
     */
    public List<Product> findNewProductList() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product order by pdate desc limit ?,?";
        return qr.query(sql,new BeanListHandler<Product>(Product.class),0,9);
    }

    /**
     * 获取分类数据
     * @return 分类数据
     */
    public List<Category> findAllCategory() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category";
        return qr.query(sql,new BeanListHandler<Category>(Category.class));
    }

    /**
     * 获取商品总条数
     * @return 总条数
     */
    public int getCount(String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT COUNT(*) FROM product WHERE cid=? AND pflag=0";
        Long query = (Long)qr.query(sql,new ScalarHandler(),cid);
        return query.intValue();
    }

    /**
     * 返回当前页面的商品
     * @param cid
     * @param index
     * @param currentCount
     * @return
     */
    public List<Product> findProductBtPage(String cid, int index, int currentCount) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid=? limit ?,?";
        return qr.query(sql, new BeanListHandler<Product>(Product.class), cid, index, currentCount);
    }

    /**
     * 通过pid获取商品信息
     * @param pid 商品id
     * @return 商品信息
     */
    public Product findProductByPid(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid=? limit 0,1";
        return qr.query(sql, new BeanHandler<>(Product.class), pid);
    }
}
