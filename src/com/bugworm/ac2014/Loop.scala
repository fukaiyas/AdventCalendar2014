package com.bugworm.ac2014

import javafx.event.{ActionEvent, EventHandler}

import scalafx.animation.{KeyFrame, Timeline}
import scalafx.Includes._
import scalafx.util.Duration

class Loop extends Timeline {

  cycleCount = Timeline.INDEFINITE
  keyFrames = KeyFrame(Duration(1000), "main loop", new EventHandler[ActionEvent] {
    def handle(e : ActionEvent) : Unit = {
      snowman()
    }
  })

  def snowman() : Unit = {
    if(Math.random > 0.1){
      SyobochimController.instance.mainScreen.getChildren.add(new Snowman)
    }
  }
}
