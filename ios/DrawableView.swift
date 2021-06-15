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
    }
    override init(frame: CGRect) {
        super.init(frame: frame)
        layer.addSublayer(mDrawable)
        mDrawable.setShape(s: .svgPath)
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
            let align = p?["align"] as? String ?? "xMidYMid"
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
    @objc func setPathRotation(_ r:CGFloat){
        mDrawable.setPathRotation(degrees: r)
        mDrawable.invalidateSelf()
        print("called rotation ",r)
    }
    @objc func setPathScale(_ v:[String:Any]?){

            let x = v?["x"] as? CGFloat ?? 1
            let y = v?["y"] as? CGFloat ?? 1
            mDrawable.setPathScale(sx: x, sy: y)
            mDrawable.invalidateSelf()
        print("called scale ",x,y)

    }
    @objc func setPathTranslation(_ v:[String:Any]?){

        let x = v?["dx"] as? CGFloat ?? 0
        let y = v?["dy"] as? CGFloat ?? 0
        let per = v?["percentageValue"] as? Bool ?? false
        print("called trans ",x,y,per)
        if(per){
            mDrawable.setPathTranslation(percentX: x, percentY: y, plusX: 0, plusY: 0)
        }else{
            mDrawable.setPathTranslation(dx: x, dy: y)
        }
        mDrawable.invalidateSelf()
     
    }
    
    @objc func setShadowColor(_ c:CGFloat){
        mDrawable.setShadowColor(c: c == 0 ? UIColor.black.cgColor : UIColor.parseSignedInt(argb: Int(c)).cgColor)
        mDrawable.invalidateSelf()
        
    }
    @objc func setShadowOffset(_ v:[String:Any]?){
        let x = v?["x"] as? CGFloat ?? 0
        let y = v?["y"] as? CGFloat ?? 0
        mDrawable.setShadowOffset(p: CGSize(width: x, height: y))
        mDrawable.invalidateSelf()

    }
    @objc func setShadowOpacity(_ v:CGFloat){
        mDrawable.setShadowOpacity(o: Float(v))
    }
    @objc func setShadowRadius(_ v:CGFloat){
        mDrawable.setShadowRadius(r: v)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeWidth(_ v:CGFloat){
        mDrawable.setStrokeWidth(w: v)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeColor(_ v:CGFloat){
        mDrawable.setStrokeColor(color:  v == 0 ? UIColor.black.cgColor : UIColor.parseSignedInt(argb: Int(v)).cgColor)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeStart(_ v:CGFloat){
        mDrawable.setStrokeStart(s: v)
        mDrawable.invalidateSelf()
    }
    @objc func setStrokeEnd(_ v:CGFloat){
        mDrawable.setStrokeEnd(e: v)
        mDrawable.invalidateSelf()
    }
    @objc func setFillColor(_ v:CGFloat){
        mDrawable.setFillColor(c:  v == 0 ? UIColor.clear.cgColor : UIColor.parseSignedInt(argb: Int(v)).cgColor)
        mDrawable.invalidateSelf()
    }
    @objc func setBgColor(_ v:CGFloat){
        mDrawable.setBackgroundColor(c:  v == 0 ? UIColor.clear.cgColor : UIColor.parseSignedInt(argb: Int(v)).cgColor)
        mDrawable.invalidateSelf()
    }
    
    
          
  
    
  
    
 

}
