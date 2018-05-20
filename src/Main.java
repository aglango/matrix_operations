import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner option = new Scanner(System.in);
        int action = -1;
        while (action != 0) {
            System.out.print("Welcome to best matrix calculator ever made. What do you want to do?\n" +
                    "1. Add matrices\n" +
                    "2. Subtract matrices\n" +
                    "3. Multiple matrices\n" +
                    "4. Multiple matrix by a scalar\n" +
                    "5. Count determinant\n" +
                    "6. Count inverted Matrix\n" +
                    "7. Solve system of equalization\n" +
                    "0. Exit this awesome application\n");
            action = option.nextInt();
            if (action == 0) {
                System.exit(0);
            }
            int m, n, num, opt;
            double[] result;
            Matrix m1, m2;
            switch (action) {
                case 1:
                    System.out.println("Type matrix dimensions: ");
                    m = option.nextInt();
                    n = option.nextInt();
                    m1 = new Matrix(m, n);
                    m1.ReadMatrixManually();
                    m2 = new Matrix(m, n);
                    m2.ReadMatrixManually();
                    m1 = MOperation.Add(m1, m2);
                    System.out.println("Result:");
                    m1.PrintMatrix();
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 2:
                    System.out.println("Type matrix dimensions: ");
                    m = option.nextInt();
                    n = option.nextInt();
                    m1 = new Matrix(m, n);
                    m1.ReadMatrixManually();
                    m2 = new Matrix(m, n);
                    m2.ReadMatrixManually();
                    m1 = MOperation.Sub(m1, m2);
                    System.out.println("Result:");
                    m1.PrintMatrix();
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 3:
                    System.out.println("Type matrix dimensions: ");
                    m = option.nextInt();
                    n = option.nextInt();
                    m1 = new Matrix(m, n);
                    m1.ReadMatrixManually();
                    m2 = new Matrix(m, n);
                    m2.ReadMatrixManually();
                    m1 = MOperation.MultMatrix(m1, m2);
                    System.out.println("Result:");
                    m1.PrintMatrix();
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 4:
                    System.out.println("Type matrix dimensions: ");
                    m = option.nextInt();
                    n = option.nextInt();
                    m1 = new Matrix(m, n);
                    m1.ReadMatrixManually();
                    System.out.println("Type scalar value: ");
                    num = option.nextInt();
                    m1 = MOperation.MultScalar(m1, num);
                    System.out.println("Result:");
                    m1.PrintMatrix();
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 5:
                    System.out.println("Type matrix dimension: ");
                    m = option.nextInt();
                    m1 = new Matrix(m);
                    m1.ReadMatrixManually();
                    System.out.println("Result: \n" + MOperation.Det(m1, m));
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 6:
                    System.out.println("Type matrix dimension: ");
                    m = option.nextInt();
                    m1 = new Matrix(m);
                    m1.ReadMatrixManually();
                    m1 = MOperation.Inv(m1);
                    System.out.println("Result: \n");
                    m1.PrintMatrix();
                    System.out.println("Press enter to continue");
                    try {
                        System.in.read();
                    } catch (IOException ex) { }
                    break;
                case 7:
                    System.out.print("Which method do you prefer?\n" +
                            "1. Cramer\n" +
                            "2. Gauss\n" +
                            "3. Inversed matrix\n");
                    opt = option.nextInt();
                    System.out.println("Type matrix dimension: ");
                    m = option.nextInt();
                    m1 = new Matrix(m);
                    m1.ReadMatrixManually();
                    m2 = new Matrix(m, 1);
                    m2.ReadMatrixManually();
                    result = new double[m];
                    switch (opt) {
                        case 1:
                            result = MOperation.Cramer(m1, m2);
                            System.out.println("Results: \n");
                            for (int i = 0; i < m; i++) {
                                System.out.println(result[i]);
                            }
                            System.out.println("Press enter to continue");
                            try {
                                System.in.read();
                            } catch (IOException ex) { }
                            break;
                        case 2:
                            result = MOperation.GaussianElimination(m1, m2);
                            System.out.println("Results: \n");
                            for (int i = 0; i < m; i++) {
                                System.out.println(result[i]);
                            }
                            System.out.println("Press enter to continue");
                            try {
                                System.in.read();
                            } catch (IOException ex) { }
                            break;
                        case 3:
                            result = MOperation.SolveSystemOfEquations(m1, m2);
                            System.out.println("Results: \n");
                            for (int i = 0; i < m; i++) {
                                System.out.println(result[i]);
                            }
                            System.out.println("Press enter to continue");
                            try {
                                System.in.read();
                            } catch (IOException ex) { }
                            break;
                        default: continue;
                    }
                    break;
                default:
                    continue;
            }
        }


    }
}
