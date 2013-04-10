package dk.bayes.model.factorgraph

import dk.bayes.model.factor.Factor
import scala.collection.mutable.ListBuffer

/**
 * This class represents a node in a factor graph, either Factor or Variable.
 *
 * @author Daniel Korzekwa
 *
 */
sealed abstract class Node {

  private val gates = ListBuffer[Gate]()
  
  /**
   * Adds an outgoing gate to a node.
   */
  def addGate(gate: Gate) = gates += gate

  /**
   * Returns outgoing gates for a node.
   */
  def getGates(): Seq[Gate] = throw new UnsupportedOperationException("Not implemented yet.")
}

/**
 * This class represents a factor node in a factor graph.
 *
 * @param factor Factor associated with a factor node
 */
case class FactorNode(factor: Factor) extends Node

/**
 * This class represents a variable node in a factor graph.
 *
 * @param varId Unique variable id
 */
case class VarNode(varId: Int) extends Node