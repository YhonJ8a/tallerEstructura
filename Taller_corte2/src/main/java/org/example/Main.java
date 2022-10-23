package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);
        lista.primero = null;
        int opcion,lugar;
        System.out.println("Practica nodos\n ¿Qué desea hacer?\n");
        do{
            System.out.println("\n1) Insertar nodo\n" +
                    "2) Eliminar Enésimo\n" +
                    "3) Imprimir lista de izquerda a derecha\n"+
                    "4) Imprimir lista de derecha a izquierda\n"+
                    "5) Sumar primer par con el ultimo par\n"+
                    "6) Concatenar\n"+
                    "7) Intercalar\n"+
                    "0) salir\n");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Valor del nodo");
                    lista.insertarNodo(sc.nextInt());
                    lista.insertarNodo(2);
                    lista.insertarNodo(3);
                    lista.insertarNodo(4);
                    break;
                case 2:
                    break;
                case 3:
                    lista.imprimirListaIzq_Der();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Digita un un número válido");
                    break;
            }
        }while(opcion !=0);
    }
    public static class Lista{
        nodo primero;
        public void insertarNodo(int valor){
            nodo temporal = new nodo();
            temporal.info = valor;
            if(vacio())
                primero = temporal;
            else{
                nodo current = primero;
                while (current.siguiente != null){
                    current = current.siguiente;
                }
                current.siguiente = temporal;
                temporal.anterior = current;
                //primero = current;
                int i = 0;
            }
        }
        public void sumarPrimerParUltimoPar(){
            int primerPar=0, ban2=0, ultimoPrimo=0;
            nodo temporal = new nodo();
            temporal=primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else {
                while (temporal != null) {
                    if (temporal.esPar() && ban2 == 0) {
                        primerPar = temporal.info;
                        ban2 = 1;
                    }
                    if (!temporal.esPar() && ultimoPrimo != temporal.info)
                        ultimoPrimo = temporal.info;
                    temporal = temporal.siguiente;
                }
                System.out.println("La suma de primer par y el ultimo par es : " + (primerPar + ultimoPrimo));
            }
        }
        public void imprimirListaIzq_Der(){
            nodo temporal = new nodo();
            temporal = primero;
            if (vacio())
                System.out.println("La lista está vacía");
            else{
                while (temporal != null) {
                    System.out.println(temporal.info);
                    temporal = temporal.siguiente;
                }
            }
        }
        public Boolean vacio(){
            return (primero==null);
        }
    }
    private static class nodo{
        int info;
        nodo siguiente;
        nodo anterior;
        public Boolean esPar(){
            return (info % 2 == 0);
        }
        public Boolean esPrimo(){
            return (info % 2 == 0 && info % 3 == 0 && info % 5 == 0 && info % 7 ==0 || (info == 1 || info ==2 || info == 3 || info ==5 || info ==7));
        }
    }
}