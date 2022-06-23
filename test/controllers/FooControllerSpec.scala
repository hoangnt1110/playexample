package controllers

import com.typesafe.config.ConfigFactory
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import play.api.Configuration

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class FooControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "FooController GET" should {

    "render the index page from a new instance of controller" in {
      val controller = new FooController(stubControllerComponents(), config = Configuration(ConfigFactory.load()))
      val home = controller.get().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")
      contentAsString(home) must include ("bar")
    }
  }
}
