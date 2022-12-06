import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

  public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

  public static void main(String[] args) throws IOException {

    CloseableHttpClient httpClient = HttpClients.custom()
        .setDefaultRequestConfig(RequestConfig.custom()
            .setConnectTimeout(5000)
            .setSocketTimeout(30000)
            .setRedirectsEnabled(false)
            .build())
        .build();

    HttpGet request = new HttpGet(URL);

    CloseableHttpResponse response = httpClient.execute(request);

    String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

    httpClient.close();

    readAnswer(body);
  }

  static void readAnswer(String body) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    List<Cat> allCats = mapper.readValue(body, new TypeReference<List<Cat>>() {
    });

    List<Cat> catsPrint = allCats.stream().filter(cat -> cat.getVoice() != 0).toList();
    System.out.println(catsPrint);
  }
}
