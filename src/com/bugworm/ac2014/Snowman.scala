package com.bugworm.ac2014

import scalafx.animation.{Interpolator, TranslateTransition}
import scalafx.scene.Node
import scalafx.scene.image.{Image, ImageView}
import scalafx.Includes._
import scalafx.util.Duration

object Snowman {
  val image : Image = new Image("/backpaper.png")
}
class Snowman extends ImageView{

  val r = SyobochimAdventCalendar.random.nextBoolean
  image = Snowman.image
  fitHeight = 64
  fitWidth = 64
  translateX = if(r) -64 else 784
  translateY = SyobochimAdventCalendar.random.nextDouble * (SyobochimController.instance.mainScreen.getHeight - 128)
  val move = new Linear(this, r)
  var lockon : Option[ImageView] = None

  def touch() = {
    SyobochimController.action(this)
  }
  def kunka() = {
  }

  onMousePressed = handle {
    touch()
  }
  onTouchPressed = handle {
    touch()
  }
}

class Linear(backpaper : Snowman, r : Boolean) extends TranslateTransition{
  val snowman : Snowman = backpaper
  node = backpaper
  fromX = backpaper.translateX()
  toX = if(r) 848 else -64
  duration = Duration(Math.random * 3000 + 6000)
  interpolator = Interpolator.LINEAR
  onFinished = handle {
    SyobochimController.remove(snowman)
  }
  play()
}
