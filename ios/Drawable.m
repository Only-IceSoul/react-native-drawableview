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
RCT_EXTERN_MODULE(Drawable,RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(path, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(pathRotation, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(pathScale, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(pathTranslation, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(pathInset, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(shadowColor, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowOffset, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(shadowOpacity, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(shadowRadius, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeWidth, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeColor, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeStart, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeEnd, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(strokeCap, NSString)
RCT_EXPORT_VIEW_PROPERTY(strokeJoin, NSString)
RCT_EXPORT_VIEW_PROPERTY(strokeMiter, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(fillColor, NSNumber)
RCT_EXPORT_VIEW_PROPERTY(bgColor, NSNumber)
@end
