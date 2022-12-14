//
// Disclaimer
// © 2019, Cyxtera Cybersecurity, Inc. d/b/a AppGate.  All rights reserved.  

// Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: 
// (a) redistributions of source code must retain the above copyright notice, this list of conditions and the disclaimer below, and (b) 
// redistributions in binary form must reproduce the above copyright notice, this list of conditions and the disclaimer below in the documentation
// and/or other materials provided with the distribution. 

// THE CODE AND SCRIPTS POSTED ON THIS WEBSITE ARE PROVIDED ON AN “AS IS” BASIS AND YOUR USE OF SUCH CODE AND/OR SCRIPTS IS AT YOUR OWN RISK.  
// APPGATE DISCLAIMS ALL EXPRESS AND IMPLIED WARRANTIES, EITHER IN FACT OR BY OPERATION OF LAW, STATUTORY OR OTHERWISE, INCLUDING, BUT NOT LIMITED TO, 
// ALL WARRANTIES OF MERCHANTABILITY, TITLE, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT, ACCURACY, COMPLETENESS, COMPATABILITY OF SOFTWARE OR 
// EQUIPMENT OR ANY RESULTS TO BE ACHIEVED THEREFROM.  APPGATE DOES NOT WARRANT THAT SUCH CODE AND/OR SCRIPTS ARE OR WILL BE ERROR-FREE.  
// IN NO EVENT SHALL APPGATE BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, RELIANCE, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES, OR ANY LOSS 
// OF GOODWILL, LOSS OF ANTICIPATED SAVINGS, COST OF PURCHASING REPLACEMENT SERVICES, LOSS OF PROFITS, REVENUE, DATA OR DATA USE, ARISING IN ANY WAY OUT 
// OF THE USE AND/OR REDISTRIBUTION OF SUCH CODE AND/OR SCRIPTS, REGARDLESS OF THE LEGAL THEORY UNDER WHICH SUCH LIABILITY IS ASSERTED AND REGARDLESS 
// OF WHETHER APPGATE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH LIABILITY.
//

package com.appgate.did.DetectIDCordovaPlugin;

import java.util.regex.Pattern;

/**
 * Created by John Garcia on 28/05/2018.
 */

public class DIDServerURL {

    private final String serverURL;
    private static final String regexUrlServer = "^(http:\\/\\/|https:\\/\\/)((([0-9]{1,3}).){3}(([0-9]{1,3}))|(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?)(:[0-9]{2,4})?(\\/detect\\/public\\/registration\\/mobileServices.htm\\?code=)([0-9]{0,6})?";
    private static final Pattern patternServerUrl = Pattern.compile(regexUrlServer);

    /**
     * Private constructor
     *
     * @param serverURL serverUrl
     */
    private DIDServerURL(String serverURL) {
        this.serverURL = serverURL;
    }

    /**
     * Method to get instance of DIDServerURL
     *
     * @param serverURL serverUrl client
     * @return DIDServerUrl
     */
    public static DIDServerURL getInstance(String serverURL) {
        validateServerURL(serverURL);
        return new DIDServerURL(serverURL);
    }

    /**
     * Public method to get server Url
     *
     * @return serverUrl
     */
    public String getServerURL() {
        return serverURL;
    }

    /**
     * Method to validate server url
     *
     * @param url client url
     */
    private static void validateServerURL(String url) {
        if (!patternServerUrl.matcher(url).matches()) {
            throw new IllegalArgumentException("Invalid Server Url");
        }
    }

}
