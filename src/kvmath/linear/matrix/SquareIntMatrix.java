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
public class SquareIntMatrix extends IntMatrix implements SquareMatrix<SquareIntMatrix> {

    public SquareIntMatrix(int side) {
        super(side, side);
    }

    public SquareIntMatrix(int[][] mat) {
        super(mat);
        if (this.getWidth() != this.getHeight()) {
            throw new MatrixSizeException("Input array is not square.");
        }
    }

    public SquareIntMatrix(Matrix mat) {
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
        int det = 0;
        int sign = 1;
        SquareIntMatrix tmp;
        for (int i = 0; i < n; ++i) {
            tmp = this.getCofactor(0, i, n);
            det += (int) sign * this.m[0][i] * tmp.determinant(n - 1).intValue();
        }
        return det;
    }

    @Override
    public SquareIntMatrix inverse() {
        return new SquareIntMatrix(this.adjoint().div(this.determinant().intValue()));
    }

    @Override
    public SquareIntMatrix getBase() {
        return this;
    }

    @Override
    public SquareIntMatrix adjoint() {
        int sign;
        SquareIntMatrix tmp, adj = new SquareIntMatrix(this.clone());
        for (int i = 0; i < this.getSize(); ++i) {
            for (int j = 0; j < this.getSize(); ++j) {
                tmp = getCofactor(i, j, this.getSize());
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj.m[j][i] = (int) sign * tmp.determinant(this.getSize() - 1).intValue();
            }
        }
        return adj;
    }

    @Override
    public SquareIntMatrix copy() {
        return new SquareIntMatrix(this);
    }
}
