import java.util.*;

public class MergeSort {
    public static void main(String[] args) throws Exception {
    //Declaração do vetor:
        int []num = new int[8];
        int []v = new int[num.length]; // vetor auxiliar 

    //Preenchendo o vetor com entrada pelo usuario:
       Scanner scan = new Scanner(System.in);

        System.out.println("Digite até 8 números aleatórios: ");

            for(int imprimir =0; imprimir < num.length; imprimir ++){
                System.out.print((imprimir +1)+ "º num: " + " ");
                num [imprimir] = scan.nextInt();
            }         
    //Imprimindo o vetor não ordenado        
            System.out.print("Vetor não ordenado: ");
            for (int n : num) System.out.print(n + " ");

    //Imprimindo o vetor ordenado      
         mergeSort(num, v,0, num.length-1);
            System.out.println("\nVetor ordenado: " + Arrays.toString(num));            
    }

    private static void mergeSort(int[]num, int[]v, int inicio, int fim) {
        if (inicio < fim){
            int meio = (inicio + fim) /2; //achando o meio do vetor 
            mergeSort(num, v, inicio, meio);
            mergeSort(num, v, meio+1, fim);
            intercalar(num,v, inicio, meio, fim);
        }
    }
   private static void intercalar(int[] num, int[] v, int inicio, int meio, int fim) {
    // Copia para o vetor auxiliar
    for (int i = inicio; i <= fim; i++) {
        v[i] = num[i];
    }

    int indEsquerda = inicio; // Inicio da primeira parte
    int indDireita = meio + 1; // Inicio da segunda parte 
    int indAtual = inicio; //Indice a ser inserido no vetor 

    // Intercala de volta para o vetor original
    while (indEsquerda <= meio && indDireita <= fim) {
        if (v[indEsquerda] <= v[indDireita]) {
            num[indAtual] = v[indEsquerda];
            indEsquerda++;
        } else {
            num[indAtual] = v[indDireita];
            indDireita++;
        }
        indAtual++;
    }

    // Copia o restante da primeira metade (se sobrou)
    while (indEsquerda <= meio) {
        num[indAtual] = v[indEsquerda];
        indEsquerda++;
        indAtual++;
    }

    // A segunda metade já está no lugar, não precisa copiar
    }
}
