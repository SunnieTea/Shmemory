package site.jwojcik.schmemory.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import site.jwojcik.schmemory.data.SceneDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SceneScreen(
    sceneId: Int,
    onUpClick: () -> Boolean,
    modifier: Modifier = Modifier,
    sceneDataSource: SceneDataSource = SceneDataSource()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        sceneDataSource.getScene(sceneId)?.name ?: "Error loading Scene by Id "
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = modifier
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = modifier.padding(innerPadding)
        ) {
            items(sceneDataSource.loadScenes()) { scene ->
                Text(scene.name)
            }
        }
    }
}
