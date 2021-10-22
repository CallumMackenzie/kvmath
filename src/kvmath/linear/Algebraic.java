/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear;

/**
 *
 * @author callum
 * @param <T>
 */
public interface Algebraic<T> extends Comparable<T> {

    public T set(T nw);

    public T clone();

    public T add(T... others);

    public T sub(T... others);

    public T mul(T... others);

    public T div(T... others);

    public T add(float... others);

    public T add(double... others);

    public T add(long... others);

    public T add(int... others);

    public T sub(float... others);

    public T sub(double... others);

    public T sub(long... others);

    public T sub(int... others);

    public T mul(float... others);

    public T mul(double... others);

    public T mul(long... others);

    public T mul(int... others);

    public T div(float... others);

    public T div(double... others);

    public T div(long... others);

    public T div(int... others);

    public default T addEquals(T... others) {
        return this.set(this.add(others));
    }

    public default T subEquals(T... others) {
        return this.set(this.sub(others));
    }

    public default T mulEquals(T... others) {
        return this.set(this.mul(others));
    }

    public default T divEquals(T... others) {
        return this.set(this.div(others));
    }

    public default T addEquals(float... others) {
        return this.set(this.add(others));
    }

    public default T addEquals(double... others) {
        return this.set(this.add(others));
    }

    public default T addEquals(long... others) {
        return this.set(this.add(others));
    }

    public default T addEquals(int... others) {
        return this.set(this.add(others));
    }

    public default T subEquals(float... others) {
        return this.set(this.sub(others));
    }

    public default T subEquals(double... others) {
        return this.set(this.sub(others));
    }

    public default T subEquals(long... others) {
        return this.set(this.sub(others));
    }

    public default T subEquals(int... others) {
        return this.set(this.sub(others));
    }

    public default T mulEquals(float... others) {
        return this.set(this.mul(others));
    }

    public default T mulEquals(double... others) {
        return this.set(this.mul(others));
    }

    public default T mulEquals(long... others) {
        return this.set(this.mul(others));
    }

    public default T mulEquals(int... others) {
        return this.set(this.mul(others));
    }

    public default T divEquals(float... others) {
        return this.set(this.div(others));
    }

    public default T divEquals(double... others) {
        return this.set(this.div(others));
    }

    public default T divEquals(long... others) {
        return this.set(this.div(others));
    }

    public default T divEquals(int... others) {
        return this.set(this.div(others));
    }
}
