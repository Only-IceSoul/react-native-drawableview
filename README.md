# DrawableView

Draw svg paths with shadows

android: api 21+   
ios : 10.0+   

<img src="./src/demo.jpg" width="300">


## Getting started

`$ npm install react-native-drawableview --save`  
`$ react-native link react-native-drawableview`  
  
or

`$ yarn add react-native-drawableview `
    
## Android

**Add Kotlin**

/app/build.gradle 

```gradle
apply plugin: 'kotlin-android' 

android {

   dependencies {
     // From node_modules
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
  
    }
}

```

/build.gradle

```gradle
buildscript {

        ext.kotlin_version = '1.5.10'  //last version
        dependencies {
            classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        }
    }
}

```

## IOS

**Add Swift**

open the xcode project.  
add a .swift file.  
Skip the bridge.  

# Usage
```javascript
import Drawableview from 'react-native-drawableview';

// TODO: What to do with the module?
   <Drawableview {...props} />

//animation 

const DrawableAnim = Animated.createAnimatedComponent(Drawableview)

```


## Props   

| Name | description | type | default |
| --- | --- | --- | --- |
| path | set the path | Object | undefined |
| pathScale | set the scale | Object | 1 1 |
| pathRotation | set the rotation | Number | 0 |
| pathTranslation | set the translation  | Object | 0 0 |
| pathInset | Inset the rectangle  | Object | 0 0 |
| shadowColor | set the sahdow color  | CSSColor | 'black' |
| shadowOffset | set the offset | Object | 0 0 |
| shadowOpacity | set the shadow opacity 0 to 1  | Number | 0 |
| shadowRadius | shadow radius | Number | 1 |
| strokeWidth | line width | Number | 0 |
| strokeColor | line color | CSSColor | 'black' |
| strokeStart | the start | Number | 0 |
| strokeEnd | the end | Number | 1 |
| strokeCap | line cap | string | 'butt' |
| strokeJoin | line join | string | 'miter' |
| strokeMiter | control the behavior of miter | Number | 4 |
| fillColor | set the fill color  | CSSColor | 'transparent' |
| backgroundColor | set the bg | CSSColor | 'transparent' |

