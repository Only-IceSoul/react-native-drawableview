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
    

    let mDrawable = Drawable()
    
     
    init() {
        super.init(frame: .zero)
        layer.addSublayer(mDrawable)
        mDrawable.setShape(s: .svgPath)
        mDrawable.setStrokeMiter(miter: 4)
    }
    override init(frame: CGRect) {
        super.init(frame: frame)
        layer.addSublayer(mDrawable)
        mDrawable.setShape(s: .svgPath)
        mDrawable.setStrokeMiter(miter: 4)
    }
    
    required init?(coder: NSCoder) {fatalError("init(coder:) has not been implemented")}
    
    override var bounds: CGRect{
        didSet{
            mDrawable.onBoundsChange(bounds)
        }
    }
    
    @objc func setPath(_ p:[String:Any]?){
        
            let d = p?["d"] as? String ?? ""
            let viewBox = p?["viewBox"] as? [CGFloat] ?? [0,0,0,0]
            let aspect = p?["aspect"] as? String ?? "none"
            let align = p?["align"] as? String ?? "none"
            var a :ViewBox.AspectRatio = .none
            switch aspect {
            case "meet":
                a = .meet
                break
            case "slice":
                a = .slice
                break
            default:
                a = .none
                break
            }

            mDrawable.setSvgPath(d: d,viewBox: viewBox,align: align,aspect: a)
            mDrawable.invalidateSelf()
        
    }
    @objc func setPathRotation(_ r:NSNumber?){
        let rotation = CGFloat(truncating: r ?? 0)
        mDrawable.setRotationZ(degrees: rotation)
        mDrawable.invalidateSelf()
    }
    @objc func setPathScale(_ v:[String:Any]?){
            let x = v?["x"] as? CGFloat ?? 1
            let y = v?["y"] as? CGFloat ?? 1
            mDrawable.setScale(sx: x, sy: y)
            mDrawable.invalidateSelf()
    }
    @objc func setPathTranslation(_ v:[String:Any]?){

        let x = v?["dx"] as? CGFloat ?? 0
        let y = v?["dy"] as? CGFloat ?? 0
        let per = v?["percentageValue"] as? Bool ?? false
      
        if(per){
            mDrawable.setTranslation(percentX: x, percentY: y, plusX: 0, plusY: 0)
        }else{
            mDrawable.setTranslation(dx: x, dy: y)
        }
        mDrawable.invalidateSelf()
     
    }
    
    @objc func setShadow(_ c:NSNumber?){
        let color = Int(truncating: c ?? 0)
        mDrawable.setShadowColor(c: c == nil ? UIColor.black.cgColor : UIColor.parseInt(argb: color).cgColor)
        mDrawable.invalidateSelf()
    }
    @objc func setShadowOffset(_ v:[String:Any]?){
        let x = v?["x"] as? CGFloat ?? 0
        let y = v?["y"] as? CGFloat ?? 0
        mDrawable.setShadowOffset(p: CGSize(width: x, height: y))
        mDrawable.invalidateSelf()

    }
    @objc func setShadowOpacity(_ v:NSNumber?){
        let op = Float(truncating: v ?? 0)
        mDrawable.setShadowOpacity(o: op)
        mDrawable.invalidateSelf()
    }
    @objc func setShadowRadius(_ v:NSNumber?){
        let rad = CGFloat(truncating: v ?? 1)
        mDrawable.setShadowRadius(r: rad)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeWidth(_ v:NSNumber?){
        let sw = CGFloat(truncating: v ?? 0)
        mDrawable.setStrokeWidth(w: sw)
        mDrawable.invalidateSelf()
    }
    @objc func setStroke(_ v:NSNumber?){
        let color = Int(truncating: v ?? 0)
        mDrawable.setStrokeColor(color:  v == nil ? UIColor.black.cgColor : UIColor.parseInt(argb: color).cgColor)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeStart(_ v:NSNumber?){
        let sv = CGFloat(truncating: v ?? 0)
        mDrawable.setStrokeStart(s: sv)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeEnd(_ v:NSNumber?){
        let ev = CGFloat(truncating: v ?? 1)
        mDrawable.setStrokeEnd(e: ev)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeCap(_ v:String?){
        var cap = CAShapeLayerLineCap.init(rawValue: "butt")
        switch(v ?? "butt"){
            case "round":
                cap = CAShapeLayerLineCap.init(rawValue: "round")
                break
            case "square" :
                cap = CAShapeLayerLineCap.init(rawValue: "square")
                break
            default:
                cap = CAShapeLayerLineCap.init(rawValue: "butt")
                break
         }
        mDrawable.setStrokeCap(cap: cap)
         mDrawable.invalidateSelf()
     }
     
    @objc func setStrokeJoin(_ v:String?){
        var join = CAShapeLayerLineJoin.miter
        switch(v ?? "miter"){
            case "round":
                join = CAShapeLayerLineJoin.round
                break
            case "bevel" :
                join = CAShapeLayerLineJoin.bevel
                break
            default:
                join = CAShapeLayerLineJoin.miter
                break
         }
        mDrawable.setStrokeJoin(join: join)
         mDrawable.invalidateSelf()
     }
     
    @objc func setStrokeMiter(_ v:NSNumber?){
        let value = CGFloat(truncating: v ?? 4)
        mDrawable.setStrokeMiter(miter: value)
         mDrawable.invalidateSelf()
     }

    @objc func setFill(_ v:NSNumber?){
        let color = Int(truncating: v ?? 0)
        mDrawable.setFillColor(c:  v == nil ? UIColor.clear.cgColor : UIColor.parseInt(argb: color).cgColor)
        mDrawable.invalidateSelf()
    }
   
    
    
          
  
    
  
    
 

}
