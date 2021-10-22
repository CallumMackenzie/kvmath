package kvmath.graphics;

public class Vec4G implements Comparable<Vec4G> {

    protected float x, y, z, w;

    public Vec4G(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4G(float x, float y, float z) {
        this(x, y, z, 1.f);
    }

    public Vec4G(float x, float y) {
        this(x, y, 0.f, 1.f);
    }

    public Vec4G(float x) {
        this(x, 0.f, 0.f, 1.f);
    }

    public Vec4G() {
        this(0.f, 0.f, 0.f, 1.f);
    }

    public Vec4G(Vec4G v) {
        this(v.x, v.y, v.z, v.w);
    }

    public Vec4G(double x, double y, double z, double w) {
        this((float) x, (float) y, (float) z, (float) w);
    }

    public Vec4G(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vec4G(double x, double y) {
        this((float) x, (float) y);
    }

    public Vec4G(double x) {
        this((float) x);
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setX(double x) {
        this.x = (float) x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setY(double y) {
        this.y = (float) y;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setZ(double z) {
        this.z = (float) z;
    }

    public float getW() {
        return this.w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setW(double w) {
        this.w = (float) w;
    }

    public static Vec4G mulMat4(Vec4G v, Mat4G mat) {
        float[][] m = mat.getM();
        return new Vec4G(
                v.x * m[0][0] + v.y * m[1][0] + v.z * m[2][0] + v.w * m[3][0],
                v.x * m[0][1] + v.y * m[1][1] + v.z * m[2][1] + v.w * m[3][1],
                v.x * m[0][2] + v.y * m[1][2] + v.z * m[2][2] + v.w * m[3][2],
                v.x * m[0][3] + v.y * m[1][3] + v.z * m[2][3] + v.w * m[3][3]);
    }

    public Vec4G mulMat4(Mat4G m) {
        return Vec4G.mulMat4(this, m);
    }

    /**
     *
     * @param vs any number of vectors to add
     * @return a new Vec4G with the sum
     */
    public Vec4G add(Vec4G... vs) {
        Vec4G vec = new Vec4G(this);
        for (Vec4G v : vs) {
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
     * @return a new Vec4G with the difference
     */
    public Vec4G sub(Vec4G... vs) {
        Vec4G vec = new Vec4G(this);
        for (Vec4G v : vs) {
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
     * @return a new Vec4G with the product
     */
    public Vec4G mul(Vec4G... vs) {
        Vec4G vec = new Vec4G(this);
        for (Vec4G v : vs) {
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
     * @return a new Vec4G with the quotient
     */
    public Vec4G div(Vec4G... vs) {
        Vec4G vec = new Vec4G(this);
        for (Vec4G v : vs) {
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
     * @return a new Vec4G with the product
     */
    public Vec4G mulFloat(float... ns) {
        Vec4G vec = new Vec4G(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
            vec.z *= n;
            vec.w *= n;
        }
        return vec;
    }

    public Vec4G mul(float... ns) {
        return this.mulFloat(ns);
    }

    /**
     *
     * @param ns floats to add
     * @return a new Vec4G with the sum
     */
    public Vec4G addFloat(float... ns) {
        Vec4G vec = new Vec4G(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
            vec.z += n;
            vec.w += n;
        }
        return vec;
    }

    public Vec4G add(float... ns) {
        return this.addFloat(ns);
    }

    /**
     *
     * @param ns floats to multiply
     * @return a new Vec4G with the difference
     */
    public Vec4G subFloat(float... ns) {
        Vec4G vec = new Vec4G(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
            vec.z -= n;
            vec.w -= n;
        }
        return vec;
    }

    public Vec4G sub(float... ns) {
        return this.subFloat(ns);
    }

    /**
     *
     * @param ns floats to multiply
     * @return a new Vec4G with the product
     */
    public Vec4G divFloat(float... ns) {
        Vec4G vec = new Vec4G(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;
            vec.z /= n;
            vec.w /= n;
        }
        return vec;
    }

    public Vec4G div(float... ns) {
        return this.divFloat(ns);
    }

    public Vec4G addEquals(Vec4G... vectors) {
        return this.set(this.add(vectors));
    }

    public Vec4G addEquals(float... ns) {
        return this.set(this.add(ns));
    }

    public Vec4G subEquals(Vec4G... vectors) {
        return this.set(this.sub(vectors));
    }

    public Vec4G subEquals(float... ns) {
        return this.set(this.sub(ns));
    }

    public Vec4G mulEquals(Vec4G... vectors) {
        return this.set(this.mul(vectors));
    }

    public Vec4G mulEquals(float... ns) {
        return this.set(this.mul(ns));
    }

    public Vec4G divEquals(Vec4G... vectors) {
        return this.set(this.div(vectors));
    }

    public Vec4G divEquals(float... ns) {
        return this.set(this.div(ns));
    }

    public Vec4G set(Vec4G newVector) {
        this.x = newVector.x;
        this.y = newVector.y;
        this.z = newVector.z;
        this.w = newVector.w;
        return this;
    }

    /**
     *
     * @return a copy of the Vec4G normalized
     */
    public Vec4G normalized() {
        Vec4G vec = new Vec4G(this);
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
     * Normalizes the Vec4G
     */
    public void normalize() {
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
    public boolean equalsXYZ(Vec4G v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x, y, z, and w components are equal
     */
    public boolean equalsXYZW(Vec4G v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z && v.w == this.w);
    }

    /**
     * @return the length of the Vec4G
     */
    public float len() {
        return (float) Math.sqrt(Vec4G.dot(this, this));
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vec4G) {
            return this.equalsXYZW((Vec4G) o);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vec4G(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
    }

    /**
     *
     * @param v1 the first Vec4G
     * @param v2 the second Vec4G
     * @return the dot product
     */
    public static float dot(Vec4G v1, Vec4G v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
    }

    public static Vec4G filledWith(float v) {
        return new Vec4G(v, v, v, v);
    }

    public static Vec4G filledWith(double v) {
        return filledWith((float) v);
    }

    public float x() {
        return this.x;
    }

    public float y() {
        return this.y;
    }

    public float z() {
        return this.z;
    }

    public float w() {
        return this.w;
    }

    public Vec3G xyz() {
        return new Vec3G(this.x, this.y, this.z);
    }

    public Vec3G rgb() {
        return this.xyz();
    }

    public Vec2G xy() {
        return new Vec2G(this.x, this.y);
    }

    public Vec2G uv() {
        return new Vec2G(this.x, this.y);
    }

    public Vec2G zw() {
        return new Vec2G(this.z, this.w);
    }

    public Vec2G st() {
        return new Vec2G(this.z, this.w);
    }

    public float r() {
        return this.x;
    }

    public float g() {
        return this.y;
    }

    public float b() {
        return this.z;
    }

    public float a() {
        return this.w;
    }

    public void setR(float r) {
        this.x = r;
    }

    public void setG(float g) {
        this.y = g;
    }

    public void setB(float b) {
        this.z = b;
    }

    public void setA(float a) {
        this.w = a;
    }

    @Override
    public int compareTo(Vec4G other) {
        return (int) (this.len() - other.len());
    }

    public int rgbaAsInt() {
        int ret = 0;
        Vec4G col = this.mul(255.f);
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.a() & 0xff;
        return ret;
    }

    public int argbAsInt() {
        int ret = 0;
        Vec4G col = this.mul(255.f);
        ret |= (int) col.a() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        return ret;
    }

    public int abgrAsInt() {
        int ret = 0;
        Vec4G col = this.mul(255.f);
        ret |= (int) col.a() & 0xff;
        ret <<= 8;
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        return ret;
    }

    public int bgraAsInt() {
        int ret = 0;
        Vec4G col = this.mul(255.f);
        ret |= (int) col.b() & 0xff;
        ret <<= 8;
        ret |= (int) col.g() & 0xff;
        ret <<= 8;
        ret |= (int) col.r() & 0xff;
        ret <<= 8;
        ret |= (int) col.a() & 0xff;
        return ret;
    }

    public Vec4G restrictedColor() {
        Vec4G r = new Vec4G(this);
        if (r.x > 1) {
            r.x = 1;
        }
        if (r.x < 0) {
            r.x = 0;
        }
        if (r.y > 1) {
            r.y = 1;
        }
        if (r.y < 0) {
            r.y = 0;
        }
        if (r.z > 1) {
            r.z = 1;
        }
        if (r.z < 0) {
            r.z = 0;
        }
        if (r.w > 1) {
            r.w = 1;
        }
        if (r.w < 0) {
            r.w = 0;
        }
        return r;
    }
}
