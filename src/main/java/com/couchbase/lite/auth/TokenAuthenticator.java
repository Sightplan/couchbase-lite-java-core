/**
 * Copyright (c) 2016 Couchbase, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.couchbase.lite.auth;

import java.net.URL;
import java.util.Map;

/**
 * Authenticator impl that knows how to do token based auth
 *
 * @exclude
 */
public class TokenAuthenticator extends AuthenticatorImpl {
    private String loginPath;
    private Map<String, String>loginParams;

    public TokenAuthenticator(String loginPath, Map<String, String> loginParams) {
        this.loginPath = loginPath;
        this.loginParams = loginParams;
    }

    @Override
    public boolean usesCookieBasedLogin() {
        return true;
    }

    @Override
    public Map<String, String> loginParametersForSite(URL site) {
        return loginParams;
    }

    @Override
    public String loginPathForSite(URL site) {
        String path = loginPath;
        if (path != null && !path.startsWith("/")) {
            path = '/' + path;
        }
        return path;
    }
}
