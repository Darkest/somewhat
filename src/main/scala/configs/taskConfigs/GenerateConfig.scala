package configs.taskConfigs

import configs.TaskConfig

case class GenerateConfig(num: Int = 1) extends TaskConfig

//object GenerateConfig {
//  def parse: OParser[Unit, Config] = {
//    val builder = OParser.builder[Config]
//    val parser  = {
//      import builder._
//      OParser.sequence(
//        opt[Int]('n', "num")
//          .optional()
//          .action((n, c) => c.copy(num = n))
//          .text("num is the number of generated entries")
//      )
//    }
//    parser
//  }
//}
