# DrawableView

Draw svg paths with shadows and roundedrects

<img src="./src/demo.jpg" width="300">


## Getting started

`$ npm install react-native-drawableview --save`

### Mostly automatic installation

`$ react-native link react-native-drawableview`


# Usage
```javascript
import Drawableview from 'react-native-drawableview';

// TODO: What to do with the module?
   <Drawableview attrs={props} />
```


## Props   

| Name | description | type | default |
| --- | --- | --- | --- |
| borderRadiusTopLeft | set the corner radius | Number | 0 |
| borderRadiusTopRight | set the corner radius | Number | 0 |
| borderRadiusBottomLeft | set the corner radius | Number | 0 |
| borderRadiusBottomRight | set the corner radius | Number | 0 |
| path | { d: string, viewBox: string or array, preserveAspectRatio: string } | Object | undefined |
| pathScale | set the scale | Number | 1 |
| pathRotation | set the rotation | Number | 0 |
| pathTranslation | { dx: number, dy:number , percentageValue: Bool }  | Object | undefined |
| shadowColor | set the sahdow color  | Color | 'black' |
| shadowOffset |{ x : number , y : number  } | Object | undefined |
| shadowOpacity | set the shadow opacity 0 to 1  | Number | 0 |
| shadowRadius | shadow radius | Number | 1 |
| strokeWidth | line width | Number | 0 |
| strokeColor | line color | Color | 'black' |
| fillColor | set the fill color  | Color | 'transparent' |
| backgroundColor | set the bg | Color | 'transparent' |

