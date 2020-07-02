import zio.{App => ZIOApp}
import zio.console._

object ZIOApp extends ZIOApp {

  val myAppLogic =
    for {
      _    <- putStrLn("Hello! What is your name?")
      name <- getStrLn
      _    <- putStrLn(s"Hello, ${name}, welcome to ZIO!")
    } yield ()

  def run(args: List[String]) =
    myAppLogic.exitCode
}
