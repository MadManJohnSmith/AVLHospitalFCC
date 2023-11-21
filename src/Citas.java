import java.time.LocalDate;
public class Citas {
    public LocalDate fecha;
    public String nombreMedico;
    public int consultorio;
    public Citas(LocalDate fecha, String nombreMedico, int consultorio) {
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.consultorio = consultorio;
    }
}