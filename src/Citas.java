import java.time.LocalDateTime;
public class Citas {
    public LocalDateTime fecha;
    public String nombreMedico;
    public int consultorio;
    public Citas(LocalDateTime fecha, String nombreMedico, int consultorio) {
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.consultorio = consultorio;
    }
}