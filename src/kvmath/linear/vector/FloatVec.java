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
public class FloatVec implements Vector<FloatVec> {

    protected float[] v;

    public FloatVec(int len) {
        this.v = new float[len];
    }

    public FloatVec(float... v) {
        this.v = v;
    }

    public static FloatVec toFloatVec(Number... nms) {
        FloatVec ret = new FloatVec(nms.length);
        for (int i = 0; i < nms.length; ++i) {
            ret.v[i] = nms[i].floatValue();
        }
        return ret;
    }

    @Override
    public FloatVec clone() {
        return new FloatVec(this.v);
    }

    public float[] getValues() {
        return this.v;
    }

    @Override
    public Number[] getNumberValues() {
        Float[] ret = new Float[this.nElems()];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = this.v[i];
        }
        return ret;
    }

    public void setValues(float[] v) {
        this.v = v;
    }

    public void setValue(int index, float val) {
        this.v[index] = val;
    }

    @Override
    public void setValue(int index, Number val) {
        this.v[index] = val.floatValue();
    }

    @Override
    public int nElems() {
        return this.v.length;
    }

    @Override
    public FloatVec add(FloatVec... others) {
        return VectorUtils.<FloatVec, Float>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public FloatVec sub(FloatVec... others) {
        return VectorUtils.<FloatVec, Float>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public FloatVec mul(FloatVec... others) {
        return VectorUtils.<FloatVec, Float>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public FloatVec div(FloatVec... others) {
        return VectorUtils.<FloatVec, Float>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public FloatVec add(float... others) {
        return VectorUtils.<FloatVec>operand(this, others, (lhs, rhs) -> lhs + rhs);
    }

    @Override
    public FloatVec sub(float... others) {
        return VectorUtils.<FloatVec>operand(this, others, (lhs, rhs) -> lhs - rhs);
    }

    @Override
    public FloatVec mul(float... others) {
        return VectorUtils.<FloatVec>operand(this, others, (lhs, rhs) -> lhs * rhs);
    }

    @Override
    public FloatVec div(float... others) {
        return VectorUtils.<FloatVec>operand(this, others, (lhs, rhs) -> lhs / rhs);
    }

    @Override
    public FloatVec normalized() {
        return this.div((float) this.len());
    }

    @Override
    public double len() {
        return Math.sqrt(this.dot(this));
    }

    @Override
    public double dot(FloatVec other) {
        if (other.nElems() != this.nElems()) {
            throw new VectorSizeException();
        }
        float ret = 0;
        for (int i = 0; i < other.nElems(); ++i) {
            ret += other.v[i] * this.v[i];
        }
        return (double) ret;
    }

    @Override
    public FloatVec set(FloatVec other) {
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
    public int compareTo(FloatVec other) {
        return ((Double) this.len()).compareTo(other.len());
    }

    @Override
    public FloatVec add(int... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec add(double... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec add(long... others) {
        return this.add(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec sub(int... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec sub(double... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec sub(long... others) {
        return this.sub(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec mul(int... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec mul(double... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec mul(long... others) {
        return this.mul(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec div(int... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec div(double... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public FloatVec div(long... others) {
        return this.div(ArrayUtils.toFloatArray(others));
    }

    @Override
    public Number getNumberValue(int i) {
        return (Float) this.v[i];
    }

}
