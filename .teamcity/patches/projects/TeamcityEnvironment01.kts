package patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project
import jetbrains.buildServer.configs.kotlin.v2018_1.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a project with id = 'TeamcityEnvironment01'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, Project({
    id("TeamcityEnvironment01")
    name = "Teamcity-Environment01"
}))

