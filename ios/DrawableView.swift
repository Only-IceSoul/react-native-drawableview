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
        mDrawable.setShape(s: .svgPath)
        mDrawable.setStrokeMiter(4)
    }
    override init(frame: CGRect) {
        super.init(frame: frame)
        layer.addSublayer(mDrawable)
        mDrawable.setShape(s: .svgPath)
        mDrawable.setStrokeMiter(4)
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
        mDrawable.setPathRotation(degrees: rotation)
        mDrawable.invalidateSelf()
    }
    @objc func setPathScale(_ v:[String:Any]?){
            let x = v?["x"] as? CGFloat ?? 1
            let y = v?["y"] as? CGFloat ?? 1
            mDrawable.setPathScale(sx: x, sy: y)
            mDrawable.invalidateSelf()
    }
    @objc func setPathTranslation(_ v:[String:Any]?){

        let x = v?["dx"] as? CGFloat ?? 0
        let y = v?["dy"] as? CGFloat ?? 0
        let per = v?["percentageValue"] as? Bool ?? false
      
        if(per){
            mDrawable.setPathTranslation(percentX: x, percentY: y, plusX: 0, plusY: 0)
        }else{
            mDrawable.setPathTranslation(dx: x, dy: y)
        }
        mDrawable.invalidateSelf()
     
    }
    
    @objc func setShadowColor(_ c:NSNumber?){
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
    @objc func setStrokeColor(_ v:NSNumber?){
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
        var cap = DrawableLineCap.butt
        switch(v ?? "butt"){
            case "round":
                cap = DrawableLineCap.round
                break
            case "square" :
                cap = DrawableLineCap.square
                break
            default:
                cap = DrawableLineCap.butt
                break
         }
         mDrawable.setStrokeCap(cap)
         mDrawable.invalidateSelf()
     }
     
    @objc func setStrokeJoin(_ v:String?){
        var join = DrawableLineJoin.miter
        switch(v ?? "miter"){
            case "round":
                join = DrawableLineJoin.round
                break
            case "bevel" :
                join = DrawableLineJoin.bevel
                break
            default:
                join = DrawableLineJoin.miter
                break
         }
         mDrawable.setStrokeJoin(join)
         mDrawable.invalidateSelf()
     }
     
    @objc func setStrokeMiter(_ v:NSNumber?){
        let value = CGFloat(truncating: v ?? 4)
        mDrawable.setStrokeMiter(value)
         mDrawable.invalidateSelf()
     }
    @objc func setPathInset(_ v:[String:Any]?){
        let x = v?["x"] as? CGFloat ?? 0
        let y = v?["y"] as? CGFloat ?? 0
        mDrawable.setInset(dx: x,dy: y)
         mDrawable.invalidateSelf()
     }
    @objc func setFillColor(_ v:NSNumber?){
        let color = Int(truncating: v ?? 0)
        mDrawable.setFillColor(c:  v == nil ? UIColor.clear.cgColor : UIColor.parseInt(argb: color).cgColor)
        mDrawable.invalidateSelf()
    }
    @objc func setBgColor(_ v:NSNumber?){
        let color = Int(truncating: v ?? 0)
        mDrawable.setBackgroundColor(c:  v == nil ? UIColor.clear.cgColor : UIColor.parseInt(argb: color).cgColor)
        mDrawable.invalidateSelf()
    }
    
    
          
  
    
  
    
 

}
