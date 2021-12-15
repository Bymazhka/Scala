import scala.math.pow

object lr1 {
  def main(args: Array[String]): Unit = {
    println("task13: " + task13("Hello"))
    println("task14: " + task14("Hello"))
    println("task16: " + task16("Hello"))
    println("task17: " + task17(3,2))
    println("task18: " + task18(10, 20))
    println("task19: " + task19(List(List(1, 1), 2, List(3, List(5, 8)))))
    println("task20: " + task20(26))
    println("task21: " + task21(List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5),2))
    println("task24: " + task24(3,2))
    println("task25: " + task25(List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5),2))
    println("task26: " + task26(8,3))
    println("task27: " + task27(List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5),2))
    println("task28: " + task28(8))
    println("task29: " + task29(List(1, 1, 2, 2, 3, 3, 4, 4, 5, 5)))
    println("task30: " + task30(512))
    println("task31: " + task31(List((1,"First"),(2,"Second"),(3,"Third"))))

  }
  //13. Напишите цикл for для вычисления кодовых пунктов Юникода всех букв в строке.
  // Например, произведение символов в строке «Hello» равно 9415087488
  def task13(n:String) = {
    var c:BigInt = 1;
    for (i <- n) c*=i.toInt;
    c;
  }
  //14. Решите предыдущее упражнение без применения цикла.
  //Напишите функцию product(s: String), вычисляющую произведение, как
  //описано в предыдущих упражнениях.
  def task14(n:String): BigInt = {
    n.map(x=>x.toLong) reduce((x,y)=>x*y);
  }
  //16. Сделайте функцию из предыдущего упражнения рекурсивной.
  def task16(n:String): BigInt = {
    var t = n.toList;
    if (t.isEmpty) 1
    else t.head.toLong * task16(n.tail)
  }
  //17. Напишите функцию, вычисляющую xn, где n – целое число.
  //Используйте следующее рекурсивное определение:
  //• xn = y2, если n – четное и положительное число, где y=xn/2
  //• xn = x*xn-1, если n – нечетное и положительное число.
  //• x0=1.
  //• xn=1/x-n, если n – отрицательное число.
  //Не используйте инструкцию return.
  def task17(x:Double, n:Int): Double = {
    if(n == 0) 1
    else if(n>0) x * task17(x,n-1)
    else 1/task17(x,-n)
  }
  //18. f(m,n) - сумма всех натуральных чисел от m до n включительно, в
  //десятичной записи которых нет одинаковых цифр.
  def task18(n:Int, m:Int) = {
    var sum :Int = 0;
    var strs : List[String] = List();
    for(i<-n to m){
      strs=strs:+i.toString;
    }
    for(str<-strs){
      for(s<-str){
        if(str.filter(x=>x==s).length==1) sum+=str.toInt;
      }
    }
    sum;
  }
  //19. Список содержит целые числа, а также другие списки, такие же
  //как и первоначальный. Получить список, содержащий только целые числа из
  //всех вложенных списков. Пример:
  //f(List(List(1, 1), 2, List(3, List(5, 8)))) = List(1, 1, 2, 3, 5, 8)
  def task19(l:List[Any]):List[Int]={
    var res: List[Int] = List();
    for(i<-l){
      if(i.isInstanceOf[List[Any]]){
        res = res++task19(i.asInstanceOf[List[Any]]);
      }
      else{
        res = res:+i.asInstanceOf[Int];
      }
    }
    res;
  }
  //20. f(n) - сумма цифр наибольшего простого делителя натурального числа n.
  def task20(n: Int): Int ={
    var sum:Int = 0;
    var k:Int = 0;
    for(i<-n-1 to 1 by -1) if(n%i==0)
    {
      sum = 0;
      k = 0;
      for(j<-i to 1 by -1) { //проверка на простое число
        if (i%j == 0) k+=1;
        if (k == 2) {
          var res=0;
          val str = i.toString;
          for(i<-str) res+=i.asDigit
          return res
        }
      }
    }
    1
  }
  //21. Список содержит элементы одного, но любого типа. Получить
  //список, содержащий каждый имеющийся элемент старого списка k раз
  //подряд. Число k задается при выполнении программы.
  def task21(l:List[Any],n: Int) ={
    var res: List[Any] = List()
    for(i<- l;j<- 1 until n+1){
      res=res :+ i
    }
    res
  }
  //24. f(m,n) - наименьшее общее кратное натуральных чисел m и n.
  def task24(n:Int, m:Int): Int ={
    return m * (n / noc(n, m))
  }
  def noc(n:Int, m:Int) : Int={
    if (m == 0) {
      return n
    }
    else {
      return noc(m, n % m)
    }
  }
  //25. Список содержит элементы одного, но любого типа. Получить
  //список, из элементов исходного, удаляя каждый k-й элемент. Число k
  //задается при выполнении программы.
  def task25(l: List[Any],k:Int)={
    var lst: List[Any] = List()
    var i =1
    for(t<-l){
      if(i!=k){
        lst= lst:+t
        i+=1
      }
      else {
        i=1
      }
    }
    lst
  }
  //26. f(n,k) - число размещений из n по k. Факториал не использовать.
  def task26(n: Int, k: Int): BigInt ={
    var res:BigInt =1
    for(t<-n-k+1 to n) res*=t
    return  res
  }
  //27. Список содержит элементы одного, но любого типа. Получить
  //новый список, перемещая циклически каждый элемент на k позиций влево
  //(при перемещении на одну позицию первый элемент становится последним,
  //второй первым и так далее). Число k задается при выполнении программы.
  //Если k отрицательное, то перемещение происходит вправо.
  def task27(l:List[Any],k:Int)={
    var lst:List[Any] = l
    for(l<-0 to k-1) {
      var t = lst.head
      lst = lst.drop(1)
      lst = lst:+t
    }
    lst
  }
  //28. f(n) - наибольшее совершенное число не превосходящее n.
  //Совершенным называется натуральное число n равное сумме своих
  //делителей, меньших n, например 6 = 1 + 2 + 3 ( f(6) = 6, f(7) = 6, ... ).
  def task28(n: Int): Int ={
    var seq = (2 to n).filter(x=>(1 to x-1).filter(t=>x%t==0).sum == x).max
    seq
  }
  //29. Список содержит элементы одного, но любого типа. Получить
  //два списка из элементов исходного, выбирая в первый элементы с четными
  //индексами, а во второй с нечетными.
  def task29(enter:List[Any])={
    var l1:List[Any] = List()
    var l2:List[Any] = List()
    var i =0;
    for(t<-enter){
      if(i%2==0){
        l1= l1:+t
      }
      else {
        l2= l2:+t
      }
      i+=1
    }
    println(l1)
    println(l2)
  }
  //30. f(n) - наибольшее из чисел от 1 до n включительно, обладающее
  //свойством: сумма цифр n в некоторой степени > 1 равна самому числу n.
  //Пример: 512 = 83
  def task30(n:Int)={
    var max =0;
    var sum =0
    for(i<-n.toString) sum+=i.asDigit

    for(k<- 1 to n){
      var t=0
      var c=2
      while (t<n){
        t=pow(sum,c).toInt
        c+=1
      }
      if (t == n && sum>max){
        max = sum
      }
    }
    max
  }
  //31. Список в качестве элементов содержит кортежи типа: (n, s), где n
  //— целые числа, а s — строки. Получить два списка из элементов исходного,
  //выбирая в первый числа, а во второй строки из кортежей.
  def task31(l:List[Tuple2[Int,String]])={
    var l1:List[Int] = List()
    var l2:List[String] = List()
    var i =0;
    for(t<-l){
      l1= l1:+t._1
      l2= l2:+t._2
    }
    println(l1)
    println(l2)
  }

}
