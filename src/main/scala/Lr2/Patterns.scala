package Lr2
/** Напишите решение в виде функции.
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result



  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def Func_a(value: Int): String ={
    value match {
      case 1 => "it is one"
      case 2 => "it is two"
      case 3 => "it is three"
      case _ => "what's that"
    }
  }
  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = Func_a(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def Func_b(value: String): Boolean ={
    value match {
    case "max" | "Max" => true
    case "moritz" | "Moritz" => true
    case _ => false
  }
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = Func_b(value)

  // c) Напишите функцию проверки является ли `value` четным 

  def Func_c(value: Int): Boolean={
    value % 2 match {
  case 0 => true
  case 1 => false
  }
  }


  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  def testIsEven(value: Int): Boolean = Func_c(value)


  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def Func_d(a: Hand, b: Hand): Result = {
    (a, b) match {
      case (Paper, Rock) => Win;
      case (Scissor, Paper) => Win;
      case (Rock, Scissor) => Win;
      case (Paper, Paper) => Draw;
      case (Rock, Rock) => Draw;
      case (Scissor, Scissor) => Draw;
      case _ => Lose;
    }
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = Func_d(a, b)



  // Примечание: используйте определение Animals
  sealed trait Animal { //можно наследоваться только в этом файле
    val name: String
    var food: Food
  }

  case class Mammal(name: String, var food: Food, var weight: Int) extends Animal
  case class Fish(name: String, var food: Food) extends Animal
  case class Bird(name: String, var food: Food) extends Animal
  sealed trait Food
  case object Meat extends Food
  case object Vegetables extends Food
  case object Plants extends Food

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def Func_e(animal: Animal): Int = {
    animal match {
      case animal: Mammal => animal.weight;
      case _ => -1;
    }
  }


  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = Func_e(animal)


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.

 def Func_f(animal: Animal): Animal = {
   animal match {
     case animal: Fish => animal.food = Plants;
     case animal: Bird => animal.food = Plants;
     case _ => animal
   }
   animal
 }

  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = Func_f(animal)

}
