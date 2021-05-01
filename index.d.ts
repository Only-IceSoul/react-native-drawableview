import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type Color = number | number[] | string;
type  NumberProp =  string[] | number[]
type DrawableAttrs =  {

    borderRadiusTopLeft?: number
    borderRadiusTopRight?: number
    borderRadiusBottomLeft?: number
    borderRadiusBottomRight?: number

    path?:{
        d:string
        viewBox:string | NumberProp[] 
        preserveAspectRatio?:string
    }
    pathScale?:{ x:number,y:number }
    pathRotation?: number
    pathTranslation?:{
        dx:number,
        dy:number,
        percentageValue:boolean
    }
    shadowColor?: Color
    shadowOffset?: {x: number,y:number}
    shadowOpacity?: number
    shadowRadius?:number

    strokeWidth?:number,
    strokeColor?: Color

    fillColor?:number | number[] | string;
    backgroundColor?: Color


}

interface DrawableViewProps extends ViewProps {
    attrs?:DrawableAttrs
}

declare class ViewDrawable extends React.Component<DrawableViewProps> {}
declare const DrawableView: Constructor<NativeMethods> & typeof ViewDrawable;

export default DrawableView