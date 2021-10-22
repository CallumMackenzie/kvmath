package kvmath.graphics;

public class QuaternionG extends Vec4G {

    public QuaternionG() {
        super(0.f, 0.f, 0.f, 1.f);
    }

    public QuaternionG(Vec4G v) {
        this.x = v.x();
        this.y = v.y();
        this.z = v.z();
        this.w = v.w();
    }

    // NOT axis angle
    public QuaternionG(Vec3G v, float real) {
        x = v.x();
        y = v.y();
        z = v.z();
        w = real;
    }

    public QuaternionG(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec3G getComplex() {
        return this.xyz();
    }

    public void setComplex(Vec3G c) {
        this.x = c.x();
        this.y = c.y();
        this.z = c.z();
    }

    public float getReal() {
        return this.w;
    }

    public void setReal(float r) {
        this.w = r;
    }

    public QuaternionG conjugate() {
        return new QuaternionG(this.getComplex().mul(-1.f), this.getReal());
    }

    public QuaternionG inverse() {
        return this.conjugate().div(this.len());
    }

    public QuaternionG mul(QuaternionG rhs) {
        return new QuaternionG(this.y() * rhs.z() - this.z() * rhs.y() + this.x() * rhs.w() + this.w() * rhs.x(),
                this.z() * rhs.x() - this.x() * rhs.z() + this.y() * rhs.w() + this.w() * rhs.y(),
                this.x() * rhs.y() - this.y() * rhs.x() + this.z() * rhs.w() + this.w() * rhs.z(),
                this.w() * rhs.w() - this.x() * rhs.x() - this.y() * rhs.y() - this.z() * rhs.z());
    }

    public QuaternionG mul(float s) {
        return new QuaternionG(this.getComplex().mul(s), this.getReal() * s);
    }

    public QuaternionG div(float s) {
        if (s == 0) {
            return new QuaternionG();
        }
        return new QuaternionG(this.getComplex().div(s), this.getReal() / s);
    }

    public void scaleAxis(Vec3G w) {
        float theta = w.len();
        if (theta > 0.0001) {
            float s = (float) Math.sin((double) (theta / 2.f));

            Vec3G W = w.div(theta).mul(s);
            this.x = W.x();
            this.y = W.y();
            this.z = W.z();
            this.w = (float) Math.cos((double) (theta / 2.f));
        } else {
            this.set(new Vec4G(0.f, 0.f, 0.f, 1.f));
        }
    }

    public Vec3G rotateVec3(Vec3G v) {
        return (this.mul(new QuaternionG(v, 0)).mul(this.conjugate())).getComplex();
    }

    public void setEuler(Vec3G euler) {
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

    public Vec3G getEuler() {
        Vec3G euler = new Vec3G();

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

    public static QuaternionG axisAngle(Vec3G axis, float angle) {
        return new QuaternionG(axis.mul((float) Math.sin((double) (angle * .5f))),
                (float) Math.cos((double) (angle * .5f)));
    }

    public static QuaternionG angleAxis(float angle, Vec3G axis) {
        return axisAngle(axis, angle);
    }

    public static QuaternionG fromEuler(Vec3G eu) {
        QuaternionG ret = new QuaternionG();
        ret.setEuler(eu);
        return ret;
    }

    public static QuaternionG fromEuler(float x, float y, float z) {
        return QuaternionG.fromEuler(new Vec3G(x, y, z));
    }
}
