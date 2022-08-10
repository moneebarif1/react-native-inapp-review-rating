import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-inapp-review-rating' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const InappReviewRating = NativeModules.InappReviewRating  ? NativeModules.InappReviewRating  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function inAppReviewFlowRequest(): Promise<boolean> {
   return InappReviewRating.requestReviewFlow();
}

export function inAppReviewShow(): Promise<boolean> {
   return InappReviewRating.showInAppReviewFlow();
}
