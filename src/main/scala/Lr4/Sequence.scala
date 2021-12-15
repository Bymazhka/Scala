package Lr4
import scala.annotation.tailrec
import scala.language.postfixOps

// Примечание: напишите функции с хвостовой рекурсией
//Опция  – это коллекция элементов заданного типа.
object Sequence {

  /* a) Найдите последний элемент Seq.
   *    
   */
  def testLastElement[A](seq: Seq[A]): Option[A] = {
    seq match {
      case head :: tail => Some(seq.last)//если есть значение
      case Nil => None
    }
  }

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))).
   *    
   */
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = {
    @tailrec
    def loop[A](a: Seq[A], b: Seq[A],c:Seq[(A,A)]): Seq[(A, A)] ={
      (a,b) match{
        case (Nil,Nil)|(_,Nil)|(Nil,_) => c //если последовательность пустая
        case _ =>
          val tc = c:+(a.head,b.head)
          val ta = a.drop(1)
          val tb = b.drop(1)
          loop(ta,tb,tc)
      }
    }
    loop(a,b,Seq.empty[(A,A)])
  }

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *    
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    @tailrec
    def loop[A](s: Seq[A])(c: A => Boolean): Boolean={
      if (s == Nil || s.length==0) true
      else if(c(s.head)){
        val t = s.drop(1)
        loop(t)(c)
      }
      else false
    }
    loop(seq)(cond)
  }

  /* d) Проверьте, является ли Seq палиндромом
   *    
   */
  def testPalindrom[A](seq: Seq[A]): Boolean = {
    @tailrec
    def loop(se: Seq[A]): Boolean = {
      if (se.length ==0 ||se.length ==1) true
      else if (se.head == se.last){
        val t = se.drop(1).reverse.drop(1)
        loop(t)
      }
      else false
    }
    loop(seq)
  }

  /* e) Реализуйте flatMap используя foldLeft.
   *    
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = {
    seq.foldLeft[Seq[B]](Seq())((res,t)=>res++:f(t))
  }
}
