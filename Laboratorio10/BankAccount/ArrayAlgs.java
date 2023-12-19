public class ArrayAlgs
{
   public static void mergeSort(BankAccount[] arr)
   {
      if (arr.length == 1 || arr == null)
         return;
         
      int mid = arr.length / 2;
      BankAccount []sx = new BankAccount[mid];
      BankAccount []dx = new BankAccount[arr.length - mid];
      System.arraycopy(arr, 0, sx, 0, sx.length);
      System.arraycopy(arr, mid, dx, 0,dx.length);
      
      mergeSort(sx);
      mergeSort(dx);
      
      merge(arr, sx, dx);
   }
   
   private static void merge(BankAccount[] src, BankAccount[] sx, BankAccount[] dx)
   {
      int srcI = 0, sxI = 0, dxI = 0;
      
      while(sxI < sx.length && dxI < dx.length)
      {
         if (dx[dxI].compareTo(sx[sxI]) == 1)
            src[srcI++] = sx[sxI++];
         else
            src[srcI++] = dx[dxI++];
      }
      
      while(sxI < sx.length)
      {
         src[srcI++] = sx[sxI++];
      }
      
      while(dxI < dx.length)
      {
         src[srcI++] = dx[dxI++];
      }
   }
   
   public static void selectionSort(BankAccount[] a)
   {
      for (int i = 0; i < a.length; i++)
      {
         int min = findMinPos(a, i);
         
         if (min != i)
            swap(a, min, i);
      }
   }
   
   private static int findMinPos(BankAccount[] a, int from)
   {
      int minPos = from;
      for (int i = from + 1; i < a.length; i++)
      {
         if (a[i].compareTo(a[minPos]) == -1)
            minPos = i;
      }
      
      return minPos;
   }
   
   public static void swap(BankAccount[] a, int src, int dest)
   {
      BankAccount tmp = a[dest];
      a[dest] = a[src];
      a[src] = tmp;
   }
   
   public static void insertionSort(BankAccount[] a)
   {
      for (int i = 1; i < a.length; i++)
      {
         for (int j = i - 1; j >= 0; j--)
         {
            if (a[j].compareTo(a[j+1]) == 1)
               swap(a, j, j+1);
            else
               break;
         }
      }
   }
   
   
   
   
   
   
   
   
   
}
