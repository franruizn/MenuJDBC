package Modelo;

/**
 * La clase Especialidad representa una especialidad médica en el sistema. Contiene
 * información sobre la especialidad, incluyendo su identificador y nombre.
 *
 * @author franr
 */
public class Especialidad {
    private int idespecialidad;  // Identificador único de la especialidad médica.
    private String nombre;      // Nombre de la especialidad.

    /**
     * Constructor de la clase Especialidad con parámetros.
     *
     * @param idespecialidad Identificador único de la especialidad médica.
     * @param nombre Nombre de la especialidad.
     */
    public Especialidad(int idespecialidad, String nombre) {
        this.idespecialidad = idespecialidad;
        this.nombre = nombre;
    }

    /**
     * Constructor por defecto de la clase Especialidad.
     */
    public Especialidad() {
    }

    /**
     * Obtiene el identificador único de la especialidad médica.
     *
     * @return El identificador único de la especialidad médica.
     */
    public int getIdespecialidad() {
        return idespecialidad;
    }

    /**
     * Establece el identificador único de la especialidad médica.
     *
     * @param idespecialidad El identificador único de la especialidad médica.
     */
    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    /**
     * Obtiene el nombre de la especialidad.
     *
     * @return El nombre de la especialidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la especialidad.
     *
     * @param nombre El nombre de la especialidad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
