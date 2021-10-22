/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.linear.matrix;

/**
 *
 * @author callum
 */
public class Mat3D extends SquareDoubleMatrix {

    public Mat3D() {
        super(3);
    }

    public Mat3D(double[][] m) {
        super(m);
        if (this.getHeight() != 3 || this.getWidth() != 3) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat3D(Matrix in) {
        super(in);
        if (in.getHeight() != 3 || in.getWidth() != 3) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
