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
public class Mat4I extends SquareIntMatrix {

    public Mat4I() {
        super(4);
    }

    public Mat4I(int[][] m) {
        super(m);
        if (this.getHeight() != 4 || this.getWidth() != 4) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat4I(Matrix in) {
        super(in);
        if (in.getHeight() != 4 || in.getWidth() != 4) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
