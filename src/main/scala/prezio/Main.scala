import cats.implicits._
import cats.effect.IO
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App {

  {
    implicit val ec = scala.concurrent.ExecutionContext.global

    def fPrint(str: String): Future[Unit] =
      Future.successful { println(str) }

    val f1 = fPrint("========== Future test ==========")
    val f2 = f1

    val program = f1 *> f2
    Await.result(program, Duration.Inf)
  }

  {
    def ioPrint(str: String): IO[Unit] =
      IO { println(str) }

    val io1 = ioPrint("------------ IO test ------------")
    val io2 = io1

    val program = io1 *> io2
    program.unsafeRunSync
  }
}
