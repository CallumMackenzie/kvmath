package kvmath.graphics;

import java.io.Serializable;

/**
 * A 4 component vector for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Vec4 implements Comparable<Vec4>, Serializable {

    public static final long serialVersionUID = 87583783L;

    protected float x, y, z, w;

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4(float x, float y, float z) {
        this(x, y, z, 1.f);
    }

    public Vec4(float x, float y) {
        this(x, y, 0.f, 1.f);
    }

    public Vec4(float x) {
        this(x, 0.f, 0.f, 1.f);
    }

    public Vec4() {
        this(0.f, 0.f, 0.f, 1.f);
    }

    public Vec4(Vec4 v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vec4(double x, double y, double z, double w) {
        this((float) x, (float) y, (float) z, (float) w);
    }

    public Vec4(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vec4(double x, double y) {
        this((float) x, (float) y);
    }

    public Vec4(double x) {
        this((float) x);
    }

    public final float getX() {
        return this.x;
    }

    public final void setX(float x) {
        this.x = x;
    }

    public final void setX(double x) {
        this.x = (float) x;
    }

    public final float getY() {
        return this.y;
    }

    public final void setY(float y) {
        this.y = y;
    }

    public final void setY(double y) {
        this.y = (float) y;
    }

    public final float getZ() {
        return this.z;
    }

    public final void setZ(float z) {
        this.z = z;
    }

    public final void setZ(double z) {
        this.z = (float) z;
    }

    public final float getW() {
        return this.w;
    }

    public final void setW(float w) {
        this.w = w;
    }

    public final void setW(double w) {
        this.w = (float) w;
    }

    public static Vec4 mulMat4(Vec4 v, Mat4 mat) {
        float[][] m = mat.getMatrixArray();
        return new Vec4(
                v.x * m[0][0] + v.y * m[1][0] + v.z * m[2][0] + v.w * m[3][0],
                v.x * m[0][1] + v.y * m[1][1] + v.z * m[2][1] + v.w * m[3][1],
                v.x * m[0][2] + v.y * m[1][2] + v.z * m[2][2] + v.w * m[3][2],
                v.x * m[0][3] + v.y * m[1][3] + v.z * m[2][3] + v.w * m[3][3]);
    }

    public final Vec4 mulMat4(Mat4 m) {
        return Vec4.mulMat4(this, m);
    }

    /**
     *
     * @param vs any number of vectors to add
     * @return a new Vec4 with the sum
     */
    public final Vec4 add(Vec4... vs) {
        Vec4 vec = new Vec4(this);
        for (Vec4 v : vs) {
            vec.x += v.x;
            vec.y += v.y;
            vec.z += v.z;
            vec.w += v.w;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to subtract
     * @return a new Vec4 with the difference
     */
    public final Vec4 sub(Vec4... vs) {
        Vec4 vec = new Vec4(this);
        for (Vec4 v : vs) {
            vec.x -= v.x;
            vec.y -= v.y;
            vec.z -= v.z;
            vec.w -= v.w;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to multiply
     * @return a new Vec4 with the product
     */
    public final Vec4 mul(Vec4... vs) {
        Vec4 vec = new Vec4(this);
        for (Vec4 v : vs) {
            vec.x *= v.x;
            vec.y *= v.y;
            vec.z *= v.z;
            vec.w *= v.w;
        }
        return vec;
    }

    /**
     *
     * @param vs any number of vectors to divide
     * @return a new Vec4 with the quotient
     */
    public final Vec4 div(Vec4... vs) {
        Vec4 vec = new Vec4(this);
        for (Vec4 v : vs) {
            vec.x /= v.x;
            vec.y /= v.y;
            vec.z /= v.z;
            vec.w /= v.w;
        }
        return vec;
    }

    /**
     *
     * @param ns floats to multiply
     * @return a new Vec4 with the product
     */
    public final Vec4 mul(float... ns) {
        Vec4 vec = new Vec4(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
            vec.z *= n;
            vec.w *= n;
        }
        return vec;
    }

    /**
     *
     * @param ns floats to add
     * @return a new Vec4 with the sum
     */
    public final Vec4 add(float... ns) {
        Vec4 vec = new Vec4(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
            vec.z += n;
            vec.w += n;
        }
        return vec;
    }

    /**
     *
     * @param ns floats to multiply
     * @return a new Vec4 with the difference
     */
    public final Vec4 sub(float... ns) {
        Vec4 vec = new Vec4(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
            vec.z -= n;
            vec.w -= n;
        }
        return vec;
    }

    /**
     *
     * @param ns floats to multiply
     * @return a new Vec4 with the product
     */
    public final Vec4 div(float... ns) {
        Vec4 vec = new Vec4(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;
            vec.z /= n;
            vec.w /= n;
        }
        return vec;
    }

    public final Vec4 addEquals(Vec4... vectors) {
        return this.set(this.add(vectors));
    }

    public final Vec4 addEquals(float... ns) {
        return this.set(this.add(ns));
    }

    public final Vec4 subEquals(Vec4... vectors) {
        return this.set(this.sub(vectors));
    }

    public final Vec4 subEquals(float... ns) {
        return this.set(this.sub(ns));
    }

    public final Vec4 mulEquals(Vec4... vectors) {
        return this.set(this.mul(vectors));
    }

    public final Vec4 mulEquals(float... ns) {
        return this.set(this.mul(ns));
    }

    public final Vec4 divEquals(Vec4... vectors) {
        return this.set(this.div(vectors));
    }

    public final Vec4 divEquals(float... ns) {
        return this.set(this.div(ns));
    }

    public final Vec4 set(Vec4 newVector) {
        this.x = newVector.x;
        this.y = newVector.y;
        this.z = newVector.z;
        this.w = newVector.w;
        return this;
    }

    /**
     *
     * @return a copy of the Vec4 normalized
     */
    public final Vec4 normalized() {
        Vec4 vec = new Vec4(this);
        float l = vec.len();
        if (l != 0.f) {
            vec.x /= l;
            vec.y /= l;
            vec.z /= l;
            vec.w /= l;
        }
        return vec;
    }

    /**
     *
     * Normalizes the Vec4
     */
    public final void normalize() {
        float l = this.len();
        if (l != 0.f) {
            this.x /= l;
            this.y /= l;
            this.z /= l;
            this.w /= l;
        }
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x, y, and z components are equal
     */
    public final boolean equalsXYZ(Vec4 v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x, y, z, and w components are equal
     */
    public final boolean equalsXYZW(Vec4 v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z && v.w == this.w);
    }

    /**
     * @return the length of the Vec4
     */
    public final float len() {
        return (float) Math.sqrt(Vec4.dot(this, this));
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec4) {
            return this.equalsXYZW((Vec4) o);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vec4G(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
    }

    /**
     *
     * @param v1 the first Vec4
     * @param v2 the second Vec4
     * @return the dot product
     */
    public static float dot(Vec4 v1, Vec4 v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
    }

    public static Vec4 filledWith(float v) {
        return new Vec4(v, v, v, v);
    }

    public static Vec4 filledWith(double v) {
        return filledWith((float) v);
    }

    public final float x() {
        return this.x;
    }

    public final float y() {
        return this.y;
    }

    public final float z() {
        return this.z;
    }

    public final float w() {
        return this.w;
    }

    public final Vec3 xyz() {
        return new Vec3(this.x, this.y, this.z);
    }

    public final Vec3 rgb() {
        return this.xyz();
    }

    public final Vec2 xy() {
        return new Vec2(this.x, this.y);
    }

    public final Vec2 uv() {
        return new Vec2(this.x, this.y);
    }

    public final Vec2 zw() {
        return new Vec2(this.z, this.w);
    }

    public final Vec2 st() {
        return new Vec2(this.z, this.w);
    }

    public final float r() {
        return this.x;
    }

    public final float g() {
        return this.y;
    }

    public final float b() {
        return this.z;
    }

    public final float a() {
        return this.w;
    }

    public final void setR(float r) {
        this.x = r;
    }

    public final void setG(float g) {
        this.y = g;
    }

    public final void setB(float b) {
        this.z = b;
    }

    public final void setA(float a) {
        this.w = a;
    }

    @Override
    public int compareTo(Vec4 other) {
        return (int) (this.len() - other.len());
    }

    public final int rgbaAsInt() {
        int ret = 0;
        Vec4 col = this.mul(255.f);
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.a() & 0xff;
        return ret;
    }

    public final int argbAsInt() {
        int ret = 0;
        Vec4 col = this.mul(255.f);
        ret |= (int) col.a() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        return ret;
    }

    public final int abgrAsInt() {
        int ret = 0;
        Vec4 col = this.mul(255.f);
        ret |= (int) col.a() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        return ret;
    }

    public final int bgraAsInt() {
        int ret = 0;
        Vec4 col = this.mul(255.f);
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.a() & 0xff;
        return ret;
    }

    public final Vec4 restrictedColor() {
        Vec4 r = new Vec4(this);
        r.x = restrict(1, 0, r.x);
        r.y = restrict(1, 0, r.y);
        r.z = restrict(1, 0, r.z);
        r.w = restrict(1, 0, r.w);
        return r;
    }

    private static float restrict(float upper, float lower, float res) {
        if (res > upper) {
            res = upper;
        }
        if (res < lower) {
            res = lower;
        }
        return res;
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y, this.z, this.w};
    }
}
