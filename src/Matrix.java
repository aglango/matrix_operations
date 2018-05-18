import java.util.Scanner;


public class Matrix implements MatrixInterface{
    int M;
    int N;
    double[][] tab;

    public Matrix(int m, int n) {
        M = m;
        N = n;
        tab = new double[m][n];
    }

    public void PrintMatrix() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(this.tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void ReadMatrixManually() {
        System.out.println("Uzupelnianie macierzy: Podaj " + M*N + " liczb (wczytywanie wierszami - po " + N + " liczb na każdy wiersz)");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tab[i][j] = in.nextDouble();
            }
        }
    }


    public Matrix Compl(Matrix m) { // obliczanie macierzy dopelnien
        for (int i = 0; i < m.N; i++) {
            System.out.print(' ');
        }
        return m;
    }

    public Matrix Complement(Matrix m, int i, int j) {
        Matrix helper = new Matrix(m.M - 1, m.N - 1);
        int col = 0;
        int row = 0;
        for (int k = 0; i < m.N; i++) {
            if (k == i) continue;

            for (int l = 0; l < m.N; l++) {
                if (l == j) continue;
                helper.tab[row][col] = m.tab[k][l];
            }
        }
        return helper;
    }

    public double Det(Matrix m, int size) { // obliczanie wyznacznika rekurencyjnie metodą laplace'a
        if (M != N) {
            System.out.println("Error - Wyznacznik macierzy: macierz nie jest macierza kwadratowa");
            System.exit(1);
        }
        if (M == 1)
        {
            return tab[0][0];
        }

        if (N == 2)
        {
            return tab[0][0] * tab[1][1] - tab[1][0] * tab[0][1];
        }

        int znak = 1; // do macierzy dopełnień
        double det = 0; // wartość wyznacznika

        for (int i = 0; i < size; i++)
        {
            det += znak * m.tab[0][i] * Det(Complement(m, 0, i), m.N - 1);
            znak = -znak;
        }
        return det;

    }

}
