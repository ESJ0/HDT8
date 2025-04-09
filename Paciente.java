/**
 * Clase Paciente que representa un paciente con nombre, síntoma y código.
 * Implementa la interfaz Comparable para permitir la comparación entre pacientes
 */

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigo;

    /**
     * Constructor de la clase Paciente.
     * @param nombre Nombre del paciente.
     * @param sintoma Síntoma del paciente.
     * @param codigo Código de prioridad del paciente.
     */
    public Paciente(String nombre, String sintoma, char codigo) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    /**
     * Método para obtener el nombre del paciente.
     * @return Nombre del paciente.
    */
    public String getNombre(){ 
        return nombre;
    }

    /**
     * Método para obtener el síntoma del paciente.
     * @return Síntoma del paciente.
    */
    public String getSintoma(){ 
        return sintoma;
    }

    /**
     * Método para obtener el código de prioridad del paciente.
     * @return Código de prioridad del paciente.
    */
    public char getCodigo(){ 
        return codigo;
    }

    /**
     * Método para comparar dos pacientes por su código de prioridad.
     * @param otro Paciente a comparar.
     * @return Valor negativo si este paciente tiene menor prioridad, cero si son iguales, y positivo si tiene mayor prioridad.
    */
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigo, otro.codigo);
    }

    /**
     * Método toString para representar el paciente como una cadena.
     * @return Cadena que representa al paciente.
    */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigo;
    }
}
