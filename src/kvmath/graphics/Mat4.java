package kvmath.graphics;

import java.io.Serializable;

/**
 * A 4x4 float matrix for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Mat4 implements Serializable {

    public static final long serialVersionUID = 45312432L;

    private final float m[][];

    public Mat4() {
        this.m = new float[4][4];
    }

    public Mat4(float[][] m) {
        this();
        this.copyFrom(m);
    }

    /**
     *
     * Copies the given array's values into this one ignoring out of bounds
     * values
     *
     * @param m The array to copy from
     */
    public final void copyFrom(float[][] m) {
        for (int i = 0; i < Math.min(m.length, 4); ++i) {
            System.arraycopy(m[i], 0, this.m[i], 0, Math.min(m[i].length, 4));
        }
    }

    /**
     *
     * @return the flattened Mat4
     */
    public final float[] flatten() {
        return Mat4.flatten(this);
    }

    /**
     *
     * @return the inverse of the Mat4
     */
    public final Mat4 inverse() {
        return Mat4.inverse(this);
    }

    /**
     *
     * @param mats the matrices to multiply
     * @return the matrix product
     */
    public final Mat4 mul(Mat4... mats) {
        Mat4 m1 = new Mat4(this.m);
        for (Mat4 m2 : mats) {
            Mat4 matrix = new Mat4();
            for (int c = 0; c < 4; c++) {
                for (int r = 0; r < 4; r++) {
                    matrix.m[r][c] = m1.m[r][0] * m2.m[0][c] + m1.m[r][1] * m2.m[1][c] + m1.m[r][2] * m2.m[2][c]
                            + m1.m[r][3] * m2.m[3][c];
                }
            }
            m1 = matrix;
        }
        return m1;
    }

    /**
     *
     * @return the float array Mat4
     */
    public final float[][] getMatrixArray() {
        return m;
    }

    public final Mat4 transposed() {
        Mat4 ret = new Mat4();
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                ret.m[i][j] = m[j][i];
            }
        }
        return ret;
    }

    public final Mat4 transpose() {
        this.copyFrom(this.transposed().getMatrixArray());
        return this;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ret.append(Float.toString(m[i][j]))
                        .append(", ");
            }
            ret.append("\n");
        }
        return ret.toString();
    }

    /**
     *
     * Constructs a perspective projection matrix
     *
     * @param fovDeg the FOV in degrees
     * @param aspectRatio the aspect ratio of the screen
     * @param near the near clip plane
     * @param far the far clip plane
     * @return a perspective projection matrix
     */
    public static Mat4 perspective(float fovDeg, float aspectRatio, float near, float far) {
        float fovRad = 1.f / (float) Math.tan((fovDeg * 0.5f) * (3.14159265f / 180.f));
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = aspectRatio * fovRad;
        matrix.m[1][1] = fovRad;
        matrix.m[2][2] = far / (far - near);
        matrix.m[3][2] = (-far * near) / (far - near);
        matrix.m[2][3] = 1.f;
        matrix.m[3][3] = 0.f;
        return matrix;
    }

    /**
     *
     * @param m a matrix
     * @return the inverse
     */
    public static Mat4 inverse(Mat4 m) {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = m.m[0][0];
        matrix.m[0][1] = m.m[1][0];
        matrix.m[0][2] = m.m[2][0];
        matrix.m[0][3] = 0.f;
        matrix.m[1][0] = m.m[0][1];
        matrix.m[1][1] = m.m[1][1];
        matrix.m[1][2] = m.m[2][1];
        matrix.m[1][3] = 0.f;
        matrix.m[2][0] = m.m[0][2];
        matrix.m[2][1] = m.m[1][2];
        matrix.m[2][2] = m.m[2][2];
        matrix.m[2][3] = 0.f;
        matrix.m[3][0] = -(m.m[3][0] * matrix.m[0][0] + m.m[3][1] * matrix.m[1][0] + m.m[3][2] * matrix.m[2][0]);
        matrix.m[3][1] = -(m.m[3][0] * matrix.m[0][1] + m.m[3][1] * matrix.m[1][1] + m.m[3][2] * matrix.m[2][1]);
        matrix.m[3][2] = -(m.m[3][0] * matrix.m[0][2] + m.m[3][1] * matrix.m[1][2] + m.m[3][2] * matrix.m[2][2]);
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     * Constructs an identity matrix
     *
     * @return the identity matrix
     */
    public static Mat4 identity() {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = 1.f;
        matrix.m[1][1] = 1.f;
        matrix.m[2][2] = 1.f;
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     *
     * @param pos the position
     * @param target the target
     * @return a matrix associated with the direction of a point
     */
    public static Mat4 lookAt(Vec3 pos, Vec3 target) {
        return Mat4.lookAt(pos, target, new Vec3(0, 1.f, 0));
    }

    /**
     *
     * @param pos the position
     * @param target the target
     * @param up the direction to treat as up
     * @return a matrix associated with the direction of a point
     */
    public static Mat4 lookAt(Vec3 pos, Vec3 target, Vec3 up) {
        Vec3 newForward = target.sub(pos);
        newForward.normalize();

        Vec3 a = newForward.mul(Vec3.dot(up, newForward));
        Vec3 newUp = up.sub(a);
        newUp.normalize();

        Vec3 newRight = Vec3.cross(newUp, newForward);
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = newRight.getX();
        matrix.m[0][1] = newRight.getY();
        matrix.m[0][2] = newRight.getZ();
        matrix.m[0][3] = 0.f;
        matrix.m[1][0] = newUp.getX();
        matrix.m[1][1] = newUp.getY();
        matrix.m[1][2] = newUp.getZ();
        matrix.m[1][3] = 0.f;
        matrix.m[2][0] = newForward.getX();
        matrix.m[2][1] = newForward.getY();
        matrix.m[2][2] = newForward.getZ();
        matrix.m[2][3] = 0.f;
        matrix.m[3][0] = pos.getX();
        matrix.m[3][1] = pos.getY();
        matrix.m[3][2] = pos.getZ();
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     * Constructs a scale matrix
     *
     * @param x x scale
     * @param y y scale
     * @param z z scale
     * @return a 3D scale matrix
     */
    public static Mat4 scale(float x, float y, float z) {
        Mat4 matrix = Mat4.identity();
        matrix.m[0][0] = x;
        matrix.m[1][1] = y;
        matrix.m[2][2] = z;
        return matrix;
    }

    /**
     * Constructs a scale matrix
     *
     * @param x x scale
     * @param y y scale
     * @return a 3D scale matrix
     */
    public static Mat4 scale(float x, float y) {
        return scale(x, y, 1.f);
    }

    /**
     * Constructs a scale matrix
     *
     * @param x x scale
     * @return a 3D scale matrix
     */
    public static Mat4 scale(float x) {
        return scale(x, 1.f);
    }

    /**
     * Constructs a scale matrix
     *
     * @param v a Vec3 representing a scale
     * @return a 3D scale matrix
     */
    public static Mat4 scale(Vec3 v) {
        return scale(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Constructs a translation matrix
     *
     * @param x x translation
     * @param y y translation
     * @param z z translation
     * @return a 3D translation matrix
     */
    public static Mat4 translation(float x, float y, float z) {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = 1.f;
        matrix.m[1][1] = 1.f;
        matrix.m[2][2] = 1.f;
        matrix.m[3][3] = 1.f;
        matrix.m[3][0] = x;
        matrix.m[3][1] = y;
        matrix.m[3][2] = z;
        return matrix;
    }

    /**
     * Constructs a translation matrix
     *
     * @param x x translation
     * @param y y translation
     * @return a 3D translation matrix
     */
    public static Mat4 translation(float x, float y) {
        return translation(x, y, 0.f);
    }

    /**
     * Constructs a translation matrix
     *
     * @param x x translation
     * @return a 3D translation matrix
     */
    public static Mat4 translation(float x) {
        return translation(x, 0.f);
    }

    /**
     * Constructs a translation matrix
     *
     * @param v a Vec3 representing a transformation
     * @return a 3D translation matrix
     */
    public static Mat4 translation(Vec3 v) {
        return translation(v.getX(), v.getY(), v.getZ());
    }

    /**
     *
     * @param xRad Euler x rotation in radians
     * @return a 3D rotation matrix with an x component only
     */
    public static Mat4 rotationX(float xRad) {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = 1.f;
        matrix.m[1][1] = (float) Math.cos(xRad);
        matrix.m[1][2] = (float) Math.sin(xRad);
        matrix.m[2][1] = -(float) Math.sin(xRad);
        matrix.m[2][2] = (float) Math.cos(xRad);
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     *
     * @param yRad Euler y rotation in radians
     * @return a 3D rotation matrix with an y component only
     */
    public static Mat4 rotationY(float yRad) {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = (float) Math.cos(yRad);
        matrix.m[0][2] = (float) Math.sin(yRad);
        matrix.m[2][0] = -(float) Math.sin(yRad);
        matrix.m[1][1] = 1.f;
        matrix.m[2][2] = (float) Math.cos(yRad);
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     *
     * @param zRad Euler z rotation in radians
     * @return a 3D rotation matrix with an z component only
     */
    public static Mat4 rotationZ(float zRad) {
        Mat4 matrix = new Mat4();
        matrix.m[0][0] = (float) Math.cos(zRad);
        matrix.m[0][1] = (float) Math.sin(zRad);
        matrix.m[1][0] = -(float) Math.sin(zRad);
        matrix.m[1][1] = (float) Math.cos(zRad);
        matrix.m[2][2] = 1.f;
        matrix.m[3][3] = 1.f;
        return matrix;
    }

    /**
     *
     * @param xRad Euler x rotation in radians
     * @param yRad Euler y rotation in radians
     * @param zRad Euler z rotation in radians
     * @return a rotation matrix
     */
    public static Mat4 rotation(float xRad, float yRad, float zRad) {
        return Mat4.rotationX(xRad).mul(Mat4.rotationY(yRad), Mat4.rotationZ(zRad));
    }

    /**
     *
     * @param rotation Euler angle rotation
     * @return a rotation matrix
     */
    public static Mat4 rotation(Vec3 rotation) {
        return Mat4.rotation(rotation.getX(), rotation.getY(), rotation.getZ());
    }

    /**
     *
     * @param q a rotation quaternion
     * @return a rotation matrix
     */
    public static Mat4 rotation(Quaternion q) {
        q.normalize();
        return new Mat4(new float[][]{
            {1.f - 2.f * q.y() * q.y() - 2.f * q.z() * q.z(), 2.f * q.x() * q.y() - 2.f * q.z() * q.w(),
                2.f * q.x() * q.z() + 2.f * q.y() * q.w(), 0.f},
            {2.f * q.x() * q.y() + 2.f * q.z() * q.w(), 1.f - 2.f * q.x() * q.x() - 2.f * q.z() * q.z(),
                2.f * q.y() * q.z() - 2.f * q.x() * q.w(), 0.f},
            {2.f * q.x() * q.z() - 2.f * q.y() * q.w(), 2.f * q.y() * q.z() + 2.f * q.x() * q.w(),
                1.f - 2.f * q.x() * q.x() - 2.f * q.y() * q.y(), 0.f},
            {0, 0, 0, 1.f}});
    }

    /**
     *
     * @param mat the matrix to flatten
     * @return the flattened matrix
     */
    public static float[] flatten(Mat4 mat) {
        float f[] = new float[16];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                f[k] = mat.getMatrixArray()[i][j];
                k++;
            }
        }
        return f;
    }

    /**
     *
     * @param xRad Euler x rotation
     * @param yRad Euler y rotation
     * @param zRad Euler z rotation
     * @param pt the point to rotate around
     * @return a rotation matrix
     */
    public static Mat4 rotationOnPoint(float xRad, float yRad, float zRad, Vec3 pt) {
        return Mat4.translation(pt).mul(Mat4.rotation(xRad, yRad, zRad),
                Mat4.translation(-pt.getX(), -pt.getY(), -pt.getZ()));
    }

    /**
     *
     * @param rotation Euler angle rotation
     * @param point the point to rotate around
     * @return a rotation matrix
     */
    public static Mat4 rotationOnPoint(Vec3 rotation, Vec3 point) {
        return Mat4.rotationOnPoint(rotation.getX(), rotation.getY(), rotation.getZ(), point);
    }

    /**
     *
     * @param rot quaternion rotation
     * @param pt the point to rotate around
     * @return a rotation matrix
     */
    public static Mat4 rotationOnPoint(Quaternion rot, Vec3 pt) {
        return Mat4.translation(pt).mul(Mat4.rotation(rot),
                Mat4.translation(-pt.x(), -pt.y(), -pt.z()));
    }

}
