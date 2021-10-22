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
public class Vec3I extends IntVec {

    public Vec3I(int x, int y, int z) {
        super(3);
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public Vec3I(int x, int y) {
        this(x, y, 0);
    }

    public Vec3I(int x) {
        this(x, 0, 0);
    }

    public Vec3I() {
        this(0, 0, 0);
    }

    public Vec3I(Vec3I v) {
        this(v.getX(), v.getY(), v.getZ());
    }

    public Vec3I(Vector v) {
        this(v.getValue(0).intValue(), v.getValue(1).intValue(), v.getValue(2).intValue());
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

    public final void setX(int x) {
        this.v[0] = x;
    }

    public final void setY(int y) {
        this.v[1] = y;
    }

    public final void setZ(int z) {
        this.v[2] = z;
    }

    public int r() {
        return this.getX();
    }

    public int g() {
        return this.getY();
    }

    public int b() {
        return this.getZ();
    }

    public void setR(int r) {
        this.setX(r);
    }

    public void setG(int g) {
        this.setY(g);
    }

    public void setB(int b) {
        this.setZ(b);
    }

    public int x() {
        return getX();
    }

    public int y() {
        return getY();
    }

    public int z() {
        return getZ();
    }

    public static Vec3I cross(Vec3I a, Vec3I b) {
        return new Vec3I(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX()
        );
    }
}
