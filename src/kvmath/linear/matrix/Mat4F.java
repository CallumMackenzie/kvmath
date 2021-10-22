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
public class Mat4F extends SquareFloatMatrix {

    public Mat4F() {
        super(4);
    }

    public Mat4F(float[][] m) {
        super(m);
        if (this.getHeight() != 4 || this.getWidth() != 4) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat4F(Matrix in) {
        super(in);
        if (in.getHeight() != 4 || in.getWidth() != 4) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
