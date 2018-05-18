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


    public static Matrix Add(Matrix m1, Matrix m2){
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
        if (m1.M != m2.N ) {
            System.out.println("Error - mnozenie macierzy: Wymiary macierzy nie zgadzaja sie");
            System.exit(1);
        }

        Matrix result = new Matrix(m1.M, m1.M);

        for (int i = 0; i < m1.N; i++) {
            for (int j = 0; j < m1.N; j++) {
                result.tab[i][j]=0;
                for(int k=0; k<m1.M; k++){
                    result.tab[i][j] = result.tab[i][j] + (m1.tab[i][k] * m2.tab[k][j]);
                }

            }
        }

        return result;
    }

    public static Matrix MultMatrix(Matrix m1, Matrix m2){
        return m1;
    }

    public static Matrix MultScalar(Matrix m1, double a){

        Matrix result = new Matrix(m1.M, m1.N);

        for (int i = 0; i < m1.M; i++) {
            for (int j = 0; j < m1.N; j++) {
                result.tab[i][j] = m1.tab[i][j] * a;
            }
        }
        return result;
    }



}
