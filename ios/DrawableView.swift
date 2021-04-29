//
//  Drawable.swift
//  Drawableview
//
//  Created by Juan J LF on 4/26/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import UIKit

@objc(DrawableView)
class DrawableView: UIView {
    

    
    init() {super.init(frame: .zero)
    
    }
    override init(frame: CGRect) {super.init(frame: frame)
    }
    
    required init?(coder: NSCoder) {fatalError("init(coder:) has not been implemented")}
    
    override var bounds: CGRect{
        didSet{
            
        }
    }
    
    @objc func setNativeProps(_ props: [String:Any]?){
        if props != nil{
            let w = props!["width"] as? Int ?? -1
            let h = props!["height"] as? Int ?? -1
        }
       
    }
    
  
    
 

}
