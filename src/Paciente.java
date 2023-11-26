import java.util.Scanner;
import java.time.LocalDate;
public class Paciente {
    public int NSS;
    public String nombres;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public char sexo;
    public int edad;
    public ListaLigada citas;
    public Paciente(int NSS, String nombres, String apellidoPaterno,
                    String apellidoMaterno, char sexo, int edad) {
        this.NSS = NSS;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sexo = sexo;
        this.edad = edad;
        this.citas = new ListaLigada();
    }
    public Paciente() {
        citas = new ListaLigada();
    }
    
    public void mostrarPaciente(){
        System.out.println("NSS: " + NSS);
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Sexo: " + sexo);
        System.out.println("Edad: " + edad);
        System.out.println("Citas:");
    }
    
    public void insertarCita(){
        Scanner scanner = new Scanner(System.in);
        
             String fechastr = "";
             String nombreMedico ="";
             int consultorio = 0;
             System.out.println("Ingrese la fecha");
             fechastr = scanner.nextLine();
             LocalDate fecha = LocalDate.parse(fechastr);
             System.out.println("Ingrese el Médico");
             nombreMedico = scanner.next();
             System.out.println("Ingrese el Consultorio");
             consultorio = scanner.nextInt();
             Citas nuevaCita = new Citas(fecha, nombreMedico, consultorio);
             this.citas.insertarOrdenado(nuevaCita);
            
    }
    
    
}
