import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type Color = number | number[] | string;

interface DrawableViewProps extends ViewProps {
  
    path?:{
        d:string
        viewBox:number[] 
        aspect?: 'meet' | 'slice' | 'none'
        align?:'xMinYMin'|
        'xMidYMin' |
        'xMaxYMin' |
        'xMinYMid' |
        'xMidYMid' |
        'xMaxYMid' |
        'xMinYMax' |
        'xMidYMax' |
        'xMaxYMax' |
        'none'
    }
    pathScale?:{ x:number,y:number }
    pathRotation?: number
    pathTranslation?:{
        dx:number,
        dy:number,
        percentageValue:boolean
    }
    pathInset?:{ x:number,y:number }
    
    shadowColor?: Color
    shadowOffset?: {x: number,y:number}
    shadowOpacity?: number
    shadowRadius?:number

    strokeWidth?:number
    strokeColor?: Color
    strokeStart?:number
    strokeEnd?:number
    strokeCap?:'butt' | 'round' | 'square'
    strokeJoin?: 'bevel' | 'miter' | 'round'
    strokeMiter?:number

    fillColor?:number | number[] | string
    bgColor?: Color
}

declare class ViewDrawable extends React.Component<DrawableViewProps> {}
declare const DrawableView: Constructor<NativeMethods> & typeof ViewDrawable;

export default DrawableView