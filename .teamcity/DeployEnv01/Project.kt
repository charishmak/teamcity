package DeployEnv01

import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project ({
    id("DeployEnv01")
    parentId("Project01")
    name = "DeployEnv01"
    description = "DeployEnv01"
})