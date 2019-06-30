
#import <React/RCTBridgeModule.h>
#import <UIKit/UIKit.h>

@interface RNInfoManifestBridge : NSObject <RCTBridgeModule>

@end

@implementation RNInfoManifestBridge

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup {
  return YES;
}

- (NSDictionary *)constantsToExport {
  NSBundle *mainBundle = [NSBundle mainBundle];
  NSString *displayName = [mainBundle objectForInfoDictionaryKey:@"CFBundleDisplayName"];
  if (displayName == nil) {
    displayName = @"";
  }

  NSString *iosVersion = [[UIDevice currentDevice] systemVersion];
  NSString *iosDeviceName = [[UIDevice currentDevice] name];
  NSString *version = [mainBundle objectForInfoDictionaryKey:@"CFBundleVersion"];
  NSString *shortVersion = [mainBundle objectForInfoDictionaryKey:@"CFBundleShortVersionString"];
  NSString *bundleIdentifier = [mainBundle objectForInfoDictionaryKey:@"CFBundleIdentifier"];
  NSString *bundleName = [mainBundle objectForInfoDictionaryKey:@"CFBundleName"];

  NSMutableDictionary *ret = [NSMutableDictionary new];
  [[mainBundle infoDictionary] enumerateKeysAndObjectsUsingBlock:^(id key, id value, BOOL* stop) {
    [ret setObject:value forKey:key];
  }];
  [ret setObject:version forKey:@"version"];
  [ret setObject:shortVersion forKey:@"shortVersion"];
  [ret setObject:bundleIdentifier forKey:@"bundleIdentifier"];
  [ret setObject:bundleName forKey:@"bundleName"];
  [ret setObject:displayName forKey:@"displayName"];
  [ret setObject:iosVersion forKey:@"iosVersion"];
  [ret setObject:iosDeviceName forKey:@"iosDeviceName"];

  return ret;
}

@end
