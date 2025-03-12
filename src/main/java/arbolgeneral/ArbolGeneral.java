package arbolgeneral;


public class ArbolGeneral {

    private NodoGeneral raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public ArbolGeneral(NodoGeneral nodo) {
        this.raiz = nodo;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void vaciar() {
        raiz = null;
    }

    public NodoGeneral raiz() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en raiz: árbol vacío");
        }
        return raiz;
    }

    public ArbolGeneral primerHijo() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.primerHijo);
    }

    public ArbolGeneral hermano() throws Exception { // si el árbol está vacío
        if (esVacio()) {
            throw new Exception("Error en hijoIzq: árbol vacío");
        }

        return new ArbolGeneral(raiz.hermano);
    }

    public ArbolGeneral padre() throws Exception { //argumento ilegal
        if (raiz == null) {
            throw new Exception("Error en padre: subárbol vacío");
        }

        return new ArbolGeneral(raiz.padre);
    }

    public void añadirHijo(NodoGeneral hijo) throws Exception { // si el árbol está vacío o argumento ilegal
        if (hijo == null) {
            throw new Exception("Error en añadirHijo: hijo es un árbol vacío");
        }
        if (esVacio()) {
            throw new Exception("Error en añadirHijo: árbol vacío");
        }

        if (raiz.primerHijo == null) {
            raiz.primerHijo = hijo;
            hijo.padre = raiz;
        } else {
            NodoGeneral aux = raiz.primerHijo;
            while (aux.hermano != null) {
                aux = aux.hermano;
            }

            aux.hermano = hijo;
            hijo.padre = raiz;
        }
    }

    public void eliminar(ArbolGeneral subarbol) throws Exception {
        if (subarbol == null) {
            throw new Exception("Error en borra: subárbol vacío");
        }

        if (subarbol.raiz == raiz) {
            raiz = null;
        } else {
            ArbolGeneral p = subarbol.padre();
            if (p.esVacio()) {
                throw new Exception("Error en borra: no existe el subárbol a eliminar");
            } else if (p.raiz.primerHijo == subarbol.raiz) {
                p.raiz.primerHijo = p.raiz.primerHijo.hermano;
            } else {
                NodoGeneral aux = p.raiz.primerHijo;
                while (aux.hermano != subarbol.raiz) {
                    aux = aux.hermano;
                }

                aux.hermano = aux.hermano.hermano;
            }
        }
    }

    public void pintaArbol(int esp) {
        if (!esVacio()) {
            try {
                for (int i = 0; i < esp; i++) {
                    System.out.print("  ");
                }
                System.out.print("|");
                System.out.println(raiz.dato + " ");

                for (ArbolGeneral aux = primerHijo(); !aux.esVacio(); aux = aux.hermano()) {
                    aux.pintaArbol(esp + 1);
                }
            } catch (Exception e) {
            }
        }
    }

    public int gradoArbol() {
        return gradoNodo(raiz);
    }

    private int gradoNodo(NodoGeneral node) {
        if (node == null) {
            return 0;
        }

        int maxGrade = 0;
        int childrenCounter = 0;
        NodoGeneral aux = node.primerHijo;

        // Contar el número de hijos del nodo actual
        while (aux != null) {
            ++childrenCounter;
            aux = aux.hermano;
        }

        // Verificar si este nodo tiene más hijos que el grado máximo encontrado
        maxGrade = Math.max(maxGrade, childrenCounter);

        // Recorrer todos los hijos y calcular el grado de sus subárboles
        aux = node.primerHijo;
        while (aux != null) {
            maxGrade = Math.max(maxGrade, gradoNodo(aux));
            aux = aux.hermano;
        }

        return maxGrade;
    }

    public static void main(String[] args) {
        NodoGeneral n = new NodoGeneral(1);
        ArbolGeneral a = new ArbolGeneral(n);
        n = new NodoGeneral(2);
        ArbolGeneral b = new ArbolGeneral(n);
        n = new NodoGeneral(3);
        ArbolGeneral c = new ArbolGeneral(n);
        n = new NodoGeneral(4);
        ArbolGeneral d = new ArbolGeneral(n);
        ArbolGeneral e = new ArbolGeneral(new NodoGeneral(5));
        ArbolGeneral f = new ArbolGeneral(new NodoGeneral(6));
        ArbolGeneral g = new ArbolGeneral(new NodoGeneral(7));
        ArbolGeneral h = new ArbolGeneral(new NodoGeneral(8));
        ArbolGeneral i = new ArbolGeneral(new NodoGeneral(9));
        try {
            a.añadirHijo(c.raiz());            // 1 -> 3
            a.añadirHijo(b.raiz());            // 1 -> 3, 2

            c.añadirHijo(new NodoGeneral(10)); // 3 -> 10
            c.añadirHijo(new NodoGeneral(11)); // 3 -> 10, 11

            b.añadirHijo(d.raiz());            // 2 -> 4
            b.añadirHijo(f.raiz());            // 2 -> 4, 6
            b.añadirHijo(g.raiz());            // 2 -> 4, 6, 7
            b.añadirHijo(h.raiz());            // 2 -> 4, 6, 7, 8
            b.añadirHijo(i.raiz());            // 2 -> 4, 6, 7, 8, 9

            e.añadirHijo(a.raiz());            // 5 -> 1


            System.out.println("arbol");
            e.pintaArbol(0);

            System.out.println("El grado del arbol es: " + e.gradoArbol());
            //e.eliminar(c);
            //e.pintaArbol(0);

        } catch (Exception exc) {
        }

    }
}
