/**
 * Created by student on 2018-05-17.
 */
public class Main {
    public static void main(String[] args){
        /*int x1 = MOperation.ReadManually();
        int y1 = MOperation.ReadManually();
        Matrix m1 = new Matrix(x1, y1);
        m1.ReadMatrixManually();
        x1 = MOperation.ReadManually();
        y1 = MOperation.ReadManually();
        Matrix m2 = new Matrix(x1,y1);
        m2.ReadMatrixManually();
        m1 = MOperation.MultMatrix(m1,m2);
        m1.PrintMatrix();
        System.out.println("Det = " + m1.Det(m1, m1.N));

        Matrix m1 = new Matrix();

        Matrix m2 = new Matrix(4, 4);
        m1.PrintMatrix();

        System.out.println("\n");

        m2 = MOperation.Trans(m1);
        m2.PrintMatrix();

        System.out.println("\n");

        m2 = MOperation.Inv(m1);
        m2.PrintMatrix();*/

        Matrix m1 = new Matrix();
        Matrix fac = new Matrix(3, 1);
        fac.ReadMatrixManually();

        MOperation.GaussianElimination(m1, fac);
        MOperation.Cramer(m1, fac);




    }
}
