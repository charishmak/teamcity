package BuildStep

import BuildStep.BuildTypes.RunBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({

    id("BuildStep")
    parentId("Project01")
    name = "BuildStep"
    description = "Run Build"

    buildType(RunBuild)
    buildTypesOrder = arrayListOf(RunBuild)
})