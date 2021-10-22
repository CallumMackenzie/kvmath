/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.vector.DoubleVec;
import kvmath.linear.vector.Vector;
import kvmath.utils.ArrayUtils;

/**
 *
 * @author callum
 */
public class DoubleMatrix implements Matrix<DoubleMatrix> {

    double[][] m;

    public DoubleMatrix(int w, int h) {
        this.m = new double[h][w];
    }

    public DoubleMatrix(double[][] m) {
        this.m = m;
    }

    public DoubleMatrix(Matrix mat) {
        this(mat.getWidth(), mat.getHeight());
        for (int i = 0; i < mat.getHeight(); ++i) {
            for (int j = 0; j < mat.getWidth(); ++j) {
                this.m[i][j] = mat.getNumberValue(j, i).doubleValue();
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
        Double[][] ret = new Double[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); ++i) {
            for (int j = 0; j < this.getWidth(); ++j) {
                ret[i][j] = (Double) this.m[i][j];
            }
        }
        return ret;
    }

    @Override
    public Number getNumberValue(int w, int h) {
        return (Double) this.m[h][w];
    }

    @Override
    public void setNumberValue(int w, int h, Number val) {
        this.m[h][w] = val.doubleValue();
    }

    @Override
    public DoubleMatrix set(DoubleMatrix nw) {
        this.m = nw.m;
        return this;
    }

    @Override
    public DoubleMatrix clone() {
        return new DoubleMatrix(this.m);
    }

    @Override
    public DoubleMatrix add(DoubleMatrix... others) {
        DoubleMatrix ret = this.clone();
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
    public DoubleMatrix sub(DoubleMatrix... others) {
        DoubleMatrix[] neg = new DoubleMatrix[others.length];
        for (int i = 0; i < neg.length; ++i) {
            neg[i] = others[i].clone().mulEquals(-1);
        }
        return this.add(neg);
    }

    @Override
    public DoubleMatrix mul(DoubleMatrix... others) {
        DoubleMatrix ret = new DoubleMatrix(others[0].getWidth(), this.getHeight());
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
    public DoubleMatrix add(double... others) {
        return MatrixUtils.<DoubleMatrix>operand(this, others, (l, r) -> l + r);
    }

    @Override
    public DoubleMatrix add(float... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix add(long... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix add(int... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix sub(double... others) {
        return MatrixUtils.<DoubleMatrix>operand(this, others, (l, r) -> l - r);
    }

    @Override
    public DoubleMatrix sub(float... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix sub(long... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix sub(int... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix mul(double... others) {
        return MatrixUtils.<DoubleMatrix>operand(this, others, (l, r) -> l * r);
    }

    @Override
    public DoubleMatrix mul(float... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix mul(long... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix mul(int... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix div(double... others) {
        return MatrixUtils.<DoubleMatrix>operand(this, others, (l, r) -> l / r);
    }

    @Override
    public DoubleMatrix div(float... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix div(long... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleMatrix div(int... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public int compareTo(DoubleMatrix arg0) {
        return ((Integer) (this.getWidth() * this.getHeight())).compareTo(arg0.getWidth() * arg0.getHeight());
    }

    @Override
    public Vector getRow(int row) {
        return new DoubleVec(this.m[row]);
    }

    @Override
    public Vector getColumn(int column) {
        DoubleVec ret = new DoubleVec(this.getHeight());
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
