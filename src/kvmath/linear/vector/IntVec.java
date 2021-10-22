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
public class IntVec implements Vector<IntVec> {

    protected int[] v;

    public IntVec(int len) {
        this.v = new int[len];
    }

    public IntVec(int... v) {
        this.v = v;
    }

    public static IntVec toIntVec(Number... nms) {
        IntVec ret = new IntVec(nms.length);
        for (int i = 0; i < nms.length; ++i) {
            ret.v[i] = nms[i].intValue();
        }
        return ret;
    }

    @Override
    public IntVec clone() {
        return new IntVec(this.v);
    }

    public int[] getValues() {
        return this.v;
    }

    @Override
    public Number[] getNumberValues() {
        Integer[] ret = new Integer[this.nElems()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = this.v[i];
        }
        return ret;
    }

    public void setValues(int[] v) {
        this.v = v;
    }

    public void setValue(int index, int val) {
        this.v[index] = val;
    }

    @Override
    public void setValue(int index, Number val) {
        this.v[index] = val.intValue();
    }

    @Override
    public int nElems() {
        return this.v.length;
    }

    @Override
    public IntVec add(IntVec... others) {
        return VectorUtils.<IntVec, Integer>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public IntVec sub(IntVec... others) {
        return VectorUtils.<IntVec, Integer>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public IntVec mul(IntVec... others) {
        return VectorUtils.<IntVec, Integer>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public IntVec div(IntVec... others) {
        return VectorUtils.<IntVec, Integer>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public IntVec add(int... others) {
        return VectorUtils.<IntVec>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public IntVec sub(int... others) {
        return VectorUtils.<IntVec>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public IntVec mul(int... others) {
        return VectorUtils.<IntVec>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public IntVec div(int... others) {
        return VectorUtils.<IntVec>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public IntVec normalized() {
        return this.div((int) this.len());
    }

    @Override
    public double len() {
        return Math.sqrt(this.dot(this));
    }

    public double dot(IntVec other) {
        if (other.nElems() != this.nElems()) {
            throw new VectorSizeException();
        }
        int ret = 0;
        for (int i = 0; i < other.nElems(); ++i) {
            ret += other.v[i] * this.v[i];
        }
        return (double) ret;
    }

    @Override
    public IntVec set(IntVec other) {
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
    public int compareTo(IntVec other) {
        return ((Double) this.len()).compareTo(other.len());
    }

    @Override
    public IntVec add(float... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec add(double... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec add(long... others) {
        return this.add(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec sub(float... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec sub(double... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec sub(long... others) {
        return this.sub(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec mul(float... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec mul(double... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec mul(long... others) {
        return this.mul(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec div(float... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec div(double... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public IntVec div(long... others) {
        return this.div(ArrayUtils.toIntArray(others));
    }

    @Override
    public Number getNumberValue(int i) {
        return (Integer) this.v[i];
    }
}
