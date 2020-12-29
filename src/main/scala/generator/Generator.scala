package generator

import configs.taskConfigs.GenerateConfig
import org.scalacheck.Gen

object Generator {

  case class Record(id: String, system: String)

  def generate(config: GenerateConfig): Seq[(String, String)] = {
    for {
      _ <- 1 to config.num
      record <- recordGenerator().sample
    } yield record
  }

  private val systemGenerator: Gen[String] = {
    val ls = List("way4", "profile", "bq")
    Gen.oneOf(ls)
  }

  val numStrGen = (n: Int) => Gen.listOfN(n, Gen.numChar).map(_.mkString)

  private def recordGenerator(idLen: Int = 20) =
    for {
      id <- numStrGen(idLen)
      system <- systemGenerator
    } yield (id, system)

}
