import java.util.Scanner;

public class Puzzle8 {
//12578 346                         123 16758
    public static String estadoInicialF = "12578 346";
    public static String estadoInicialD = "12 578346";
    public static String estadoFinal = "12345678 ";

    public static void main(String[] args) {
        // Instanciar el arbol
        Scanner scanner = new Scanner(System.in);
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicialF), estadoFinal);
        ArbolBusqueda b = new ArbolBusqueda(new Nodo(estadoInicialD), estadoFinal);
        // Ejecuta la busqueda
        
        int op, opdificultad;
        do {
            System.out.println("Busqueda por anchura");
            System.out.println("Tipo de dificultad:");
            System.out.println("1.- Facil");
            System.out.println("2.- Dificil");
            opdificultad = scanner.nextInt();
            switch (opdificultad) {
                case 1:
                
                    System.out.println("Busqueda por anchura Facil");
                    System.out.println("1.- Heuristica 1");
                    System.out.println("2.- Heuristica 2");
                    System.out.println("3.- Heuristica 3");
                    System.out.println("4.- Mostrar Tiempos");
                    System.out.println("5.- Salir");
                    op = scanner.nextInt();
                    switch (op) {
                        case 1:
                            a.busquedaPorAnchuraConHeuristica(op);
                            break;
                        case 2:
                            a.busquedaPorAnchuraConHeuristica(op);
                            break;

                        case 3:
                            a.busquedaPorAnchuraConHeuristica(op);
                            break;
                        case 4:
                            a.busquedaPorAnchuraConHeuristica(1);
                            a.busquedaPorAnchuraConHeuristica(2);
                            a.busquedaPorAnchuraConHeuristica(3);
                            a.mostrartiempos();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Busqueda por anchura Facil");
                    System.out.println("1.- Heuristica 1");
                    System.out.println("2.- Heuristica 2");
                    System.out.println("3.- Heuristica 3");
                    System.out.println("4.- Mostrar Tiempos");
                    System.out.println("5.- Salir");
                    op = scanner.nextInt();
                    switch (op) {
                        case 1:
                            b.busquedaPorAnchuraConHeuristica(op);
                            break;
                        case 2:
                            b.busquedaPorAnchuraConHeuristica(op);
                            break;
                        case 3:
                            b.busquedaPorAnchuraConHeuristica(op);
                            break;
                        case 4:
                            b.mostrartiempos();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Opcion no valida\n\n");
                            break;
                    }
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opdificultad != 2);  
        scanner.close();
    }
}