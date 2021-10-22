/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.quaternion;

import kvmath.linear.vector.Vec4I;
import kvmath.linear.vector.Vector;
import kvmath.linear.vector.Vec3I;

/**
 *
 * @author callum
 */
public class IntQuaternion extends Vec4I implements Quaternion<IntQuaternion> {

    public IntQuaternion(Vector complex, int real) {
        super(complex);
        assertLength();
        this.setW(real);
    }

    public IntQuaternion() {
        super();
    }

    public IntQuaternion(Vector other) {
        super(other);
        assertLength();
    }

    @Override
    public Vector<?> getComplex() {
        return new Vec3I(this);
    }

    @Override
    public IntQuaternion getBase() {
        return this;
    }

    @Override
    public void setComplex(Vector<?> complex) {
        int w = this.getW();
        this.set(new Vec4I(complex));
        this.setW(w);
    }

    @Override
    public IntQuaternion conjugate() {
        return new IntQuaternion(this.getComplex().mul(-1), getReal().intValue());
    }

    @Override
    public Vector<?> rotateVector(Vector<?> v) {
        return new IntQuaternion(this.mul(new IntQuaternion(v, 0)).mul(conjugate())).getComplex();
    }

    @Override
    public void setEuler(Vector<?> euler_) {
        IntQuaternion euler = new IntQuaternion(euler_);
        int c1 = (int) Math.cos((double) (euler.getZ() * .5f));
        int c2 = (int) Math.cos((double) (euler.getY() * .5f));
        int c3 = (int) Math.cos((double) (euler.getX() * .5f));
        int s1 = (int) Math.sin((double) (euler.getZ() * .5f));
        int s2 = (int) Math.sin((double) (euler.getY() * .5f));
        int s3 = (int) Math.sin((double) (euler.getX() * .5f));
        this.setX(c1 * c2 * s3 - s1 * s2 * c3);
        this.setY(c1 * s2 * c3 + s1 * c2 * s3);
        this.setZ(s1 * c2 * c3 - c1 * s2 * s3);
        this.setW(c1 * c2 * c3 + s1 * s2 * s3);
    }

    @Override
    public IntQuaternion inverse() {
        return new IntQuaternion(this.conjugate().div(this.len()));
    }

    public static IntQuaternion fromEuler(Vector<?> euler) {
        IntQuaternion ret = new IntQuaternion();
        ret.setEuler(euler);
        return ret;
    }

    public static IntQuaternion fromAxisAngle(Vector<?> axis, Number angle) {
        return new IntQuaternion((axis.mul(Math.sin(angle.doubleValue()) * 0.5)),
                (int) Math.cos(angle.doubleValue() * 0.5));
    }

}
