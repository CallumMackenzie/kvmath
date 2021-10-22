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
public class Vec4I extends IntVec {

    public Vec4I(int x, int y, int z, int w) {
        super(4);
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    public Vec4I() {
        this(0, 0, 0, 0);
    }

    public Vec4I(Vector other) {
        this(other.getValue(0).intValue(),
                other.getValue(1).intValue(),
                other.getValue(2).intValue(),
                other.getValue(3).intValue());
    }

    public final void setX(int x) {
        this.v[0] = x;
    }

    public final void setY(int y) {
        this.v[1] = y;
    }

    public final void setZ(int z) {
        this.v[2] = z;
    }

    public final void setW(int w) {
        this.v[3] = w;
    }

    public final int getX() {
        return this.v[0];
    }

    public final int getY() {
        return this.v[1];
    }

    public final int getZ() {
        return this.v[2];
    }

    public final int getW() {
        return this.v[3];
    }

}
