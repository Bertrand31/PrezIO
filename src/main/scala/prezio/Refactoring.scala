import cats.implicits._
import cats.effect._
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Refactoring extends IOApp {

  private def retrieveFromDB(key: String): IO[String] =
    IO.pure(key)

  private def enrich(data: String): IO[String] =
    IO.pure(data ++ "-baz")

  private def writeToConsole(data: String): IO[Unit] =
    IO { println(data) }

  private def retrieveAndEnrich(id: String): IO[String] =
    for {
      record    <- retrieveFromDB(id)
      processed =  record ++ "-bar"
      enriched  <- enrich(processed)
    } yield enriched

  val program = retrieveAndEnrich("test") >>= writeToConsole


  def run(args: List[String]): IO[ExitCode] =
    program
      .as(ExitCode.Success)
}
