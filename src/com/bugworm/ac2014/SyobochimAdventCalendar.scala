package com.bugworm.ac2014

import java.net.URL
import javafx.fxml.FXMLLoader
import javafx.scene.layout.StackPane

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._

object SyobochimAdventCalendar extends JFXApp {
  val screen : StackPane = FXMLLoader.load(getClass().getResource("/screen.fxml"))
  stage = new PrimaryStage {
    scene = new Scene {
      title = "Syobochim Advent Calendar"
      root = screen
    }
  }
}
