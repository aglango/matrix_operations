import java.util.Scanner;
import java.util.Random;

public class Matrix {
    int M; // col
    int N; // row
    double[][] tab;

    public Matrix() // default
    {
        M = 3;
        N = 3;
        tab = new double[3][3];
    }

    public Matrix(int m, int n) { // jakakolwiek
        M = m;
        N = n;
        tab = new double[m][n];
    }

    public Matrix(int size) // kwadratowa
    {
        M = size;
        N = size;
        tab = new double[M][N];
    }

    public void PrintMatrix() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%.2f ", this.tab[i][j]);
            }
            System.out.println();
        }
    }

    public void ReadMatrixManually() {
        System.out.println("Filling matrix: Give " + M*N + " numbers (reading by rows -  " + N + " numbers for " + M + " columns)");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tab[i][j] = in.nextDouble();
            }
        }
    }


    public void ReadRandomMatrix() {
        Random rand = new Random();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tab[i][j] = rand.nextInt(40) - 20;
            }
        }
    }



}
