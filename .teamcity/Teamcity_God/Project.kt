package Teamcity_God

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project ({
    uuid = "9814b870-7d53-4e11-a623-f5ee025df33a"
    id ("Teamcity_God")
    name = "Teamcity God"
    description = "Teamcity God"

    params {
        param( "VSTS.Git.RepoName", "https://github.com/charishmak/teamcity.git#refs/heads/master")
    }
    subProjectsOrder = arrayListOf(AbsoluteId("Build"))
})