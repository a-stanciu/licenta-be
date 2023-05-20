package alin.licenta.be.util;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ImageHostingUtil {
    private final String uri;

    @Autowired
    public ImageHostingUtil(MessageSource messageSource) {
        uri = "https://api.imgbb.com/1/upload?key=" + messageSource.getMessage("secret.imgbb.api.key", null, Locale.ENGLISH);
    }

    public String hostImage(String base64image) throws IOException, ParseException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody("image", base64image);

        HttpEntity multipart = builder.build();
        httpPost.setEntity(multipart);

        CloseableHttpResponse response = client.execute(httpPost);
        client.close();
        String requestBody = EntityUtils.toString(response.getEntity(), "UTF-8");

        Pattern pattern = Pattern.compile("\"display_url\":\"[^\"]*");
        Matcher matcher = pattern.matcher(requestBody);

        String displayUrl = "";

        if (matcher.find()) {
            displayUrl = matcher.group();
            displayUrl = displayUrl.substring(15);
        }

        return displayUrl;
    }
}
