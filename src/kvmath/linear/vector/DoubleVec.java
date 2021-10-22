/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.vector;

import kvmath.utils.ArrayUtils;

/**
 *
 * @author callum
 */
public class DoubleVec implements Vector<DoubleVec> {

    protected double[] v;

    public DoubleVec(int len) {
        this.v = new double[len];
    }

    public DoubleVec(double... v) {
        this.v = v;
    }

    public static DoubleVec toDoubleVec(Number... nms) {
        DoubleVec ret = new DoubleVec(nms.length);
        for (int i = 0; i < nms.length; ++i) {
            ret.v[i] = nms[i].doubleValue();
        }
        return ret;
    }

    @Override
    public DoubleVec clone() {
        return new DoubleVec(this.v);
    }

    public double[] getValues() {
        return this.v;
    }

    @Override
    public Number[] getNumberValues() {
        Double[] ret = new Double[this.nElems()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = this.v[i];
        }
        return ret;
    }

    public void setValues(double[] v) {
        this.v = v;
    }

    public void setValue(int index, double val) {
        this.v[index] = val;
    }

    @Override
    public void setValue(int index, Number val) {
        this.v[index] = val.doubleValue();
    }

    @Override
    public int nElems() {
        return this.v.length;
    }

    @Override
    public DoubleVec add(DoubleVec... others) {
        return VectorUtils.<DoubleVec, Double>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public DoubleVec sub(DoubleVec... others) {
        return VectorUtils.<DoubleVec, Double>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public DoubleVec mul(DoubleVec... others) {
        return VectorUtils.<DoubleVec, Double>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public DoubleVec div(DoubleVec... others) {
        return VectorUtils.<DoubleVec, Double>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public DoubleVec add(double... others) {
        return VectorUtils.<DoubleVec>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public DoubleVec sub(double... others) {
        return VectorUtils.<DoubleVec>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public DoubleVec mul(double... others) {
        return VectorUtils.<DoubleVec>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public DoubleVec div(double... others) {
        return VectorUtils.<DoubleVec>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public DoubleVec normalized() {
        return this.div(this.len());
    }

    @Override
    public double len() {
        return Math.sqrt(this.dot(this));
    }

    @Override
    public double dot(DoubleVec other) {
        if (other.nElems() != this.nElems()) {
            throw new VectorSizeException();
        }
        double ret = 0;
        for (int i = 0; i < other.nElems(); ++i) {
            ret += other.v[i] * this.v[i];
        }
        return ret;
    }

    @Override
    public DoubleVec set(DoubleVec other) {
        if (other.nElems() != this.nElems()) {
            throw new VectorSizeException();
        }
        for (int i = 0; i < this.nElems(); ++i) {
            this.v[i] = other.v[i];
        }
        return this;
    }

    @Override
    public String toString() {
        return VectorUtils.vecToString(this);
    }

    @Override
    public int compareTo(DoubleVec other) {
        return ((Double) this.len()).compareTo(other.len());
    }

    @Override
    public DoubleVec add(int... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec add(float... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec add(long... others) {
        return this.add(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec sub(int... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec sub(float... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec sub(long... others) {
        return this.sub(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec mul(int... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec mul(float... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec mul(long... others) {
        return this.mul(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec div(int... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec div(float... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public DoubleVec div(long... others) {
        return this.div(ArrayUtils.toDoubleArray(others));
    }

    @Override
    public Number getNumberValue(int i) {
        return (Double) this.v[i];
    }

}
