package Lr3
/** Напишите свои решения в виде функций. */
object RecursiveData {

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def task1(l: List[Int]): Boolean = {
    if (l == Nil) true
    else  false
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = task1(list)


  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def task2(list_b: List[Int]): Int = {
    if (task1(list_b)) -1
    else list_b.head
  }
  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = task2(list)


  /* c) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  trait Tree[A]
  case class Node[A](ln:Tree[A], rn:Tree[A]) extends Tree[A] //ссылочный
  case class Leaf[A](vl:A) extends Tree[A] //имеет значения

}
