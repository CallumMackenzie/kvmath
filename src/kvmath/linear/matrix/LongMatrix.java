/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.vector.LongVec;
import kvmath.linear.vector.Vector;
import kvmath.utils.ArrayUtils;

/**
 *
 * @author callum
 */
public class LongMatrix implements Matrix<LongMatrix> {

    long[][] m;

    public LongMatrix(int w, int h) {
        this.m = new long[h][w];
    }

    public LongMatrix(long[][] m) {
        this.m = m;
    }

    public LongMatrix(Matrix mat) {
        this(mat.getWidth(), mat.getHeight());
        for (int i = 0; i < mat.getHeight(); ++i) {
            for (int j = 0; j < mat.getWidth(); ++j) {
                this.m[i][j] = mat.getNumberValue(j, i).longValue();
            }
        }
    }

    @Override
    public int getWidth() {
        if (m.length == 0) {
            return 0;
        }
        return m[0].length;
    }

    @Override
    public int getHeight() {
        return m.length;
    }

    @Override
    public Number[][] getNumberValues() {
        Long[][] ret = new Long[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); ++i) {
            for (int j = 0; j < this.getWidth(); ++j) {
                ret[i][j] = (Long) this.m[i][j];
            }
        }
        return ret;
    }

    @Override
    public Number getNumberValue(int w, int h) {
        return (Long) this.m[h][w];
    }

    @Override
    public void setNumberValue(int w, int h, Number val) {
        this.m[h][w] = val.longValue();
    }

    @Override
    public LongMatrix set(LongMatrix nw) {
        this.m = nw.m;
        return this;
    }

    @Override
    public LongMatrix clone() {
        return new LongMatrix(this.m);
    }

    @Override
    public LongMatrix add(LongMatrix... others) {
        LongMatrix ret = this.clone();
        for (var mat : others) {
            if (mat.getHeight() != this.getHeight() || mat.getWidth() != this.getWidth()) {
                throw new MatrixSizeException();
            }
            for (int i = 0; i < ret.getHeight(); ++i) {
                for (int j = 0; j < ret.getWidth(); ++j) {
                    ret.m[i][j] += mat.m[i][j];
                }
            }
        }
        return ret;
    }

    @Override
    public LongMatrix sub(LongMatrix... others) {
        LongMatrix[] neg = new LongMatrix[others.length];
        for (int i = 0; i < neg.length; ++i) {
            neg[i] = others[i].clone().mulEquals(-1);
        }
        return this.add(neg);
    }

    @Override
    public LongMatrix mul(LongMatrix... others) {
        LongMatrix ret = new LongMatrix(others[0].getWidth(), this.getHeight());
        for (var mat : others) {
            if (mat.getWidth() != this.getHeight() || mat.getHeight() != this.getWidth()) {
                throw new MatrixSizeException("Matrix sizes not valid for multiplication.");
            }
            for (int row = 0; row < ret.getHeight(); row++) {
                for (int col = 0; col < ret.getWidth(); col++) {
                    ret.m[row][col] = 0;
                    for (int i = 0; i < mat.getHeight(); i++) {
                        ret.m[row][col] += this.m[row][i] * mat.m[i][col];
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public LongMatrix add(long... others) {
        return MatrixUtils.<LongMatrix>operand(this, others, (l, r) -> l + r);
    }

    @Override
    public LongMatrix add(float... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix add(double... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix add(int... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix sub(long... others) {
        return MatrixUtils.<LongMatrix>operand(this, others, (l, r) -> l - r);
    }

    @Override
    public LongMatrix sub(float... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix sub(double... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix sub(int... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix mul(long... others) {
        return MatrixUtils.<LongMatrix>operand(this, others, (l, r) -> l * r);
    }

    @Override
    public LongMatrix mul(float... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix mul(double... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix mul(int... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix div(long... others) {
        return MatrixUtils.<LongMatrix>operand(this, others, (l, r) -> l / r);
    }

    @Override
    public LongMatrix div(float... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix div(double... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongMatrix div(int... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public int compareTo(LongMatrix arg0) {
        return ((Integer) (this.getWidth() * this.getHeight())).compareTo(arg0.getWidth() * arg0.getHeight());
    }

    @Override
    public Vector getRow(int row) {
        return new LongVec(this.m[row]);
    }

    @Override
    public Vector getColumn(int column) {
        LongVec ret = new LongVec(this.getHeight());
        for (int i = 0; i < this.getHeight(); ++i) {
            ret.setValue(i, this.m[i][column]);
        }
        return ret;
    }

    @Override
    public String toString() {
        return MatrixUtils.matToString(this);
    }

}
