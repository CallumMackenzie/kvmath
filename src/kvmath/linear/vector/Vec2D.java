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
public final class Vec2D extends DoubleVec {

    public Vec2D(double x, double y) {
        super(2);
        this.setX(x);
        this.setY(y);
    }

    public Vec2D() {
        this(0, 0);
    }

    public Vec2D(Vector other) {
        this(other.getValue(0).doubleValue(), other.getValue(1).doubleValue());
    }

    public void setX(double x) {
        this.v[0] = x;
    }

    public void setY(double y) {
        this.v[1] = y;
    }

    public double getX() {
        return this.v[0];
    }

    public double getY() {
        return this.v[1];
    }

    public double x() {
        return this.getX();
    }

    public double y() {
        return this.getY();
    }

    public double getU() {
        return this.getX();
    }

    public double getV() {
        return this.getY();
    }

    public void setU(double n) {
        this.setX(n);
    }

    public void setV(double n) {
        this.setY(n);
    }
}
