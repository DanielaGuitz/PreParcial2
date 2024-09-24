package umg.ejercicio.DataBase.Model;

public class Ejercicio2Model {
    private int id;
    private String carnet;
    private String nombre;
    private String correo;
    private String seccion;
    private long telegramid;
    private String activo;


    public Ejercicio2Model() {}

    //Constructor de todos los parametros
    public Ejercicio2Model(int id, String carnet, String nombre, String correo, String seccion, long telegramid, String activo) {
        this.id = id;
        this.carnet = carnet;
        this.nombre = nombre;
        this.correo = correo;
        this.seccion = seccion;
        this.telegramid = telegramid;
        this.activo = activo;
    }

    //Constructor de algunos parametros
    public Ejercicio2Model(int id, String carnet, String nombre, String correo, String seccion) {
        this.id = id;
        this.carnet = carnet;
        this.nombre = nombre;
        this.correo = correo;
        this.seccion = seccion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarne() {
        return carnet;
    }

    public void setCarne(String carne) {
        this.carnet = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public long getTelegramid() {
        return telegramid;
    }

    public void setTelegramid(long telegramid) {
        this.telegramid = telegramid;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}

