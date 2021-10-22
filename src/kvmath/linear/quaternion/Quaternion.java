/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.quaternion;

import kvmath.linear.vector.Vector;
import kvmath.linear.vector.VectorSizeException;

/**
 *
 * @author callum
 * @param <T>
 */
public interface Quaternion<T extends Vector> {

    public Vector<?> getComplex();

    public T getBase();

    public void setComplex(Vector<?> complex);

    public T conjugate();

    public Vector<?> rotateVector(Vector<?> v);

    public void setEuler(Vector<?> euler);

    public T inverse();

    public default Number getReal() {
        this.assertLength();
        return this.getBase().getNumberValue(3);
    }

    public default void setReal(Number real) {
        assertLength();
        this.getBase().setValue(3, real);
    }

    public default void assertLength() {
        if (this.getBase().nElems() != 4) {
            throw new VectorSizeException("Quaternions must have a vector base with 4 components.");
        }
    }

}
