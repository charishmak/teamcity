package BuildStep.BuildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.DslContext
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object RunBuild : BuildType({
    name = "RunBuild"

    vcs {
        root(DslContext.settingsRoot)
    }


        steps {
            powerShell {
                name = "Agent Diagnostics Step"
                scriptMode = script {
                    content = """
                    dir "C:\Program Files (x86)\Microsoft SDKs\Windows\v10.0A\bin\"
                    dir "C:\Program Files (x86)\Microsoft SDKs\Windows\v10.0A\bin\NETFX 4.6.1 Tools"
                    Get-ChildItem Env:
                    dir "C:\TeamCity\tools\NuGet.CommandLine.3.4.4\"
                """.trimIndent()
                }
            }
            powerShell {
                name = "Set build number"
                scriptMode = script {
                    content = """
                    ${'$'}hash = "%build.vcs.number%"
                    ${'$'}shortHash = ${'$'}hash.substring(0, 7)
                    ${'$'}buildCounter = "%build.counter%"
                    ${'$'}buildNumber = "1.0.${'$'}buildCounter-v${'$'}shortHash"
                    Write-Host "##teamcity[buildNumber '${'$'}buildNumber']"
                    echo "##teamcity[buildNumber '${"$"}BUILD_NUMBER'}"
                """.trimIndent()
                }
            }
    }

    triggers {
        vcs {
            branchFilter = ""
            perCheckinTriggering = true
            groupCheckinsByCommitter = true
            enableQueueOptimization = false
        }
    }
})

