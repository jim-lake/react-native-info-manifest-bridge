
# react-native-info-manifest-bridge

## Getting started

`$ npm install react-native-info-manifest-bridge --save`

### Mostly automatic installation

`$ react-native link react-native-info-manifest-bridge`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-info-manifest-bridge` and add `RNInfoManifestBridge.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNInfoManifestBridge.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.jimlake.RNInfoManifestBridgePackage;` to the imports at the top of the file
  - Add `new RNInfoManifestBridgePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-info-manifest-bridge'
  	project(':react-native-info-manifest-bridge').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-info-manifest-bridge/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-info-manifest-bridge')
  	```


## Usage
```javascript
import RNInfoManifestBridge from 'react-native-info-manifest-bridge';

// TODO: What to do with the module?
RNInfoManifestBridge;
```
