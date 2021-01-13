package com.niker68.tanks;

public enum EnumOfOrientation {
   up("up"),
   down("down"),
   right("right"),
   left("left");

   private String orientation;
   private EnumOfOrientation(String orientation) {
      this.orientation = orientation;
   }
}
