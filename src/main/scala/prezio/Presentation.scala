import cats.implicits._
import cats.effect.IO
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Presentation extends App {

  implicit val ec = scala.concurrent.ExecutionContext.global
}
