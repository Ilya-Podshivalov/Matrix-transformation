import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.lang.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix {
    public static class MemberComparator implements Comparator<Double> {
        public int compare(Double a, Double b) {
            if (a.equals(b)) return 0;
            else if (a > b) return -1;
            else return 1;
        }
    }

    public static boolean MatrEquals(Double[][] mass1, Double[][] mass2, int n) {
        boolean flag = false;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < n; k++) {
                Double tmp;
                for (int j1 = k; j1 < n; j1++) {
                    tmp = mass2[k][j1];
                    mass2[k][j1] = mass2[j1][k];
                    mass2[j1][k] = tmp;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (Arrays.equals(mass1[i], mass2[i])) count++;
            }
            if (count == n) flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        DecimalFormat decimalFormat2 = (DecimalFormat) NumberFormat.getCurrencyInstance();
        MemberComparator comparer = new MemberComparator();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Double[][] matr = new Double[n][n];
        Double[][] matr2 = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] = (Double) (Math.random()) * (int) (Math.random() * 10);
            }
        }

        Arrays.sort(matr[n - 1], comparer);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr2[i][j] = (Double) (Math.random()) * (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(decimalFormat2.format(matr[i][j]) + " ");
            }
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print (matr2[i][j] + " ");
            }
        }

        System.out.println(" ");
        System.out.println("///////////////////");

        ///////////
        Double[][] matr3 = new Double[n][n];
        for (int i = 0; i < n; i++) {
            matr3[i] = Arrays.copyOf(matr2[i], n);
        }
        for (int k = 0; k < n; k++) {
            Double tmp;
            for (int j1 = k; j1 < n; j1++) {
                tmp = matr2[k][j1];
                matr2[k][j1] = matr2[j1][k];
                matr2[j1][k] = tmp;
            }
        }
        System.out.println(MatrEquals(matr3, matr2, n));
        System.out.println(MatrEquals(matr, matr2, n));

        int[][] matrSearch = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrSearch[i][j] = 3;
            }
        }
        System.out.println(Arrays.binarySearch(matrSearch[0], 3) + " " + Arrays.binarySearch(matrSearch[1], 2));
    }
}