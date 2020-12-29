package configs.taskConfigs

sealed trait TaskConfig

case class GenerateConfig(num: Int = 1, unique: Boolean = false, writeTo: String = "out", sep: Char = ',') extends TaskConfig
case class LoadConfig(user: String, pass: String, table: String) extends TaskConfig
