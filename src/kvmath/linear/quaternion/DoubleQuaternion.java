/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.quaternion;

import kvmath.linear.vector.Vec4D;
import kvmath.linear.vector.Vector;
import kvmath.linear.vector.Vec3D;

/**
 *
 * @author callum
 */
public class DoubleQuaternion extends Vec4D implements Quaternion<DoubleQuaternion> {

    public DoubleQuaternion(Vector complex, double real) {
        super(complex);
        assertLength();
        this.setW(real);
    }

    public DoubleQuaternion() {
        super();
    }

    public DoubleQuaternion(Vector other) {
        super(other);
        assertLength();
    }

    @Override
    public Vector<?> getComplex() {
        return new Vec3D(this);
    }

    @Override
    public DoubleQuaternion getBase() {
        return this;
    }

    @Override
    public void setComplex(Vector<?> complex) {
        double w = this.getW();
        this.set(new Vec4D(complex));
        this.setW(w);
    }

    @Override
    public DoubleQuaternion conjugate() {
        return new DoubleQuaternion(this.getComplex().mul(-1), getReal().doubleValue());
    }

    @Override
    public Vector<?> rotateVector(Vector<?> v) {
        return new DoubleQuaternion(this.mul(new DoubleQuaternion(v, 0)).mul(conjugate())).getComplex();
    }

    @Override
    public void setEuler(Vector<?> euler_) {
        DoubleQuaternion euler = new DoubleQuaternion(euler_);
        double c1 = (double) Math.cos((double) (euler.getZ() * .5f));
        double c2 = (double) Math.cos((double) (euler.getY() * .5f));
        double c3 = (double) Math.cos((double) (euler.getX() * .5f));
        double s1 = (double) Math.sin((double) (euler.getZ() * .5f));
        double s2 = (double) Math.sin((double) (euler.getY() * .5f));
        double s3 = (double) Math.sin((double) (euler.getX() * .5f));
        this.setX(c1 * c2 * s3 - s1 * s2 * c3);
        this.setY(c1 * s2 * c3 + s1 * c2 * s3);
        this.setZ(s1 * c2 * c3 - c1 * s2 * s3);
        this.setW(c1 * c2 * c3 + s1 * s2 * s3);
    }

    @Override
    public DoubleQuaternion inverse() {
        return new DoubleQuaternion(this.conjugate().div(this.len()));
    }

    public static DoubleQuaternion fromEuler(Vector<?> euler) {
        DoubleQuaternion ret = new DoubleQuaternion();
        ret.setEuler(euler);
        return ret;
    }

    public static DoubleQuaternion fromAxisAngle(Vector<?> axis, Number angle) {
        return new DoubleQuaternion((axis.mul(Math.sin(angle.doubleValue()) * 0.5)),
                (double) Math.cos(angle.doubleValue() * 0.5));
    }

}
