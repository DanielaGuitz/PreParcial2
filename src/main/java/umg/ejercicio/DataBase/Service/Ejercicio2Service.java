package umg.ejercicio.DataBase.Service;

import umg.ejercicio.DataBase.Conexion.Conexion;
import umg.ejercicio.DataBase.Conexion.ManagerTransaction;
import umg.ejercicio.DataBase.Model.Ejercicio2Model;

import java.sql.Connection;
import java.sql.SQLException;

public class Ejercicio2Service {
    private Ejercicio2Model ejercicio2Model = new Ejercicio2Model();


    public boolean eliminarUser(int id) throws SQLException {
        return ejercicio2Model.deleteUserById(id);
    }



    public boolean checkEmailDuplicated(String email) {
        return ejercicio2Model.isEmailDuplicated(email);
    }

    public void createUser(Ejercicio2Model user) throws SQLException {
        try (Connection connection = Conexion.getConnection()) {
            ManagerTransaction tm = new ManagerTransaction(connection);
            tm.beginTransaction();
            try {
                ejercicio2Model.insertUser(user);
                tm.commit();
            } catch (SQLException e) {
                tm.rollback();
                throw e;
            }
        }
    }



    public boolean actualizarUser(Ejercicio2Model user) throws SQLException {
        return ejercicio2Model.updateUser(user);
    }



    public Ejercicio2Model getUserByCarne(String carne) throws SQLException {
        return ejercicio2Model.getUserByCarne(carne);
    }


}

