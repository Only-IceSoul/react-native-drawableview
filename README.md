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
        repositories {
            ...
            mavenCentral()
            jcenter()
        }
        ext.kotlin_version = '1.5.21'  //last version
        dependencies {
            classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        }
    }
}

```

RN 0.64:

if you need it, add it

/nodemodules/react-native-drawableview/android/../DrawableViewManager.kt

```
  fun setShadowColor
  
  to

  override fun setShadowColor
```


## IOS

**Add Swift**

(If you are using expo sdk >=42 you don't need to do this)

/ios/name_project

add a .swift file


# Usage
```javascript
import Drawableview from 'react-native-drawableview';

// TODO: What to do with the module?
   <Drawableview {...props} />

```


## Props   

| Name | description | type | default |
| --- | --- | --- | --- |
| path | set the path | Object | undefined |
| pathScale | set the scale | Object | 1 1 |
| pathRotation | set the rotation | Number | 0 |
| pathTranslation | set the translation  | Object | 0 0 |
| shadowColor | set the sahdow color  | Color | 'black' |
| shadowOffset | set the offset | Object | 0 0 |
| shadowOpacity | set the shadow opacity 0 to 1  | Number | 0 |
| shadowRadius | shadow radius | Number | 1 |
| strokeWidth | line width | Number | 0 |
| strokeColor | line color | Color | 'black' |
| strokeStart | the start | Number | 0 |
| strokeEnd | the end | Number | 1 |
| dashArray | required on web for strokeStart and strokeEnd | Number | 0 |
| strokeCap | line cap | string | 'butt' |
| strokeJoin | line join | string | 'miter' |
| strokeMiter | control the behavior of miter | Number | 4 |
| fillColor | set the fill color  | Color | 'transparent' |
| backgroundColor | set the bg | Color | 'transparent' |

