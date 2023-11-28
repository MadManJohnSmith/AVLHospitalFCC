import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Citas {
    public LocalDateTime fecha;
    public String nombreMedico;
    public int consultorio;
    public Citas(LocalDateTime fecha, String nombreMedico, int consultorio) {
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.consultorio = consultorio;
    }
    
      public void mostrarCita() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaFormateada = fecha.format(formatter);

        System.out.println("Fecha y hora de la cita: " + fechaFormateada);
        System.out.println("Nombre del médico: " + nombreMedico);
        System.out.println("Consultorio: " + consultorio);
    }
}
