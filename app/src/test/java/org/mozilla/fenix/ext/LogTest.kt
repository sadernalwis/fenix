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
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.verify
import io.mockk.every
import android.util.Log
import org.mozilla.fenix.BuildConfig

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class LogTest {

    @Test
    fun `Test log debug function`() {
        mockkStatic(Log::class)
        logDebug("hi","hi")
        verify {(logDebug("hi", "hi"))}
        verify {(Log.d("hi", "hi"))}
    }

    @Test
    fun `Test log warn function with tag and message args`() {
        mockkStatic(Log::class)
        logWarn("hi","hi")
        verify {(logWarn("hi", "hi"))}
        verify {(Log.w("hi", "hi"))}
    }
}