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

        // Caso izquierda-izquierda
        if (equilibrio > 1 && paciente.NSS < nodo.izquierdo.paciente.NSS) {
            return rotarDerecha(nodo);
        }

        // Caso derecha-derecha
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

    // Método público para insertar un paciente en el árbol AVL
    public void insertar(Paciente paciente) {
        raiz = insertar(raiz, paciente);
    }

    // Otros métodos (eliminar, buscar, mostrar, etc.) se pueden agregar según sea necesario
}
