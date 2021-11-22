package kvmath.graphics;

import java.io.Serializable;

/**
 * A 2x2 float matrix for graphics applications
 *
 * @author Callum Mackenzie
 */
public class Mat2G implements Serializable {

    public static final long serialVersionUID = 782327382L;

    private final float m[][];

    public Mat2G() {
        this.m = new float[2][2];
    }

    public Mat2G(float m[][]) {
        this();
        this.copyFrom(m);
    }

    /**
     *
     * @return the flattened matrix
     */
    public float[] flatten() {
        return new float[]{m[0][0], m[0][1], m[1][0], m[1][1]};
    }

    /**
     *
     * @return the 2D float array matrix
     */
    public float[][] getMatrixArray() {
        return m;
    }

    /**
     *
     * @param m the 2D float array matrix to set
     */
    public final void copyFrom(float[][] m) {
        for (int i = 0; i < Math.min(m.length, 2); ++i) {
            System.arraycopy(m[i], 0, this.m[i], 0, Math.min(m[i].length, 2));
        }
    }

    /**
     *
     * @return the determinant of this matrix
     */
    public float determinant() {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    /**
     *
     * @return the inverse of this matrix
     */
    public Mat2G inverse() {
        return Mat2G.inverse(this);
    }

    /**
     *
     * @param mats matrices to multiply
     * @return the product
     */
    public Mat2G mul(Mat2G... mats) {
        Mat2G m1 = new Mat2G(this.m);
        for (Mat2G m2 : mats) {
            Mat2G matrix = new Mat2G();
            for (int c = 0; c < 2; c++) {
                for (int r = 0; r < 2; r++) {
                    matrix.m[r][c] = m1.m[r][0] * m2.m[0][c] + m1.m[r][1] * m2.m[1][c];
                }
            }
            m1 = matrix;
        }
        return m1;
    }

    @Override
    public String toString() {
        return "Mat2G((" + m[0][0] + "," + m[0][1] + ") (" + m[1][0] + "," + m[1][1] + "))";
    }

    /**
     *
     * @param x the x scale
     * @param y the y scale
     * @return the scaling matrix
     */
    public static Mat2G scale(float x, float y) {
        Mat2G mat = new Mat2G();
        mat.m[0][0] = x;
        mat.m[1][1] = y;
        return mat;
    }

    /**
     *
     * @param scale the scale
     * @return the scaling matrix
     */
    public static Mat2G scale(Vec2G scale) {
        return scale(scale.getX(), scale.getY());
    }

    /**
     *
     * @param radians the clockwise rotation in radians
     * @return the 2D rotation matrix
     */
    public static Mat2G rotation(float radians) {
        Mat2G mat = new Mat2G();
        mat.m[0][0] = (float) Math.cos(radians);
        mat.m[0][1] = (float) Math.sin(radians);
        mat.m[1][0] = (float) -Math.sin(radians);
        mat.m[1][1] = (float) Math.cos(radians);
        return mat;
    }

    /**
     *
     * @return a 2D identity matrix
     */
    public static Mat2G identity() {
        Mat2G m = new Mat2G();
        m.m[0][0] = 1;
        m.m[1][1] = 0;
        return m;
    }

    /**
     *
     * @param mat the matrix to invert
     * @return the inverse
     */
    public static Mat2G inverse(Mat2G mat) {
        float determinant = mat.determinant();
        Mat2G m = new Mat2G();
        m.m[0][0] = mat.m[0][0] / determinant;
        m.m[1][1] = mat.m[1][1] / determinant;
        m.m[1][0] = mat.m[1][0] / determinant;
        m.m[0][1] = mat.m[0][1] / determinant;
        return m;
    }

    /**
     *
     * @return the transposed matrix
     */
    public Mat2G transposed() {
        return new Mat2G(new float[][]{
            {this.m[0][0], this.m[1][0]},
            {this.m[0][1], this.m[1][1]}});
    }

    /**
     *
     * @return this
     */
    public Mat2G transpose() {
        this.copyFrom(this.transposed().getMatrixArray());
        return this;
    }
}
