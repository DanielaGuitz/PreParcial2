package umg.ejercicio.DataBase.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerTransaction {
    private Connection connection;

    public ManagerTransaction(Connection connection) {
        this.connection = connection;
    }

    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}

