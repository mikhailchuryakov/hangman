class Hangman(val word: String) {
  var current: String = "*" * word.length
  var idx = 0

  def guess(letter: Char): Status = {
    val after: String = word.zip(current).map { case (l, r) => if (l == letter) l else r }.mkString
    if (after == current) {
      idx += 1
      println(Hangman.wrongMsg(idx))
      println(Hangman.picture(idx))
      if (idx == Hangman.limit) Failure(after)
      else Continue(after)
    }
    else if (after == word) Success(after)
    else {
      println(Hangman.rightMsg)
      println(Hangman.wordMsg(after))
      current = after
      Continue(current)
    }
  }
}

object Hangman {
  val limit: Int = 5
  val words = List("hangman", "competition", "failure")

  def wrongMsg(attempt: Int): String = s"Missed, mistake $attempt out of 5."

  val rightMsg: String = "Hit!"
  val previewMsg = "Guess a letter:"
  val loseMsg: String = "You lost!"

  def wordMsg(word: String): String = s"The word: $word"

  val winMsg: String = "You won!"
  val guessMsg: String = "Guess a letter:"

  val picture = Map(
    1 ->
      """
       _________
      |         |
      |
      |
      |
      |
      |
    __|______________
      """,
    2 ->
      """
       _________
      |         |
      |
      |
      |
      |       _____
      |         |
    __|_________|____
      """,
    3 ->
      """
       _________
      |         |
      |
      |
      |
      |       _____
      |         |
    __|_________|____
      """,
    4 ->
      """
       _________
      |         |
      |         0
      |        /|\
      |         |
      |      __||__
      |         |
    __|_________|____
      """,
    5 ->
      """
       _________
      |         |
      |         0
      |        \|/
      |         |
      |        / \
      |
    __|_____________
      """
  )
}
