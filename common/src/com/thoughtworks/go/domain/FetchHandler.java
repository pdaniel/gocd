/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.go.domain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import com.thoughtworks.go.work.DefaultGoPublisher;

public interface FetchHandler extends Serializable {
    String url(String remoteHost, String workingUrl) throws IOException;

    void handle(InputStream stream) throws IOException;

    boolean handleResult(int returncode, DefaultGoPublisher goPublisher);

    void useArtifactMd5Checksums(ArtifactMd5Checksums artifactMd5Checksums);

    public File getArtifact() ;

    public void setArtifact(File artifact) ;

    public String getSrcFile();

    public void setSrcFile(String srcFile) ;
}
