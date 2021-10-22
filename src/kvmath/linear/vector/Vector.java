/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.vector;

import java.util.Arrays;
import java.util.stream.Stream;
import kvmath.linear.Algebraic;

/**
 *
 * @author callum
 * @param <T> The type implementing this one.
 */
public interface Vector<T extends Vector> extends Algebraic<T> {

    public T normalized();

    public double len();

    public int nElems();
    
    public double dot(T other);

    public Number[] getNumberValues();

    public Number getNumberValue(int index);

    public void setValue(int i, Number e);

    public default T normalize() {
        return this.set(this.normalized());
    }

    public default Number getValue(int index) {
        if (index >= nElems()) {
            return 0;
        }
        return getNumberValue(index);
    }

    public default FloatVec toFloatVec() {
        return FloatVec.toFloatVec(getNumberValues());
    }

    public default IntVec toIntVec() {
        return IntVec.toIntVec(getNumberValues());
    }

    public default DoubleVec toDoubleVec() {
        return DoubleVec.toDoubleVec(getNumberValues());
    }

    public default LongVec toLongVec() {
        return LongVec.toLongVec(getNumberValues());
    }

    public default Stream<Number> stream() {
        return Arrays.stream(getNumberValues());
    }

}
