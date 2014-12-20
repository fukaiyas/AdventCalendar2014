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
  y = Math.random * (SyobochimController.instance.mainScreen.getHeight - 128)

  def touch() = {
    SyobochimController.instance.mainScreen.getChildren.remove(this)
  }

  onMouseClicked = handle {
    touch()
  }
  onTouchPressed = handle {
    touch()
  }
}
