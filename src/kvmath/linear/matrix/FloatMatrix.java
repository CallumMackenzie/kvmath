/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.vector.FloatVec;
import kvmath.linear.vector.Vector;
import kvmath.utils.ArrayUtils;

/**
 *
 * @author callum
 */
public class FloatMatrix implements Matrix<FloatMatrix> {

    float[][] m;

    public FloatMatrix(int w, int h) {
        this.m = new float[h][w];
    }

    public FloatMatrix(float[][] m) {
        this.m = m;
    }

    public FloatMatrix(Matrix mat) {
        this(mat.getWidth(), mat.getHeight());
        for (int i = 0; i < mat.getHeight(); ++i) {
            for (int j = 0; j < mat.getWidth(); ++j) {
                this.m[i][j] = mat.getNumberValue(j, i).floatValue();
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
        Float[][] ret = new Float[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); ++i) {
            for (int j = 0; j < this.getWidth(); ++j) {
                ret[i][j] = (Float) this.m[i][j];
            }
        }
        return ret;
    }

    @Override
    public Number getNumberValue(int w, int h) {
        return (Float) this.m[h][w];
    }

    @Override
    public void setNumberValue(int w, int h, Number val) {
        this.m[h][w] = val.floatValue();
    }

    @Override
    public FloatMatrix set(FloatMatrix nw) {
        this.m = nw.m;
        return this;
    }

    @Override
    public FloatMatrix clone() {
        return new FloatMatrix(this.m);
    }

    @Override
    public FloatMatrix add(FloatMatrix... others) {
        FloatMatrix ret = this.clone();
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
    public FloatMatrix sub(FloatMatrix... others) {
        FloatMatrix[] neg = new FloatMatrix[others.length];
        for (int i = 0; i < neg.length; ++i) {
            neg[i] = others[i].clone().mulEquals(-1);
        }
        return this.add(neg);
    }

    @Override
    public FloatMatrix mul(FloatMatrix... others) {
        FloatMatrix ret = new FloatMatrix(others[0].getWidth(), this.getHeight());
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
    public FloatMatrix add(float... others) {
        return MatrixUtils.<FloatMatrix>operand(this, others, (l, r) -> l + r);
    }

    @Override
    public FloatMatrix add(double... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix add(long... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix add(int... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix sub(float... others) {
        return MatrixUtils.<FloatMatrix>operand(this, others, (l, r) -> l - r);
    }

    @Override
    public FloatMatrix sub(double... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix sub(long... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix sub(int... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix mul(float... others) {
        return MatrixUtils.<FloatMatrix>operand(this, others, (l, r) -> l * r);
    }

    @Override
    public FloatMatrix mul(double... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix mul(long... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix mul(int... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix div(float... others) {
        return MatrixUtils.<FloatMatrix>operand(this, others, (l, r) -> l / r);
    }

    @Override
    public FloatMatrix div(double... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix div(long... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatMatrix div(int... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public int compareTo(FloatMatrix arg0) {
        return ((Integer) (this.getWidth() * this.getHeight())).compareTo(arg0.getWidth() * arg0.getHeight());
    }

    @Override
    public Vector getRow(int row) {
        return new FloatVec(this.m[row]);
    }

    @Override
    public Vector getColumn(int column) {
        FloatVec ret = new FloatVec(this.getHeight());
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
