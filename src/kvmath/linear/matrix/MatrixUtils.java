/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

import kvmath.linear.quaternion.Quaternion;
import kvmath.linear.vector.Vec2D;
import kvmath.linear.vector.Vec3D;
import kvmath.linear.vector.Vec4D;
import kvmath.linear.vector.Vector;
import kvmath.utils.BiFunction;

/**
 *
 * @author callum
 */
public class MatrixUtils {

    public static <T extends Matrix> T operand(T in, float[] nums, BiFunction<Float, Float, Float> fn) {
        T ret = (T) in.clone();
        for (var num : nums) {
            for (int i = 0; i < ret.getHeight(); ++i) {
                for (int j = 0; j < ret.getWidth(); ++j) {
                    ret.setNumberValue(j, i, fn.apply(in.getNumberValue(j, i).floatValue(), num));
                }
            }
        }
        return ret;
    }

    public static <T extends Matrix> T operand(T in, int[] nums, BiFunction<Integer, Integer, Integer> fn) {
        T ret = (T) in.clone();
        for (var num : nums) {
            for (int i = 0; i < ret.getHeight(); ++i) {
                for (int j = 0; j < ret.getWidth(); ++j) {
                    ret.setNumberValue(j, i, fn.apply(in.getNumberValue(j, i).intValue(), num));
                }
            }
        }
        return ret;
    }

    public static <T extends Matrix> T operand(T in, double[] nums, BiFunction<Double, Double, Double> fn) {
        T ret = (T) in.clone();
        for (var num : nums) {
            for (int i = 0; i < ret.getHeight(); ++i) {
                for (int j = 0; j < ret.getWidth(); ++j) {
                    ret.setNumberValue(j, i, fn.apply(in.getNumberValue(j, i).doubleValue(), num));
                }
            }
        }
        return ret;
    }

    public static <T extends Matrix> T operand(T in, long[] nums, BiFunction<Long, Long, Long> fn) {
        T ret = (T) in.clone();
        for (var num : nums) {
            for (int i = 0; i < ret.getHeight(); ++i) {
                for (int j = 0; j < ret.getWidth(); ++j) {
                    ret.setNumberValue(j, i, fn.apply(in.getNumberValue(j, i).longValue(), num));
                }
            }
        }
        return ret;
    }

    public static String matToString(Matrix m) {
        StringBuilder s = new StringBuilder().append("{");
        for (int i = 0; i < m.getHeight(); ++i) {
            s.append(i == 0 ? "" : " ").append(m.getRow(i)).append(i + 1 == m.getHeight() ? "" : ",\n");
        }
        return s.append("}").toString();
    }

    public static SquareMatrix<?> scale2D(double x, double y) {
        return new SquareDoubleMatrix(new double[][]{
            {x, 0},
            {0, y}
        });
    }

    public static SquareMatrix<?> scale2D(Vector<?> in) {
        Vec2D v = new Vec2D(in);
        return scale2D(v.getX(), v.getY());
    }

    public static SquareMatrix<?> scale3D(double x, double y, double z) {
        return new SquareDoubleMatrix(new double[][]{
            {x, 0, 0},
            {0, y, 0},
            {0, 0, z}
        });
    }

    public static SquareMatrix<?> scale3D(Vector<?> in) {
        Vec3D v = new Vec3D(in);
        return scale3D(v.getX(), v.getY(), v.getZ());
    }

    public static SquareMatrix<?> rotation3D(Quaternion<?> q) {
        Vec4D qBase = new Vec4D(q.getBase());
        q.getBase().normalize();
        return rotation3D(qBase.getX(), qBase.getY(), qBase.getZ(), qBase.getW());
    }

    public static SquareMatrix<?> rotation3D(double x, double y, double z, double w) {
        return new SquareDoubleMatrix(new double[][]{
            {1.0 - 2.0 * y * y - 2.0 * z * z, 2.0 * x * y - 2.0 * z * w,
                2.0 * x * z + 2.0 * y * w, 0.0},
            {2.0 * x * y + 2.0 * z * w, 1.0 - 2.0 * x * x - 2.0 * z * z,
                2.0 * y * z - 2.0 * x * w, 0.0},
            {2.0 * x * z - 2.0 * y * w, 2.0 * y * z + 2.0 * x * w,
                1.0 - 2.0 * x * x - 2.0 * y * y, 0.0},
            {0, 0, 0, 1.0}});
    }

    public static SquareMatrix<?> rotation3D(double x, double y, double z) {
        SquareDoubleMatrix rotationX = new SquareDoubleMatrix(new double[][]{
            {1, 0, 0, 0},
            {0, Math.cos(x), Math.sin(x), 0},
            {0, -Math.sin(x), Math.cos(x), 0},
            {0, 0, 0, 1}
        });
        SquareDoubleMatrix rotationY = new SquareDoubleMatrix(new double[][]{
            {Math.cos(y), 0, Math.sin(y), 0},
            {0, 1, 0, 0},
            {-Math.sin(y), 0, Math.cos(y), 0},
            {0, 0, 0, 1}
        });
        SquareDoubleMatrix rotationZ = new SquareDoubleMatrix(new double[][]{
            {Math.cos(z), Math.sin(z), 0, 0},
            {-Math.sin(z), Math.cos(z), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        });
        return new SquareDoubleMatrix(rotationX.mul(rotationY, rotationZ));
    }

    public static SquareMatrix<?> rotation3D(Vector<?> euler) {
        Vec3D eul = new Vec3D(euler);
        return rotation3D(eul.getX(), eul.getY(), eul.getZ());
    }

    public static SquareMatrix<?> perspective3D(double fov, double aspect, double near, double far) {
        double fovRad = 1.0 / Math.tan(Math.toRadians(fov * 0.5));
        return new SquareDoubleMatrix(new double[][]{
            {aspect * fovRad, 0, 0, 0},
            {0, fovRad, 0, 0},
            {0, 0, far / (far - near), 1},
            {0, 0, (-far * near) / (far - near), 0}
        });
    }

    public static SquareMatrix<?> lookAt3D(Vector pos, Vector target, Vector up) {
        Vec3D newForward = new Vec3D(((Vector) target.sub(pos)).normalize());
        Vec3D a = new Vec3D(newForward.mul(up.dot(newForward)));
        Vec3D newUp = new Vec3D(((Vector) up.sub(a)).normalize());
        Vec3D newRight = Vec3D.cross(newUp, newForward);
        Vec3D newPos = new Vec3D(pos);
        return new SquareDoubleMatrix(new double[][]{
            {newRight.getX(), newRight.getY(), newRight.getZ(), 0},
            {newUp.getX(), newUp.getY(), newUp.getZ(), 0},
            {newForward.getX(), newForward.getY(), newForward.getZ(), 0},
            {newPos.getX(), newPos.getY(), newPos.getZ(), 1}
        });
    }

    public static SquareMatrix<?> translation3D(double x, double y, double z) {
        return new SquareDoubleMatrix(new double[][]{
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {x, y, z, 1}
        });
    }

    public static SquareMatrix<?> translation3D(Vector in) {
        Vec3D v = new Vec3D(in);
        return translation3D(v.getX(), v.getY(), v.getZ());
    }

    public static SquareMatrix<?> rotationOnPoint3D(Vector<?> rot, Vector<?> point) {
        return (SquareMatrix) translation3D(point).getBase().mul(rotation3D(rot), translation3D(point.mul(-1)));
    }

    public static SquareMatrix<?> rotationOnPoint3D(Quaternion<?> q, Vector<?> point) {
        return (SquareMatrix) translation3D(point).getBase().mul(rotation3D(q), translation3D(point.mul(-1)));
    }

}
