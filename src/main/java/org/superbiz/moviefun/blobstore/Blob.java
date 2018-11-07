package org.superbiz.moviefun.blobstore;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

public class Blob {
    public final String name;
    public final InputStream inputStream;
    public final String contentType;

    public Blob(String name, InputStream inputStream, String contentType) {
        this.name = name;
        this.inputStream = inputStream;
        this.contentType = contentType;
    }

}