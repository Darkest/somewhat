import configs.taskConfigs.GenerateConfig
import configs.{Config, Generate}
import generator.Generator.generate

object Main extends App {
  import scopt.OParser


  val builder = OParser.builder[Config]
  var parser  = {
    import builder._
    OParser.sequence(
      programName("somewhat"),
      head("somewhat",  "0.1"),
      cmd("generate")
        .action((_, c) => c.copy(generateTask = Some(GenerateConfig())))
        .children(
          opt[Int]('n', "num")
            .action((n, c) => c.copy(generateTask = Some(GenerateConfig(num = n))))
        )
    )
  }

  OParser.parse(parser, args, Config(Some(Generate))) match {
    case Some(config) =>
      config.task match {
        case Some(_) =>
          val output = generate(config)
          println(output)
        case None => println("No task is selected! Choose one of (Generate, ... )")
      }
    case None =>
  }


}
