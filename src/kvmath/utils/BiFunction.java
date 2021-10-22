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
public interface BiFunction<LS, RS, RET> {

    public RET apply(LS lhs, RS rhs);
}
