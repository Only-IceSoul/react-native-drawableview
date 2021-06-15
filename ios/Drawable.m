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
RCT_EXPORT_VIEW_PROPERTY(pathRotation, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(pathScale, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(pathTranslation, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(shadowColor, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(shadowOffset, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(shadowOpacity, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(shadowRadius, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(strokeWidth, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(strokeColor, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(strokeStart, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(strokeEnd, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(fillColor, CGFloat)
RCT_EXPORT_VIEW_PROPERTY(bgColor, CGFloat)
@end
