/**
 * Created by student on 2018-05-17.
 */
public interface MatrixInterface {
//    int Rank();
//    MatrixInterface Trans();
//    MatrixInterface Rev();
    MatrixInterface Compl(Matrix m);
    MatrixInterface Complement(Matrix m, int i, int j);
    double Det(Matrix m, int size);
//    MatrixInterface Cramer();
//    MatrixInterface Gauss();
    void PrintMatrix();
    void ReadMatrixManually();
//    void ReadMatrixFromFile();
}
