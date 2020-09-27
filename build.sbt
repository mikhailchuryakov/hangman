import Dependencies._

name := "hangman"

version := "0.1"

scalaVersion := "2.13.3"

scalacOptions := Seq(
  "-encoding",
  "utf8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-target:jvm-1.8",
  "-language:_",
)

lazy val hangman = (project in file("."))
  .settings(
    name := "hangman",
    libraryDependencies += scalatest,
  )
