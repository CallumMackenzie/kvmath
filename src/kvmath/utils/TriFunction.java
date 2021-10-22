/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.utils;

/**
 *
 * @author callum
 */
@FunctionalInterface
public interface TriFunction<A1, A2, A3, RET> {

    public RET apply(A1 a, A2 b, A3 c);
}
