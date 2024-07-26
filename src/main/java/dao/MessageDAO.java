package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.MessageBean;

public class MessageDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "SELECT m.id, m.content, m.date_and_time, m.sender_id, m.seen AS seen, u.mail FROM fitness_app_db.message m INNER JOIN fitness_app_db.user u ON m.sender_id = u.id WHERE m.receiver_id IS NULL;";
	private static final String SQL_SELECT_BY_ID = "SELECT m.id, m.content, m.seen, u.mail " +
            "FROM fitness_app_db.message m " +
            "INNER JOIN fitness_app_db.user u ON m.sender_id = u.id " +
            "WHERE m.id=?";
	private static final String SQL_UPDATE_STATUS = "UPDATE message m SET m.seen=? WHERE m.id=?";


    public MessageDAO() {
        // TODO Auto-generated constructor stub
    }

    public static List<MessageBean> getAll() {
        List<MessageBean> messages = new ArrayList<>();

        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            c = connectionPool.checkOut();
            ps = DBUtil.prepareStatement(c, SQL_SELECT_ALL, false);
            rs = ps.executeQuery();

            while (rs.next()) {
                messages.add(new MessageBean(rs.getInt("id"), rs.getString("content"), rs.getBoolean("seen"), rs.getString("mail")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkIn(c);
        }

        return messages;
    }

    public static void update(Integer id) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = connectionPool.checkOut();
            ps = DBUtil.prepareStatement(c, SQL_UPDATE_STATUS, false);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkIn(c);
        }
    }

    public static MessageBean getById(int id) {
        Connection c = null;
        ResultSet rs = null;
        PreparedStatement ps=null;
        MessageBean messageBean=null;

        try {
            c = connectionPool.checkOut();
            ps =DBUtil.prepareStatement(c, SQL_SELECT_BY_ID, false);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                messageBean=new MessageBean(rs.getInt("id"), rs.getString("content"), rs.getBoolean("seen"), rs.getString("mail"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkIn(c);
        }
        return messageBean;
    }
}
