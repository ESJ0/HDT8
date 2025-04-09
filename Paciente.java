public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigo;

    public Paciente(String nombre, String sintoma, char codigo) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    public String getNombre(){ 
        return nombre;}

    public String getSintoma(){ 
        return sintoma;}

    public char getCodigo(){ 
        return codigo;}

    public int compareTo(Paciente otro) {
        return Character.compare(this.codigo, otro.codigo);
    }

    public String toString() {
        return nombre + ", " + sintoma + ", " + codigo;
    }
}
