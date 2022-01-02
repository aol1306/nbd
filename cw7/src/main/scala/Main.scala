import scala.annotation.tailrec

// 1a.
def join(list: List[String]): String = {
  var ret = ""
  for (i <- 0 to list.length-1) {
    ret += list(i) + ","
  }
  return ret.dropRight(1)
}

// 1b.
def joinP(list: List[String]): String = {
  val filtered = list.filter(_.startsWith("P"))
  return join(filtered)
}

// 1c.
def joinWhile(list: List[String]): String = {
  var ret = "";
  val iter = list.iterator
  while (iter.hasNext) {
    ret += iter.next + ","
  }
  return ret.dropRight(1)
}

// 2a.
def joinRec(list: List[String]): String = {
  if (list.length == 1) {
    return list(0)
  } else {
    return list(0) + "," + joinRec(list.tail)
  }
}

// 2b.
def joinRecRev(list: List[String]): String = {
  if (list.length == 1) {
    return list(0)
  } else {
    return joinRecRev(list.tail) + "," + list(0)
  }
}

// 3.
def tailRec(list: List[String]): String = {
  @tailrec def rec(s: String, list: List[String]): String = {
    if (list.length == 1) {
      s + list(0)
    } else {
      rec(s + list(0) + ",", list.tail)
    }
  }
  rec("", list)
}

// 4a.
def joinFoldL(list: List[String]): String = {
  list.foldLeft("")((x, y) => (x + "," + y)).substring(1)
}

// 4b.
def joinFoldR(list: List[String]): String = {
  list.foldRight("")((x, y) => (x + "," + y)).dropRight(1)
}

// 4c.
def joinFoldLP(list: List[String]): String = {
  list
    .filter(_.startsWith("P"))
    .foldLeft("")((x, y) => (x + "," + y))
    .substring(1)
}

// 5.
def discount(map: Map[String, Double]): Map[String, Double] = {
  map.map((k, v) => (k, v*0.9))
}

// 6.
def printTuple(t: (String, Int, Double)) = {
  println(s"string: ${t._1}")
  println(s"int: ${t._2}")
  println(s"double: ${t._3}")
}

// 7.
def option() = {
  val map = Map("Niemcy" -> "Berlin", "Polska" -> "Warszawa")
  def checkCapital(country: String) = {
    map.get(country) match {
      case Some(capital) => println(s"For $country found $capital")
      case None => println(s"Not found for $country")
    }
  }
  checkCapital("Japonia")
  checkCapital("Niemcy")
}

// 8.
def rmZeroRec(list: List[Int]): List[Int] = {
  @tailrec def rec(ret: List[Int], list: List[Int]): List[Int] = {
    if (list.length == 0) {
      ret
    } else {
      if (list(0) == 0) {
        rec(ret, list.tail)
      } else {
        rec(ret :+ list(0), list.tail)
      }
    }
  }
  rec(List(), list)
}

// 9.
def addOne(list: List[Int]): List[Int] = {
  list.map(x => x + 1)
}

// 10.
def filter512(list: List[Double]): List[Double] = {
  list.filter(x => x >= -5 && x <= 12)
}

@main def hello: Unit = 
  val days = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  val functions = List(
    join,
    joinP,
    joinWhile,
    joinRec,
    joinRecRev,
    tailRec,
    joinFoldL,
    joinFoldR,
    joinFoldLP,
  )

  for (f <- functions) {
    println(f(days))
  }

  val catalog = Map(
    "ziemniaki" -> 10.0,
    "marchew" -> 5.0,
    "cebula" -> 2.0,
  )
  println(catalog)
  println(discount(catalog))

  printTuple(("test", 1, 1.9))

  option()

  println(rmZeroRec(List(1, 2, 3, 0, 0, -4, 0, 34, 0)))
  println(addOne(List(1, 2, 3, 0, 0, -4, 0, 34, 0)))
  println(filter512(List(1, 2, 3, 0, 0, -4, 0, 34, 0)))
