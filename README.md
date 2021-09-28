# DrawableView

Draw svg paths with shadows

android: api 21+   
ios : 10.0+   
web: svg  

<img src="./src/demo.jpg" width="300">


## Getting started

`$ npm install react-native-drawableview --save`  
`$ react-native link react-native-drawableview`  
  
or

`$ yarn add react-native-drawableview `
    


## IOS

cd ios

pod install

**Add Swift**

/ios/name_project

add a .swift file


# Usage



```javascript
import {DrawableView ,DrawableViewS, Color} from 'react-native-drawableview';

// (Android) DrawableViewS  -> shadow Layer type Software( < api 28 )
// (Android) DrawableView  -> Layer type none 
// TODO: What to do with the module?

   var colorRed = Color('red') //Color('rgba(255,0,0,1)'), #FF0000 .....

   <DrawableViewS {...props} shadow={colorRed} />

```


## Props   



| Name | description | type | default |
| --- | --- | --- | --- |
| d | The shape, defined by a series of commands   | String | "" |
| viewBox | defines the position and dimension, in user space    | Array[Number] (4) | undefined |
| align | the aligment     | String | xMidYMid |
| aspect | aspect ratio   | String | meet |
| opacity | The opacity attribute specifies the transparency | Number | 1 |
| fill | The fill prop refers to the color inside the shape.        | Color | black |
| fillRule | determines what side of a path is inside a shape  | String | nonzero |
| fillOpacity   | the opacity of the color [0 - 1] | Number | 1 |
| stroke | defines the color of a line  | Color | transparent |
| strokeOpacity |  the opacity of the line color [0 - 1]  | Number | 1 |
| strokeWidth | defines the thickness of a line | Number | 1 
| strokeCap | line cap | string | 'butt' |
| strokeJoin | line join | string | 'miter' |
| strokeMiter | control the behavior of miter | Number | 4 |
| strokeStart | the start | Number | 0 |
| strokeEnd | the end | Number | 1 |
| dashArray | required for stroke (web) | Number | 0 |
| shadow | set the sahdow color  | Color | 'black' |
| shadowOpacity | set the shadow opacity [0 - 1]  | Number | 0 |
| shadowRadius | the radius | Number | 2 |
| shadowOffset | set the offset | Number | 2  |
| shadowOffsetX | set the offset x | Number | 2  |
| shadowOffsetY | set the offset y| Number | 2  |
| shadowPercentageValue | offset * size (mobile) | Bool | false |
| shadowRect | clip Region (web) | Object | size * 3 |

<br>

### Transform ###  

<br>

The percentageValue property (mobile) : refers to the fact that the Origin will be multiplied by the size of the view.  
  
| Name | type | default |
| --- | --- | --- |
| translateZ | Number (zIndex) | 0 |
| transX | Number | 0 |
| transY | Number | 0 |
| transPercentageValue | Bool | false |  
| rot | Number | 0 |
| rotOx | Number | 0 |
| rotOy | Number | 0 |
| rotPercentageValue | Bool | false |
| sc | Number | 1 |
| scX | Number | 1 |
| scY | Number | 1 |
| scO | Number | 0 |
| scOx | Number | 0 |
| scOy | Number | 0 |
| scPercentageValue | Bool | false |

