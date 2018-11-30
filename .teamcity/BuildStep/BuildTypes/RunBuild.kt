package BuildStep.BuildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.DslContext
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object RunBuild : BuildType({
    name = "RunBuild"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "set version using script opa"
            scriptContent = """
                        #!/bin/bash
                        HASH=%build.vcs.number%
                        SHORT_HASH=${"$"}{HASH:0:7}
                        BUILD_COUNTER=%build.counter%
                        BUILD_NUMBER="1.0.${"$"}BUILD_COUNTER.${"$"}SHORT_HASH"
                        echo "##teamcity[buildNumber '${"$"}BUILD_NUMBER']"
                    """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }
})

