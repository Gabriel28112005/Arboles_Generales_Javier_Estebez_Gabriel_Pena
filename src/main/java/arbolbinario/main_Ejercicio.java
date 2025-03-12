package arbolbinario;



public class main_Ejercicio {

    public static void main(String... args){

        //Altura --> El método recibirá como parámetro de entrada un árbol binario y devolverá la altura del mismo.
        //numeroNodos --> El método recibirá como parámetro de entrada un árbol binario y devolverá el número de nodos que tiene.


        ArbolBinario<Integer> arbolA = new ArbolBinario(new NodoBinario<Integer>(1));
        ArbolBinario<Integer> arbolB = new ArbolBinario(new NodoBinario<Integer>(2));
        ArbolBinario<Integer> arbolC = new ArbolBinario(new NodoBinario<Integer>(3));
        ArbolBinario<Integer> arbolD = new ArbolBinario(new NodoBinario<Integer>(4));
        ArbolBinario<Integer> arbolE = new ArbolBinario(new NodoBinario<Integer>(5));
        ArbolBinario<Integer> arbolF = new ArbolBinario(new NodoBinario<Integer>(6));
        ArbolBinario<Integer> arbolG = new ArbolBinario(new NodoBinario<Integer>(7));


        try{

            NumeroNodos(arbolA);




        }catch (Exception e){
            System.out.print("Error génerico en main");
        }






    } //Fin del public static void main


    public static void Altura(ArbolBinario<String> arbol){

        if(arbol.raiz!=null){

            try{
                Altura(arbol.hijoDer());
                Altura(arbol.hijoIzq());



            }catch (Exception e){
                System.out.print("Error de altura");
            } //Fin del try-catch

        } //Fin del condicional de la función

    } //Fin del public static void Altura



    public static void NumeroNodos(NodoBinario<Integer> nodo){

        if (nodo.dato != null){

            try{
                int altura = 1 + nodo.izq + nodo.der;

            }catch (Exception e){
                System.out.print("Error de número de nodos");
            }

        }



    } //Fin del public static void NumeroNodos

} //Fin del public class arbolbinario.main_Ejercicio