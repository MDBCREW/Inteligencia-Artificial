public class Nodo {
    int dato;
	Nodo izquierda, derecha;

	public Nodo(int dato) {
		this.dato = dato;
		this.izquierda = this.derecha = null;
	}

	public void imprimir() {
		System.out.println(dato);
	}
}