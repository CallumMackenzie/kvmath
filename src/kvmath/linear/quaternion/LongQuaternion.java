/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.quaternion;

import kvmath.linear.vector.Vec4L;
import kvmath.linear.vector.Vector;
import kvmath.linear.vector.Vec3L;

/**
 *
 * @author callum
 */
public class LongQuaternion extends Vec4L implements Quaternion<LongQuaternion> {

    public LongQuaternion(Vector complex, long real) {
        super(complex);
        assertLength();
        this.setW(real);
    }

    public LongQuaternion() {
        super();
    }

    public LongQuaternion(Vector other) {
        super(other);
        assertLength();
    }

    @Override
    public Vector<?> getComplex() {
        return new Vec3L(this);
    }

    @Override
    public LongQuaternion getBase() {
        return this;
    }

    @Override
    public void setComplex(Vector<?> complex) {
        long w = this.getW();
        this.set(new Vec4L(complex));
        this.setW(w);
    }

    @Override
    public LongQuaternion conjugate() {
        return new LongQuaternion(this.getComplex().mul(-1), getReal().longValue());
    }

    @Override
    public Vector<?> rotateVector(Vector<?> v) {
        return new LongQuaternion(this.mul(new LongQuaternion(v, 0)).mul(conjugate())).getComplex();
    }

    @Override
    public void setEuler(Vector<?> euler_) {
        LongQuaternion euler = new LongQuaternion(euler_);
        long c1 = (long) Math.cos((double) (euler.getZ() * .5f));
        long c2 = (long) Math.cos((double) (euler.getY() * .5f));
        long c3 = (long) Math.cos((double) (euler.getX() * .5f));
        long s1 = (long) Math.sin((double) (euler.getZ() * .5f));
        long s2 = (long) Math.sin((double) (euler.getY() * .5f));
        long s3 = (long) Math.sin((double) (euler.getX() * .5f));
        this.setX(c1 * c2 * s3 - s1 * s2 * c3);
        this.setY(c1 * s2 * c3 + s1 * c2 * s3);
        this.setZ(s1 * c2 * c3 - c1 * s2 * s3);
        this.setW(c1 * c2 * c3 + s1 * s2 * s3);
    }

    @Override
    public LongQuaternion inverse() {
        return new LongQuaternion(this.conjugate().div(this.len()));
    }

    public static LongQuaternion fromEuler(Vector<?> euler) {
        LongQuaternion ret = new LongQuaternion();
        ret.setEuler(euler);
        return ret;
    }

    public static LongQuaternion fromAxisAngle(Vector<?> axis, Number angle) {
        return new LongQuaternion((axis.mul(Math.sin(angle.doubleValue()) * 0.5)),
                (long) Math.cos(angle.doubleValue() * 0.5));
    }

}
