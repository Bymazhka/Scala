package Lr2

import Lr2.HigherOrder.multiply

object Main {
  def main(args: Array[String]): Unit = {
    println("Functions:")
    println("Площадь окружности: " + Functions.testCircle(3))
    println()
    println("Площадь прямоугольника с карированной функцией: " + Functions.testRectangleCurried(3, 4))
    println()
    println("Площадь прямоугольника: " + Functions.testRectangleUc(3, 4))
    println()
    println("HiOrder:")
    println("Функция n * f(a, b) " + HigherOrder.testNTimes(multiply, 4, 6, 2))
    println("Функция if (a > b) a else b " + HigherOrder.testAnonymousNTimes(4, 6, 2))
    println()
    println("Patterns:")
    println("Из Int в String " + PatternMatching.testIntToString(1))
    println("Из Int в String " + PatternMatching.testIntToString(5))
    println()
    println("Value = (М)max или (M)moritz " + PatternMatching.testIsMaxAndMoritz("Max"))
    println("Value = (М)max или (M)moritz " + PatternMatching.testIsMaxAndMoritz("Stax"))
    println()
    println("Value чётное " + PatternMatching.testIsEven(1))
    println("Value чётное " + PatternMatching.testIsEven(4))
    println()
    println("В канобу игрок а " + PatternMatching.testWinsA(PatternMatching.Rock, PatternMatching.Scissor))
    println("В канобу игрок а " + PatternMatching.testWinsA(PatternMatching.Scissor, PatternMatching.Scissor))
    println("В канобу игрок а " + PatternMatching.testWinsA(PatternMatching.Paper, PatternMatching.Scissor))
    println()
    println("Вес Mammal: " + PatternMatching.testExtractMammalWeight(PatternMatching.Mammal("cat", PatternMatching.Meat, 3)))
    println("Вес Mammal: " + PatternMatching.testExtractMammalWeight(PatternMatching.Bird("bird", PatternMatching.Vegetables)))
    println()
    println("Изменилось ли поле еды " + PatternMatching.testUpdateFood(PatternMatching.Mammal("cat", PatternMatching.Meat, 3)))
    println("Изменилось ли поле еды " + PatternMatching.testUpdateFood(PatternMatching.Fish("fish", PatternMatching.Meat)))
    println()
    println("Classes:")
    println("Известен ли такой тип еды " + CLasses.Food.apply("Meat"))
    println("Известен ли такой тип еды " + CLasses.Food.apply(""))
    println("Известен ли такой тип еды " + CLasses.Food.apply("Vegitables"))
    println()
    println("AnimalObj.apply(\"cat\") " + CLasses.AnimalObj.apply("cat"))
    println("AnimalObj.apply(\"parrot\") " + CLasses.AnimalObj.apply("parrot"))
    println("AnimalObj.apply(\"elephant\") " + CLasses.AnimalObj.apply("elephant"))
    println()
    println("Известно ли животное " + CLasses.AnimalObj.knownAnimal("cat"))
    println("Известно ли животное " + CLasses.AnimalObj.knownAnimal("parrot"))
    println("Известно ли животное " + CLasses.AnimalObj.knownAnimal("elephant"))
  }
}
