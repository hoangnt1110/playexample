package controllers

import models._
import javax.inject._
import play.api.mvc._
import play.api.libs.json.Json

class UsersController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  implicit val userFormat = Json.format[User]
  def get(id: Long) = Action {
    val user: User = User("1", "Hoang")
    Ok(Json.toJson(user))
  }

  def save = Action(parse.json) { request =>
    val user = request.body.as[User]
    //saveUser(user)
    Created("User1 was created")
  }
}