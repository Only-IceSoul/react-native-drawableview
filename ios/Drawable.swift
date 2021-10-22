//
//  Drawable.swift
//  react-native-drawableview
//
//  Created by Juan J LF on 9/23/21.
//

import Foundation
import UIKit
 class Drawable: CAShapeLayer  {
   
    
    var mProps = CommonProps()
    var mTransform = TransformProps()
    

    var mBounds = CGRect()
    var mRectPath = CGRect()
    var mRectVb = CGRect(x: 0, y: 0, width: -1, height: -1)
    
    var mPath  = UIBezierPath()
    
    var mD = ""
    var mAlign = "xMidYMid"
    var mAspect = SVGViewBox.AspectRatio.meet
    
   
    
     override init() {
        super.init()
        super.fillColor = UIColor.clear.cgColor
        super.shadowOffset = .init(width: 0, height: 0)
        super.lineWidth = 0
        super.strokeColor = UIColor.clear.cgColor
        super.shadowOpacity = 0
        super.shadowRadius = 0
        super.shadowColor = UIColor.clear.cgColor
    }
        
    
    
    //MARK: set and get
    
    @discardableResult
     func setD(_ v:String) -> Drawable{
        mD = v
        invalidate()
       return self
    }
    
    @discardableResult
     func setViewBox(_ v:[CGFloat]) -> Drawable{
        mRectVb.set(left: v[0], top: v[1], right: v[0] + v[2], bottom: v[1] + v[3])
        invalidate()
       return self
    }
    
    @discardableResult
     func setAspect(_ v:SVGViewBox.AspectRatio) -> Drawable{
        if mAspect != v{
            mAspect = v
            invalidate()
        }
       return self
    }
    
    @discardableResult
     func setAlign(_ v:String) -> Drawable{
        if mAlign != v{
            mAlign = v
            invalidate()
        }
       return self
    }
    
    @discardableResult
    func setOpacity(_ v:Float) -> Drawable{
        if mProps.opacity != v{
            mProps.opacity = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setFill(_ v:Int) -> Drawable{
        if mProps.fillColor != v{
            mProps.fillColor = v
            invalidateCommonProps()
        }
       return self
   }
    
    @discardableResult
     func setFillRule(_ v:String) -> Drawable{
        if mProps.fillRule != v{
            mProps.fillRule = v
            invalidateCommonProps()
            invalidate()
        }
       return self
    }
    
    @discardableResult
     func setFillOpacity(_ v:CGFloat) -> Drawable{
        if mProps.fillOpacity != v{
            mProps.fillOpacity = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStroke(_ v:Int) -> Drawable{
        if mProps.strokeColor != v{
            mProps.strokeColor = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeOpacity(_ v:CGFloat) -> Drawable{
        if mProps.strokeOpacity != v{
            mProps.strokeOpacity = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeWidth(_ v:CGFloat) -> Drawable{
        if mProps.strokeWidth != v{
            mProps.strokeWidth = v
            invalidateShadowPath()
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeCap(_ v:String) -> Drawable{
        if mProps.strokeCap != v{
            mProps.strokeCap = v
            invalidateShadowPath()
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeJoin(_ v:String) -> Drawable{
        if mProps.strokeJoin != v{
            mProps.strokeJoin = v
            invalidateShadowPath()
            invalidateCommonProps()
        }
       return self
    }
    @discardableResult
     func setStrokeMiter(_ v:CGFloat) -> Drawable{
        if mProps.strokeMiter != v{
            mProps.strokeMiter = v
            invalidateShadowPath()
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeStart(_ v:CGFloat) -> Drawable{
        if mProps.strokeStart != v{
            mProps.strokeStart = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setStrokeEnd(_ v:CGFloat) -> Drawable{
        if mProps.strokeEnd != v{
            mProps.strokeEnd = v
            invalidateCommonProps()
        }
       return self
    }
    
    
    @discardableResult
     func setShadow(_ v:Int) -> Drawable{
        if mProps.shadowColor != v{
            mProps.shadowColor = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setShadowOpacity(_ v:Float) -> Drawable{
        if mProps.shadowOpacity != v{
            mProps.shadowOpacity = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setShadowRadius(_ v:CGFloat) -> Drawable{
        if mProps.shadowRadius != v{
            mProps.shadowRadius = v
            invalidateCommonProps()
        }
       return self
    }
    
    @discardableResult
     func setShadowOffset(_ v:CGFloat) -> Drawable{
        if mProps.shadowOffsetX != v || mProps.shadowOffsetY != v  {
            mProps.shadowOffsetX = v
            mProps.shadowOffsetY = v
            invalidateCommonProps()
        }
       return self
    }
    @discardableResult
     func setShadowOffsetX(_ v:CGFloat) -> Drawable{
        if mProps.shadowOffsetX != v {
            mProps.shadowOffsetX = v
            invalidateCommonProps()
        }
       return self
    }
    @discardableResult
     func setShadowOffsetY(_ v:CGFloat) -> Drawable{
        if mProps.shadowOffsetY != v  {
            mProps.shadowOffsetY = v
            invalidateCommonProps()
        }
       return self
    }
    @discardableResult
     func setShadowPercentageValue(_ v:Bool) -> Drawable{
        if mProps.shadowOffsetIsPercent != v  {
            mProps.shadowOffsetIsPercent = v
            invalidateCommonProps()
        }
       return self
    }
    
    //MARK: Transform props
     func setTransX(v:CGFloat) {
            if(mTransform.mTranslationX != v ){
                mTransform.mTranslationX = v;
                invalidateTransform();
            }
        }
         func setTransY(v:CGFloat) {
            if(mTransform.mTranslationY != v ){
                mTransform.mTranslationY = v;
                invalidateTransform();
            }
        }
         func setTransPercentageValue(v:Bool) {
            if(mTransform.mTranslationIsPercent != v ){
                mTransform.mTranslationIsPercent = v;
                invalidateTransform();
            }
        }

         func setRot(v:CGFloat) {
            if(mTransform.mRotation != v ){
                mTransform.mRotation = v;
                invalidateTransform();
            }
        }
         func setRotO(v:CGFloat) {
            if(mTransform.mRotationOriginX != v || mTransform.mRotationOriginY != v ){
                mTransform.mRotationOriginX = v;
                mTransform.mRotationOriginY = v;
                invalidateTransform();
            }
        }
         func setRotOx(v:CGFloat) {
            if(mTransform.mRotationOriginX != v ){
                mTransform.mRotationOriginX = v;
                invalidateTransform();
            }
        }
         func setRotOy(v:CGFloat) {
            if(mTransform.mRotationOriginY != v ){
                mTransform.mRotationOriginY = v;
                invalidateTransform();
            }
        }
         func setRotPercentageValue(v:Bool) {
            if(mTransform.mRotationIsPercent != v ){
                mTransform.mRotationIsPercent = v;
                invalidateTransform();
            }
        }

         func setSc(v:CGFloat){
            if(mTransform.mScaleX != v || mTransform.mScaleY != v){
                mTransform.mScaleX = v;
                mTransform.mScaleY = v;
                invalidateTransform();
            }
        }
         func setScX(v:CGFloat) {
            if(mTransform.mScaleX != v ){
                mTransform.mScaleX = v;
                invalidateTransform();
            }
        }

         func setScY(v:CGFloat) {
            if(mTransform.mScaleY != v ){
                mTransform.mScaleY = v;
                invalidateTransform();
            }
        }
         func setScO(v:CGFloat){
            if(mTransform.mScaleOriginX != v || mTransform.mScaleOriginY != v){
                mTransform.mScaleOriginX = v;
                mTransform.mScaleOriginY = v;
                invalidateTransform();
            }
        }
         func setScOx(v:CGFloat) {
            if(mTransform.mScaleOriginX != v ){
                mTransform.mScaleOriginX = v;
                invalidateTransform();
            }
        }
         func setScOy(v:CGFloat) {
            if(mTransform.mScaleOriginY != v ){
                mTransform.mScaleOriginY = v;
                invalidateTransform();
            }
        }
         func setScPercentageValue(v:Bool) {
            if(mTransform.mScaleIsPercent != v ){
                mTransform.mScaleIsPercent = v;
                invalidateTransform();
            }
        }
    
    //MARK: layer methods
    
     func onBoundsChange(_ frame: CGRect){
        mBounds.set(rect: frame)
        disableAnimation()
        super.frame = mBounds
        super.position = CGPoint(x: 0, y: 0)
        super.anchorPoint = CGPoint(x: 0, y: 0)
        commit()
        invalidate()
        
    }
    

    open func setupPath(){
        
        mPath.removeAllPoints()

        do{
           mPath = try SVGPathParser.parse(d: mD)

        }catch{
           print("PathParser ERROR: ",error)
        }
        
    }
    
    
    
  
    func invalidate(){
        if(mBounds.width > 0 && mBounds.height > 0){
            
            setupPath()
            
            viewBoxTransform() 
            
            mPath.usesEvenOddFillRule = mProps.getFillRule()
            
            super.path = mPath.cgPath
            
          
            //require rectpath , viewboxtransform
            invalidateShadowPath()
            invalidateCommonProps()
            invalidateTransform()
        }
        
    }
    
    func invalidateShadowPath(){
        let sw:CGFloat = validateViewBox() ? mProps.getStrokeWidth().asViewBoxToMax(mRectVb, mRectPath.width, mRectPath.height) : mProps.getStrokeWidth()
        super.shadowPath = fill() ? mPath.cgPath : mPath.cgPath.copy(strokingWithWidth: sw, lineCap: mProps.getCGStrokeCap(), lineJoin: mProps.getCGStrokeJoin(), miterLimit: mProps.getStrokeMiter())
        
    }
   
    
     func invalidateCommonProps(){
        
        if(mBounds.width > 0 && mBounds.height > 0 ){
            disableAnimation()
            setupFill()
            setupStroke()
            setupShadow()
            super.opacity = mProps.getOpacity()
            commit()
        }
    }
       
     func invalidateTransform(){
     
        if(mBounds.width > 0 && mBounds.height > 0 ){
            var matrix = CATransform3DIdentity
          
            
            if mTransform.mTranslationX != 0 || mTransform.mTranslationY != 0{
                var transX = mTransform.mTranslationX
                var transY = mTransform.mTranslationY
                if mTransform.mTranslationIsPercent{
                    transX = mTransform.mTranslationX * mBounds.width
                    transY = mTransform.mTranslationY * mBounds.height
                }else if validateViewBox() {
                    transX = (mTransform.mTranslationX / mRectVb.width) * mRectPath.width
                    transY = (mTransform.mTranslationY / mRectVb.height) * mRectPath.height
                }
                
                matrix = CATransform3DTranslate(matrix, transX, transY, 0)
            }
            
            if mTransform.mRotation != 0{
                var rotX = mTransform.mRotationOriginX
                var rotY = mTransform.mRotationOriginY
                if mTransform.mRotationIsPercent{
                    rotX = mTransform.mRotationOriginX * mBounds.width
                    rotY = mTransform.mRotationOriginY * mBounds.height
                }else if validateViewBox(){
                   
                    rotX = mRectPath.left + mTransform.mRotationOriginX.asViewBoxToWidth(mRectVb, mRectPath.width)
                    rotY = mRectPath.top + mTransform.mRotationOriginY.asViewBoxToHeight(mRectVb, mRectPath.height)
                }
                matrix = CATransform3DTranslate(matrix, rotX, rotY, 0)
                matrix = CATransform3DRotate(matrix, mTransform.mRotation.toRadians(), 0, 0, 1)
                matrix = CATransform3DTranslate(matrix, -rotX, -rotY, 0)
            }
       
            if mTransform.mScaleX != 1 || mTransform.mScaleY != 1{
            
                var ox = mTransform.mScaleOriginX
                var oy = mTransform.mScaleOriginY
                if mTransform.mScaleIsPercent {
                    ox = mTransform.mScaleOriginX * mBounds.width
                    oy = mTransform.mScaleOriginY * mBounds.height
                }else if validateViewBox() {
                    ox = mRectPath.left + mTransform.mScaleOriginX.asViewBoxToWidth(mRectVb, mRectPath.width)
                    oy = mRectPath.top +  mTransform.mScaleOriginY.asViewBoxToHeight(mRectVb, mRectPath.height)
                }
                matrix = CATransform3DTranslate(matrix, ox, oy, 0)
                matrix = CATransform3DScale(matrix, mTransform.mScaleX, mTransform.mScaleY, 1)
                matrix = CATransform3DTranslate(matrix, -ox, -oy, 0)
            }

            disableAnimation()
            super.transform = matrix
            commit()
        }
    }
    
    private func viewBoxTransform(){
         if validateViewBox() {
            mRectPath.set(rect: mRectVb)
            let trans = SVGViewBox.transform(vbRect: mRectVb, eRect: mBounds, align: mAlign, meetOrSlice: mAspect )
            mPath.apply(trans)
            mRectPath = mRectPath.applying(trans)
         }else{
            mRectPath.set(rect: mBounds)
         }
    }
    
   
    
    private func setupFill(){
        let c = UIColor.parseInt(argb: mProps.getFillColor(), opacity: mProps.getFillOpacity())
        super.fillColor = c.cgColor
    }
    
    private func setupStroke(){
        let sw:CGFloat = validateViewBox() ? mProps.getStrokeWidth().asViewBoxToMax(mRectVb, mRectPath.width, mRectPath.height) : mProps.getStrokeWidth()
        super.lineWidth = sw
        let c = UIColor.parseInt(argb: mProps.getStrokeColor(), opacity: mProps.getStrokeOpacity())
        super.strokeColor = c.cgColor
        
        super.lineCap = mProps.getStrokeCap().toTarget()
        super.miterLimit = mProps.getStrokeMiter()
        super.lineJoin = mProps.getStrokeJoin().toTarget()
        super.strokeStart = mProps.getStrokeStart()
        super.strokeEnd = mProps.getStrokeEnd()
        
    }
    private func setupShadow(){
        let c = UIColor.parseInt(argb: mProps.getShadowColor())
        super.shadowColor = c.cgColor
        
        var offset = CGSize(width: 0, height: 0)
        if mProps.getShadowOffsetIsPercent(){
            offset.width = mProps.getShadowOffsetX() * mBounds.width
            offset.height = mProps.getShadowOffsetY() * mBounds.height
        }else if validateViewBox() {
            offset.width = (mProps.getShadowOffsetX() / mRectVb.width) * mRectPath.width
            offset.height = (mProps.getShadowOffsetY() / mRectVb.height) * mRectPath.height
        }else{
            offset.width = mProps.getShadowOffsetX()
            offset.height = mProps.getShadowOffsetY()
        }
        super.shadowOffset = offset
        
        let radius:CGFloat = validateViewBox() ? mProps.getShadowRadius().asViewBoxToMax(mRectVb, mRectPath.width, mRectPath.height) : mProps.getShadowRadius()
        super.shadowRadius = radius
        super.shadowOpacity = mProps.getShadowOpacity()
        
    }
 
    private func validateViewBox() -> Bool {
        return mRectVb.width >= 0 && mRectVb.height >= 0
    }
    private func fill()->Bool{
        return mProps.getFillColor() != 0
    }
    
     func disableAnimation(){
        CATransaction.begin()
        CATransaction.setDisableActions(true)
    }
    
     func commit(){
        CATransaction.commit()
    }
    

   
     override init(layer: Any) {
        super.init(layer: layer)

    }
     required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
 

      
}
