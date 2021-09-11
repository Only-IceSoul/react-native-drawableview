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
    
## Android

RN 0.64:

if you need it, add it

/nodemodules/react-native-drawableview/android/../DrawableViewManager.java

```
  void setShadowColor
  
  to
    
  @override
   void setShadowColor
```


## IOS

**Add Swift**

(If you are using expo sdk >=42 you don't need to do this)

/ios/name_project

add a .swift file


# Usage
```javascript
import {Drawableview , Color} from 'react-native-drawableview';

// TODO: What to do with the module?

   var colorRed = Color('red') //Color('rgba(255,0,0,1)'), #FF0000 .....

   <Drawableview {...props} shadowColor={colorRed} />

```


## Props   

| Name | description | type | default |
| --- | --- | --- | --- |
| path | set the path | Object | undefined |
| pathScale | set the scale | Object | 1 1 |
| pathRotation | set the rotation | Number | 0 |
| pathTranslation | set the translation  | Object | 0 0 |
| shadow | set the sahdow color  | Color | 'black' |
| shadowOffset | set the offset | Object | 0 0 |
| shadowOpacity | set the shadow opacity 0 to 1  | Number | 0 |
| shadowRadius | shadow radius | Number | 1 |
| strokeWidth | line width | Number | 0 |
| stroke | line color | Color | 'black' |
| strokeStart | the start | Number | 0 |
| strokeEnd | the end | Number | 1 |
| dashArray | required on web for strokeStart and strokeEnd | Number | 0 |
| strokeCap | line cap | string | 'butt' |
| strokeJoin | line join | string | 'miter' |
| strokeMiter | control the behavior of miter | Number | 4 |
| fill | set the fill color  | Color | 'transparent' |
| bgColor | set the bg | Color | 'transparent' |

