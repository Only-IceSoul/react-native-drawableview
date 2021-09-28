import React from "react";
import { Constructor, NativeMethods, ViewProps } from "react-native";

type ColorType = number | string;

interface DrawableViewProps extends ViewProps {
  
    d:string
    viewBox?:number[] 
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

    opacity?:number
    translateZ?:number

    fill?:ColorType
    fillRule?: 'evenodd' | 'nonzero'
    fillOpacity?:number

    stroke?: ColorType
    strokeOpacity?:number
    strokeWidth?:number
    strokeStart?:number
    strokeEnd?:number
    strokeCap?:'butt' | 'round' | 'square'
    strokeJoin?: 'bevel' | 'miter' | 'round'
    strokeMiter?:number
    dashArray?:number  //web

    shadow?: ColorType
    shadowOffset?:number
    shadowOffsetX?:number
    shadowOffsetY?:number
    shadowPercentageValue?:boolean //mobile
    shadowOpacity?: number
    shadowRadius?:number
    shadowRect?:{ x:number,y:number,w:number,h:number, units:'userSpaceOnUse' | 'objectBoundingBox'} //web
   
    // transformOrder?: "r-s-t" | "r-t-s" | "s-r-t" | "s-t-r" | "t-r-s" | "t-s-r" 

    transX?:number
    transY?:number
    transPercentageValue?:boolean  //mobile
    
    rot?:number
    rotO?:number
    rotOx?:number
    rotOy?:number
    rotPercentageValue?:boolean //mobile

    sc?:number
    scX?:number
    scY?:number
    scO?:number
    scOx?:number
    scOy?:number
    scPercentageValue?:boolean //mobile
    
}

declare class DrawableComponent extends React.Component<DrawableViewProps> {}
declare const DrawableViewBase: Constructor<NativeMethods> & typeof DrawableComponent;

export class DrawableView extends DrawableViewBase {}
export class DrawableViewS extends DrawableViewBase {}
export function Color(color:number | number[] | string): number; 