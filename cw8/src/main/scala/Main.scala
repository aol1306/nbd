// 1.
def pattern(s: String): String = {
  s match {
    case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
}

// 2.
class KontoBankowe(val stanKonta: Int) {
  def this() = {
    this(0)
  }

  def wplata(kwota: Int) = {
    KontoBankowe(stanKonta + kwota)
  }

  def wyplata(kwota: Int) = {
    if (stanKonta >= kwota) {
      KontoBankowe(stanKonta - kwota)
    } else {
      this
    }
  }

  override def toString(): String = s"KontoBankowe: stan konta: $stanKonta"
}

// 3.
case class Osoba(val imie: String, val nazwisko: String)

def greet(osoba: Osoba): String = {
  osoba match {
    case Osoba("Jan", "Kowalski") => "Hej Jan"
    case Osoba("Maria", "Kowalska") => "Cześć Maria"
    case _ => s"Hej inna osobo ${osoba.imie}"
  }
}

// 4.
def secondOrder(x: Int, f: Int => Int): Int = {
  f(f(f(x)))
}

// 5.
// 5.	Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik. Osoba powinna mieć własności read only: imie, nazwisko, podatek. Pracownik powinien mieć własność pensja (z getterem i seterem). Student i Pracownik powinni przesłaniać własność podatek – dla Studenta zwracamy 0, dla Pracownika 20% pensji. Nauczyciel powinien dziedziczyć z Pracownika, dla niego podatek zwraca 10% pensji. Stwórz obiekty z każdym z traitów, pokaż jak podatek działa dla każdego z nich. Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności od kolejności w jakiej te traity zostały dodane przy tworzeniu obiektu.
package cw5:
  class Osoba(val _imie: String, val _nazwisko: String, val _podatek: Double) {
    def imie = _imie
    def nazwisko = _nazwisko
    def podatek = _podatek
    override def toString = s"Osoba podatek: $podatek"
  }

  trait Pracownik(var _pensja: Double) extends Osoba {
    def pensja = _pensja
    def pensja_=(v: Double) = _pensja = v
    override def podatek = _pensja * 0.2
    override def toString = s"Pracownik pensja: $pensja, podatek: $podatek"
  }

  trait Student extends Osoba {
    override def podatek = 0
    override def toString = s"Student podatek: $podatek"
  }

  trait Nauczyciel extends Pracownik {
    override def podatek = _pensja * 0.1
    override def toString = s"Nauczyciel pensja: $pensja, podatek: $podatek"
  }

@main def hello: Unit = 
  println(pattern("Poniedziałek"))
  println(pattern("Sobota"))
  println(pattern("Aaaa"))

  println(KontoBankowe(10))
  println(KontoBankowe(10).wplata(100))
  println(KontoBankowe(10).wyplata(1))
  println(KontoBankowe())

  val osoby = List(Osoba("Jan", "Kowalski"), Osoba("Stefan", "Kowalski"), Osoba("Maria", "Kowalska"))
  for (osoba <- osoby) {
    println(greet(osoba))
  }

  println(secondOrder(10, (x => x+1)))
  val student = new cw5.Osoba("Jan", "Kowalski", 0) with cw5.Student
  println(student)
  val pracownik = new cw5.Osoba("Jan", "Kowalski", 0) with cw5.Pracownik(100)
  println(pracownik)
  val nauczyciel = new cw5.Osoba("Jan", "Kowalski", 0) with cw5.Pracownik(100) with cw5.Nauczyciel
  println(nauczyciel)
  val studentPracownik = new cw5.Osoba("Jan", "Kowalski", 0) with cw5.Student with cw5.Pracownik(100)
  println(studentPracownik)
  val pracownikStudent = new cw5.Osoba("Jan", "Kowalski", 0) with cw5.Pracownik(100) with cw5.Student
  println(pracownikStudent)

