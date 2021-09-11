import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type ColorType = number | string;

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
    
    shadow?: ColorType
    shadowOffset?: {x: number,y:number}
    shadowOpacity?: number
    shadowRadius?:number

    strokeWidth?:number
    stroke?: ColorType
    strokeStart?:number
    strokeEnd?:number
    dashArray?:number
    strokeCap?:'butt' | 'round' | 'square'
    strokeJoin?: 'bevel' | 'miter' | 'round'
    strokeMiter?:number

    fill?:ColorType
    bgColor?: ColorType
}

declare class DrawableComponent extends React.Component<DrawableViewProps> {}
declare const DrawableViewBase: Constructor<NativeMethods> & typeof DrawableComponent;

export class DrawableView extends DrawableViewBase {}
export function Color(color:number | number[] | string): number; 