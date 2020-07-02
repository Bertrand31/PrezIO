import cats.implicits._
import cats.effect._
import scala.concurrent.ExecutionContext

object Goodies extends App {


  implicit val contextShift = IO.contextShift(ExecutionContext.global)

  {
    // Semigroup instance
    val effect1 = IO.pure("foo")
    val effect2 = IO.pure("bar")
    val effect3 = IO.pure("baz")

    val program = effect1 |+| effect2

    val finalProgram =
      List(program, effect3)
        // .reduce(_ |+| _)
        .foldMap(identity)

    println(finalProgram.unsafeRunSync)
  }

  {
    // Easy parallelism
    val effect1 = IO { println("foo") }
    val effect2 = IO { println("bar") }
    val effect3 = IO { println("baz") }

    List(effect1, effect2, effect3)
      .parSequence
      .unsafeRunAsync({ _ => })
  }
}
