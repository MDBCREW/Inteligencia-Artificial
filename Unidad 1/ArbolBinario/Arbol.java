public class Arbol {
    private Nodo raiz;

    public Arbol() {
    }

    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }
    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.dato == busqueda) {
            return true;
        } else if (busqueda < n.dato) {
            return existe(n.izquierda, busqueda);
        } else {
            return existe(n.derecha, busqueda);
        }

    }

    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }
    private void insertar(Nodo padre, int dato) {
        if (dato > padre.dato) {
            if (padre.derecha == null) {
                padre.derecha = (new Nodo(dato));
            } else {
                this.insertar(padre.derecha, dato);
            }
        } else {
            if (padre.izquierda == null) {
                padre.izquierda = (new Nodo(dato));
            } else {
                this.insertar(padre.izquierda, dato);
            }
        }
    }

}