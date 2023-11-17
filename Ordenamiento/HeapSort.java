package Ordenamiento;

public class HeapSort {
  public static void heapSort (int arr[]) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }
    
    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, i, 0);
      System.out.println();
    }
  }

  private static void heapify(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
      largest = l;
    if (r < n && arr[r] > arr[largest])
      largest = r;
    
    System.out.println("Heapify en elemento " + arr[i] + " con " + arr[largest]);
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest ];
      arr[largest] = swap;
      heapify(arr, n, largest);
    }
    System.out.println("Arreglo heapify: " + java.util.Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int arr[] = { 12, 11, 13, 5, 6, 7, 100, -1, 63 };
    System.out.println("Arreglo origina: " + java.util.Arrays.toString(arr));
    heapSort(arr);
    System.out.println("Arreglo ordenado: " + java.util.Arrays.toString(arr));
  }
}