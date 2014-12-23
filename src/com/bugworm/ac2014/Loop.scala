package com.bugworm.ac2014

import javafx.event.{ActionEvent, EventHandler}

import scalafx.animation.{Timeline, KeyFrame}
import scalafx.Includes._
import scalafx.util.Duration

class Loop extends Timeline {

  val cycle = 100
  cycleCount = 60000 / cycle
  keyFrames = KeyFrame(Duration(cycle), "main loop", handle { snowman() } )
//  onFinished = handle{ SyobochimController.endLoop() }
  onFinished = handle {
    new Timeline{
      cycleCount = 1
      keyFrames = KeyFrame(Duration(6000), "")
      onFinished = handle { SyobochimController.endLoop() }
    }.play()
  }
  SyobochimController.startLoop()
  SyobochimAdventCalendar.random.setSeed(123)

  def snowman() : Unit = {
    if(SyobochimAdventCalendar.random.nextDouble > 0.9){
      SyobochimController.instance.mainScreen.getChildren.add(new Snowman)
    }
  }
}
