package Build

import Build.BuildTypes.RunBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    uuid = "960c326c-bf30-42ec-8429-9357908f927e"
    id("Build")
    parentId("Teamcity_God")
    name = "Build"
    description = "Run Build"


    buildType(RunBuild)
    buildTypesOrder = arrayListOf(RunBuild)
})



