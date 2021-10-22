/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.Algebraic;
import kvmath.linear.vector.Vector;

/**
 *
 * @author callum
 * @param <T> The class implementing the Matrix interface.
 */
public interface Matrix<T extends Matrix> extends Algebraic<T> {

    public int getWidth();

    public int getHeight();

    public Number[][] getNumberValues();

    public Number getNumberValue(int w, int h);

    public void setNumberValue(int w, int h, Number val);

    public Vector getRow(int row);

    public Vector getColumn(int column);

    public default Number getValue(int w, int h) {
        if (w >= this.getWidth() || h >= this.getHeight()) {
            return 0;
        }
        return this.getNumberValue(w, h);
    }

    @Override
    public default T div(T... others) {
        T ret = (T) this.clone();
        for (var mat : others) {
            if (!(mat instanceof SquareMatrix)) {
                throw new MatrixSizeException("Cannot divide non-square matrices.");
            }
            ret.mulEquals((FloatMatrix) ((SquareMatrix) mat).inverse());
        }
        return ret;
    }

    public default Vector mulColumn(Vector other) {
        if (other.nElems() != this.getWidth()) {
            throw new MatrixSizeException();
        }
        Vector ret = (Vector) other.clone();
        for (int i = 0; i < this.getHeight(); ++i) {
            ret.setValue(i, other.dot(this.getRow(i)));
        }
        return ret;
    }

    public default Vector mulRow(Vector other) {
        if (other.nElems() != this.getHeight()) {
            throw new MatrixSizeException();
        }
        Vector ret = (Vector) other.clone();
        for (int i = 0; i < this.getWidth(); ++i) {
            ret.setValue(i, other.dot(this.getColumn(i)));
        }
        return ret;
    }

    public default boolean isSquare() {
        return this.getWidth() == this.getHeight();
    }

    public default DoubleMatrix toDoubleMatrix() {
        return new DoubleMatrix(this);
    }

    public default LongMatrix toLongMatrix() {
        return new LongMatrix(this);
    }

    public default IntMatrix toIntMatrix() {
        return new IntMatrix(this);
    }

    public default FloatMatrix toFloatMatrix() {
        return new FloatMatrix(this);
    }

}
