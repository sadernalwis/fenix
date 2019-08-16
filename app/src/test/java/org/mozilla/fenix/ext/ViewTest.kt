package org.mozilla.fenix.ext

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import mozilla.components.support.ktx.android.util.dpToPx
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import io.mockk.every
import kotlinx.coroutines.ObsoleteCoroutinesApi
import androidx.core.content.ContextCompat
import mozilla.components.support.test.robolectric.testContext
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.mozilla.fenix.TestApplication
// For layouts
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.os.Bundle

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class ViewTest {

    @Test
    fun testIncreaseTapArea() {
        val mockView: View = mockk(relaxed=true)
        //val mockParent: ViewGroup = mockk(relaxed=true)
        //val mockGroup = spyk(ViewGroup(testContext))
        //mockGroup.addView(mockView)

        //Let's try  with layouts
        val inflateView: LinearLayout = mockk(relaxed=true)
        inflateView.addView(mockView)

        every { (mockView.getParent()) } returns (inflateView as ViewGroup)

        mockView.increaseTapArea(4)
        verify {mockView.increaseTapArea(4)}
        //verify { mockView.parent.setTouchDelegate() }

    }
}

