package com.bugworm.ac2014

import java.net.URL
import java.util.ResourceBundle
import javafx.fxml.{FXML, Initializable}
import javafx.scene.control.Label
import javafx.scene.layout.Pane

import scala.collection.mutable.ListBuffer
import scalafx.Includes._
import scalafx.animation._
import scalafx.beans.property.IntegerProperty
import scalafx.scene.image.{Image, ImageView}
import scalafx.util.Duration
import scalafx.util.converter.NumberStringConverter

object SyobochimController{
  val score : IntegerProperty = IntegerProperty(0)
  var scoreRate : Integer = 1
  var instance : SyobochimController = _
  val syobochim : ImageView = new ImageView{
    image = new Image("/syobochim.png")
    fitHeight = 64
    fitWidth = 64
    translateX = 276
    translateY = 640
    onMousePressed = handle {
      touch()
    }
    onTouchPressed = handle {
      touch()
    }
  }
  val targets : ListBuffer[Snowman] = new ListBuffer[Snowman]
  var waitingAnimation = new TranslateTransition{
    node = syobochim
    duration = Duration(2000)
    autoReverse = true
    cycleCount = Animation.Indefinite
    toX = 380
  }
  def touch() : Unit = {
    if(targets.isEmpty){
      val fuyo = new ImageView{
        image = new Image("/fuyo.png")
        fitWidth = 160
        fitHeight = 120
        translateX <== syobochim.translateX - 40
        translateY = 560
      }
      instance.mainScreen.getChildren.add(fuyo)
      new TranslateTransition{
        node = fuyo
        cycleCount = 3
        autoReverse = true
        duration = Duration(800)
        toY = 520
        onFinished = handle{
          instance.mainScreen.getChildren.remove(fuyo.delegate)
        }
      }.play()
      return
    }
    waitingAnimation.stop()
    kunkaNext()
  }
  def action(snowman : Snowman): Unit ={
    if(!targets.contains(snowman)) {
      targets.append(snowman)
      snowman.lockon = new ImageView{
        image = new Image("/lockon.png")
        translateX <== snowman.translateX
        translateY <== snowman.translateY
      }
      instance.mainScreen.getChildren.add(snowman.lockon)
    }
  }
  def kunkaNext() : Unit = {
    val target = targets.remove(0)
    target.move.stop()
    new TranslateTransition{
      node = syobochim
      duration = Duration(200)
      toX = target.translateX.value
      toY = target.translateY.value
      onFinished = handle {
        new TranslateTransition{
          node = new ImageView{
            image = new Image("/kunka.png")
            translateX = syobochim.translateX.value - 18
            translateY = syobochim.translateY.value
          }
          instance.mainScreen.getChildren.append(node.value)
          duration = Duration(800)
          toY = syobochim.translateY.value - 32
          onFinished = handle{
            instance.mainScreen.getChildren.remove(node.value)
          }
        }.play()
        score.value = score.value + scoreRate
        scoreRate += 1
        println(score.value)
        instance.mainScreen.getChildren.remove(target.delegate)
        instance.mainScreen.getChildren.remove(target.lockon.delegate)
        if(targets.isEmpty) home() else kunkaNext()
      }
    }.play()
  }
  def remove(snowman : Snowman) : Unit = {
    instance.mainScreen.getChildren.remove(snowman.delegate)
    if(snowman.lockon != null){
      instance.mainScreen.getChildren.remove(snowman.lockon.delegate)
    }
    if(targets.contains(snowman)){
      targets.remove(targets.indexOf(snowman))
    }
  }
  def home(): Unit ={
    scoreRate = 1
    new TranslateTransition(){
      node = syobochim
      duration = Duration(200)
      toX = 276
      toY = 640
      onFinished = handle {
        waitingAnimation = new TranslateTransition{
          node = syobochim
          duration = Duration(2000)
          autoReverse = true
          cycleCount = Animation.Indefinite
          toX = 380
        }
        waitingAnimation.play()
      }
    }.play()
  }
}
class SyobochimController extends Initializable{

  @FXML
  var score : Label = _

  @FXML
  var mainScreen : Pane = _

  override def initialize(location: URL, resources: ResourceBundle): Unit = {
    SyobochimController.instance = this
    score.textProperty().bindBidirectional(SyobochimController.score, new NumberStringConverter()) //TODO 調べる
    mainScreen.getChildren.add(SyobochimController.syobochim)
    SyobochimController.waitingAnimation.play()
    new Loop().play()
  }
}
