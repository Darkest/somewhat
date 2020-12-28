package generator

import configs.taskConfigs.GenerateConfig
import org.scalacheck.Gen

object Generator {

  case class Record(id: String, system: String)

  def generate(config: GenerateConfig) = {
    val generator = {
      for {
        id <- Gen.numStr
        system <- systemGenerator
      } yield (id, system)
    }
    generator.sample
  }

  private val systemGenerator: Gen[String] = {
    val ls = List("way4", "profile", "bq")
    Gen.oneOf(ls)
  }

}
