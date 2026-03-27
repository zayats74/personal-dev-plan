package ru.scalabook.pdp.localization

import pureconfig.ConfigSource
import weaver.SimpleIOSuite

object ConfigSuite extends SimpleIOSuite:
  private val configSource = ConfigSource.default.load[Config]

  pureTest("check read config"):
    expect(configSource.isRight)

  pureTest("check russian language config"):
    matches(configSource):
      case Right(config) =>
        expect(
          config.localization.languages.exists(_.code == LanguageCode("ru"))
        )

  pureTest("check english language config"):
    matches(configSource):
      case Right(config) =>
        expect(
          config.localization.languages.exists(_.code == LanguageCode("en"))
        )
end ConfigSuite
