package com.bugworm.ac2014

import javafx.event.{ActionEvent, EventHandler}

import scalafx.animation.{Timeline, KeyFrame}
import scalafx.Includes._
import scalafx.util.Duration

class Loop extends Timeline {

  cycleCount = Timeline.Indefinite
  keyFrames = KeyFrame(Duration(100), "main loop", new EventHandler[ActionEvent] {
    def handle(e : ActionEvent) : Unit = {
      snowman()
    }
  })

  def snowman() : Unit = {
    if(SyobochimAdventCalendar.random.nextDouble > 0.9){
      SyobochimController.instance.mainScreen.getChildren.add(new Snowman)
    }
  }
}
