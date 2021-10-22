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
public class Mat2F extends SquareFloatMatrix {

    public Mat2F() {
        super(2);
    }

    public Mat2F(float[][] m) {
        super(m);
        if (this.getHeight() != 2 || this.getWidth() != 2) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat2F(Matrix in) {
        super(in);
        if (in.getHeight() != 2 || in.getWidth() != 2) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
