
import androidx.navigation.NavController
import com.paulo.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}