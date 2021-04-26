import { requireNativeComponent } from 'react-native';
import React, { useMemo } from 'react'
import extractColor from './ColorUtil';
import extractViewBox from './ViewBox';

const JJDrawableView = requireNativeComponent('JJDrawableView');




const DrawableView = (props:any) => {
    const {style,...others} = props

    const {backgroundColor,elevation , path,
        pathOffset,
        shadowScale,
        scale,
        shadowColor,
        shadowOffset,
        shadowOpacity,
        borderBottomColor,
        borderBottomEndRadius,
        borderBottomLeftRadius,
        borderBottomWidth,
        borderBottomRightRadius,
        borderBottomStartRadius,
        borderTopColor,
        borderTopEndRadius,
        borderTopLeftRadius,
        borderTopRightRadius,
        borderTopStartRadius,
        borderTopWidth,
        borderLeftColor,
        borderLeftWidth,
        borderRightColor,
        borderRightWidth,
        borderStartColor,
        borderStartWidth,
        borderEndColor,
        borderEndWidth,
        borderColor,
        borderRadius,
        borderStyle,
        borderWidth,
        ...othersStyle } = style

    

 
    const bgColor = useMemo(()=>{
         return extractColor(backgroundColor)
    },[props.style])

    const borColor = useMemo(()=>{
        return extractColor(borderColor)
   },[props.style])

   const vBox = useMemo(()=>{
       if(path){
          return extractViewBox({ viewBox: path.viewBox , preserveAspectRatio: path.preserveAspectRatio })
       }
       return  {
        minX: 0,
        minY: 0,
        vbWidth: 0,
        vbHeight: 0,
        align:  'xMidYMid',
        meetOrSlice: 0,
      };
     },[props.style])

    const so = useMemo(()=>{
        var base = borderRadius || 0
        var o = {
            rtl:base,
            rtr:base,
            rbl:base,
            rbr:base,
            isTopRtl:false,
            isBottomRtl:false,
        }
      
        o.rtl =  borderTopLeftRadius || base
        o.rtr =  borderTopRightRadius || base
        o.rbl =  borderBottomLeftRadius || base
        o.rbr =  borderBottomRightRadius || base


        if( borderTopStartRadius ) {
            o.isTopRtl = true
            o.rtl =  borderTopStartRadius
        }
        if( borderTopEndRadius ) {
            o.isTopRtl = true
            o.rtr =  borderTopEndRadius
        }
        if( borderBottomStartRadius ) {
            o.isBottomRtl = true
            o.rbl =  borderBottomStartRadius
        }
        if( borderBottomEndRadius ) {
            o.isBottomRtl = true
            o.rbr =  borderBottomEndRadius
        }


        return o
    },[props.style])
    


    return (  
      
         
            <JJDrawableView {...others} style={othersStyle} nativeProps={{

                radiusTopLeft: so.rtl,
                radiusTopRight: so.rtr,
                radiusBottomLeft: so.rbl,
                radiusBottomRight: so.rbr,
                isBorderTopRtl: so.isTopRtl, 
                isBorderBottomRtl:so.isBottomRtl,

                strokeColor:borColor,
                strokeWidth:borderWidth,

                shadowScale:shadowScale,
                shadowOpacity: shadowOpacity ,
                shadowOffsetX:shadowOffset ? shadowOffset.width || 0 : 0,
                shadowOffsetY:shadowOffset ? shadowOffset.height || 0 : 0,
                shadowColor:shadowColor,

                elevation:elevation,
                fillColor:bgColor,
           

                path:path ? path.d : null,
                vbMinX:vBox.minX,
                vbMinY:vBox.minY,
                vbMeetOrSlice:vBox.meetOrSlice,
                vbAlign:vBox.align,
                vbWidth:vBox.vbWidth,
                vbHeight:vBox.vbHeight,
                pathOffsetX:pathOffset ? pathOffset.x || 0 : 0,
                pathOffsetY:pathOffset ? pathOffset.y || 0: 0,
                scale:scale,
              

                
            }} />
 
    )
}




export default DrawableView