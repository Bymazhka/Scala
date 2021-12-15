package Lr5
import Lr5.Typeclasses.{testReversableString, testSmashDouble, testSmashInt, testSmashString}
object Main_5 {
      def main(args: Array[String]): Unit = {
      println("Typeclasses")
      println(testReversableString("string"))
      println(testSmashInt(5, 12))
      println(testSmashDouble(8.0, 3.0))
      println(testSmashString("coto", "pes"))
  }
}
