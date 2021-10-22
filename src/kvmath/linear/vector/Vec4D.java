/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.vector;

/**
 *
 * @author callum
 */
public class Vec4D extends DoubleVec {

    public Vec4D(double x, double y, double z, double w) {
        super(4);
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    public Vec4D() {
        this(0, 0, 0, 0);
    }

    public Vec4D(Vector other) {
        this(other.getValue(0).doubleValue(),
                other.getValue(1).doubleValue(),
                other.getValue(2).doubleValue(),
                other.getValue(3).doubleValue());
    }

    public final void setX(double x) {
        this.v[0] = x;
    }

    public final void setY(double y) {
        this.v[1] = y;
    }

    public final void setZ(double z) {
        this.v[2] = z;
    }

    public final void setW(double w) {
        this.v[3] = w;
    }

    public final double getX() {
        return this.v[0];
    }

    public final double getY() {
        return this.v[1];
    }

    public final double getZ() {
        return this.v[2];
    }

    public final double getW() {
        return this.v[3];
    }

}
