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
public class LongVec implements Vector<LongVec> {

    protected long[] v;

    public LongVec(int len) {
        this.v = new long[len];
    }

    public LongVec(long... v) {
        this.v = v;
    }

    public static LongVec toLongVec(Number... nms) {
        LongVec ret = new LongVec(nms.length);
        for (int i = 0; i < nms.length; ++i) {
            ret.v[i] = nms[i].longValue();
        }
        return ret;
    }

    @Override
    public LongVec clone() {
        return new LongVec(this.v);
    }

    public long[] getValues() {
        return this.v;
    }

    @Override
    public Number[] getNumberValues() {
        Long[] ret = new Long[this.nElems()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = this.v[i];
        }
        return ret;
    }

    public void setValues(long[] v) {
        this.v = v;
    }

    public void setValue(int index, long val) {
        this.v[index] = val;
    }

    @Override
    public void setValue(int index, Number val) {
        this.v[index] = val.longValue();
    }

    @Override
    public int nElems() {
        return this.v.length;
    }

    @Override
    public LongVec add(LongVec... others) {
        return VectorUtils.<LongVec, Long>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public LongVec sub(LongVec... others) {
        return VectorUtils.<LongVec, Long>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public LongVec mul(LongVec... others) {
        return VectorUtils.<LongVec, Long>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public LongVec div(LongVec... others) {
        return VectorUtils.<LongVec, Long>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public LongVec add(long... others) {
        return VectorUtils.<LongVec>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public LongVec sub(long... others) {
        return VectorUtils.<LongVec>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public LongVec mul(long... others) {
        return VectorUtils.<LongVec>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public LongVec div(long... others) {
        return VectorUtils.<LongVec>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public LongVec add(float... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec add(double... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec add(int... others) {
        return this.add(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec sub(float... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec sub(double... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec sub(int... others) {
        return this.sub(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec mul(float... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec mul(double... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec mul(int... others) {
        return this.mul(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec div(float... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec div(double... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec div(int... others) {
        return this.div(ArrayUtils.toLongArray(others));
    }

    @Override
    public LongVec normalized() {
        return this.div((long) this.len());
    }

    @Override
    public double len() {
        return Math.sqrt(this.dot(this));
    }

    @Override
    public double dot(LongVec other) {
        if (other.nElems() != this.nElems()) {
            throw new VectorSizeException();
        }
        long ret = 0;
        for (int i = 0; i < other.nElems(); ++i) {
            ret += other.v[i] * this.v[i];
        }
        return (double) ret;
    }

    @Override
    public LongVec set(LongVec other) {
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
    public int compareTo(LongVec other) {
        return ((Double) this.len()).compareTo(other.len());
    }

    @Override
    public Number getNumberValue(int i) {
        return (Long) this.v[i];
    }
}
