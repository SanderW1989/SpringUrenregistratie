package com.rotterdam.groep1.Urenregistratie.fileUpload.handler;

import com.rotterdam.groep1.Urenregistratie.fileUpload.model.request.FileUploadRequest;
import com.rotterdam.groep1.Urenregistratie.fileUpload.model.response.FileUploadResponse;

public interface IFileUploadHandler {

    FileUploadResponse handle(FileUploadRequest request);

}