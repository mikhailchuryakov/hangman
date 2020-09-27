import sbt._

object Dependencies {

  object Version {
    val scalatest = "3.2.2"
  }

  val scalatest = "org.scalatest" %% "scalatest" % Version.scalatest
}
