import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type Color = number | string;

//atributo dasharray y todo el drawable view, actualizar inset con dip en android, traer el color de gradient
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
    dashArray?:number
    strokeCap?:'butt' | 'round' | 'square'
    strokeJoin?: 'bevel' | 'miter' | 'round'
    strokeMiter?:number

    fillColor?:number | string
    bgColor?: Color
}

declare class DrawableComponent extends React.Component<DrawableViewProps> {}
declare const DrawableViewBase: Constructor<NativeMethods> & typeof DrawableComponent;

export class DrawableView extends DrawableViewBase {}
export function Color(color:number | number[] | string): number; 