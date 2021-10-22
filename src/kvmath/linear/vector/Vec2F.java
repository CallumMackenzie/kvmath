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
public final class Vec2F extends FloatVec {

    public Vec2F(float x, float y) {
        super(2);
        this.setX(x);
        this.setY(y);
    }

    public Vec2F() {
        this(0, 0);
    }

    public Vec2F(Vector other) {
        this(other.getValue(0).floatValue(), other.getValue(1).floatValue());
    }

    public void setX(float x) {
        this.v[0] = x;
    }

    public void setY(float y) {
        this.v[1] = y;
    }

    public float getX() {
        return this.v[0];
    }

    public float getY() {
        return this.v[1];
    }

    public float x() {
        return this.getX();
    }

    public float y() {
        return this.getY();
    }

    public float getU() {
        return this.getX();
    }

    public float getV() {
        return this.getY();
    }

    public void setU(float n) {
        this.setX(n);
    }

    public void setV(float n) {
        this.setY(n);
    }
}
