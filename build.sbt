name := "PrezIO"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(

  // Cats
  "org.typelevel" %% "cats-core" % "2.1.1",
  "org.typelevel" %% "cats-effect" % "2.1.2",

  // ZIO
  "dev.zio" %% "zio" % "1.0.0-RC21-2",

  // Tests
  "org.scalatest" %% "scalatest" % "3.1.0",
)

scalacOptions ++= Seq(
  "-Ymacro-annotations", // Needed by newtype
  "-deprecation", // Warn about deprecated features
  "-encoding", "UTF-8", // Specify character encoding used by source files
  "-feature", // Emit warning and location for usages of features that should be imported explicitly
  "-language:existentials", // Existential types (- wildcard types) can be written and inferred
  "-language:higherKinds", // Allow higher-kinded types
  "-unchecked", // Enable additional warnings where generated code depends on assumptions
  "-Xlint:_", // Enable all available style warnings
  "-Ywarn-macros:after", // Only inspect expanded trees when generating unused symbol warnings
  "-Ywarn-unused:_", // Enables all unused warnings
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
)

scalacOptions in Test --= Seq(
  "-Xlint:_",
  "-Ywarn-unused-import",
)

javaOptions ++= Seq(
  "-XX:+CMSClassUnloadingEnabled", // Enable class unloading under the CMS GC
)

enablePlugins(JavaServerAppPackaging)
