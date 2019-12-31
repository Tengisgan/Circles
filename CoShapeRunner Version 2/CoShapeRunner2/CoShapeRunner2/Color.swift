//
//  Color.swift
//  Game
//
//  Created by Tengis Gantulga on 6/7/18.
//  Copyright © 2018 Tengis Gantulga. All rights reserved.
//

import Foundation
import SpriteKit


enum Color: String {
    case Red
    case Blue
    case Yellow
    
    func getColor() -> SKColor {
        if(self == Color.Red) {
            return SKColor.red
        }else if(self == Color.Blue) {
            return SKColor.blue
        }else {
            return SKColor.yellow
        }
    }
    
}
