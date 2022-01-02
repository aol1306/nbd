// 1a.
def join(list: List[String]): String = {
  var ret = ""
  for (i <- 0 to list.length-2) {
    ret += list(i) + ","
  }
  ret += list.last
  return ret
}

// 1b.
def joinP(list: List[String]): String = {
  val filtered = list.filter(_.startsWith("P"))
  return join(filtered)
}

// 1c.
def joinWhile(list: List[String]): String = {

}

@main def hello: Unit = 
  val days = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println(join(days))
  println(joinP(days))
