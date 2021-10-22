package kvmath.graphics;

public class Vec2G implements Comparable<Vec2G> {

    protected float x, y;

    float getX() {
        return this.x;
    }

    void setX(float x) {
        this.x = x;
    }

    void setX(double x) {
        this.x = (float) x;
    }

    float getY() {
        return this.y;
    }

    void setY(float y) {
        this.y = y;
    }

    void setY(double y) {
        this.y = (float) y;
    }

    public Vec2G(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vec2G(float x) {
        this(x, 0.f);
    }

    public Vec2G() {
        this(0);
    }

    public Vec2G(Vec2G v) {
        this(v.x, v.y);
    }

    public Vec2G(double x, double y) {
        this((float) x, (float) y);
    }

    /**
     * Creates a new Vec2G casting input doubles to floats
     *
     * @param x the x component
     */
    public Vec2G(double x) {
        this((float) x);
    }

    public float len() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vec2G sub(Vec2G... vs) {
        Vec2G vec = new Vec2G(this);
        for (Vec2G v : vs) {
            vec.x -= v.x;
            vec.y -= v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2G with the passed values added to it
     */
    public Vec2G add(Vec2G... vs) {
        Vec2G vec = new Vec2G(this);
        for (Vec2G v : vs) {
            vec.x += v.x;
            vec.y += v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2G multiplied by the passed values
     */
    public Vec2G mul(Vec2G... vs) {
        Vec2G vec = new Vec2G(this);
        for (Vec2G v : vs) {
            vec.x *= v.x;
            vec.y *= v.y;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a copy of the Vec2G divided by the passed values
     */
    public Vec2G div(Vec2G... vs) {
        Vec2G vec = new Vec2G(this);
        for (Vec2G v : vs) {
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
     * Normalizes the Vec2G
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
     * @return a copy of the Vec2G normalized
     */
    public Vec2G normalized() {
        float l = len();
        if (l == 0) {
            l = 1.f;
        }
        return new Vec2G(this.x / l, this.y / l);
    }

    public Vec2G mulFloat(float... ns) {
        Vec2G vec = new Vec2G(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
        }
        return vec;
    }

    public Vec2G mul(float... f) {
        return this.mulFloat(f);
    }

    public Vec2G divFloat(float... ns) {
        Vec2G vec = new Vec2G(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;

        }
        return vec;
    }

    public Vec2G div(float... f) {
        return this.divFloat(f);
    }

    public Vec2G addFloat(float... ns) {
        Vec2G vec = new Vec2G(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
        }
        return vec;
    }

    public Vec2G add(float... f) {
        return this.addFloat(f);
    }

    public Vec2G subFloat(float... ns) {
        Vec2G vec = new Vec2G(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
        }
        return vec;
    }

    public Vec2G sub(float... f) {
        return this.subFloat(f);
    }

    /**
     *
     * @param mat the matrix to multiply by
     * @return the product
     */
    public Vec2G mulMat2(Mat2G mat) {
        return Vec2G.mulMat2(this, mat);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x and y components are equal
     */
    public boolean equalsXY(Vec2G v) {
        return (v.x == this.x && v.y == this.y);
    }

    public Vec2G addEquals(Vec2G... vectors) {
        return this.set(this.add(vectors));
    }

    public Vec2G addEquals(float... ns) {
        return this.set(this.add(ns));
    }

    public Vec2G subEquals(Vec2G... vectors) {
        return this.set(this.sub(vectors));
    }

    public Vec2G subEquals(float... ns) {
        return this.set(this.sub(ns));
    }

    public Vec2G mulEquals(Vec2G... vectors) {
        return this.set(this.mul(vectors));
    }

    public Vec2G mulEquals(float... ns) {
        return this.set(this.mul(ns));
    }

    public Vec2G divEquals(Vec2G... vectors) {
        return this.set(this.div(vectors));
    }

    public Vec2G divEquals(float... ns) {
        return this.set(this.div(ns));
    }

    public Vec2G set(Vec2G newVector) {
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
        if (o instanceof Vec2G) {
            return this.equalsXY((Vec2G) o);
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
    public static Vec2G mulMat2(Vec2G vec, Mat2G mat) {
        Vec2G v = new Vec2G(vec);
        v.x = (v.x * mat.getM()[0][0]) + (v.x * mat.getM()[0][1]);
        v.y = (v.y * mat.getM()[1][0]) + (v.y * mat.getM()[1][1]);
        return v;
    }

    public Vec4G xyxy() {
        return new Vec4G(this.x, this.y, this.x, this.y);
    }

    public Vec4G yxyx() {
        return new Vec4G(this.y, this.x, this.y, this.x);
    }

    public Vec4G xxxx() {
        return Vec4G.filledWith(this.x);
    }

    public Vec4G yyyy() {
        return Vec4G.filledWith(this.y);
    }

    public Vec4G xxxy() {
        return new Vec4G(this.x, this.x, this.x, this.y);
    }

    public Vec4G yyyx() {
        return new Vec4G(this.y, this.y, this.y, this.x);
    }

    public Vec3G xxx() {
        return Vec3G.filledWith(this.y);
    }

    public Vec3G yyy() {
        return Vec3G.filledWith(this.y);
    }

    public Vec3G xxy() {
        return new Vec3G(this.x, this.x, this.y);
    }

    public Vec3G yyx() {
        return new Vec3G(this.y, this.y, this.x);
    }

    public Vec2G yx() {
        return new Vec2G(this.y, this.x);
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

    public static float dot(Vec2G v1, Vec2G v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    public static Vec2G filledWith(float n) {
        return new Vec2G(n, n);
    }

    public static Vec2G filledWith(double n) {
        return Vec2G.filledWith((float) n);
    }

    @Override
    public int compareTo(Vec2G other) {
        return (int) (this.len() - other.len());
    }
}