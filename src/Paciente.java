import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente {
    public int NSS;
    public String nombres;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public char sexo;
    public int edad;
    public ListaLigada citas;
    public Paciente() {
        citas = new ListaLigada();
    }
    public Paciente(int NSS, String nombres, String apellidoPaterno,
                    String apellidoMaterno, char sexo, int edad) {
        this.NSS = NSS;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.edad = edad;
        citas = new ListaLigada();
    }
    public void agregarCita(LocalDateTime fecha, String nombreMedico, int consultorio) {
        Citas nuevaCita = new Citas(fecha, nombreMedico, consultorio);
        citas.insertarOrdenado(nuevaCita);
    }

    public void mostrar(){
        System.out.println("\tDatos del Paciente");
        System.out.println("NSS: "+ NSS);
        System.out.println("Nombre: "+ nombres+" "+ apellidoMaterno+" "+apellidoPaterno);
        System.out.println("Sexo: "+ sexo);
        System.out.println("Edad: "+ edad);
        System.out.println("\n\tCitas");
        if(citas.esVacia()){
            System.out.println("El paciente no tiene citas.");
        }else{
            citas.mostrarLista();
        }
    }

    public void agregarCita(Citas cita) {
        citas.insertarOrdenado(cita);
        System.out.println("Cita agregada con éxito.");
    }
}