package wiki.laona.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import wiki.laona.es.constant.Constants;

import java.io.IOException;

/**
 * @author laona
 * @description 索引创建
 * @date 2022-02-22 20:24
 **/
public class ESTest_Index_Create {
    
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(Constants.HOST, Constants.PORT, Constants.HTTP))
        );
        // 创建索引
        CreateIndexRequest request = new CreateIndexRequest(Constants.INDEX_USER);
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("acknowledged = " + acknowledged);
        client.close();
    }
}
