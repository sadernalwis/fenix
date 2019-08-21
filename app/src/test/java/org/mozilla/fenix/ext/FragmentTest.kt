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
import io.mockk.verify
import io.mockk.every
import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import org.mozilla.fenix.components.Components
import androidx.navigation.NavController

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class FragmentTest {

    val navDirections = mockk<NavDirections>(relaxed=true)
    //val mockDestination: NavDestination = mockk(relaxed=true)
    //val mockExtras: Extras = mockk(relaxed=true)
    //val mockFragment: Fragment = mockk(relaxed=true)
    val navController = spyk(NavController(testContext))
    val mockId = 4
    val mockNavHostFragment = spyk(NavHostFragment())
    val mockFragment = spyk(Fragment())
    //private fun findNavController(mockFragment) = navController

    @Test
    fun `Test nav fun with ID and directions`() {
        every {(findNavController(mockFragment))} returns navController
        //every { mock["findNavController"]() } returns navController

        mockFragment.nav(4, navDirections)
        verify {(findNavController(mockFragment).nav(mockId, navDirections))}
    }
}