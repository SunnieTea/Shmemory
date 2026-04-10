package site.jwojcik.schmemory.data

data class Line (
    val characterName: String,
    val text: String
)

data class Scene (
    val id: Int = 0,
    val name: String,
    val readingFor: String,
    val lines: List<Line>
);