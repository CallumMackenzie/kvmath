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
public class Vec3L extends LongVec {

    public Vec3L(long x, long y, long z) {
        super(3);
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public Vec3L(long x, long y) {
        this(x, y, 0);
    }

    public Vec3L(long x) {
        this(x, 0, 0);
    }

    public Vec3L() {
        this(0, 0, 0);
    }

    public Vec3L(Vec3L v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vec3L(Vector v) {
        this(v.getValue(0).longValue(), v.getValue(1).longValue(), v.getValue(2).longValue());
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

    public final void setX(long x) {
        this.v[0] = x;
    }

    public final void setY(long y) {
        this.v[1] = y;
    }

    public final void setZ(long z) {
        this.v[2] = z;
    }

    public long r() {
        return this.getX();
    }

    public long g() {
        return this.getY();
    }

    public long b() {
        return this.getZ();
    }

    public void setR(long r) {
        this.setX(r);
    }

    public void setG(long g) {
        this.setY(g);
    }

    public void setB(long b) {
        this.setZ(b);
    }

    public long x() {
        return getX();
    }

    public long y() {
        return getY();
    }

    public long z() {
        return getZ();
    }

    public static Vec3L cross(Vec3L a, Vec3L b) {
        return new Vec3L(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX()
        );
    }
}
