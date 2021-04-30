//
//  Drawable.swift
//  Drawableview
//
//  Created by Juan J LF on 4/26/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import UIKit
import jjutils

@objc(DrawableView)
class DrawableView: UIView {
    

    let mDrawable = JJDrawable()
    
    init() {
        super.init(frame: .zero)
        layer.addSublayer(mDrawable)
    }
    override init(frame: CGRect) {
        super.init(frame: frame)
        layer.addSublayer(mDrawable)
    }
    
    required init?(coder: NSCoder) {fatalError("init(coder:) has not been implemented")}
    
    override var bounds: CGRect{
        didSet{
            mDrawable.onBoundsChange(bounds)
        }
    }
    
    @objc func setAttrs(_ props: [String:Any]?){
        if props != nil{
            let rtl = props!["borderRadiusTopLeft"] as? CGFloat ?? 0
            let rtr = props!["borderRadiusTopRight"] as? CGFloat ?? 0
            let rbl = props!["borderRadiusBottomLeft"] as? CGFloat ?? 0
            let rbr = props!["borderRadiusBottomRight"] as? CGFloat ?? 0
            
            let p = props!["path"] as? String
            let pvb = props!["pathViewBox"] as? [CGFloat] ?? [0,0,0,0]
            let pvbas = props!["pathViewBoxAspect"] as? Int ?? 0
            let pvba = props!["pathViewBoxAlign"] as? String ?? "xMidYMid"
            let psx = props!["pathScaleX"] as? CGFloat ?? 1
            let psy = props!["pathScaleY"] as? CGFloat ?? 1
            let pr = props!["pathRotation"] as? CGFloat ?? 0
            let ptx = props!["pathTranslationX"] as? CGFloat ?? 0
            let pty = props!["pathTranslationY"] as? CGFloat ?? 0
            let ptp = props!["pathTranslationIsPercent"] as? Bool ?? false
            
            let so = props!["shadowOpacity"] as? Float ?? 0
            let sr = props!["shadowRadius"] as? CGFloat ?? 1
            let sox = props!["shadowOffsetX"] as? CGFloat ?? 0
            let soy = props!["shadowOffsetY"] as? CGFloat ?? 0
            let sc = props!["shadowColor"] as? Int ?? 0
            
            let strokeW = props!["strokeWidth"] as? CGFloat ?? 0
            let strokeC = props!["strokeColor"] as? Int ?? 0
            
            let fc = props!["fillColor"] as? Int ?? 0
            let bg = props!["backgroundColor"] as? Int ?? 0
            
            let viewBoxAspet:ViewBox.AspectRatio = pvbas == 0 ? .meet : (pvb[4] == 1 ? .slice : .none)
            
            
            if(p != nil){
                mDrawable.setShape(s: .svgPath)
                    .setSvgPath(d: p!,viewBox: [pvb[0],pvb[1],pvb[2],pvb[3]],align: pvba,aspect: viewBoxAspet)
            }else{
                mDrawable.setShape(s: .none)
            }
            
            mDrawable.setRadius(topLeft: rtl, topRight: rtr, bottomLeft: rbl, bottomRight: rbr)
               
                .setPathScale(sx: psx, sy: psy)
                .setPathRotation(degrees: pr)
                .setShadowRadius(r: sr)
                .setShadowOffset(p: CGSize(width: sox, height: soy))
                .setShadowOpacity(o: so)
                .setShadowColor(c: sc == 0 ? UIColor.black.cgColor : UIColor.parseSignedInt(argb: sc).cgColor)
                .setStrokeWidth(w: strokeW)
                .setStrokeColor(color:  strokeC == 0 ? UIColor.black.cgColor : UIColor.parseSignedInt(argb: strokeC).cgColor)
                .setFillColor(c: fc == 0 ? UIColor.clear.cgColor : UIColor.parseSignedInt(argb: fc).cgColor)
                .setBackgroundColor(c: bg == 0 ? UIColor.clear.cgColor : UIColor.parseSignedInt(argb: bg).cgColor)
                
              
            if(ptp){
                mDrawable.setTranslation(percentX: ptx, percentY: pty, plusX: 0, plusY: 0)
            }else{
                mDrawable.setTranslation(dx: ptx, dy: pty)
            }
           
            mDrawable.invalidateSelf()
        }
       
    }
    
  
    
 

}
