package hangman

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HangmanTest extends AnyFlatSpec with Matchers {
  val example = "aaab"

  it should "mistake" in {
    val hangman = new Hangman(example)
    hangman.guess('c') equals Continue("****")
  }

  it should "open one letter" in {
    val hangman = new Hangman(example)
    hangman.guess('b') equals Continue("***b")
  }

  it should "win the game" in {
    val hangman = new Hangman(example)
    hangman.guess('b')
    hangman.guess('a') equals Success("aaab")
  }

  it should "failed" in {
    val hangman = new Hangman(example)
    hangman.guess('c')
    hangman.guess('c')
    hangman.guess('c')
    hangman.guess('c')
    hangman.guess('c') equals Failure("****")
  }
}
