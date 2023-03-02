import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ArbolBusqueda {

    Nodo raiz;
    String objetivo;

    Nodo FinalH1,FinalH2,FinalH3;
    long TiempoH1,TiempoH2,TiempoH3;


    public ArbolBusqueda(Nodo raiz, String objetivo) {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }

    // Busqueda por Anchura
    public void busquedaPorAnchura() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Queue<Nodo> estadosPorVisitar = new LinkedList<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("Se ha encontrado el objetivo");
        System.out.println(nodoActual.getEstado() + "\n");
        System.out.println("Se imprimiran los pasos para conseguir el estado final");
        camino(nodoActual, new String());
    }

    public void busquedaPorProfundidad() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("Se ha encontrado el objetivo");
        System.out.println(nodoActual.getEstado());

        System.out.println("Se imprimiran los pasos para conseguir el estado final");
        camino(nodoActual, new String());
        
    }

    public void camino(Nodo nodo, String aux) {
        if (nodo.padre != null) {
            camino(nodo.padre, aux);
        }
        aux = nodo.getEstado();
        System.out.println(aux.charAt(0) + " | " + aux.charAt(1) + " | " + aux.charAt(2));
        System.out.println(aux.charAt(3) + " | " + aux.charAt(4) + " | " + aux.charAt(5));
        System.out.println(aux.charAt(6) + " | " + aux.charAt(7) + " | " + aux.charAt(8));
        System.out.println();
    }

    public void busquedaPorAnchuraConHeuristica(int op) {
        long TiempoInicio, TiempoFinal;
        TiempoInicio = System.currentTimeMillis();
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    switch (op) {
                        case 1:
                            nHijo.costo = heuristica1(nHijo.getEstado(), objetivo);                            
                            break;
                        case 2:
                            nHijo.costo = heuristica2(nHijo.getEstado(), objetivo);
                            break;
                        case 3:
                            nHijo.costo = heuristica3(nHijo.getEstado(), objetivo);
                            break;
                    }
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        TiempoFinal = System.currentTimeMillis();
        switch (op) {
            case 1:
                this.TiempoH1 = TiempoFinal - TiempoInicio;
                this.FinalH1 = nodoActual;
                break;
            case 2:
                this.TiempoH2 = TiempoFinal - TiempoInicio;
                this.FinalH2 = nodoActual;
                break;
            case 3:
                this.TiempoH3 = TiempoFinal - TiempoInicio;
                this.FinalH3 = nodoActual;
                break;
        }
        System.out.println(estadosVisitados.size());
        System.out.println("Se ha encontrado el objetivo");
        System.out.println(nodoActual.getEstado() + "\n");

        System.out.println("Se imprimiran los pasos para conseguir el estado final");
        camino(nodoActual, new String());
    }

    public int heuristica1(String actual, String objetivo) {
        int cont = 0;
        for(int i=0; i<actual.length(); i++){
            if (actual.charAt(i) != objetivo.charAt(i)){
                cont++ ;
            }
        }
        return cont;
    }
    public int heuristica2(String actual, String objetivo) {
        int a,b,cont = 0;
        for(int i=0; i<actual.length(); i++){
            a = Character.getNumericValue(actual.charAt(i));
            if (actual.charAt(i) == ' ')
                a = 0;
            b = Character.getNumericValue(objetivo.charAt(i));
            if (objetivo.charAt(i) == ' ')
                b = 0;
            cont = cont + Math.abs(a-b) ;
    }
        return cont;
    }

    public int heuristica3(String actual, String objetivo) {
        int cont = 0;
        for(int i=0; i<actual.length(); i++){
            for(int j=0; j<actual.length(); j++){
                if (actual.charAt(i) == objetivo.charAt(j)){
                    cont += Math.abs(i-j);
                    break;
                }
            }
        }
        return cont;
    }
    
    public void mostrartiempos(){

        System.out.println("Tiempo de ejecucion: ");
        System.out.println("Heuristica 1:");
        System.out.println("Tiempo: "+TiempoH1 +" milisegundos");    
        System.out.println("Heuristica 2:");
        System.out.println("Tiempo: "+TiempoH2 +" milisegundos");    
        System.out.println("Heuristica 3:");
        System.out.println("Tiempo: "+TiempoH3 +" milisegundos");    
    }
}