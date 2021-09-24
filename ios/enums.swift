//
//  enums.swift
//  react-native-drawableview
//
//  Created by Juan J LF on 9/23/21.
//

import Foundation
import UIKit

enum PathParserError: Error {
    case runtimeError(String)
    case IllegalStateException(String)
    case Exception(String)
    case IllegalArgumentException(String)
    case IndexOutOfBoundsException(String)
    case NullPointerException(String)
    case OperationCanceledException(String)
    case ParseException(String)
  
}

enum DrawableAxis {
    case x, y , z
}

enum DrawableLineCap : String{
    case butt,
         round,
         square
    
    func toTarget() -> CAShapeLayerLineCap
    {
        return CAShapeLayerLineCap.init(rawValue: rawValue)
    }
}

enum GradientDrawableType : String{
    case axial,
         radial,
         conic
    func toTarget() -> CAGradientLayerType
    {
        return CAGradientLayerType(rawValue: rawValue)
    }
}

enum DrawableLineJoin : String{
    case bevel,
         miter,
         round
    
    func toTarget() -> CAShapeLayerLineJoin
    {
        return CAShapeLayerLineJoin.init(rawValue: rawValue)
    }
}
