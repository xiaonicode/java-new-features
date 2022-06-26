package com.xiaonicode.java11;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * HttpClient 的测试类
 * <p>
 * {@link HttpClient} 替换原有的 {@link java.net.HttpURLConnection}, 它最先出现于 Java 9 中, 后续正式发布于 Java 11
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/110">JEP 110: HTTP/2 Client (Incubator)</a>
 * @see <a href="http://openjdk.java.net/jeps/321">JEP 321: HTTP Client (Standard)</a>
 * @since 2022-06-25
 */
public class HttpClientTest {

    @Test
    public void test1() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).GET().build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, responseBodyHandler);
        String body = response.body();
        System.out.println(body);
    }

}
