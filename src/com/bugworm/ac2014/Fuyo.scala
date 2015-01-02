package com.bugworm.ac2014

import scalafx.Includes._
import scalafx.animation.TranslateTransition
import scalafx.scene.Node
import scalafx.scene.image.ImageView
import scalafx.util.Duration

object Fuyo {
  def apply(syobochim : Node) : Unit = {
    val fuyo = new ImageView("/fuyo.png"){
      fitWidth = 160
      fitHeight = 120
      translateX <== syobochim.translateX - 40
      translateY = 560
    }
    SyobochimController.instance.mainScreen.getChildren.add(fuyo)
    new TranslateTransition{
      node = fuyo
      cycleCount = 3
      autoReverse = true
      duration = Duration(800)
      toY = 520
      onFinished = handle{ SyobochimController.removeTarget(fuyo) }
    }.play()
  }
}
