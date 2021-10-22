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
public class Mat3L extends SquareLongMatrix {

    public Mat3L() {
        super(3);
    }

    public Mat3L(long[][] m) {
        super(m);
        if (this.getHeight() != 3 || this.getWidth() != 3) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat3L(Matrix in) {
        super(in);
        if (in.getHeight() != 3 || in.getWidth() != 3) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
