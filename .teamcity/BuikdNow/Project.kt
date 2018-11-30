package BuikdNow

import BuikdNow.BuildTypes.RunBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    uuid = "960c326c-bf30-42ec-8429-9357908f927e"
    id("BuikdNow")
    parentId("Teamcity_God")
    name = "BuikdNow"
    description = "Run Build"


    buildType(RunBuild)
    buildTypesOrder = arrayListOf(RunBuild)
})



