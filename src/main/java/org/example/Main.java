package org.example;

import arbolgeneral.ArbolGeneral;
import arbolgeneral.NodoGeneral;

public class Main {
    public static void main(String[] args) {
        NodoGeneral n = new NodoGeneral(1);
        ArbolGeneral a = new ArbolGeneral(n);
        n = new NodoGeneral(2);
        ArbolGeneral b = new ArbolGeneral(n);
        n = new NodoGeneral(3);
        ArbolGeneral c = new ArbolGeneral(n);
        n = new NodoGeneral(-4);
        ArbolGeneral d = new ArbolGeneral(n);
        ArbolGeneral e = new ArbolGeneral(new NodoGeneral(2));
        ArbolGeneral f = new ArbolGeneral(new NodoGeneral(43));
        ArbolGeneral g = new ArbolGeneral(new NodoGeneral(1));
        ArbolGeneral h = new ArbolGeneral(new NodoGeneral(-3));
        ArbolGeneral i = new ArbolGeneral(new NodoGeneral(54));

        try {
            a.añadirHijo(c.raiz());                 // 1 -> 3
            a.añadirHijo(b.raiz());                 // 1 -> 3, 2

            c.añadirHijo(new NodoGeneral(-8)); // 3 -> 10
            c.añadirHijo(new NodoGeneral(5));  // 3 -> 10, 11

            b.añadirHijo(d.raiz());                 // 2 -> 4
            b.añadirHijo(f.raiz());                 // 2 -> 4, 6
            b.añadirHijo(g.raiz());                 // 2 -> 4, 6, 7
            b.añadirHijo(h.raiz());                 // 2 -> 4, 6, 7, 8
            b.añadirHijo(i.raiz());                 // 2 -> 4, 6, 7, 8, 9

            e.añadirHijo(a.raiz());                 // 5 -> 1


            System.out.println("arbol");
            e.pintaArbol(0);

            System.out.println("El grado del arbol es: " + e.gradoArbol());

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}