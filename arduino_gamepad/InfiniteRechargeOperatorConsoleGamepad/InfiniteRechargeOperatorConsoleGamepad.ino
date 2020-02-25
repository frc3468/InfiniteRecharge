//  3468 MAGNATech's Custom Gamepad for the 2020 FRC Game Infinite Recharge
//  NOTE: This sketch file is for use with the Arduino Pro Micro
//  Copyright (C) 2020  Gustave Michel III <gustave@michel.com>
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <https://www.gnu.org/licenses/>.

#include <Joystick.h>

// Pin Definitions
#define LAUNCHER_THROTTLE_PIN A3
#define LAUNCHER_MANUAL_PIN 15      // No Pullup
#define LAUNCER_AUTO_PIN 14         // Pullup, Invert
#define COLOR_WHEEL_RAISE_PIN 10    // No Pullup, Invert
#define LIFT_HOOK_RAISE_PIN 16      // No Pullup, Invert
#define COLOR_WHEEL_FORWARD_PIN 3   // Pullup, Invert
#define COLOR_WHEEL_REVERSE_PIN 2   // Pullup, Invert
#define LIFT_FORWARD_PIN 5          // Pullup, Invert
#define LIFT_REVERSE_PIN 4          // Pullup, Invert
#define CONVEYOR_FORWARD_PIN 6      // Pullup, Invert
#define CONVEYOR_REVERSE_PIN 7      // Pullup, Invert
#define PICKUP_FORWARD_PIN 8        // Pullup, Invert
#define PICKUP_REVERSE_PIN 9        // Pullup, Invert

Joystick_ joystick(JOYSTICK_DEFAULT_REPORT_ID,JOYSTICK_TYPE_GAMEPAD,
  12, 0,                  // Button Count, Hat Switch Count
  false, false, false,    // X, Y, Z Axis
  false, false, false,    // Rx, Ry, Rz Axis
  false, true,            // rudder, throttle Axis
  false, false, false);   // accelerator, brake, steering Axis

void setup() {
  // Initialize Button Pins
  pinMode(LAUNCHER_MANUAL_PIN, INPUT);
  pinMode(LAUNCER_AUTO_PIN, INPUT_PULLUP);
  pinMode(COLOR_WHEEL_RAISE_PIN, INPUT);
  pinMode(LIFT_HOOK_RAISE_PIN, INPUT);
  pinMode(COLOR_WHEEL_FORWARD_PIN, INPUT_PULLUP);
  pinMode(COLOR_WHEEL_REVERSE_PIN, INPUT_PULLUP);
  pinMode(LIFT_FORWARD_PIN, INPUT_PULLUP);
  pinMode(LIFT_REVERSE_PIN, INPUT_PULLUP);
  pinMode(CONVEYOR_FORWARD_PIN, INPUT_PULLUP);
  pinMode(CONVEYOR_REVERSE_PIN, INPUT_PULLUP);
  pinMode(PICKUP_FORWARD_PIN, INPUT_PULLUP);
  pinMode(PICKUP_REVERSE_PIN, INPUT_PULLUP);

  // Initialize Joystick Library
  joystick.begin();
}

void loop() {
  // Read Throttle Axis
  joystick.setThrottle(1023-analogRead(LAUNCHER_THROTTLE_PIN));
  
  // Read Button Values
  joystick.setButton(0,  digitalRead(LAUNCHER_MANUAL_PIN));
  joystick.setButton(1,  !digitalRead(LAUNCER_AUTO_PIN));
  joystick.setButton(2,  !digitalRead(COLOR_WHEEL_RAISE_PIN));
  joystick.setButton(3,  !digitalRead(LIFT_HOOK_RAISE_PIN));
  joystick.setButton(4,  !digitalRead(COLOR_WHEEL_FORWARD_PIN));
  joystick.setButton(5,  !digitalRead(COLOR_WHEEL_REVERSE_PIN));
  joystick.setButton(6,  !digitalRead(LIFT_FORWARD_PIN));
  joystick.setButton(7,  !digitalRead(LIFT_REVERSE_PIN));
  joystick.setButton(8,  !digitalRead(CONVEYOR_FORWARD_PIN));
  joystick.setButton(9,  !digitalRead(CONVEYOR_REVERSE_PIN));
  joystick.setButton(10, !digitalRead(PICKUP_FORWARD_PIN));
  joystick.setButton(11, !digitalRead(PICKUP_REVERSE_PIN));

  delay(10);
}
