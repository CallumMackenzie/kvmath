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
public class MatrixSizeException extends RuntimeException {

    public MatrixSizeException() {
        super();
    }

    public MatrixSizeException(String msg) {
        super(msg);
    }
}
