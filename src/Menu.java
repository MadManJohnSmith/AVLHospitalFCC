import java.time.LocalDate;
import java.util.Scanner;
public class Menu {
    AVL arbolPrincipal = new AVL();
    public void insertarPaciente(){
        Paciente nuevoPaciente = new Paciente();
        arbolPrincipal.insertar(nuevoPaciente);
    }
    public void insertarCita(){

    }
    public void modificarPaciente(){

    }
    public void modificarCita(){

    }
    public void buscar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("De el NSS del paciente que quiere buscar");
        int nss = scanner.nextInt();
        arbolPrincipal.buscar(nss);
    }
    public void mostrarPreorden(){
        arbolPrincipal.mostrarPreorden();
    }
    public void mostrarInorden(){
        arbolPrincipal.mostrarInorden();
    }
    public void mostrarPostorden(){
         arbolPrincipal.mostrarPostorden();
    }
    public void exportar(){

    }
    public void eliminar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("De el NSS del paciente que quiere eliminar");
        int nss = scanner.nextInt();
        arbolPrincipal.eliminar(arbolPrincipal.raiz,nss);
    }
    public void salir(){

    }
    public void modoPrueba(){
        System.out.println("\tMODO DE PRUEBA");
        System.out.println("Bienvenido de vuelta!");

    }
}
