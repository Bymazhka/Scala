package Lr4

import Lr4.Adts.{testDouble, testGetNth, testGoodOldJava, testIsEven, testSafeDivide}
import Lr4.Maps.{User, testGroupUsers, testNumberFrodos, testUnderaged}
import Lr4.Sequence.{testFlatMap, testForAll, testLastElement, testPalindrom, testZip}

object Main_4 {
  def main(args: Array[String]): Unit = {
    println("Strings")
    println("1. "+Strings.testUppercase("lowercase to upper"))
    println("2 "+Strings.testInterpolations("Dan", 24))
    println("3 "+Strings.testComputation(2, 4))
    println("4 "+Strings.testTakeTwo("more then two"))
    println("4.1 "+Strings.testTakeTwo("tw"))
    println("Sequence")
    println("1 "+testLastElement(Seq(100,12,45,7,65)))
    println("1.1 "+testLastElement(Seq.empty[Int]))
    println("2 "+testZip(Seq(10, 20, 30), Seq(40,50,60)))
    println("2.1 "+testZip(Seq(3), Seq(6, 7, 9)))
    println("3 "+testForAll(Seq(5, 12,14))(x=>x>0))
    println("3.1 "+testForAll(Seq(-4, 8, 366,-2))(x=>x>0))
    println("4 "+testPalindrom(Seq('0','1','2','1','0')))
    println("4.1 "+testPalindrom(Seq('0','1','2','3','0')))
    println("5 "+testFlatMap(Seq(12,14,18,7))(x=>x.toString.toSeq))
    println("Maps")
    println("1 " +testGroupUsers(Seq(User("Jack", 15), User("Boba", 45), User("Biba", 40), User("Boba", 12),User("Flynn",15))))
    println("2 " +testNumberFrodos(Map("First" -> User("Adams", 19), "Second" -> User("NoAdam", 25), "Adamantium" -> User("Addd", 40))))
    println("3 " +testUnderaged(Map("First" -> User("Adams", 19), "Second" -> User("NoAdam", 25), "Adamantium" -> User("Addd", 40))))
    println("Adts")
    println("1 "+testGetNth(List(1, 2, 3), 2))
    println("1.1 "+testGetNth(List(1, 2, 3), 4))
    println("2 "+testDouble(Option(16)))
    println("2.1 "+testDouble(None))
    println("3 "+testIsEven(2))
    println("3.1 "+testIsEven(3))
    println("4 "+testSafeDivide(100, 3))
    println("4.1 "+testSafeDivide(5, 0))
    println("5 "+testGoodOldJava(x=>x.toInt/0, "6"))
    println("5.1 "+testGoodOldJava(x=>x.toInt*5, "17"))
  }
}
