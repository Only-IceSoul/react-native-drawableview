import React, { useMemo } from 'react'
import { StyleSheet } from 'react-native'

const clamp = (num) =>{
    return num < 0 ? 0 : (num > 1 ? 1 : num) 
}

const DrawableViewWeb = (props) => {
    const {
        d,

        svgKey,

        viewBox,
        align,
        aspect,

        fill,
        fillRule,
        fillOpacity,

        stroke,
        strokeOpacity,
        strokeWidth,
        strokeStart,
        strokeEnd,
        dashArray,
        dashClipValue,
        strokeCap,
        strokeJoin,
        strokeMiter,
                
        shadow,
        shadowOpacity,
        shadowRadius,
        shadowOffset,
        shadowOffsetX,
        shadowOffsetY,
        shadowPercentageValue,
        shadowRect,

        mask,

        opacity,
        translateZ,

        transX,
        transY,
        transPercentageValue,

        rot,
        rotO,
        rotOx,
        rotOy,
        rotPercentageValue,

        sc,
        scX,
        scY,
        scO,
        scOx,
        scOy,
        scPercentageValue,
    
       style,
        ...rest 
    } = props


    const styleObject = useMemo(()=>{
        if (typeof style === 'number') return StyleSheet.flatten(style) 
        if(Array.isArray(style)){
           var styleJs = {}
           style.forEach((v)=>{
             if(typeof v === 'number'){
                let ss = StyleSheet.flatten(style) 
                Object.assign(styleJs,ss)
             }else{
               Object.assign(styleJs,v)
             }
           })
 
           return styleJs
        }
        return style
      },[style])

    const path = d === undefined ? "" : d
    const vb = viewBox === undefined ? undefined : `${viewBox[0]} ${viewBox[1]} ${viewBox[2]} ${viewBox[3]}`
    const asp = aspect === undefined ? "meet" : aspect
    const alg = align === undefined ? "xMidYMid" : align

  //MARK : Paintable
  const userKey = svgKey === undefined ? "" : svgKey

  const dashClip = dashClipValue === undefined ? 0 : dashClipValue
  const dasharr = dashArray === undefined ? 0 : dashArray

  const fc = fill === undefined ? '' : fill
  const fo = fillOpacity === undefined ? "" : `${fillOpacity}`
  const fr = fillRule === undefined ? "" : fillRule
  
  const cap = strokeCap === undefined ? "" : strokeCap

  const ss = strokeStart === undefined ? 0 : clamp(strokeStart)  
  const se = strokeEnd === undefined ? 1 :  clamp(strokeEnd)

  const join = strokeJoin === undefined ? "" : strokeJoin
  const miterLimit = strokeMiter === undefined ? "" : `${strokeMiter}`
  const stc = stroke === undefined ? '' : stroke
  const so = strokeOpacity === undefined ? "" : `${strokeOpacity}`
  const sw = strokeWidth === undefined ? 1 : strokeWidth
 

  const shc = shadow === undefined ? 'rgba(0,0,0,1)'.split(",") : shadow.split(",")
  const sho = shadowOpacity === undefined ? 0 : clamp(shadowOpacity)
  const shr = shadowRadius === undefined ? 2 : shadowRadius
  const shox = shadowOffset === undefined ? (shadowOffsetX === undefined ? 2 : shadowOffsetX ) : shadowOffset
  const shoy =  shadowOffset === undefined ? (shadowOffsetY === undefined ? 2 : shadowOffsetY) : shadowOffset
  const shRect = shadowRect === undefined ? {x:-2, y:-2 , w:5,h:5, units:'objectBoundingBox'} : shadowRect

  const op = opacity === undefined ? "" : `${opacity}`
  const zIndex = translateZ === undefined ? 0 : translateZ
 
  const dx = transX === undefined ? 0 : transX
  const dy = transY === undefined ? 0 : transY

  const scaleX = sc === undefined ? ( scX === undefined ? 1 : scX) : sc
  const scaleY = sc === undefined ?  (scY === undefined ? 1 : scY) : sc
  const scaleOX = scO === undefined ? ( scOx === undefined ? 0 : scOx) : scO
  const scaleOY = scO === undefined ?  (scOy === undefined ? 0 : scOy) : scO

  const rotation = rot === undefined ? 0 : rot
  const rotationOX = rotO === undefined ? ( rotOx === undefined ? 0 : rotOx) : rotO
  const rotationOY = rotO === undefined ?  (rotOy === undefined ? 0 : rotOy) : rotO


  const transform = `rotate(${rotation} ${rotationOX} ${rotationOY}) translate(${scaleOX} ${scaleOY}) scale(${scaleX} ${scaleY}) translate(${-scaleOX} ${-scaleOY}) translate(${dx} ${dy})`


  const keyFilter = `jjlfshadowfilter${userKey}`
  const keyMaskStroke = `jjlfMaskfilterNotButt${userKey}`
  const keyMaskStroke2 = `jjlfMaskfilterNotButt2${userKey}`
  const filterShadowProp = sho > 0 ? `url(#${keyFilter})` : ""
  
  const isFillTransparent = fc === `rgba(0, 0, 0, 0)` || fc === "transparent"

  const maskStroke = ss !== 0 || se !== 1
  const maskStroke2 = maskStroke && se < 1


    return (  
           <div {...rest} style={{...styleObject,zIndex:zIndex}}>

                <div style={{width:'100%',height:'100%',position:'absolute',left:0,top:0,opacity:op}}>

                
                    <svg style={{width:'100%',height:'100%',overflow:'visible'}} viewBox={vb} 
                            preserveAspectRatio={`${alg} ${asp}`}>

                    { sho > 0 &&
                        <defs>
                            <filter id={keyFilter}
                                filterUnits={`${shRect.units}`}
                            x={`${shRect.x}`} y={`${shRect.y}`} width={`${shRect.w}`} height={`${shRect.h}`}>
                                <feDropShadow dx={`${shox}`} dy={`${shoy}`} stdDeviation={`${shr}`} floodColor={`${shc[0]},${shc[1]},${shc[2]},${sho * parseFloat(shc[3])}`} />
                                </filter>

                        </defs>
                    }



                    { maskStroke &&  
                        <mask id={keyMaskStroke} maskUnits="userSpaceOnUse" transform={transform} >

                                <path d={path}
                                
                                    fill={'none'}  
                                stroke={'white'} strokeWidth={`${sw}`}
                                strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                strokeDasharray={`${dasharr}`} strokeDashoffset={`${( (ss) * (-dasharr) )}`} />

                        </mask>
                    }

                    { maskStroke2 && 
                        <mask id={keyMaskStroke2} maskUnits="userSpaceOnUse" transform={transform}  >



                            <path d={path}
                            
                            fill={'none'}  
                            stroke={'white'} strokeWidth={`${sw}`}
                            strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                            strokeDasharray={`${dasharr}`} strokeDashoffset={`${( (1 - se) * (dasharr) )}`} />



                            { ss > 0 && se < 1 && 
                                <>
                                    <path d={path}
                                        fill={'none'}  
                                    stroke={'black'} strokeWidth={`${sw}`}
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={`${dasharr}`} strokeDashoffset={`${( (  (1 - ss) + dashClip  ) * (dasharr) )}`} />

                                    <path d={path}
                                    fill={'none'}  
                                    stroke={'black'} strokeWidth={`${sw}`}
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={`${dasharr}`} strokeDashoffset={`${( (se + dashClip) * (-dasharr) )}`} />

                                </>
                            } 

                        </mask>
                    }


                    <g     transform={transform}  >
                        <path d={path}
                        
                        filter={!isFillTransparent  ? filterShadowProp : ""} fill={fc} fillRule={fr} fillOpacity={fo}  
                        stroke={"none"} />
                        {ss < se ? 
                            <g   filter={isFillTransparent   ? filterShadowProp : ""}   >
                            <g      
                            mask={ maskStroke2 ? `url(#${keyMaskStroke2})` :  "" }
                            >
                                     <path d={path}
                                    
                                    mask={ maskStroke ? `url(#${keyMaskStroke})` : ""}
                                    fill={"none"}
                                    stroke={stc} strokeOpacity={so}
                                    strokeWidth={`${sw}`} 
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={``} strokeDashoffset={`0`}
                                />
                            </g>
                            </g>
                        : null
                        }

                        </g>

                    </svg>
                      
            
                   
               </div>
             
           </div>
        
    )
}

export default DrawableViewWeb