public class Ex6_6 {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {2, 9},
                {0, 9}
        };

        int[][] matrix2 = {
                {2, 0},
                {0, 4}
        };

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Lỗi: Không thể thực hiện cộng hai ma trận có kích thước khác nhau.");
        } else {
            System.out.println("Ma trận 1:");
            printMatrix(matrix1);

            System.out.println("Ma trận 2:");
            printMatrix(matrix2);

            int[][] sumMatrix = addMatrices(matrix1, matrix2);
            System.out.println("Kết quả của phép cộng ma trận:");
            printMatrix(sumMatrix);
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
