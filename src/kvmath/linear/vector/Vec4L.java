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
public class Vec4L extends LongVec {

    public Vec4L(long x, long y, long z, long w) {
        super(4);
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    public Vec4L() {
        this(0, 0, 0, 0);
    }

    public Vec4L(Vector other) {
        this(other.getValue(0).longValue(),
                other.getValue(1).longValue(),
                other.getValue(2).longValue(),
                other.getValue(3).longValue());
    }

    public final void setX(long x) {
        this.v[0] = x;
    }

    public final void setY(long y) {
        this.v[1] = y;
    }

    public final void setZ(long z) {
        this.v[2] = z;
    }

    public final void setW(long w) {
        this.v[3] = w;
    }

    public final long getX() {
        return this.v[0];
    }

    public final long getY() {
        return this.v[1];
    }

    public final long getZ() {
        return this.v[2];
    }

    public final long getW() {
        return this.v[3];
    }

}
