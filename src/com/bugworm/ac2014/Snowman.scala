package com.bugworm.ac2014

import scalafx.scene.image.{Image, ImageView}
import scalafx.Includes._

object Snowman {
  val image : Image = new Image("/backpaper.png")
}
class Snowman extends ImageView{

  image = Snowman.image
  fitHeight = 64
  fitWidth = 64
  x = Math.random * (SyobochimController.instance.mainScreen.getWidth - 64)
  y = Math.random * (SyobochimController.instance.mainScreen.getHeight - 64)

  def touch() : Unit = {
    SyobochimController.instance.mainScreen.getChildren.remove(this)
  }

  onMouseMoved = handle {
    touch()
  }
  onTouchMoved = handle {
    touch()
  }
  onTouchPressed = handle {
    touch()
  }
}
