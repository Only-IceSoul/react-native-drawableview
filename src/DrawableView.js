import { ListViewBase, requireNativeComponent } from 'react-native';
import React, { PureComponent, useMemo } from 'react'
import extractColor from './ColorUtil';
import extractViewBox from './ViewBox';


const DrawableNative = requireNativeComponent('Drawable',null);

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
//     strokeStart?:number
//     strokeEnd?:number
//     fillColor?:number | number[] | string;
//     backgroundColor?: Color


// }


const Drawable = (props) => {
    const {style,...others} = props

    const {
        backgroundColor,
        elevation,
        shadowColor,
        shadowOffset,
        shadowOpacity,
        shadowRadius,
        ...othersStyle 
    } = style


    const path = useMemo(()=>{
        let vb = props.path.viewBox
        if (vb.length !== 4 || vb.some(isNaN)) {
            console.warn('Invalid `viewBox` prop:' + viewBox)
            return{
                d: props.path.d,
                viewBox: [0,0,0,0],
                aspect:props.path.aspect,
                align:props.path.align
            }
        }
      return {
        d: props.path.d,
        viewBox: vb,
        aspect:props.path.aspect,
        align:props.path.align
      }
    },[props.path])

   const strokeColor = useMemo(()=>{
        return extractColor(props.strokeColor)
   },[props.strokeColor])
    
   const fillColor = useMemo(()=>{
    return extractColor(props.fillColor)
},[props.fillColor])
const bgColor = useMemo(()=>{
    return extractColor(props.bgColor)
},[props.bgColor])


const sc = useMemo(()=>{
    return extractColor(props.shadowColor)
},[props.shadowColor])
    return (  
      
            //@ts-ignore
            <DrawableNative
            ref={props.ref}  
            style={othersStyle} 
                path={path}
                pathScale={others.pathScale || { x:1,y:1}}
                pathRotation={others.pathRotation || 0}
                pathTranslation={others.pathTranslation}
                shadowColor={sc}
                shadowOffset={others.shadowOffset}
                shadowOpacity={others.shadowOpacity || 0}
                shadowRadius={others.shadowRadius || 1}
            
                strokeWidth={others.strokeWidth || 0}
                strokeColor={strokeColor}
                strokeStart={others.strokeStart || 0}
                strokeEnd={others.strokeEnd || 1}
            
                fillColor={fillColor} 
                bgColor={bgColor}
            />
        
    )
}


class DrawableView extends PureComponent {

    render(){
        return <Drawable {...this.props} />    
    }
}



export default DrawableView