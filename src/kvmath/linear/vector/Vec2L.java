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
public final class Vec2L extends LongVec {

    public Vec2L(long x, long y) {
        super(2);
        this.setX(x);
        this.setY(y);
    }

    public Vec2L() {
        this(0, 0);
    }

    public Vec2L(Vector other) {
        this(other.getValue(0).longValue(), other.getValue(1).longValue());
    }

    public void setX(long x) {
        this.v[0] = x;
    }

    public void setY(long y) {
        this.v[1] = y;
    }

    public long getX() {
        return this.v[0];
    }

    public long getY() {
        return this.v[1];
    }

    public long x() {
        return this.getX();
    }

    public long y() {
        return this.getY();
    }

    public long getU() {
        return this.getX();
    }

    public long getV() {
        return this.getY();
    }

    public void setU(long n) {
        this.setX(n);
    }

    public void setV(long n) {
        this.setY(n);
    }
}
