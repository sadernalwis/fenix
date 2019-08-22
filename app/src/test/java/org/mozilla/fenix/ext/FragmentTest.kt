package org.mozilla.fenix.ext
import kotlinx.coroutines.ObsoleteCoroutinesApi
import androidx.core.content.ContextCompat
import mozilla.components.support.test.robolectric.testContext
import org.mozilla.fenix.TestApplication
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.mockk.verify
import io.mockk.every
import io.mockk.Runs
import io.mockk.just
import io.mockk.confirmVerified
import io.mockk.excludeRecords
import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.NavDestination
import org.mozilla.fenix.components.Components
import androidx.navigation.NavController

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class FragmentTest {

    //val navDirections = mockk<NavDirections>(relaxed=true)
    val navDirections: NavDirections = mockk(relaxed=true)
    //val mockDestination: NavDestination = mockk(relaxed=true)
    val mockDestination= spyk(NavDestination("hi"))
    //val mockExtras: Extras = mockk(relaxed=true)
    //val mockFragment: Fragment = mockk(relaxed=true)
    //val navController: NavController = mockk(relaxed=true)
    val mockId = 4
    //val mockNavHostFragment = spyk(NavHostFragment())
    val navController = spyk(NavController(testContext))
    //val spykFragment = spyk(Fragment())
    val mockFragment: Fragment= mockk(relaxed=true)
    //val mockView: View= mockk(relaxed=true)
    //private fun findNavController(mockFragment) = navController

    /*fun findNavController() : NavController? {
        return navController
    }*/

    @Test
    fun `Test nav fun with ID and directions`() {
        mockkStatic(NavHostFragment::class)
        every {(NavHostFragment.findNavController(mockFragment))} returns navController
        every {(NavHostFragment.findNavController(mockFragment).getCurrentDestination())} returns mockDestination
        every {(NavHostFragment.findNavController(mockFragment).navigate(navDirections))} just Runs
        every {(mockDestination.getId())} returns mockId
        every {(navController.getCurrentDestination())} returns mockDestination
        every {(NavHostFragment.findNavController(mockFragment).getCurrentDestination()?.getId())} answers {(mockDestination.getId())}

        mockFragment.nav(mockId, navDirections)
        verify { mockFragment.nav(mockId, navDirections) }
        verify{ (NavHostFragment.findNavController(mockFragment).getCurrentDestination()) }
        verify{ (NavHostFragment.findNavController(mockFragment).navigate(navDirections)) }
        confirmVerified(mockFragment)
    }
}