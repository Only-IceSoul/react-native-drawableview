// main index.js

import { ViewStyle } from 'react-native';
import DrawableView from './DrawableView'

type Path = {
    d?:string,
    viewBox?:string,
    preserveAspectRatio?:string
}

export interface DrawableStyle extends ViewStyle {
    shadowScale?:number,
    path?:Path
    pathOffset?:{x:number,y:number}
    scale?:number
}

export default DrawableView;
