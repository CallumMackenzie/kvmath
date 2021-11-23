package kvmath.graphics;

import java.io.Serializable;

/**
 * A 2 component vector for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Vec2 implements Comparable<Vec2>, Serializable {

    public static final long serialVersionUID = 4384841L;

    protected float x, y;

    /**
     *
     * @return the x value
     */
    public float getX() {
        return this.x;
    }

    /**
     *
     * @param x the value to set x to
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     *
     * @param x the value to set x to
     */
    public void setX(double x) {
        this.x = (float) x;
    }

    /**
     *
     * @return the y value.
     */
    public float getY() {
        return this.y;
    }

    /**
     *
     * @param y the value to set y to
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     *
     * @param y the value to set y to
     */
    public void setY(double y) {
        this.y = (float) y;
    }

    /**
     *
     * @param x the x value
     * @param y the y value
     */
    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x the x value
     */
    public Vec2(float x) {
        this(x, 0.f);
    }

    public Vec2() {
        this(0);
    }

    /**
     *
     * @param v the vector to copy
     */
    public Vec2(Vec2 v) {
        this(v.x, v.y);
    }

    /**
     *
     * @param x the x value
     * @param y the y value
     */
    public Vec2(double x, double y) {
        this((float) x, (float) y);
    }

    /**
     *
     * @param x the x component
     */
    public Vec2(double x) {
        this((float) x);
    }

    /**
     *
     * @return the vector length
     */
    public float len() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     *
     * @param vs the vectors to subtract
     * @return the difference
     */
    public Vec2 sub(Vec2... vs) {
        Vec2 vec = new Vec2(this);
        for (Vec2 v : vs) {
            vec.x -= v.x;
            vec.y -= v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2 with the passed values added to it
     */
    public Vec2 add(Vec2... vs) {
        Vec2 vec = new Vec2(this);
        for (Vec2 v : vs) {
            vec.x += v.x;
            vec.y += v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2 multiplied by the passed values
     */
    public Vec2 mul(Vec2... vs) {
        Vec2 vec = new Vec2(this);
        for (Vec2 v : vs) {
            vec.x *= v.x;
            vec.y *= v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2 divided by the passed values
     */
    public Vec2 div(Vec2... vs) {
        Vec2 vec = new Vec2(this);
        for (Vec2 v : vs) {
            if (v.x != 0) {
                vec.x /= v.x;
            }
            if (v.y != 0) {
                vec.y /= v.y;
            }
        }
        return vec;
    }

    /**
     *
     * Normalizes the Vec2
     */
    public void normalize() {
        float l = len();
        if (l == 0) {
            return;
        }
        this.x /= l;
        this.y /= l;
    }

    /**
     *
     * @return a copy of the Vec2 normalized
     */
    public Vec2 normalized() {
        float l = len();
        if (l == 0) {
            l = 1.f;
        }
        return new Vec2(this.x / l, this.y / l);
    }

    /**
     *
     * @param ns the floats to scale by
     * @return a new scaled vector
     */
    public Vec2 mul(float... ns) {
        Vec2 vec = new Vec2(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
        }
        return vec;
    }

    /**
     *
     * @param ns the floats to scale by
     * @return a new scaled vector
     */
    public Vec2 div(float... ns) {
        Vec2 vec = new Vec2(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;
        }
        return vec;
    }

    /**
     *
     * @param ns the numbers to add
     * @return a new sum vector
     */
    public Vec2 add(float... ns) {
        Vec2 vec = new Vec2(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
        }
        return vec;
    }

    /**
     *
     * @param ns the numbers to subtract
     * @return a new difference vector
     */
    public Vec2 sub(float... ns) {
        Vec2 vec = new Vec2(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
        }
        return vec;
    }

    /**
     *
     * @param mat the matrix to multiply by
     * @return the product
     */
    public Vec2 mul(Mat2 mat) {
        return Vec2.mulMat2(this, mat);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x and y components are equal
     */
    public boolean equalsXY(Vec2 v) {
        return (v.x == this.x && v.y == this.y);
    }

    public Vec2 addEquals(Vec2... vectors) {
        return this.set(this.add(vectors));
    }

    public Vec2 addEquals(float... ns) {
        return this.set(this.add(ns));
    }

    public Vec2 subEquals(Vec2... vectors) {
        return this.set(this.sub(vectors));
    }

    public Vec2 subEquals(float... ns) {
        return this.set(this.sub(ns));
    }

    public Vec2 mulEquals(Vec2... vectors) {
        return this.set(this.mul(vectors));
    }

    public Vec2 mulEquals(float... ns) {
        return this.set(this.mul(ns));
    }

    public Vec2 divEquals(Vec2... vectors) {
        return this.set(this.div(vectors));
    }

    public Vec2 divEquals(float... ns) {
        return this.set(this.div(ns));
    }

    /**
     *
     * @param newVector the vector to be set from
     * @return this
     */
    public Vec2 set(Vec2 newVector) {
        this.x = newVector.x;
        this.y = newVector.y;
        return this;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec2) {
            return this.equalsXY((Vec2) o);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vec2G(" + this.x + "," + this.y + ")";
    }

    /**
     *
     * @param vec the base vector
     * @param mat the matrix to multiply by
     * @return the product
     */
    public static Vec2 mulMat2(Vec2 vec, Mat2 mat) {
        Vec2 v = new Vec2(vec);
        v.x = (v.x * mat.getMatrixArray()[0][0]) + (v.x * mat.getMatrixArray()[0][1]);
        v.y = (v.y * mat.getMatrixArray()[1][0]) + (v.y * mat.getMatrixArray()[1][1]);
        return v;
    }

    public Vec4 xyxy() {
        return new Vec4(this.x, this.y, this.x, this.y);
    }

    public Vec4 yxyx() {
        return new Vec4(this.y, this.x, this.y, this.x);
    }

    public Vec4 xxxx() {
        return Vec4.filledWith(this.x);
    }

    public Vec4 yyyy() {
        return Vec4.filledWith(this.y);
    }

    public Vec4 xxxy() {
        return new Vec4(this.x, this.x, this.x, this.y);
    }

    public Vec4 yyyx() {
        return new Vec4(this.y, this.y, this.y, this.x);
    }

    public Vec3 xxx() {
        return Vec3.filledWith(this.y);
    }

    public Vec3 yyy() {
        return Vec3.filledWith(this.y);
    }

    public Vec3 xxy() {
        return new Vec3(this.x, this.x, this.y);
    }

    public Vec3 yyx() {
        return new Vec3(this.y, this.y, this.x);
    }

    public Vec2 yx() {
        return new Vec2(this.y, this.x);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float u() {
        return this.x;
    }

    public float v() {
        return this.y;
    }

    public void setU(float u) {
        this.x = u;
    }

    public void setV(float v) {
        this.y = v;
    }

    /**
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the dot product
     */
    public static float dot(Vec2 v1, Vec2 v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static Vec2 filledWith(float n) {
        return new Vec2(n, n);
    }

    public static Vec2 filledWith(double n) {
        return Vec2.filledWith((float) n);
    }

    @Override
    public int compareTo(Vec2 other) {
        return (int) (this.len() - other.len());
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y};
    }

}
