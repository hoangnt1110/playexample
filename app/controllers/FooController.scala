package controllers

import play.api.Configuration

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
import javax.inject.Inject
import play.api.mvc.BaseController
import play.api.mvc.ControllerComponents

class FooController @Inject()(val controllerComponents: ControllerComponents, config: Configuration) extends BaseController {
  def get = Action {
    val foo = config.get[String]("foo")
    Ok(foo)
      .withHeaders("Foo" -> "bar")
      .withSession("SessionFoo" -> "The-value")
  }
}