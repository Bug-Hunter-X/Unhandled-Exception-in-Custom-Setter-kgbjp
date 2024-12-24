```scala
import util.control.Exception._

class MyClass(val name: String) {
  private var _age: Int = 0

  def age: Int = _age
  def age_=(newAge: Int): Unit = handling(NonFatal) { 
    if (newAge >= 0) _age = newAge
    else throw new IllegalArgumentException("Age cannot be negative")
  } match {
    case Success(_) => println("Age set successfully")
    case Failure(exception) => println(s"Error setting age: ${exception.getMessage}") 
  }
}

val obj = new MyClass("John")
obj.age = -1 // Now this will print an error message instead of crashing
obj.age = 30 // This will print "Age set successfully"
```