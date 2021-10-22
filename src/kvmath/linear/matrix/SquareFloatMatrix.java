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
public class SquareFloatMatrix extends FloatMatrix implements SquareMatrix<SquareFloatMatrix> {

    public SquareFloatMatrix(int side) {
        super(side, side);
    }

    public SquareFloatMatrix(float[][] mat) {
        super(mat);
        if (this.getWidth() != this.getHeight()) {
            throw new MatrixSizeException("Input array is not square.");
        }
    }

    public SquareFloatMatrix(Matrix mat) {
        super(mat);
        if (mat.getWidth() != mat.getHeight()) {
            throw new MatrixSizeException("Input matrix is not square.");
        }
    }

    @Override
    public Number determinant(int n) {
        if (n == 1) {
            return this.m[0][0];
        } else if (n == 2) {
            return (this.m[0][0] * this.m[1][1]) - (this.m[0][1] * this.m[1][0]);
        }
        float det = 0;
        int sign = 1;
        SquareFloatMatrix tmp;
        for (int i = 0; i < n; ++i) {
            tmp = this.getCofactor(0, i, n);
            det += (float) sign * this.m[0][i] * tmp.determinant(n - 1).floatValue();
        }
        return det;
    }

    @Override
    public SquareFloatMatrix inverse() {
        return new SquareFloatMatrix(this.adjoint().div(this.determinant().floatValue()));
    }

    @Override
    public SquareFloatMatrix getBase() {
        return this;
    }

    @Override
    public SquareFloatMatrix adjoint() {
        int sign;
        SquareFloatMatrix tmp, adj = new SquareFloatMatrix(this.clone());
        for (int i = 0; i < this.getSize(); ++i) {
            for (int j = 0; j < this.getSize(); ++j) {
                tmp = getCofactor(i, j, this.getSize());
                sign = ((i + j) % 2 == 0) ? 1 : -1;
                adj.m[j][i] = (float) sign * tmp.determinant(this.getSize() - 1).floatValue();
            }
        }
        return adj;
    }

    @Override
    public SquareFloatMatrix copy() {
        return new SquareFloatMatrix(this);
    }
}
