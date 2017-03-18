package edu.ncsu.csc.itrust.model.old.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.model.old.beans.MessageBean;
import edu.ncsu.csc.itrust.model.old.beans.loaders.MessageBeanLoader;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;

/**
 * Used for the logging mechanism.
 * 
 * DAO stands for Database Access Object. All DAOs are intended to be
 * reflections of the database, that is, one DAO per table in the database (most
 * of the time). For more complex sets of queries, extra DAOs are added. DAOs
 * can assume that all data has been validated and is correct.
 * 
 * DAOs should never have setters or any other parameter to the constructor than
 * a factory. All DAOs should be accessed by DAOFactory (@see
 * {@link DAOFactory}) and every DAO should have a factory - for obtaining JDBC
 * connections and/or accessing other DAOs.
 */
public class MessageDAO {

	private DAOFactory factory;
	private MessageBeanLoader mbLoader;

	/**
	 * The typical constructor.
	 * 
	 * @param factory
	 *            The {@link DAOFactory} associated with this DAO, which is used
	 *            for obtaining SQL connections, etc.
	 */
	public MessageDAO(DAOFactory factory) {
		this.factory = factory;
		this.mbLoader = new MessageBeanLoader();
	}

	/**
	 * Gets all the messages for a certain user MID.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesForMID(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O");) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);
			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by ascending time.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesTimeAscending(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O");) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);
			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by name ascending.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesNameAscending(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = (mid >= 999999999)
						? conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")
						: conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by name descending.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesNameDescending(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = (mid >= 999999999)
						? conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")
						: conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);
			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages from a certain user MID.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesFrom(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by ascending time.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 */
	public List<MessageBean> getMessagesFromTimeAscending(long mid) throws DBException, SQLException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by name ascending.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesFromNameAscending(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = (mid >= 999999999)
						? conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")
						: conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Gets all the messages for a certain user MID sorted by name descending.
	 * 
	 * @param mid
	 *            The MID of the user to be looked up.
	 * @return A java.util.List of MessageBeans.
	 * @throws SQLException
	 * @throws DBException
	 */
	public List<MessageBean> getMessagesFromNameDescending(long mid) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = (mid >= 999999999)
						? conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")
						: conn.prepareStatement(
								"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mid);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	/**
	 * Adds a message to the database.
	 * 
	 * @param mBean
	 *            A bean representing the message to be added.
	 * @throws SQLException
	 * @throws DBException
	 */
	public void addMessage(MessageBean mBean) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = mbLoader.loadParameters(conn.prepareStatement(
						"Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O"
								+ "Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O"),
						mBean)) {
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public void updateRead(MessageBean mBean) throws DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, mBean.getMessageId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public List<MessageBean> getCCdMessages(long refID) throws SQLException, DBException {
		try (Connection conn = factory.getConnection();
				PreparedStatement stmt = conn.prepareStatement("Abtvk1cHzRnzDmqnuIKjYhgywp6Chk9O")) {
			stmt.setLong(1, refID);
			ResultSet rs = stmt.executeQuery();

			List<MessageBean> messageList = this.mbLoader.loadList(rs);

			rs.close();
			return messageList;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
}