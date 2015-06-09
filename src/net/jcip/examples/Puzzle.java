package net.jcip.examples;

import java.util.*;

/**
 * Puzzle
 * <p/>
 * Abstraction for puzzles like the 'sliding blocks puzzle'
 *
 * @author Brian Goetz and Tim Peierls
 * 
 * P may represent as one box or more boxes.
 * M may represent as one box's movment or many boxes' movment
 * @author chenjunjie
 */
public interface Puzzle <P, M> {
  /**
   * If P represent one box's position,then this method may initial one position. 
   * Otherwise,if P represent a series of nodes,then this method should initial all boxes' position.
   * @return
   */
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
