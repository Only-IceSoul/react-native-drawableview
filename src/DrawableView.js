import { requireNativeComponent } from 'react-native';
import React, { useMemo } from 'react'
import extractColor from './ColorUtil';
import extractViewBox from './ViewBox';


const Drawable = requireNativeComponent('Drawable',null);

// type DrawableAttrs = {

//     borderRadiusTopLeft?: number
//     borderRadiusTopRight?: number
//     borderRadiusBottomLeft?: number
//     borderRadiusBottomRight?: number

//     path?:{
//         d:string
//         viewBox:string | NumberProp[] 
//         preserveAspectRatio?:string
//     }
//     pathScale?:{ x:number,y:number }
//     pathRotation?: number
//     pathTranslation?:{
//         dx:number,
//         dy:number,
//         percentageValue:boolean
//     }
//     shadowColor?: Color
//     shadowOffset?: {x: number,y:number}
//     shadowOpacity?: number
//     shadowRadius?:number

//     strokeWidth?:number,
//     strokeColor?: Color

//     fillColor?:number | number[] | string;
//     backgroundColor?: Color


// }


const DrawableView = (props) => {
    const {style,attrs,...others} = props

    const {
        backgroundColor,
        elevation,
        shadowColor,
        shadowOffset,
        shadowOpacity,
        shadowRadius,
        ...othersStyle 
    } = style

    const attrsComputed = useMemo(()=>{
       
        var o = {}
        if(attrs){
            o.borderRadiusTopLeft =  attrs.borderRadiusTopLeft || 0
            o.borderRadiusTopRight =  attrs.borderRadiusTopRight || 0
            o.borderRadiusBottomLeft =  attrs.borderRadiusBottomLeft || 0
            o.borderRadiusBottomRight =  attrs.borderRadiusBottomRight || 0
            
            if(attrs.path){
                o.path = attrs.path.d
                let vb =  extractViewBox({ viewBox: attrs.path.viewBox , preserveAspectRatio: attrs.path.preserveAspectRatio })
                o.pathViewBox = [vb.minX,vb.minY,vb.vbWidth,vb.vbHeight]
                o.pathViewBoxAspect = vb.meetOrSlice
                o.pathViewBoxAlign = vb.align
             }
    
             o.pathScaleX = attrs.pathScale?.x
             o.pathScaleY = attrs.pathScale?.y
             o.pathRotation = attrs.pathRotation
             o.pathTranslationX = attrs.pathTranslation?.dx
             o.pathTranslationY = attrs.pathTranslation?.dy
             o.pathTranslationIsPercent = attrs.pathTranslation?.percentageValue
    
             o.shadowOpacity = attrs.shadowOpacity
             o.shadowRadius = attrs.shadowRadius
             o.shadowOffsetX = attrs.shadowOffset?.x
             o.shadowOffsetY = attrs.shadowOffset?.y
             o.shadowColor = extractColor(attrs.shadowColor)
    
             o.strokeWidth = attrs.strokeWidth
             o.strokeColor = extractColor(attrs.strokeColor)
    
             o.fillColor = extractColor(attrs.fillColor)
             o.backgroundColor = extractColor(attrs.backgroundColor)
    
        }
      

        return o

    },[props.attrs])
    


    return (  
      
            //@ts-ignore
            <Drawable {...others} style={othersStyle} attrs={attrsComputed} />
        
    )
}




export default DrawableView