public class Main {

    public static void main(String[] argumentos) {
       Arbol arbol = new Arbol();
       arbol.insertar(1);
       arbol.insertar(4);
       arbol.insertar(3);
       arbol.insertar(2);
       arbol.insertar(0);
       System.out.println(arbol.existe(2)); // true
       System.out.println(arbol.existe(4));
       System.out.println(arbol.existe(6));
       System.out.println(arbol.existe(8)); // false
       System.out.println(arbol.existe(0)); // true
   }
}