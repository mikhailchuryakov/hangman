import scala.io.StdIn
import scala.util.Random

object Main extends App {
  val random = new Random()
  val hangman = new Hangman(Hangman.words(random.nextInt(3)))
  println(s"Word: ${hangman.current}")
  play(hangman.guess(StdIn.readChar()))

  @scala.annotation.tailrec
  def play(status: Status): Unit = status match {
    case Failure(_) =>
      println(Hangman.loseMsg)
    case Success(word) =>
      println(Hangman.wordMsg(word))
      println(Hangman.winMsg)
    case Continue(_) =>
      println(Hangman.guessMsg)
      play(hangman.guess(StdIn.readChar()))
  }
}


