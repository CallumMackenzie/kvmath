package kvmath.graphics;

public class Quaternion extends Vec4 {

    public Quaternion() {
        super(0.f, 0.f, 0.f, 1.f);
    }

    public Quaternion(Vec4 v) {
        this.x = v.x();
        this.y = v.y();
        this.z = v.z();
        this.w = v.w();
    }

    // NOT axis angle
    public Quaternion(Vec3 v, float real) {
        x = v.x();
        y = v.y();
        z = v.z();
        w = real;
    }

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public final Vec3 getComplex() {
        return this.xyz();
    }

    public final void setComplex(Vec3 c) {
        this.x = c.x();
        this.y = c.y();
        this.z = c.z();
    }

    public final float getReal() {
        return this.w;
    }

    public final void setReal(float r) {
        this.w = r;
    }

    public final Quaternion conjugate() {
        return new Quaternion(this.getComplex().mul(-1.f), this.getReal());
    }

    public final Quaternion inverse() {
        return this.conjugate().div(this.len());
    }

    public final Quaternion mul(Quaternion rhs) {
        return new Quaternion(this.y() * rhs.z() - this.z() * rhs.y() + this.x() * rhs.w() + this.w() * rhs.x(),
                this.z() * rhs.x() - this.x() * rhs.z() + this.y() * rhs.w() + this.w() * rhs.y(),
                this.x() * rhs.y() - this.y() * rhs.x() + this.z() * rhs.w() + this.w() * rhs.z(),
                this.w() * rhs.w() - this.x() * rhs.x() - this.y() * rhs.y() - this.z() * rhs.z());
    }

    public final Quaternion mul(float s) {
        return new Quaternion(this.getComplex().mul(s), this.getReal() * s);
    }

    public final Quaternion div(float s) {
        if (s == 0) {
            return new Quaternion();
        }
        return new Quaternion(this.getComplex().div(s), this.getReal() / s);
    }

    public final void scaleAxis(Vec3 w) {
        float theta = w.len();
        if (theta > 0.0001) {
            float s = (float) Math.sin((double) (theta / 2.f));

            Vec3 W = w.div(theta).mul(s);
            this.x = W.x();
            this.y = W.y();
            this.z = W.z();
            this.w = (float) Math.cos((double) (theta / 2.f));
        } else {
            this.set(new Vec4(0.f, 0.f, 0.f, 1.f));
        }
    }

    public final Vec3 rotateVec3(Vec3 v) {
        return (this.mul(new Quaternion(v, 0)).mul(this.conjugate())).getComplex();
    }

    public final void setEuler(Vec3 euler) {
        float c1 = (float) Math.cos((double) (euler.z() * .5f));
        float c2 = (float) Math.cos((double) (euler.y() * .5f));
        float c3 = (float) Math.cos((double) (euler.x() * .5f));
        float s1 = (float) Math.sin((double) (euler.z() * .5f));
        float s2 = (float) Math.sin((double) (euler.y() * .5f));
        float s3 = (float) Math.sin((double) (euler.x() * .5f));

        this.x = c1 * c2 * s3 - s1 * s2 * c3; // x : A
        this.y = c1 * s2 * c3 + s1 * c2 * s3; // y : B
        this.z = s1 * c2 * c3 - c1 * s2 * s3; // z : C
        this.w = c1 * c2 * c3 + s1 * s2 * s3; // w : D
    }

    public final Vec3 getEuler() {
        Vec3 euler = new Vec3();

        double PI_OVER_2 = 3.14159 * 0.5;
        double EPSILON = 1e-10;
        float sqw, sqx, sqy, sqz;

        sqw = this.w * this.w;
        sqx = this.x * this.x;
        sqy = this.y * this.y;
        sqz = this.z * this.z;

        euler.setY((float) Math.asin(
                (double) (2.f * (float) (this.w * this.y - this.x * this.z))));
        if (PI_OVER_2 - Math.abs(euler.y()) > EPSILON) {
            euler.setZ((float) Math.atan2(
                    (double) (2.f * (this.x * this.y + this.w * this.z)),
                    (double) (sqx - sqy - sqz + sqw)));
            euler.setX((float) Math.atan2(
                    (double) (2.f * (this.w * this.x + this.y * this.z)),
                    (double) (sqw - sqx - sqy + sqz)));
        } else {
            euler.setZ((float) Math.atan2(
                    (double) (2.f * this.y * this.z - 2.f * this.x * this.w),
                    (double) (2.f * this.x * this.z + 2.f * this.y * this.w)));
            euler.setX(0);
            if (euler.y() < 0) {
                euler.setZ(3.14159265f - euler.z());
            }
        }
        return euler;
    }

    public static Quaternion axisAngle(Vec3 axis, float angle) {
        return new Quaternion(axis.mul((float) Math.sin((double) (angle * .5f))),
                (float) Math.cos((double) (angle * .5f)));
    }

    public static Quaternion angleAxis(float angle, Vec3 axis) {
        return axisAngle(axis, angle);
    }

    public static Quaternion fromEuler(Vec3 eu) {
        Quaternion ret = new Quaternion();
        ret.setEuler(eu);
        return ret;
    }

    public static Quaternion fromEuler(float x, float y, float z) {
        return Quaternion.fromEuler(new Vec3(x, y, z));
    }
}
