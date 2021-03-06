//
//  DrawableView.m
//  Drawableview
//
//  Created by Juan J LF on 4/26/21.
//  Copyright © 2021 Facebook. All rights reserved.
//


#import <Foundation/Foundation.h>
#import "React/RCTViewManager.h"
#import <React/RCTBridgeModule.h>
#import <UIKit/UIKit.h>


@interface
RCT_EXTERN_MODULE(JJSDrawable,RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(d, NSString)
RCT_EXPORT_VIEW_PROPERTY(viewBox, NSArray)
RCT_EXPORT_VIEW_PROPERTY(aspect, NSString)
RCT_EXPORT_VIEW_PROPERTY(align, NSString)

RCT_EXPORT_VIEW_PROPERTY(translateZ, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(opacity, NSNumber)

RCT_EXPORT_VIEW_PROPERTY(fill, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(fillRule, NSString)
RCT_EXPORT_VIEW_PROPERTY(fillOpacity, NSNumber)

RCT_EXPORT_VIEW_PROPERTY(stroke, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeOpacity, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeWidth, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeStart, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeEnd, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeCap, NSString)
RCT_EXPORT_VIEW_PROPERTY(strokeJoin, NSString)
RCT_EXPORT_VIEW_PROPERTY(strokeMiter, NSNumber)

RCT_EXPORT_VIEW_PROPERTY(shadow, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowOpacity, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowRadius, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowOffset, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowOffsetX, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowOffsetY, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowPercentageValue, NSNumber)


RCT_EXPORT_VIEW_PROPERTY(transX, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(transY, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(transPercentageValue, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(rot, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(rotO, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(rotOx, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(rotOy, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(rotPercentageValue, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(sc, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scX, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scY, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scO, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scOx, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scOy, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(scPercentageValue, NSNumber)


@end
