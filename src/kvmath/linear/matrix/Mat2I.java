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
public class Mat2I extends SquareIntMatrix {

    public Mat2I() {
        super(2);
    }

    public Mat2I(int[][] m) {
        super(m);
        if (this.getHeight() != 2 || this.getWidth() != 2) {
            throw new MatrixSizeException("Input array is not the proper size.");
        }
    }

    public Mat2I(Matrix in) {
        super(in);
        if (in.getHeight() != 2 || in.getWidth() != 2) {
            throw new MatrixSizeException("Input matrix is not the proper size.");
        }
    }

}
