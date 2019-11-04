
Pod::Spec.new do |s|
  s.name         = "RNInfoManifestBridge"
  s.version      = "1.0.8"
  s.summary      = "RNInfoManifestBridge"
  s.description  = "React Native bridge for info.plist and Android manifest values"
  s.homepage     = "https://github.com/jim-lake/react-native-info-manfiest-bridge"
  s.license      = "MIT"
  s.author       = { "author" => "jim@blueskylabs.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/jim-lake/react-native-info-manfiest-bridge.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React"

end
