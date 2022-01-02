// 1.
class Container[A](val a: A) {
  def getContent(): A = a
  def applyFunction[R](f: A => R): R = {
    f(a)
  }
}

// 2. 3. 4.
trait Maybe[A]

class No extends Maybe[Nothing] {
  def applyFunction[A, R](f: A => R): Maybe[Nothing] = {
    No()
  }

  def getOrElse[A](v: A): A = v
}

class Yes[A](val a: A) extends Maybe[A] {
  def applyFunction[R](f: A => R): Maybe[R] = {
    Yes(f(a))
  }

  def getOrElse(v: A): A = a
}

@main def hello: Unit = 
  val container = Container[Int](1)
  println(container.applyFunction(x => s"Wynik: ${x+1}"))

  val yes = Yes[Int](10)
  val no = No()
  println(yes.isInstanceOf[Maybe[_]])
  println(no.isInstanceOf[Maybe[_]])

  println(yes.applyFunction(x => x+1))
  println(no.applyFunction[Int, Int](x => (x+1)))

  println(yes.getOrElse(1000))
  println(no.getOrElse(1000))

