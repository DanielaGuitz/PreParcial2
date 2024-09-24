package umg.ejercicio.DataBase.Service;

import umg.ejercicio.DataBase.Conexion.Conexion;
import umg.ejercicio.DataBase.Conexion.ManagerTransaction;
import umg.ejercicio.DataBase.DAO.DatosDAO;
import umg.ejercicio.DataBase.DAO.Ejercicio2DAO;
import umg.ejercicio.DataBase.Model.Ejercicio2Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Ejercicio2Service {
    private Ejercicio2DAO userDao = new Ejercicio2DAO();


    public boolean eliminarUser(int id) throws SQLException {
        return userDao.deleteUserById(id);
    }

    public boolean checkEmailDuplicated(String email) {
        return userDao.isEmailDuplicated(email);
    }

    public void createUser(Ejercicio2Model user) throws SQLException {
        try (Connection connection = Conexion.getConnection()) {
            ManagerTransaction tm = new ManagerTransaction(connection);
            tm.beginTransaction();
            try {
                userDao.insertUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }



    public boolean actualizarUser(Ejercicio2Model user) throws SQLException {
        return userDao.updateUser(user);
    }



    public Ejercicio2Model getUserByCarne(String carne) throws SQLException {
        return userDao.getUserByCarne(carne);
    }
}

