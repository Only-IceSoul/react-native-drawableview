//
//  DrawableView.swift
//  Drawableview
//
//  Created by Juan J LF on 4/26/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import UIKit

@objc(Drawable)
class Drawable: RCTViewManager {

    override func view() -> UIView! {
       return DrawableView()
     }
   override class func requiresMainQueueSetup() -> Bool {
        return false
    }
}
