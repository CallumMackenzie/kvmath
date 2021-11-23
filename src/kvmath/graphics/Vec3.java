package kvmath.graphics;

import java.io.Serializable;

/**
 * A 3 component vector for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Vec3 implements Comparable<Vec3>, Serializable {

    public static final long serialVersionUID = 873891209L;

    protected float x, y, z;

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

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(float x, float y) {
        this(x, y, 0.f);
    }

    public Vec3(float x) {
        this(x, 0.f, 0.f);
    }

    public Vec3() {
        this(0, 0, 0.f);
    }

    public Vec3(Vec3 v) {
        this(v.x, v.y, v.z);
    }

    public Vec3(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vec3(double x, double y) {
        this((float) x, (float) y);
    }

    public Vec3(double x) {
        this((float) x);
    }

    public final float len() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x and y components are equal
     */
    public boolean equalsXY(Vec3 v) {
        return (v.x == this.x && v.y == this.y);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x, y, and w components are equal
     */
    public boolean equalsXYZ(Vec3 v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z);
    }

    public final Vec3 add(Vec3... vs) {
        Vec3 vec = new Vec3(this);
        for (Vec3 v : vs) {
            vec.x += v.x;
            vec.y += v.y;
            vec.z += v.z;
        }
        return vec;
    }

    public final Vec3 sub(Vec3... vs) {
        Vec3 vec = new Vec3(this);
        for (Vec3 v : vs) {
            vec.x -= v.x;
            vec.y -= v.y;
            vec.z -= v.z;
        }
        return vec;
    }

    public final Vec3 mul(Vec3... vs) {
        Vec3 vec = new Vec3(this);
        for (Vec3 v : vs) {
            vec.x *= v.x;
            vec.y *= v.y;
            vec.z *= v.z;
        }
        return vec;
    }

    public final Vec3 div(Vec3... vs) {
        Vec3 vec = new Vec3(this);
        for (Vec3 v : vs) {
            vec.x /= v.x;
            vec.y /= v.y;
            vec.z /= v.z;
        }
        return vec;
    }

    public final Vec3 mul(float... ns) {
        Vec3 vec = new Vec3(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
            vec.z *= n;
        }
        return vec;
    }

    public final Vec3 add(float... ns) {
        Vec3 vec = new Vec3(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
            vec.z += n;
        }
        return vec;
    }

    public final Vec3 sub(float... ns) {
        Vec3 vec = new Vec3(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
            vec.z -= n;
        }
        return vec;
    }

    public final Vec3 div(float... ns) {
        Vec3 vec = new Vec3(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;
            vec.z /= n;
        }
        return vec;
    }

    public final Vec3 addEquals(Vec3... vectors) {
        for (var v : vectors) {
            this.addEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3 addEquals(float... ns) {
        for (float f : ns) {
            this.x += f;
            this.y += f;
            this.z += f;
        }
        return this;
    }

    public final Vec3 subEquals(Vec3... vectors) {
        for (var v : vectors) {
            this.subEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3 subEquals(float... ns) {
        for (float f : ns) {
            this.x -= f;
            this.y -= f;
            this.z -= f;
        }
        return this;
    }

    public final Vec3 mulEquals(Vec3... vectors) {
        for (var v : vectors) {
            this.mulEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3 mulEquals(float... ns) {
        for (float f : ns) {
            this.x *= f;
            this.y *= f;
            this.z *= f;
        }
        return this;
    }

    public final Vec3 divEquals(Vec3... vectors) {
        for (Vec3 v : vectors) {
            this.divEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3 divEquals(float... ns) {
        for (float f : ns) {
            this.x /= f;
            this.y /= f;
            this.z /= f;
        }
        return this;
    }

    public final Vec3 set(Vec3 newVector) {
        return this.setRaw(newVector.x, newVector.y, newVector.z);
    }

    public final Vec3 normalized() {
        Vec3 vec = new Vec3(this);
        float l = vec.len();
        if (l != 0.f) {
            vec.x /= l;
            vec.y /= l;
            vec.z /= l;
        }
        return vec;
    }

    public final Vec3 normalize() {
        float l = this.len();
        if (l != 0.f) {
            this.x /= l;
            this.y /= l;
            this.z /= l;
        }
        return this;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Vec3) {
            return this.equalsXYZ((Vec3) other);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Vec3G(")
                .append(this.x)
                .append(",")
                .append(this.y)
                .append(",")
                .append(this.z)
                .append(")").toString();
    }

    public static final float dot(Vec3 v1, Vec3 v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
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

    public final float r() {
        return this.x;
    }

    public final float g() {
        return this.y;
    }

    public final float b() {
        return this.z;
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

    public final Vec4 xyz1() {
        return this.xyzn(1.f);
    }

    public final Vec4 xyzn(float n) {
        return new Vec4(this.x, this.y, this.z, n);
    }

    public final Vec3 zyx() {
        return new Vec3(this.z, this.y, this.x);
    }

    public final Vec2 xy() {
        return new Vec2(this.x, this.y);
    }

    public static final Vec3 cross(Vec3 v1, Vec3 v2) {
        Vec3 v = new Vec3();
        v.x = v1.y * v2.z - v1.z * v2.y;
        v.y = v1.z * v2.x - v1.x * v2.z;
        v.z = v1.x * v2.y - v1.y * v2.x;
        return v;
    }

    public static final Vec3 filledWith(float n) {
        return new Vec3(n, n, n);
    }

    public static final Vec3 filledWith(double n) {
        return Vec3.filledWith((float) n);
    }

    @Override
    public int compareTo(Vec3 other) {
        return (int) (this.len() - other.len());
    }

    public final int rgbAsInt() {
        int ret = 0;
        Vec3 col = this.mul(255.f);
        ret |= ((int) col.r() & 0xff);
        ret <<= 8;
        ret |= ((int) col.g() & 0xff);
        ret <<= 8;
        ret |= ((int) col.b() & 0xff);
        return ret;
    }

    public final int bgrAsInt() {
        int ret = 0;
        Vec3 col = this.mul(255.f);
        ret |= ((int) col.b() & 0xff);
        ret <<= 8;
        ret |= ((int) col.g() & 0xff);
        ret <<= 8;
        ret |= ((int) col.r() & 0xff);
        return ret;
    }

    public final Vec3 restrictedColor() {
        Vec3 r = new Vec3(this);
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
        return r;
    }

    public final Vec3 sqrt() {
        this.x = (float) Math.sqrt(x);
        this.y = (float) Math.sqrt(y);
        this.z = (float) Math.sqrt(z);
        return this;
    }

    public final Vec3 sqrted() {
        return new Vec3(this).sqrt();
    }

    public final Vec3 reflected(Vec3 normal) {
        return this.subEquals(normal.mul(Vec3.dot(this, normal) * 2.f));
    }

    public final static Vec3 reflect(Vec3 ray, Vec3 norm) {
        return new Vec3(ray).reflected(norm);
    }

    public final Vec3 addEqRaw(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public final Vec3 mulEqRaw(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public final Vec3 subEqRaw(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public final Vec3 divEqRaw(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }

    public final Vec3 addRaw(float x, float y, float z) {
        Vec3 r = new Vec3(this);
        r.x += x;
        r.y += y;
        r.z += z;
        return r;
    }

    public final Vec3 mulRaw(float x, float y, float z) {
        Vec3 r = new Vec3(this);
        r.x *= x;
        r.y *= y;
        r.z *= z;
        return r;
    }

    public final Vec3 subRaw(float x, float y, float z) {
        Vec3 r = new Vec3(this);
        r.x -= x;
        r.y -= y;
        r.z -= z;
        return r;
    }

    public final Vec3 divRaw(float x, float y, float z) {
        Vec3 r = new Vec3(this);
        r.x -= x;
        r.y -= y;
        r.z -= z;
        return r;
    }

    public final Vec3 setRaw(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public final float lenSquared() {
        float len = this.len();
        return len * len;
    }

    public final float dot(Vec3 other) {
        return Vec3.dot(this, other);
    }

    public static final Vec3 refract(Vec3 in, Vec3 normal, float refractionRatio) {
        return refractWithCosine(in, normal, refractionRatio, Math.min(in.dot(normal), 1));
    }

    public static final Vec3 refractWithCosine(Vec3 in, Vec3 normal,
            float refractionRatio, float cosTheta) {
        Vec3 perp = in.add(normal.mul(cosTheta)).mulEquals(refractionRatio);
        Vec3 para = normal.mul((float) -Math.sqrt(Math.abs(1.0 - perp.lenSquared())));
        return perp.addEquals(para);
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y, this.z};
    }

}
