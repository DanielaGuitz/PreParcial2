package umg.ejercicio.DataBase.Service;

import umg.ejercicio.DataBase.DAO.DatosDAO;
import umg.ejercicio.DataBase.Model.DatosModel;

import java.sql.SQLException;
import java.util.List;

public class DatosService {
    private DatosDAO datosDao = new DatosDAO();


    //Insertar un nuevo dato
    public boolean insertarDato(DatosModel dato) {
        return datosDao.insertar(dato);
    }


    //Obtener los registros
    public List<DatosModel> obtenerTodosLosDatos() {
        return datosDao.obtenerTodos();
    }


    //Obtener un dato por ID
    public DatosModel obtenerPorId(int id) throws SQLException {
        return datosDao.obtenerPorId(id);
    }


    //Actualizar dato ya existente
    public boolean actualizarDato(DatosModel dato) {
        return datosDao.actualizar(dato);
    }


    //Eliminar un dato por su código
    public boolean eliminarDato(int codigo) {
        return datosDao.eliminar(codigo);
    }

}

