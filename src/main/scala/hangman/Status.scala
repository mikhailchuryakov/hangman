package hangman

sealed trait Status

case class Success(word: String)  extends Status
case class Failure(word: String)  extends Status
case class Continue(word: String) extends Status
