/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

/**
 *
 * @author callum
 */
public class SquareDoubleMatrix extends DoubleMatrix implements SquareMatrix<SquareDoubleMatrix> {

    public SquareDoubleMatrix(int side) {
        super(side, side);
    }

    public SquareDoubleMatrix(double[][] mat) {
        super(mat);
        if (this.getWidth() != this.getHeight()) {
            throw new MatrixSizeException("Input array is not square.");
        }
    }

    public SquareDoubleMatrix(Matrix mat) {
        super(mat);
        if (mat.getWidth() != mat.getHeight()) {
            throw new MatrixSizeException("Input matrix is not square.");
        }
    }

    @Override
    public Number determinant(int n) {
        if (n == 1) {
            return this.m[0][0];
        }
        double det = 0;
        int sign = 1;
        SquareDoubleMatrix tmp;
        for (int i = 0; i < n; ++i) {
            tmp = this.getCofactor(0, i, n);
            det += (double) sign * this.m[0][i] * tmp.determinant(n - 1).doubleValue();
        }
        return det;
    }

    @Override
    public SquareDoubleMatrix inverse() {
        return new SquareDoubleMatrix(this.adjoint().div(this.determinant().doubleValue()));
    }

    @Override
    public SquareDoubleMatrix getBase() {
        return this;
    }

    @Override
    public SquareDoubleMatrix adjoint() {
        int sign;
        SquareDoubleMatrix tmp, adj = new SquareDoubleMatrix(this.clone());
        for (int i = 0; i < this.getSize(); ++i) {
            for (int j = 0; j < this.getSize(); ++j) {
                tmp = getCofactor(i, j, this.getSize());
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj.m[j][i] = (double) sign * tmp.determinant(this.getSize() - 1).doubleValue();
            }
        }
        return adj;
    }

    @Override
    public SquareDoubleMatrix copy() {
        return new SquareDoubleMatrix(this);
    }
}
