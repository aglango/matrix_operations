import java.util.Scanner;

/**
 * Created by student on 2018-05-17.
 */
public class MOperation {


    //sprawdzic czy rozmiar sie zgadza, jak nie to błąd
    public static int ReadManually() {
        System.out.println("Rozmiar macierzy: Podaj wymiar macierzy");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        return x;
    }

    public static Matrix Add(Matrix m1, Matrix m2) {
        if (m1.N != m2.N || m1.M != m2.M) {
            System.out.println("Error - dodawanie macierzy: Wymiary macierzy nie zgadzaja sie");
            System.exit(1);
        }

        Matrix result = new Matrix(m1.M, m1.N);

        for (int i = 0; i < m1.M; i++) {
            for (int j = 0; j < m1.N; j++) {
                result.tab[i][j] = m1.tab[i][j] + m2.tab[i][j];
            }
        }

        return result;
    }

    public static Matrix Sub(Matrix m1, Matrix m2) {
        if (m1.M != m2.N) {
            System.out.println("Error - mnozenie macierzy: Wymiary macierzy nie zgadzaja sie");
            System.exit(1);
        }

        Matrix result = new Matrix(m1.M, m1.M);

        for (int i = 0; i < m1.N; i++) {
            for (int j = 0; j < m1.N; j++) {
                result.tab[i][j] = 0;
                for (int k = 0; k < m1.M; k++) {
                    result.tab[i][j] = result.tab[i][j] + (m1.tab[i][k] * m2.tab[k][j]);
                }

            }
        }

        return result;
    }

    public static Matrix MultMatrix(Matrix m1, Matrix m2) {

        if (m1.M != m2.N) {
            System.out.println("Matrixes cannot be multiplied: invalid matrixes dimensions.");
            System.exit(1);
        }

        Matrix result = new Matrix(m1.N, m2.M);

        for (int i = 0; i < m1.N; i++) {
            for (int j = 0; j < m2.M; j++) {
                for (int k = 0; k < m1.M; k++) {
                    result.tab[i][j] += m1.tab[i][k] * m2.tab[k][j];
                }
            }
        }

        return result;
    }

    public static Matrix MultScalar(Matrix m1, double a) {

        Matrix result = new Matrix(m1.M, m1.N);

        for (int i = 0; i < m1.M; i++) {
            for (int j = 0; j < m1.N; j++) {
                result.tab[i][j] = m1.tab[i][j] * a;
            }
        }
        return result;
    }

    public static Matrix Trans(Matrix m1) {
        Matrix result = new Matrix(m1.N, m1.M);
        double helper = 0;

        for (int i = 0; i < m1.N; i++) {
            for (int j = 0; j < m1.M; j++) {
                result.tab[i][j] = m1.tab[j][i];
            }
        }

        return result;
    }

    public static Matrix Inv(Matrix m1) {
        if (!IsSquareMatrix(m1)) {
            System.exit(1);
        }

        Matrix result = Trans(Compl(m1));

        double det = Det(m1, m1.N);

        for (int i = 0; i < m1.N; i++) {
            for (int j = 0; j < m1.M; j++) {
                result.tab[i][j] /= det;
            }
        }

        return result;
    }


    public static Matrix Compl(Matrix m) { // obliczanie macierzy dopelnien
        Matrix result = new Matrix(m.M, m.N);

        for (int k = 0; k < m.N; k++) {
            int coef = 1;

            if (k % 2 == 1) {
                coef = -1;
            }

            for (int l = 0; l < m.M; l++) {
                result.tab[k][l] = coef * Det(Complement(m, k, l), m.M - 1);
            }
        }

        return result;
    }

    public static Matrix Complement(Matrix m, int i, int j) {
        Matrix helper = new Matrix(m.M - 1, m.N - 1);
        int row = 0;

        for (int k = 0; k < m.N; k++) {
            if (k == i) continue;

            int col = 0;

            for (int l = 0; l < m.M; l++) {
                if (l == j) continue;
                helper.tab[row][col++] = m.tab[k][l];
            }

            row++;
        }

        return helper;
    }

    public static boolean IsSquareMatrix(Matrix m1) {
        if (m1.M != m1.N) {
            System.out.println("Operation is only allowed for square matrixes.");
            return false;
        }

        return true;
    }

    public static double Det(Matrix m, int size) { // obliczanie wyznacznika rekurencyjnie metodą laplace'a
        if (!IsSquareMatrix(m)) {
            System.exit(1);
        }

        if (size == 1) {
            return m.tab[0][0];
        }

        if (size == 2) {
            return m.tab[0][0] * m.tab[1][1] - m.tab[1][0] * m.tab[0][1];
        }

        int znak = 1; // do macierzy dopełnień
        double det = 0; // wartość wyznacznika

        for (int i = 0; i < size; i++) {
            det += znak * m.tab[0][i] * Det(Complement(m, 0, i), m.N - 1);
            znak = -znak;
        }

        return det;
    }

    public static double[] Cramer(Matrix m1, Matrix factors) {
        if (m1.M != factors.M) {
            System.out.println("The number of uknowns differs from the number of equations. This system of equations is unsolvable with Cramer method.");
            System.exit(1);
        }

        double W = Det(m1, m1.N);

        if (W == 0) {
            System.out.println("Main determent equals zero. This system of equations is unsolvable with Cramer method.");
            System.exit(1);
        }

        double[] results = new double[factors.M];
        Matrix helper = new Matrix(m1.M, m1.N);

        System.out.println("\nResults: ");

        for (int k = 0; k < m1.M; k++) {
            for (int i = 0; i < m1.M; i++) {
                for (int j = 0; j < m1.N; j++) {
                    if (j == k)
                    {
                        helper.tab[i][j] = factors.tab[i][0];
                    }
                    else
                    {
                        helper.tab[i][j] = m1.tab[i][j];
                    }
                }
            }
            results[k] = Det(helper, helper.M) / W;
            System.out.printf("%d: %.2f\n", (k + 1), results[k]);
        }

        return results;
    }

    public static double[] GaussianElimination(Matrix m1, Matrix factors) // With partial pivoting. Source: https://www.youtube.com/watch?v=6p-a7ZoGk18&t=128s
    {
        int pivotRow;
        // Forward Elimination
        for (int i = 0; i < m1.M; i++)
        {
            pivotRow = i;
            // Algorithm is looking for the biggest number in every row.
            for (int j = i + 1; j < m1.M; j++) {
                if (Math.abs(m1.tab[j][i]) > Math.abs(m1.tab[pivotRow][i])) {
                    pivotRow = j;
                }
            }

            // Swapping rows in order to get pivot on the diagonal.
            if (pivotRow != i) {
                for (int k = 0; k < m1.N; k++){
                    double helper = m1.tab[i][k];
                    m1.tab[i][k] = m1.tab[pivotRow][k];
                    m1.tab[pivotRow][k] = helper;
                }

                double helper = factors.tab[i][0];
                factors.tab[i][0] = factors.tab[pivotRow][0];
                factors.tab[pivotRow][0] = helper;
                }

            // Zeroing rows under diagonal (column i).
            for (int j = i + 1; j < m1.M; j++){
                double multiplier = m1.tab[j][i] / m1.tab[i][i];

                for (int k = i; k < m1.M; k++)
                {
                    m1.tab[j][k] -= multiplier * m1.tab[i][k];
                }

                factors.tab[j][0] -= multiplier * factors.tab[i][0];
            }
        }

        m1.PrintMatrix();

        // Back substitution.
        System.out.println("\nResults: ");
        double[] results = new double[m1.M];

        for (int i = m1.M - 1; i >= 0; i--)
        {
            double helper = 0;

            for (int j = i + 1; j < m1.M; j++)
            {
                helper += m1.tab[i][j] * results[j];
            }

            results[i] = (factors.tab[i][0] - helper) / m1.tab[i][i];
            System.out.printf("%d: %.2f\n", (i + 1), results[i]);
        }

        return results;
    }
}
