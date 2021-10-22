/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.vector;

import kvmath.utils.BiFunction;

/**
 *
 * @author callum
 */
public class VectorUtils {

    public static <T extends Vector, E extends Number> T operand(T ths, T[] vecs, BiFunction<E, E, E> fn) {
        T ret = (T) ths.clone();
        for (var vec : vecs) {
            if (vec.nElems() != ths.nElems()) {
                throw new VectorSizeException();
            }
            for (int i = 0; i < ret.nElems(); ++i) {
                ret.setValue(i, fn.apply((E) ret.getNumberValues()[i], (E) vec.getNumberValues()[i]));
            }
        }
        return ret;
    }

    public static <T extends Vector> T operand(T ths, long[] scls, BiFunction<Long, Long, Long> fn) {
        T ret = (T) ths.clone();
        for (var num : scls) {
            for (int i = 0; i < ret.nElems(); ++i) {
                ret.setValue(i, fn.apply((Long) ret.getNumberValues()[i], (Long) num));
            }
        }
        return ret;
    }

    public static <T extends Vector> T operand(T ths, int[] scls, BiFunction<Integer, Integer, Integer> fn) {
        T ret = (T) ths.clone();
        for (var num : scls) {
            for (int i = 0; i < ret.nElems(); ++i) {
                ret.setValue(i, fn.apply((Integer) ret.getNumberValues()[i], (Integer) num));
            }
        }
        return ret;
    }

    public static <T extends Vector> T operand(T ths, float[] scls, BiFunction<Float, Float, Float> fn) {
        T ret = (T) ths.clone();
        for (var num : scls) {
            for (int i = 0; i < ret.nElems(); ++i) {
                ret.setValue(i, fn.apply((Float) ret.getNumberValues()[i], (Float) num));
            }
        }
        return ret;
    }

    public static <T extends Vector> T operand(T ths, double[] scls, BiFunction<Double, Double, Double> fn) {
        T ret = (T) ths.clone();
        for (var num : scls) {
            for (int i = 0; i < ret.nElems(); ++i) {
                ret.setValue(i, fn.apply((Double) ret.getNumberValues()[i], (Double) num));
            }
        }
        return ret;
    }

    public static String vecToString(Vector v) {
        StringBuilder bd = new StringBuilder().append("{");
        for (int i = 0; i < v.nElems(); ++i) {
            bd.append(v.getValue(i));
            bd.append(i == v.nElems() - 1 ? "" : ", ");
        }
        return bd.append("}").toString();
    }

    public static void assertLength(Vector v, int sz) {
        if (v.nElems() != sz) {
            throw new VectorSizeException("Length assertion failed, expected " + sz + " elements.");
        }
    }

}
