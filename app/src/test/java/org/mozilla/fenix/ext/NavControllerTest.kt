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
import io.mockk.mockkClass
import android.app.Activity
import android.view.View
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
//import io.sentry.Sentry
//import org.mozilla.fenix.BuildConfig
import android.content.res.Resources
import androidx.navigation.NavDestination
import androidx.navigation.Navigator.Extras


@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class NavControllerTest() {

    val navController: NavController = mockk(relaxed=true)
    val navDirections = mockk<NavDirections>(relaxed=true)
    val mockDestination: NavDestination = mockk(relaxed=true)
    val mockExtras: Extras = mockk(relaxed=true)
    val mockOptions: NavOptions = mockk(relaxed=true)
    val mockBundle: Bundle = mockk(relaxed=true)
    val mockBuildConfig = mockkClass(BuildConfig::class)
    //val mockSentry: Sentry = mockk(relaxed=true)

    @Test
    fun `Test nav fun with id and directions args`() {
        every { (navController.getCurrentDestination()) } returns mockDestination
        every { (mockDestination.getId()) } returns 4
        navController.nav(4, navDirections)

        verify{ (navController.getCurrentDestination()) }
        verify{ (navController.navigate(navDirections)) }
    }

    @Test
    fun `Test nav fun with id, directions, and extras args`() {
        every { (navController.getCurrentDestination()) } returns mockDestination
        every { (mockDestination.getId()) } returns 4
        navController.nav(4, navDirections, mockExtras)

        verify{ (navController.getCurrentDestination()) }
        verify{ (navController.navigate(navDirections, mockExtras)) }
    }

    @Test
    fun `Test nav fun with id, directions, and options args`() {
        every { (navController.getCurrentDestination()) } returns mockDestination
        every { (mockDestination.getId()) } returns 4
        navController.nav(4, navDirections, mockOptions)

        verify{ (navController.getCurrentDestination()) }
        verify{ (navController.navigate(navDirections, mockOptions)) }
    }

    @Test
    fun `Test nav fun with id, destId, bundle, options, and extras args`() {
        every { (navController.getCurrentDestination()) } returns mockDestination
        every { (mockDestination.getId()) } returns 4
        navController.nav(4, 5, mockBundle, mockOptions, mockExtras)

        verify{ (navController.getCurrentDestination()) }
        verify{ (navController.navigate(5, mockBundle, mockOptions, mockExtras)) }
    }

    @Test
    fun `Test error response for id exception in-block`() {
        every { (navController.getCurrentDestination()) } returns mockDestination
        every { (mockDestination.getId()) } returns 4
        navController.nav(7, navDirections)

        verify{ (recordIdException(mockDestination.getId(), 7) ) }
    }

    //TO:DO Not working currently
    /*class Sentry() {
        fun capture(myString: String) {
            println(myString)
        }
    }

    class BuildConfig() {
        val SENTRY_TOKEN = "hi"
    }


    @Test
    fun `Test record id exception fun`() {
        val myMockSentry = Sentry::class.java
        //val myMockBC = BuildConfig()
        //every {(Sentry)} returns myMockSentry
        //every {(mockBuildConfig)} returns myMockBC
        //every {(mockSentry)} returns myMockSentry
        val actual = 7
        var expected = 4

        recordIdException(actual, expected)

        //verify { Sentry.isNullOrEmpty() }
        verify { myMockSentry.capture("Fragment id $actual did not match expected $expected")}
    }*/



}