package wiki.laona.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import wiki.laona.es.constant.Constants;

import java.io.IOException;

/**
 * @author laona
 * @description elasticsearch 客户端访问服务器测试
 * @date 2022-02-22 19:41
 **/
public class ESTest_Client {

    public static void main(String[] args) throws IOException {
        // 创建 ES 客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(Constants.HOST, Constants.PORT, Constants.HTTP))
        );
        // 关闭客户端
        client.close();
    }
}
