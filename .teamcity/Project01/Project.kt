package Project01

import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project ({
    id("Project01")
    parentId("MainProject")
    name = "Project01"
    description = "Project01"

    subProject(BuildStep.Project)
    subProject(DeployEnv01.Project)

    subProjectsOrder = arrayListOf(BuildStep.Project, DeployEnv01.Project)
})