/*
 * Copyright (c) 2023-2024  XianZhi Group All Rights
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xianzhi.cms.utils;

import io.xianzhi.business.utils.WebUtil;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import org.springframework.util.StringUtils;

/**
 * 站点工具类<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public class SiteUtils {
    /**
     * 站点ID 请求头
     */
    private static final String X_SITE_ID = "X-SITE-ID";

    /**
     * 获取当前站点ID
     *
     * @return 站点ID
     */
    public static String getCurrentSiteId() {
        String siteId = WebUtil.getRequest().getHeader(X_SITE_ID);
        if (!StringUtils.hasText(siteId)) {
            throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
        }
        return siteId;
    }
}
