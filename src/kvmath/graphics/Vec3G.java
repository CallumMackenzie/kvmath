package kvmath.graphics;

import java.io.Serializable;

/**
 * A 3 component vector for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Vec3G implements Comparable<Vec3G>, Serializable {

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

    public Vec3G(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3G(float x, float y) {
        this(x, y, 0.f);
    }

    public Vec3G(float x) {
        this(x, 0.f, 0.f);
    }

    public Vec3G() {
        this(0, 0, 0.f);
    }

    public Vec3G(Vec3G v) {
        this(v.x, v.y, v.z);
    }

    public Vec3G(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public Vec3G(double x, double y) {
        this((float) x, (float) y);
    }

    public Vec3G(double x) {
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
    public boolean equalsXY(Vec3G v) {
        return (v.x == this.x && v.y == this.y);
    }

    /**
     *
     * @param v the vector to compare
     * @return whether the x, y, and w components are equal
     */
    public boolean equalsXYZ(Vec3G v) {
        return (v.x == this.x && v.y == this.y && v.z == this.z);
    }

    public final Vec3G add(Vec3G... vs) {
        Vec3G vec = new Vec3G(this);
        for (Vec3G v : vs) {
            vec.x += v.x;
            vec.y += v.y;
            vec.z += v.z;
        }
        return vec;
    }

    public final Vec3G sub(Vec3G... vs) {
        Vec3G vec = new Vec3G(this);
        for (Vec3G v : vs) {
            vec.x -= v.x;
            vec.y -= v.y;
            vec.z -= v.z;
        }
        return vec;
    }

    public final Vec3G mul(Vec3G... vs) {
        Vec3G vec = new Vec3G(this);
        for (Vec3G v : vs) {
            vec.x *= v.x;
            vec.y *= v.y;
            vec.z *= v.z;
        }
        return vec;
    }

    public final Vec3G div(Vec3G... vs) {
        Vec3G vec = new Vec3G(this);
        for (Vec3G v : vs) {
            vec.x /= v.x;
            vec.y /= v.y;
            vec.z /= v.z;
        }
        return vec;
    }

    public final Vec3G mul(float... ns) {
        Vec3G vec = new Vec3G(this);
        for (float n : ns) {
            vec.x *= n;
            vec.y *= n;
            vec.z *= n;
        }
        return vec;
    }

    public final Vec3G add(float... ns) {
        Vec3G vec = new Vec3G(this);
        for (float n : ns) {
            vec.x += n;
            vec.y += n;
            vec.z += n;
        }
        return vec;
    }

    public final Vec3G sub(float... ns) {
        Vec3G vec = new Vec3G(this);
        for (float n : ns) {
            vec.x -= n;
            vec.y -= n;
            vec.z -= n;
        }
        return vec;
    }

    public final Vec3G div(float... ns) {
        Vec3G vec = new Vec3G(this);
        for (float n : ns) {
            vec.x /= n;
            vec.y /= n;
            vec.z /= n;
        }
        return vec;
    }

    public final Vec3G addEquals(Vec3G... vectors) {
        for (var v : vectors) {
            this.addEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3G addEquals(float... ns) {
        for (float f : ns) {
            this.x += f;
            this.y += f;
            this.z += f;
        }
        return this;
    }

    public final Vec3G subEquals(Vec3G... vectors) {
        for (var v : vectors) {
            this.subEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3G subEquals(float... ns) {
        for (float f : ns) {
            this.x -= f;
            this.y -= f;
            this.z -= f;
        }
        return this;
    }

    public final Vec3G mulEquals(Vec3G... vectors) {
        for (var v : vectors) {
            this.mulEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3G mulEquals(float... ns) {
        for (float f : ns) {
            this.x *= f;
            this.y *= f;
            this.z *= f;
        }
        return this;
    }

    public final Vec3G divEquals(Vec3G... vectors) {
        for (Vec3G v : vectors) {
            this.divEqRaw(v.x, v.y, v.z);
        }
        return this;
    }

    public final Vec3G divEquals(float... ns) {
        for (float f : ns) {
            this.x /= f;
            this.y /= f;
            this.z /= f;
        }
        return this;
    }

    public final Vec3G set(Vec3G newVector) {
        return this.setRaw(newVector.x, newVector.y, newVector.z);
    }

    public final Vec3G normalized() {
        Vec3G vec = new Vec3G(this);
        float l = vec.len();
        if (l != 0.f) {
            vec.x /= l;
            vec.y /= l;
            vec.z /= l;
        }
        return vec;
    }

    public final Vec3G normalize() {
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
        if (other instanceof Vec3G) {
            return this.equalsXYZ((Vec3G) other);
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

    public static final float dot(Vec3G v1, Vec3G v2) {
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

    public final Vec4G xyz1() {
        return this.xyzn(1.f);
    }

    public final Vec4G xyzn(float n) {
        return new Vec4G(this.x, this.y, this.z, n);
    }

    public final Vec3G zyx() {
        return new Vec3G(this.z, this.y, this.x);
    }

    public final Vec2G xy() {
        return new Vec2G(this.x, this.y);
    }

    public static final Vec3G cross(Vec3G v1, Vec3G v2) {
        Vec3G v = new Vec3G();
        v.x = v1.y * v2.z - v1.z * v2.y;
        v.y = v1.z * v2.x - v1.x * v2.z;
        v.z = v1.x * v2.y - v1.y * v2.x;
        return v;
    }

    public static final Vec3G filledWith(float n) {
        return new Vec3G(n, n, n);
    }

    public static final Vec3G filledWith(double n) {
        return Vec3G.filledWith((float) n);
    }

    @Override
    public int compareTo(Vec3G other) {
        return (int) (this.len() - other.len());
    }

    public final int rgbAsInt() {
        int ret = 0;
        Vec3G col = this.mul(255.f);
        ret |= ((int) col.r() & 0xff);
        ret <<= 8;
        ret |= ((int) col.g() & 0xff);
        ret <<= 8;
        ret |= ((int) col.b() & 0xff);
        return ret;
    }

    public final int bgrAsInt() {
        int ret = 0;
        Vec3G col = this.mul(255.f);
        ret |= ((int) col.b() & 0xff);
        ret <<= 8;
        ret |= ((int) col.g() & 0xff);
        ret <<= 8;
        ret |= ((int) col.r() & 0xff);
        return ret;
    }

    public final Vec3G restrictedColor() {
        Vec3G r = new Vec3G(this);
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

    public final Vec3G sqrt() {
        this.x = (float) Math.sqrt(x);
        this.y = (float) Math.sqrt(y);
        this.z = (float) Math.sqrt(z);
        return this;
    }

    public final Vec3G sqrted() {
        return new Vec3G(this).sqrt();
    }

    public final Vec3G reflected(Vec3G normal) {
        return this.subEquals(normal.mul(Vec3G.dot(this, normal) * 2.f));
    }

    public final static Vec3G reflect(Vec3G ray, Vec3G norm) {
        return new Vec3G(ray).reflected(norm);
    }

    public final Vec3G addEqRaw(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public final Vec3G mulEqRaw(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public final Vec3G subEqRaw(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public final Vec3G divEqRaw(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }

    public final Vec3G addRaw(float x, float y, float z) {
        Vec3G r = new Vec3G(this);
        r.x += x;
        r.y += y;
        r.z += z;
        return r;
    }

    public final Vec3G mulRaw(float x, float y, float z) {
        Vec3G r = new Vec3G(this);
        r.x *= x;
        r.y *= y;
        r.z *= z;
        return r;
    }

    public final Vec3G subRaw(float x, float y, float z) {
        Vec3G r = new Vec3G(this);
        r.x -= x;
        r.y -= y;
        r.z -= z;
        return r;
    }

    public final Vec3G divRaw(float x, float y, float z) {
        Vec3G r = new Vec3G(this);
        r.x -= x;
        r.y -= y;
        r.z -= z;
        return r;
    }

    public final Vec3G setRaw(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public final float lenSquared() {
        float len = this.len();
        return len * len;
    }

    public final float dot(Vec3G other) {
        return Vec3G.dot(this, other);
    }

    public static final Vec3G refract(Vec3G in, Vec3G normal, float refractionRatio) {
        return refractWithCosine(in, normal, refractionRatio, Math.min(in.dot(normal), 1));
    }

    public static final Vec3G refractWithCosine(Vec3G in, Vec3G normal,
            float refractionRatio, float cosTheta) {
        Vec3G perp = in.add(normal.mul(cosTheta)).mulEquals(refractionRatio);
        Vec3G para = normal.mul((float) -Math.sqrt(Math.abs(1.0 - perp.lenSquared())));
        return perp.addEquals(para);
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y, this.z};
    }

}
