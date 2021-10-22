/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.vector.IntVec;
import kvmath.linear.vector.Vector;
import kvmath.utils.ArrayUtils;

/**
 *
 * @author callum
 */
public class IntMatrix implements Matrix<IntMatrix> {

    int[][] m;

    public IntMatrix(int w, int h) {
        this.m = new int[h][w];
    }

    public IntMatrix(int[][] m) {
        this.m = m;
    }

    public IntMatrix(Matrix mat) {
        this(mat.getWidth(), mat.getHeight());
        for (int i = 0; i < mat.getHeight(); ++i) {
            for (int j = 0; j < mat.getWidth(); ++j) {
                this.m[i][j] = mat.getNumberValue(j, i).intValue();
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
        Integer[][] ret = new Integer[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); ++i) {
            for (int j = 0; j < this.getWidth(); ++j) {
                ret[i][j] = (Integer) this.m[i][j];
            }
        }
        return ret;
    }

    @Override
    public Number getNumberValue(int w, int h) {
        return (Integer) this.m[h][w];
    }

    @Override
    public void setNumberValue(int w, int h, Number val) {
        this.m[h][w] = val.intValue();
    }

    @Override
    public IntMatrix set(IntMatrix nw) {
        this.m = nw.m;
        return this;
    }

    @Override
    public IntMatrix clone() {
        return new IntMatrix(this.m);
    }

    @Override
    public IntMatrix add(IntMatrix... others) {
        IntMatrix ret = this.clone();
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
    public IntMatrix sub(IntMatrix... others) {
        IntMatrix[] neg = new IntMatrix[others.length];
        for (int i = 0; i < neg.length; ++i) {
            neg[i] = others[i].clone().mulEquals(-1);
        }
        return this.add(neg);
    }

    @Override
    public IntMatrix mul(IntMatrix... others) {
        IntMatrix ret = new IntMatrix(others[0].getWidth(), this.getHeight());
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
    public IntMatrix add(int... others) {
        return MatrixUtils.<IntMatrix>operand(this, others, (l, r) -> l + r);
    }

    @Override
    public IntMatrix add(float... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix add(long... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix add(double... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix sub(int... others) {
        return MatrixUtils.<IntMatrix>operand(this, others, (l, r) -> l - r);
    }

    @Override
    public IntMatrix sub(float... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix sub(long... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix sub(double... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix mul(int... others) {
        return MatrixUtils.<IntMatrix>operand(this, others, (l, r) -> l * r);
    }

    @Override
    public IntMatrix mul(float... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix mul(long... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix mul(double... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix div(int... others) {
        return MatrixUtils.<IntMatrix>operand(this, others, (l, r) -> l / r);
    }

    @Override
    public IntMatrix div(float... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix div(long... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntMatrix div(double... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public int compareTo(IntMatrix arg0) {
        return ((Integer) (this.getWidth() * this.getHeight())).compareTo(arg0.getWidth() * arg0.getHeight());
    }

    @Override
    public Vector getRow(int row) {
        return new IntVec(this.m[row]);
    }

    @Override
    public Vector getColumn(int column) {
        IntVec ret = new IntVec(this.getHeight());
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
