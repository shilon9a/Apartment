import dao.impl.BaseDao;
import entity.Apartment;
import util.JDBCUtil;
import util.SQL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mytest {
    private static Statement statement;

    static {
        try {
            Connection connection= JDBCUtil.getConnection();
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*testQuery();*/ //ok
        /*testSave();*/ //ok
        /*testDel();*/ //ok
        /*testUpdate();*/ //ok
    }

    public static void testQuery() throws SQLException {
        Connection connection=JDBCUtil.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from t";
        ResultSet query = statement.executeQuery(sql);
        while(query.next()){
            Integer ans=query.getInt("id");
            System.out.println(ans);
        }
    }
    public static void testQueryOne() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Connection connection=JDBCUtil.getConnection();
        String sql=SQL.QuerySQL(new Apartment(2,null,null,null,null,null));
        statement.executeQuery(sql);
    }
    public static void testSave() throws IllegalAccessException, SQLException {
        String save=SQL.SaveSQL(new Apartment(null,"13公寓","陕西科技大学",100,0,new BigDecimal(1500)));
        Connection conn=JDBCUtil.getConnection();
        Statement statement =conn.createStatement();
        statement.executeUpdate(save);

    }
    public static void testDel() throws IllegalAccessException, SQLException {
        String deleteSQL=SQL.DeleteSQL(new Apartment(1,null,null,null,null,null),1);
        statement.executeUpdate(deleteSQL);
    }
    public static void testUpdate() throws IllegalAccessException, SQLException {
        String updateSQL=SQL.UpdateSQL(new Apartment(2,"2公寓更新版","陕西科技大学",200,0,new BigDecimal(200)));
        statement.executeUpdate(updateSQL);
    }
}
