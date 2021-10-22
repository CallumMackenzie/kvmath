/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.quaternion;

import kvmath.linear.vector.Vec4F;
import kvmath.linear.vector.Vector;
import kvmath.linear.vector.Vec3F;

/**
 *
 * @author callum
 */
public class FloatQuaternion extends Vec4F implements Quaternion<FloatQuaternion> {

    public FloatQuaternion(Vector complex, float real) {
        super(complex);
        assertLength();
        this.setW(real);
    }

    public FloatQuaternion() {
        super();
    }

    public FloatQuaternion(Vector other) {
        super(other);
        assertLength();
    }

    @Override
    public Vector<?> getComplex() {
        return new Vec3F(this);
    }

    @Override
    public FloatQuaternion getBase() {
        return this;
    }

    @Override
    public void setComplex(Vector<?> complex) {
        float w = this.getW();
        this.set(new Vec4F(complex));
        this.setW(w);
    }

    @Override
    public FloatQuaternion conjugate() {
        return new FloatQuaternion(this.getComplex().mul(-1), getReal().floatValue());
    }

    @Override
    public Vector<?> rotateVector(Vector<?> v) {
        return new FloatQuaternion(this.mul(new FloatQuaternion(v, 0)).mul(conjugate())).getComplex();
    }

    @Override
    public void setEuler(Vector<?> euler_) {
        FloatQuaternion euler = new FloatQuaternion(euler_);
        float c1 = (float) Math.cos((double) (euler.getZ() * .5f));
        float c2 = (float) Math.cos((double) (euler.getY() * .5f));
        float c3 = (float) Math.cos((double) (euler.getX() * .5f));
        float s1 = (float) Math.sin((double) (euler.getZ() * .5f));
        float s2 = (float) Math.sin((double) (euler.getY() * .5f));
        float s3 = (float) Math.sin((double) (euler.getX() * .5f));
        this.setX(c1 * c2 * s3 - s1 * s2 * c3);
        this.setY(c1 * s2 * c3 + s1 * c2 * s3);
        this.setZ(s1 * c2 * c3 - c1 * s2 * s3);
        this.setW(c1 * c2 * c3 + s1 * s2 * s3);
    }

    @Override
    public FloatQuaternion inverse() {
        return new FloatQuaternion(this.conjugate().div(this.len()));
    }

    public static FloatQuaternion fromEuler(Vector<?> euler) {
        FloatQuaternion ret = new FloatQuaternion();
        ret.setEuler(euler);
        return ret;
    }

    public static FloatQuaternion fromAxisAngle(Vector<?> axis, Number angle) {
        return new FloatQuaternion((axis.mul(Math.sin(angle.doubleValue()) * 0.5)),
                (float) Math.cos(angle.doubleValue() * 0.5));
    }

}
