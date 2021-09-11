// main index.js


import { Platform,requireNativeComponent } from 'react-native';
import DrawableViewWeb from './src/DrawableViewWeb'
import ExtractColor from './src/Color'
export const DrawableView = Platform.OS == 'android' || Platform.OS == 'ios' ? requireNativeComponent('JJSDrawable',null) : DrawableViewWeb
export const Color = ExtractColor;