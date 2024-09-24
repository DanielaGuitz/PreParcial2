package umg.ejercicio.DataBase.Service;

import umg.ejercicio.DataBase.DAO.ChampionsDAO;
import umg.ejercicio.DataBase.Model.ChampionsModel;

import java.sql.SQLException;
import java.util.List;

public class ChampionsService {

    private ChampionsDAO championsDao = new ChampionsDAO();

    public boolean insertarEquipo(ChampionsModel equipo) throws SQLException {
        return championsDao.insertar(equipo);
    }

    public boolean actualizarEquipo(ChampionsModel equipo) throws SQLException {
        return championsDao.actualizar(equipo);
    }

    public boolean eliminarEquipo(int idEquipo) throws SQLException {
        return championsDao.eliminar(idEquipo);
    }


    public List<ChampionsModel> obtenerTodosLosEquipos() throws SQLException {
        return championsDao.obtenerTodos();
    }
}

