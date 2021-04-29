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

RCT_EXPORT_VIEW_PROPERTY(nativeProps, NSDictionary)

@end
