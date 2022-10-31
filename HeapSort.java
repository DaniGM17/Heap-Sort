import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class HeapSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArreglo(int n) throws IOException {
        int[] a = new int[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Integer.parseInt(entrada);
        }
        return a;
    }
    
    public static void heapSort(int[] listaD){
        int n = listaD.length;
        for(int i=n/2-1; i>=0; i--){
            ordenar(listaD, n, i);
        }
        
        for(int i=n-1; i>=0; i--){
            int m=listaD[0];
            listaD[0]=listaD[i];
            listaD[i] = m;
            
            ordenar(listaD, i, 0);
        }
    }
    
    public static void ordenar(int[] listaD, int n, int i){
        int m=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && listaD[l]>listaD[m]){
            m=l;
        }
        if(r<n && listaD[r]>listaD[m]){
            m=r;
        }
        if(m !=i){
            int mant = listaD[i];
            listaD[i] = listaD[m];
            listaD[m] = mant;
            
            ordenar(listaD, n, m);
        }
    }

    public static void imprimirArreglo(int[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        array = leerArreglo(t);
        int inicio = 0;
        int fin = array.length-1;
        heapSort(array);
        imprimirArreglo(array);
    }
}
