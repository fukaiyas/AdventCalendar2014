package com.bugworm.ac2014

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.{Initializable, FXML}
import javafx.scene.control.Label
import javafx.scene.input.TouchEvent
import javafx.scene.layout.Pane

import scalafx.animation._
import scalafx.scene.image.{ImageView, Image}
import scalafx.scene.shape.{MoveTo, ArcTo, Path}
import scalafx.util.Duration

object SyobochimController{
  var instance : SyobochimController = _
  val syobochim : ImageView = new ImageView{
    image = new Image("/syobochim.jpg")
    fitHeight = 64
    fitWidth = 64
    translateX = 276
    translateY = 640
  }
  var current = new TranslateTransition{
    node = syobochim
    duration = Duration(1000)
    autoReverse = true
    cycleCount = Animation.Indefinite
    toX = 380
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
    println(SyobochimController.current.delegate)
    SyobochimController.current.play()
    new Loop().play();
  }
}
