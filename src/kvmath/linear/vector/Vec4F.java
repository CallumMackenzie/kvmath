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
public class Vec4F extends FloatVec {

    public Vec4F(float x, float y, float z, float w) {
        super(4);
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    public Vec4F() {
        this(0, 0, 0, 0);
    }

    public Vec4F(Vector other) {
        this(other.getValue(0).floatValue(),
                other.getValue(1).floatValue(),
                other.getValue(2).floatValue(),
                other.getValue(3).floatValue());
    }

    public final void setX(float x) {
        this.v[0] = x;
    }

    public final void setY(float y) {
        this.v[1] = y;
    }

    public final void setZ(float z) {
        this.v[2] = z;
    }

    public final void setW(float w) {
        this.v[3] = w;
    }

    public final float getX() {
        return this.v[0];
    }

    public final float getY() {
        return this.v[1];
    }

    public final float getZ() {
        return this.v[2];
    }

    public final float getW() {
        return this.v[3];
    }

}
