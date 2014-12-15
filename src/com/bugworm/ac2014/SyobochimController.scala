package com.bugworm.ac2014

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.{Initializable, FXML}
import javafx.scene.control.Label
import javafx.scene.input.TouchEvent
import javafx.scene.layout.Pane

import scalafx.animation.{Timeline, KeyFrame}
import scalafx.scene.image.{ImageView, Image}

object SyobochimController{
  var instance : SyobochimController = _
  val syobochim : ImageView = new ImageView{
    image = new Image("/syobochim.jpg")
    fitHeight = 64
    fitWidth = 64
    x = 320
    y = 580
  }
}
class SyobochimController extends Initializable{

  @FXML
  var score : Label = _

  @FXML
  var mainScreen : Pane = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    SyobochimController.instance = this
    mainScreen.getChildren.add(SyobochimController.syobochim)
    new Loop().play();
  }
}
