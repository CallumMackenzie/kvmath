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
public final class Vec2I extends IntVec {

    public Vec2I(int x, int y) {
        super(2);
        this.setX(x);
        this.setY(y);
    }

    public Vec2I() {
        this(0, 0);
    }

    public Vec2I(Vector other) {
        this(other.getValue(0).intValue(), other.getValue(1).intValue());
    }

    public void setX(int x) {
        this.v[0] = x;
    }

    public void setY(int y) {
        this.v[1] = y;
    }

    public int getX() {
        return this.v[0];
    }

    public int getY() {
        return this.v[1];
    }

    public int x() {
        return this.getX();
    }

    public int y() {
        return this.getY();
    }

    public int getU() {
        return this.getX();
    }

    public int getV() {
        return this.getY();
    }

    public void setU(int n) {
        this.setX(n);
    }

    public void setV(int n) {
        this.setY(n);
    }
}
