import java.util.Scanner;

public class Ex6_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n= ");
        int n = input.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập : ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        /* Before sort */
        System.out.println("Array trước khi sort");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array sau khi sort");
        /* After sort */
        printArray(arr);

        int sum= sumArr(arr);
        System.out.println("Tổng giá trị các phần tử của mảng là: "+ sum);

        double avg= avgArr(arr);
        System.out.println("Giá trị trung bình của mảng là: "+avg);

        input.close();
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pi = parti(arr, l, h);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, h);
        }
    }

    public static int parti(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = (l - 1);

        for (int j = l; j < h; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        return i + 1;
    }

    public static int sumArr(int[] arr){
        int sum=0;
        for(int num:arr) sum +=num;
        return sum;
    }
    public static double avgArr(int[] arr){
        int sum = sumArr(arr);
        double avg = (double)sum/arr.length;
        return avg;
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
