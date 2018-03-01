using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Info.Manifest.Bridge.RNInfoManifestBridge
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNInfoManifestBridgeModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNInfoManifestBridgeModule"/>.
        /// </summary>
        internal RNInfoManifestBridgeModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNInfoManifestBridge";
            }
        }
    }
}
