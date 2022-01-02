// 1.
def generator: Iterator[(Int, Int)] = for {
  a <- Iterator.from(1)
  b <- 1 until a + 1 if a % b == 0
} yield (a, b)

// 2.
trait Maybe[A]

class No extends Maybe[Nothing] {
  def applyFunction[A, R](f: A => R): Maybe[Nothing] = No()
  def getOrElse[A](v: A): A = v
  def flatMap[A, R](f: A => R): Maybe[Nothing] = No()
  def map[A, R](f: A => R): Maybe[Nothing] = No()
}

class Yes[A](val a: A) extends Maybe[A] {
  def applyFunction[R](f: A => R): Maybe[R] = Yes(f(a))
  def getOrElse(v: A): A = a
  def map[R](f: A => R): Maybe[R] = Yes(f(a))
  def flatMap[R](f: A => R): R = f(a)
}

@main def hello: Unit = 
  for (v <- generator.take(20)) {
    println(v)
  }

  val buffer = generator.buffered
  for (i <- 0 until 20) {
    println(buffer.next())
  }

  val yes = Yes(10)
  val no = No()

  println(yes.map(x => x+10))
  println(yes.flatMap(x => x+10))
  println(no.map[Int, Int](x => x+10))
  println(no.flatMap[Int, Int](x => x+10))
