package com.bugworm.ac2014

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.{Initializable, FXML}
import javafx.scene.control.Label
import javafx.scene.input.TouchEvent
import javafx.scene.layout.Pane

import scalafx.animation.{Timeline, KeyFrame}

object SyobochimController{
  var instance : SyobochimController = _
}
class SyobochimController extends Initializable{

  @FXML
  var score : Label = _

  @FXML
  var mainScreen : Pane = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    SyobochimController.instance = this
    new Loop().play();
  }
}
