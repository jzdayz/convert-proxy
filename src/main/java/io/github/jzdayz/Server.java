package io.github.jzdayz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.jzdayz.model.Proxy;
import io.github.jzdayz.model.ProxyGroup;
import io.github.jzdayz.model.YamlData;
import io.undertow.Undertow;
import io.undertow.util.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class Server {

    private static OkHttpClient client = new OkHttpClient();

    private static ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    private static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(Integer.parseInt(args[0]), args[1])
                .setHandler(exchange -> {
                    if (exchange.getRequestURI().equals("/favicon.ico")){
                        return;
                    }
                    String url = exchange.getQueryString().substring(4);
                    String yamlStr = get(url);
                    YamlData yamlData = mapper.readValue(yamlStr, YamlData.class);
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain;charset=utf-8");
                    convert(yamlData);
                    String data = mapper.writeValueAsString(yamlData);
                    exchange.getResponseSender().send(data);
                }).build();
        server.start();
    }

    private static void convert(YamlData yamlData){
        Proxy proxy = new Proxy();
        proxy.setName("😪 Trojan");
        proxy.setType("trojan");
        proxy.setServer("jzdayz.club");
        proxy.setPort(443);
        proxy.setPassword("1008611");
        yamlData.getProxy().add(0, proxy);

        for (ProxyGroup proxyGroup : yamlData.getProxyGroup()) {
            if (proxyGroup.getName().endsWith("节点选择")){
                proxyGroup.getProxies().add(2,"😪 Trojan");
                continue;
            }
            if (proxyGroup.getName().endsWith("全球拦截")){
                proxyGroup.getProxies().add(0,"\uD83D\uDD30 节点选择");
            }
        }

        Iterator<String> iterator = yamlData.getRule().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.contains("apache.org")){
                System.out.println("remove "+next);
                iterator.remove();
            }
        }
    }
}
