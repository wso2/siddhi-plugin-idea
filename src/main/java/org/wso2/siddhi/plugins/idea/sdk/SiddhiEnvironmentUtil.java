/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.siddhi.plugins.idea.sdk;

import com.intellij.openapi.application.PathMacros;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.util.EnvironmentUtil;
import com.intellij.util.PathUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wso2.siddhi.plugins.idea.SiddhiConstants;

/**
 * Defines utility methods related to siddhi environment.
 */
public class SiddhiEnvironmentUtil {

    private SiddhiEnvironmentUtil() {
    }

    @NotNull
    public static String getBinaryFileNameForPath(@NotNull String path) {
        String resultBinaryName = FileUtil.getNameWithoutExtension(PathUtil.getFileName(path));
        return SystemInfo.isWindows ? resultBinaryName + ".bat" : resultBinaryName;
    }

    @Nullable
    public static String retrieveRepositoryPathFromEnvironment() {
        String path = EnvironmentUtil.getValue(SiddhiConstants.SIDDHI_REPOSITORY);
        return path != null ? path : PathMacros.getInstance().getValue(SiddhiConstants.SIDDHI_REPOSITORY);
    }

}
