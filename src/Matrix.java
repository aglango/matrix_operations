import java.util.Scanner;


public class Matrix {//implements MatrixInterface{
    int M; // col
    int N; // row
    double[][] tab = {{2, 1, -1}, {-3, -1, 2}, {-2, 1, 2}}; // po = też mozna usunac i zostawic samo tab;

    public Matrix() // to jest domyslna macierz, mozna to raczej usunac
    {
        M = 3;
        N = 3;
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
                System.out.printf("%.2f", this.tab[i][j]);
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

    // Mozna jeszcze dolozyc funkcje, ktora uzupelnia macierz MxN losowymi liczbami.




}
