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
public class Vec3F extends FloatVec {

    public Vec3F(float x, float y, float z) {
        super(3);
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public Vec3F(float x, float y) {
        this(x, y, 0);
    }

    public Vec3F(float x) {
        this(x, 0, 0);
    }

    public Vec3F() {
        this(0, 0, 0);
    }

    public Vec3F(Vector v) {
        this(v.getValue(0).floatValue(), v.getValue(1).floatValue(), v.getValue(2).floatValue());
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

    public final void setX(float x) {
        this.v[0] = x;
    }

    public final void setY(float y) {
        this.v[1] = y;
    }

    public final void setZ(float z) {
        this.v[2] = z;
    }

    public float r() {
        return this.getX();
    }

    public float g() {
        return this.getY();
    }

    public float b() {
        return this.getZ();
    }

    public void setR(float r) {
        this.setX(r);
    }

    public void setG(float g) {
        this.setY(g);
    }

    public void setB(float b) {
        this.setZ(b);
    }

    public float x() {
        return getX();
    }

    public float y() {
        return getY();
    }

    public float z() {
        return getZ();
    }

    public static Vec3F cross(Vec3F a, Vec3F b) {
        return new Vec3F(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX()
        );
    }
}
