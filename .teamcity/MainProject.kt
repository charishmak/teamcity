import jetbrains.buildServer.configs.kotlin.v2018_1.*

object MainProject : Project ({
    description = "Main Project Root"
    subProject(Project01.Project)
    subProjectsOrder = arrayListOf(AbsoluteId("Project01"))
})