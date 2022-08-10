#import "InappReviewRating.h"
#import <StoreKit/StoreKit.h>


#ifdef RCT_NEW_ARCH_ENABLED
#import "RNInappReviewRatingSpec.h"
#endif

@implementation InappReviewRating
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(requestReviewFlow:(RCTPromiseResolveBlock)resolve
              getName_rejecter:(RCTPromiseRejectBlock)reject)
{
    resolve(@"Success");
}

RCT_EXPORT_METHOD(showInAppReviewFlow:(RCTPromiseResolveBlock)resolve
              getName_rejecter:(RCTPromiseRejectBlock)reject)
{
    if (@available(iOS 10.3, *)) {
      [SKStoreReviewController requestReview];
    }
    resolve(@"Success");
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeInappReviewRatingSpecJSI>(params);
}
#endif

@end
