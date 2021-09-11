import React from 'react'

const clamp = (num) =>{
    return num < 0 ? 0 : (num > 1 ? 1 : num) 
}

const DrawableViewWeb = (props) => {
    const {
        path,
        pathScale,
        pathTranslation,
        pathRotation,
                
        shadow,
        shadowOffset,
        shadowOpacity,
        shadowRadius,
    
        strokeWidth,
        stroke,
        strokeStart,
        strokeEnd,
        dashArray,
        strokeCap,
        strokeJoin,
        strokeMiter,
    
         fill,
        ...rest 
    } = props


    const vb = path === undefined ? [0,0,0,0] : (path.viewBox === undefined ? [0,0,0,0] : path.viewBox) 

    const d = path === undefined ? "" : path.d
    const aspect = path === undefined ? "none" : (path.aspect === undefined ? 'none' : path.aspect)
    const align = path === undefined ? "none" : (path.align === undefined ? 'none' : path.align)

    const sc = stroke === undefined ? 'black' : stroke
    const fc = fill === undefined ? 'none' : fill
    const sw = strokeWidth === undefined ? 0 : strokeWidth
    
    const scaleX = pathScale === undefined ? 1 : pathScale.x
    const scaleY = pathScale === undefined ? 1 : pathScale.y
    const dx = pathTranslation === undefined ? '0px' : ( pathTranslation.percentageValue ? `${pathTranslation.dx * 100}%` : `${pathTranslation.dx}px` )
    const dy = pathTranslation === undefined ? '0px' : ( pathTranslation.percentageValue ? `${pathTranslation.dy * 100}%` : `${pathTranslation.dy}px` )
    const rot = pathRotation === undefined ? 0 : pathRotation
    const cap = strokeCap === undefined ? "butt" : strokeCap
    const join = strokeJoin === undefined ? "miter" : strokeJoin
    const miterLimit = strokeMiter === undefined ? 4 : strokeMiter
    const shc = shadow === undefined ? 'rgba(0,0,0,1)'.split(",") : shadow.split(",")
    const sho = shadowOpacity === undefined ? 0 : clamp(shadowOpacity)
    const sox = shadowOffset === undefined ? 0 : shadowOffset.x
    const soy = shadowOffset === undefined ? 0 : shadowOffset.y
    const shr = shadowRadius === undefined ? 1 : shadowRadius


    const end = strokeEnd === undefined ? 1 : clamp(strokeEnd)
    const start = strokeStart === undefined ? 0 : clamp(strokeStart)

    const dasharr = dashArray === undefined ? 0 : dashArray

    return (  
           <div {...rest}>
                <div style={{width:'100%',height:'100%'}}>
                    <div    style={{width:'100%',height:'100%', 
                            filter: sho > 0 ? `drop-shadow(${sox}px ${soy}px ${shr}px ${shc[0]},${shc[1]},${shc[2]},${sho * parseFloat(shc[3])}) )` : "",
                            transform:`translate(${dx},${dy}) scale(${scaleX},${scaleY}) rotate(${rot}deg)`}}
                    > 
                        <svg viewBox={`${vb[0]} ${vb[1]} ${vb[2]} ${vb[3]}`} 
                             preserveAspectRatio={`${align} ${aspect}`}>
                            <mask id="myClip" maskUnits="userSpaceOnUse" >
                            <path d={d} fill={'none'} 
                                    stroke={'white'} strokeWidth={`${sw/10}`}
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={`${dasharr}`} strokeDashoffset={`${(1 - end) * dasharr}`} />
                                    <path d={d} fill={'none'} 
                                    stroke={'black'} strokeWidth={`${sw/10}`}
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={`${dasharr}`} strokeDashoffset={`${(1 - start) * dasharr}`} />
                           
                          
                            </mask>
                            <path d={d} fill={fc} />
                            {start < end ? 
                                <path mask="url(#myClip)" d={d} fill={"none"} stroke={sc} strokeWidth={`${sw/10}`}
                                    strokeLinecap={cap} strokeLinejoin={join} strokeMiterlimit={miterLimit}
                                    strokeDasharray={`${dasharr}`} strokeDashoffset="0"
                                />
                               : null
                            }
                         </svg>
                    </div>
                   
               </div>
             
           </div>
        
    )
}

export default DrawableViewWeb