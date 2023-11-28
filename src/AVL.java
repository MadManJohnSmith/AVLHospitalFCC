/**
 *      @author
 *      Guillermo Sanchez Ortega
 *      Joe David González Herrera
 *      Grabiel Ramirez Bañuelos
 *      Alan Salas Parada
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class AVL {
    public NodoAVL raiz;

    public AVL() {
        this.raiz = null;
    }

    //Casi no se nota que salio del ChatGPT xD
    // Método para obtener la altura de un nodo
    public int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    // Método para obtener el factor de equilibrio de un nodo
    public int factorEquilibrio(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Método para rotar a la derecha
    public NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        // Realizar rotación
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    // Método para rotar a la izquierda
    public NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        // Realizar rotación
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    // Método para insertar un paciente en el árbol AVL
    public NodoAVL insertar(NodoAVL nodo, Paciente paciente) {
        if (nodo == null) {
            return new NodoAVL(paciente);
        }

        // Realizar inserción
        if (paciente.NSS < nodo.paciente.NSS) {
            nodo.izquierdo = insertar(nodo.izquierdo, paciente);
        } else if (paciente.NSS > nodo.paciente.NSS) {
            nodo.derecho = insertar(nodo.derecho, paciente);
        } else {
            // Duplicados no permitidos
            return nodo;
        }

        // Actualizar altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Obtener el factor de equilibrio del nodo y realizar las rotaciones necesarias
        int equilibrio = factorEquilibrio(nodo);

        // Rotación hacia la derecha
        if (equilibrio > 1 && paciente.NSS < nodo.izquierdo.paciente.NSS) {
            return rotarDerecha(nodo);
        }

        // Rotación hacia la izquierda
        if (equilibrio < -1 && paciente.NSS > nodo.derecho.paciente.NSS) {
            return rotarIzquierda(nodo);
        }

        // Caso izquierda-derecha
        if (equilibrio > 1 && paciente.NSS > nodo.izquierdo.paciente.NSS) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Caso derecha-izquierda
        if (equilibrio < -1 && paciente.NSS < nodo.derecho.paciente.NSS) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public NodoAVL eliminar(NodoAVL nodo, int nss){
        if (nodo == null) {
            System.out.println("Elemento no encontrado");
            return null;
        }

        // Buscar el nodo que contiene el dato
        if (nss < nodo.paciente.NSS) {
            nodo.izquierdo = eliminar(nodo.izquierdo, nss);
        } else if (nss > nodo.paciente.NSS) {
            nodo.derecho = eliminar(nodo.derecho, nss);
        } else {
            // Casos para eliminar el nodo
            if (nodo.izquierdo == null) {
                NodoAVL temp = nodo.derecho;
                System.out.print("Elemento eliminado: " + nodo.paciente.NSS + " reemplazado por ");
                if (temp != null) {
                    System.out.println(temp.paciente.NSS);
                } else {
                    System.out.println("NULL");
                }
                return temp;
            } else if (nodo.derecho == null) {
                NodoAVL temp = nodo.izquierdo;
                System.out.print("Elemento eliminado: " + nodo.paciente.NSS + " reemplazado por ");
                System.out.println(temp.paciente.NSS);
                return temp;
            } else {
                // Caso con dos hijos: encontrar el sucesor inmediato
                NodoAVL temp = encontrarMinimo(nodo.derecho);
                System.out.println("* Elemento eliminado: " + nodo.paciente.NSS + " reemplazado por " + temp.paciente.NSS);
                nodo.paciente.NSS = temp.paciente.NSS;
                nodo.derecho = eliminar(nodo.derecho, nss);
            }
        }
        return nodo;
    }

    public NodoAVL encontrarMinimo(NodoAVL nodo){
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public NodoAVL buscar(int nss) {
        return buscarRec(raiz, nss);
    }

    private NodoAVL buscarRec(NodoAVL nodo, int nss) {
        if (nodo == null) {
            return null;
        }

        if (nodo.paciente.NSS == nss) {
            return nodo;
        } else if (nss < nodo.paciente.NSS) {
            return buscarRec(nodo.izquierdo, nss);
        } else {
            return buscarRec(nodo.derecho, nss);
        }
    }

    public void mostrarInorden(NodoAVL nodo){
        if (nodo != null) {
            mostrarInorden(nodo.izquierdo);
            nodo.paciente.mostrar();
            mostrarInorden(nodo.derecho);
        }
    }

    public void mostrarInorden(){
        mostrarInorden(raiz);
        System.out.println("\n");
    }

    public void mostrarPreorden(NodoAVL nodo){
        if (nodo != null) {
            nodo.paciente.mostrar();
            mostrarPreorden(nodo.izquierdo);
            mostrarPreorden(nodo.derecho);
        }
    }

    public void mostrarPreorden(){
        mostrarPreorden(raiz);
        System.out.println("\n");
    }

    public void mostrarPostorden(NodoAVL nodo){
        if (nodo != null) {
            mostrarPostorden(nodo.izquierdo);
            mostrarPostorden(nodo.derecho);
            nodo.paciente.mostrar();
        }
    }

    public void mostrarPostorden(){
        mostrarPostorden(raiz);
        System.out.println("\n");
    }


    // Método público para insertar un paciente en el árbol AVL
    public void insertar(Paciente paciente) {
        raiz = insertar(raiz, paciente);
    }
    public void exportarAVL(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            exportarInorden(raiz, writer);
            System.out.println("Datos del AVL exportados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private void exportarInorden(NodoAVL nodo, PrintWriter writer) {
        if (nodo != null) {
            exportarInorden(nodo.izquierdo, writer);
            // Aquí puedes personalizar cómo se escriben los datos en el archivo
            System.out.println("Exportando: " + nodo.paciente.toString()); // Mensaje de depuración
            writer.println(nodo.paciente.toString());
            exportarInorden(nodo.derecho, writer);
        }
    }



}
