package site.jwojcik.schmemory.data

class SceneDataSource {
    private var sceneList = listOf<Scene>();

    fun getScene(id: Int): Scene? {
        return sceneList.find { it.id == id }
    }

    fun loadScenes() = sceneList
}