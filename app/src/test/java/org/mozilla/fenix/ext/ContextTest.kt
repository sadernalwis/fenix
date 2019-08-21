package org.mozilla.fenix.ext

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.EXTRA_SUBJECT
import android.content.Intent.EXTRA_TEXT
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.ContextThemeWrapper
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import mozilla.components.browser.search.SearchEngineManager
import mozilla.components.support.base.log.Log
import mozilla.components.support.base.log.Log.Priority.WARN
import org.mozilla.fenix.FenixApplication
import org.mozilla.fenix.R
import org.mozilla.fenix.ThemeManager
import org.mozilla.fenix.components.Components
import org.mozilla.fenix.components.metrics.MetricController
import kotlinx.coroutines.ObsoleteCoroutinesApi
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

/*@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
val mockContext: Context = mockk(relaxed=true)
val mockFenixApp: FenixApplication = mockk(relaxed=true)


class ContextTest() {
    @Test
    fun `Test setting application`() {
        mockContext.application = mockFenixApp
        verify {(get())}
    }
}*/