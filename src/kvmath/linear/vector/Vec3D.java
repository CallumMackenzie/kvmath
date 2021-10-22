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
public class Vec3D extends DoubleVec {

    public Vec3D(double x, double y, double z) {
        super(3);
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public Vec3D(double x, double y) {
        this(x, y, 0);
    }

    public Vec3D(double x) {
        this(x, 0, 0);
    }

    public Vec3D() {
        this(0, 0, 0);
    }

    public Vec3D(Vector v) {
        this(v.getValue(0).doubleValue(), v.getValue(1).doubleValue(), v.getValue(2).doubleValue());
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

    public final void setX(double x) {
        this.v[0] = x;
    }

    public final void setY(double y) {
        this.v[1] = y;
    }

    public final void setZ(double z) {
        this.v[2] = z;
    }

    public double r() {
        return this.getX();
    }

    public double g() {
        return this.getY();
    }

    public double b() {
        return this.getZ();
    }

    public void setR(double r) {
        this.setX(r);
    }

    public void setG(double g) {
        this.setY(g);
    }

    public void setB(double b) {
        this.setZ(b);
    }

    public double x() {
        return getX();
    }

    public double y() {
        return getY();
    }

    public double z() {
        return getZ();
    }

    public static Vec3D cross(Vec3D a, Vec3D b) {
        return new Vec3D(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX()
        );
    }
}
