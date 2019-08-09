package org.mozilla.fenix.ext
import kotlinx.coroutines.ObsoleteCoroutinesApi
import androidx.core.content.ContextCompat
import mozilla.components.support.test.robolectric.testContext
import org.mozilla.fenix.TestApplication
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import io.mockk.mockk


@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class StringTest {

    @Test
    fun testReplace() {
        val chars = mapOf("kate" to "kat", "roycivous" to "roy")
        var sentence = "kate is always late but roycivous is always on time"
        val new = sentence.replace(chars)
        assertEquals(new, "kat is always late but roy is always on time")
    }

    @Test
    fun testGetHostFromUrl() {
        val urlTest = "http://www.example.com:1080/docs/resource1.html"
        var new = urlTest.getHostFromUrl()
        assertEquals(new, "www.example.com")
    }

    @Test
    fun testUrlToTrimmedHost() {
        val urlTest = "http://www.example.com:1080/docs/resource1.html"
        var new = urlTest.urlToTrimmedHost(testContext)
        assertEquals(new, "example")
    }

    @Test
    fun testSimplifiedUrl() {
        val urlTest = "https://www.amazon.com"
        var new = urlTest.simplifiedUrl()
        assertEquals(new, "amazon.com")
    }
}
