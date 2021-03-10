package gt.edu.url;

interface List <E>{
         /** Returns the number of elements in this list. **/
         int size( );
         /** Returns whether the list is empty. **/
         boolean isEmpty( );
         /** Returns (but does not remove) the element at index i. **/
         E get(int i) throws IndexOutOfBoundsException;
         /** Replaces the element at index i with e, and returns the replaced element. **/
         E set(int i, E e) throws IndexOutOfBoundsException;
         void add(int i, E e) throws IndexOutOfBoundsException;
         /** Removes/returns the element at index i, shifting subsequent elements earlier. **/
         E remove(int i) throws IndexOutOfBoundsException;
 }


public class URLArrayList<E> implements List<E> {

    class Nodo {
        E info;
        Nodo siguiente;
    }

    private Nodo raiz;

    @Override
    public int size() {
        int cant = 0;
        Nodo actual = raiz;
        while (actual != null) {
            actual = actual.siguiente;
            cant++;
        }
        return cant;
    }

    @Override
    public boolean isEmpty() {
        if (raiz == null)
            return true;
        else
            return false;
    }

    @Override
    public E get(int index) {
        if (index <= size())    {
            E informacion;
            if (index == 0) {
                informacion = raiz.info;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= index - 1 ; f++)
                    reco = reco.siguiente;
                Nodo prox = reco.siguiente;
                informacion = prox.info;
                return informacion;
            }
            return informacion;
        }
        else
            return null;
    }

    @Override
    public E set(int index, E element) {
        if (index <= size() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = element;
            if (index == 0) {
                raiz.info = nuevo.info;
                return raiz.info;
            } else if (index == size() ) {
                Nodo reco = raiz;
                while (reco.siguiente != null) {
                    reco = reco.siguiente;
                }
                reco.info = nuevo.info;
                return reco.info;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= index - 1; f++)
                    reco = reco.siguiente;
                //Nodo siguiente = reco.siguiente;
                reco.siguiente.info = nuevo.info;
                //nuevo.siguiente = siguiente;
                return reco.siguiente.info;
            }
        }
        else return null;
    }

    @Override
    public void add(int index, E element) {
        if (index <= size() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = element;
            if (index == 0) {
                nuevo.siguiente = raiz;
                raiz = nuevo;
            } else if (index == size() ) {
                Nodo reco = raiz;
                while (reco.siguiente != null) {
                    reco = reco.siguiente;
                }
                reco.siguiente = nuevo;
                nuevo.siguiente = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= index - 2; f++)
                    reco = reco.siguiente;
                Nodo siguiente = reco.siguiente;
                reco.siguiente = nuevo;
                nuevo.siguiente = siguiente;
            }
        }
    }
    @Override
    public E remove(int index) {
        if (index <= size ())    {
            if (index == 1) {
                var eliminado =raiz.info;
                raiz = raiz.siguiente;
                return eliminado;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= index - 2 ; f++){
                    reco = reco.siguiente;
                Nodo prox = reco.siguiente;
                reco.siguiente = prox.siguiente;
                }
                return reco.info;
            }
        }
        else return null;
    }
}
