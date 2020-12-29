package configs

import configs.taskConfigs.{GenerateConfig, LoadConfig}

case class Config(generateTask: Option[GenerateConfig] = None, loadConfig: Option[LoadConfig] = None)
