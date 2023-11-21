import java.util.Objects;

public class ListaLigada {
    public NodoLista raiz;
    public ListaLigada() {
        raiz =null;
    }
    public boolean esVacia(){
        return raiz == null;
    }
    public void insertarOrdenado(Citas elemento){
        NodoLista nuevo= new NodoLista(elemento);
        if(esVacia()|| nuevo.elemento.fecha.isBefore(raiz.elemento.fecha)){
            nuevo.siguiente=raiz;
            raiz = nuevo;
        }else{
            NodoLista aux= raiz;
            while(aux.siguiente!=null && nuevo.elemento.fecha.isAfter(aux.siguiente.elemento.fecha)){
                aux = aux.siguiente;
            }
            nuevo.siguiente = aux.siguiente;
            aux.siguiente= nuevo;
        }
    }
    public void eliminarInicio(){
        if(esVacia()) System.out.println("No hay citas que eliminar.");
        else raiz = raiz.siguiente;
    }
    public void eliminarFinal(){
        NodoLista aux, ant;
        if(esVacia()) System.out.println("No hay citas que eliminar");
        else{
            if(raiz.siguiente==null) raiz = null;
            else {
                aux = raiz;
                ant=raiz;
                while(aux.siguiente!=null){
                    ant=aux;
                    aux=aux.siguiente;
                }
                ant.siguiente= null;
            }
        }
    }
    public void eliminar(Citas elemento) {
        if (esVacia()) {
            System.out.println("No hay citas a eliminar.");
            return;
        }
        if (raiz.elemento.equals(elemento)) {
            raiz = raiz.siguiente;
            System.out.println("Cita eliminada con éxito.");
            return;
        }
        NodoLista aux = raiz;
        NodoLista ant = null;
        while (aux != null && !aux.elemento.equals(elemento)) {
            ant = aux;
            aux = aux.siguiente;
        }
        if (aux == null) {
            System.out.println("La cita no existe.");
            return;
        }
        Objects.requireNonNull(ant).siguiente = aux.siguiente;
        System.out.println("Cita eliminada con éxito.");
    }
    public void mostrarLista(){
        NodoLista aux;
        if(esVacia()) System.out.println("No hay citas que mostrar.");
        else{
            aux=raiz;
            while(aux!=null){
                System.out.println(aux.elemento + " ");
                aux=aux.siguiente;
            }
        }
    }
}
