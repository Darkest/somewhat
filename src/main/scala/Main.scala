import configs.taskConfigs.GenerateConfig
import configs.{Config}
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
            .action((n, c) => c.copy(generateTask = Some(c.generateTask.get.copy(num = n))))
        )
    )
  }

  OParser.parse(parser, args, Config()) match {
    case Some(config) =>
      config.generateTask match {
        case Some(genConf) =>
          val output = generate(genConf).map{case (s1, s2) => s1 + genConf.sep + s2}.mkString("\n")
          println(output)
        case None => println("No generate task is chosen! Choose one of (Generate, ... )")
      }
    case None =>
  }


}
