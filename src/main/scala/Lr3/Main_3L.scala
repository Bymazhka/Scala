package Lr3

object Main_3L {
  def main(args: Array[String]): Unit = {
    println("Compositions")
    println("1 " + Compositions.testCompose((s:String)=>s.toUpperCase())((s:String)=>s.filter(ch=>ch!='R'))((s:String)=>s.toLowerCase)("Enter Str"))
    println("2 " + Compositions.testMapFlatMap((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)))
    println("3 " + Compositions.testForComprehension((n:Int)=>Some(n/2))((n:Int)=> Some(n.toString))((s:String)=>s.toList)(Some(200)))
    println("RecData")
    println("1 " + RecursiveData.testListIntEmpty(List(1,2,3,4,5)))
    println("1.1 " + RecursiveData.testListIntEmpty(List()))
    println("2 " + RecursiveData.testListIntHead(List(1,2,3,4,5)))
    println("2.1 " + RecursiveData.testListIntHead(List()))
    println("RecFunc")
    println("3 " +RecursiveFunctions.testReverse(List("First","Second","Third")))
    println("4 "+ RecursiveFunctions.testMap(List(1,2,3,4,5),(x:Int)=>if(x%2==0) x else -1))
    println("5 "+ RecursiveFunctions.testAppend(List(1,2,3,4,5),List(6,7,8,9)))
    println("6 "+ RecursiveFunctions.testFlatMap(List("This is string and num ",15.toString),(x:String)=>x.toList))
  }
}
