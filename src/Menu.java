
import java.util.Scanner;
public class Menu {
    AVL arbolPrincipal = new AVL();
    public void insertarPaciente(){
        Paciente nuevoPaciente = new Paciente();
        arbolPrincipal.insertar(nuevoPaciente);
    }
    public void insertarCita(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("De el NSS del paciente que quiere buscar");
        int nss = scanner.nextInt();
        boolean ext = true;
        ext = arbolPrincipal.buscar(nss);
        if(ext=true){
            
        }
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
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int ns =0;
        String nom;
        String apellidoPat;
        String apellidoMat;
        char sex;
        int ed;
        
        do {
            System.out.println("\tMODO DE PRUEBA");
            System.out.println("1. Insertar");
            System.out.println("2. Modificar");
            System.out.println("3. Buscar");
            System.out.println("4.Mostrar en Preorden");
            System.out.println("5.Mostrar en Inorden\n");
            System.out.println("6.Mostrar en Postorden\n");
            System.out.println("7.Exportar\n");
            System.out.println("8.Eliminar\n");
            System.out.println("8.Salir\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int o = 0;
                    System.out.println(" (1).Para insertar paciente y (2).Para agregar cita");
                    o = scanner.nextInt();
                    if(o == 1){
                        System.out.println("Inserte el NSS del paciente");
                        ns = scanner.nextInt();
                        System.out.println("Inserte el nombre del paciente");
                        nom = scanner.next();
                        System.out.println("Inserte el apellido paterno");
                        apellidoPat = scanner.next();
                        System.out.println("Inserte el apellido materno");
                        apellidoMat = scanner.next();
                        System.out.println("Inserte el sexo");
                        sex = scanner.next().charAt(0);
                        System.out.println("Inserte la edad");
                        ed = scanner.nextInt();
                        Paciente nuevoPaciente = new Paciente(ns,nom,apellidoPat,apellidoMat,sex,ed);
                        arbolPrincipal.insertar(nuevoPaciente);
                    }else{

                    }
           
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Saliendo del modo de prueba...");
                    break;
                case 4:
                    System.out.println("Mostrando en preorden");
                    arbolPrincipal.mostrarPreorden();
                    break;
                case 5:
                    System.out.println("Mostrar en inorden");
                    arbolPrincipal.mostrarInorden();
                    break;
                case 6:
                    System.out.println("Mostrar en Postorden");
                    arbolPrincipal.mostrarPostorden();
                    break;
                case 7:
                    System.out.println("Saliendo del modo de prueba...");
                    break;
                case 8:
                    System.out.println("Saliendo del modo de prueba...");
                    break;
                case 9:
                    System.out.println("Saliendo del modo de prueba...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 3);

    }
}
