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
public class SquareLongMatrix extends LongMatrix implements SquareMatrix<SquareLongMatrix> {

    public SquareLongMatrix(int side) {
        super(side, side);
    }

    public SquareLongMatrix(long[][] mat) {
        super(mat);
        if (this.getWidth() != this.getHeight()) {
            throw new MatrixSizeException("Input array is not square.");
        }
    }

    public SquareLongMatrix(Matrix mat) {
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
        long det = 0;
        int sign = 1;
        SquareLongMatrix tmp;
        for (int i = 0; i < n; ++i) {
            tmp = this.getCofactor(0, i, n);
            det += (long) sign * this.m[0][i] * tmp.determinant(n - 1).longValue();
        }
        return det;
    }

    @Override
    public SquareLongMatrix inverse() {
        return new SquareLongMatrix(this.adjoint().div(this.determinant().longValue()));
    }

    @Override
    public SquareLongMatrix getBase() {
        return this;
    }

    @Override
    public SquareLongMatrix adjoint() {
        int sign;
        SquareLongMatrix tmp, adj = new SquareLongMatrix(this.clone());
        for (int i = 0; i < this.getSize(); ++i) {
            for (int j = 0; j < this.getSize(); ++j) {
                tmp = getCofactor(i, j, this.getSize());
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj.m[j][i] = (long) sign * tmp.determinant(this.getSize() - 1).longValue();
            }
        }
        return adj;
    }

    @Override
    public SquareLongMatrix copy() {
        return new SquareLongMatrix(this);
    }
}
