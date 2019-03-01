package com.rotterdam.groep1.Urenregistratie.fileUpload.model.files;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;

//import org.apache.commons.io.FilenameUtils;

public class HttpFile {

    private final String submittedFileName;
    private final long size;
    private final Map<String, String> parameters;
    private final InputStream stream;
    private Path filePath;

    public Path getFilePath() {
		return filePath;
	}


	public void setFilePath(Path path) {
		this.filePath = path;
	}


	public HttpFile( String submittedFileName, long size, Map<String, String> parameters, InputStream stream) {
        this.submittedFileName = submittedFileName;
        this.size = size;
        this.parameters = parameters;
        this.stream = stream;
    }

    
   /* public String getExtension() {
    	return FilenameUtils.getExtension(submittedFileName);
    }*/

    public String getSubmittedFileName() {
        return submittedFileName;
    }

    public long getSize() {
        return size;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public InputStream getStream() {
        return stream;
    }
}