/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

/**
 *
 * @author callum
 * @param <T> The class implementing the SquareMatrix interface.
 */
public interface SquareMatrix<T extends Matrix> {

    public Number determinant(int n);

    public T adjoint();

    public T getBase();

    public T copy();

    public T inverse();

    public default int getSize() {
        if (!this.getBase().isSquare()) {
            throw new MatrixSizeException("Square matrix data is not square.");
        }
        return this.getBase().getHeight();
    }

    public default Number discriminant() {
        return this.determinant();
    }

    public default T getCofactor(int p, int q, int n) {
        T ret = this.copy();
        int i = 0, j = 0;
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if (row != p && col != q) {
                    ret.setNumberValue(j, i, this.getBase().getNumberValue(col, row));
                    if (++j == n - 1) {
                        j = 0;
                        ++i;
                    }
                }
            }
        }
        return ret;
    }

    public default Number determinant() {
        return this.determinant(this.getSize());
    }

    public default DoubleMatrix toSuqareDoubleMatrix() {
        return new SquareDoubleMatrix(this.getBase());
    }

    public default SquareLongMatrix toSquareLongMatrix() {
        return new SquareLongMatrix(this.getBase());
    }

    public default SquareIntMatrix toSquareIntMatrix() {
        return new SquareIntMatrix(this.getBase());
    }

    public default SquareFloatMatrix toSquareFloatMatrix() {
        return new SquareFloatMatrix(this.getBase());
    }

}
