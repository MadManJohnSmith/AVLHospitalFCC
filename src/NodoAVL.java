public class NodoAVL {
    public Paciente paciente;
    public NodoAVL izquierdo;
    public NodoAVL derecho;
    public int altura;

    public NodoAVL(Paciente paciente) {
        this.paciente = paciente;
        this.altura = 1;
    }
}
