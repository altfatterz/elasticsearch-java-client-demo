Install Elasticsearch

```bash
brew install elasticsearch
``` 

Install X-Pack on your elastic installation following the:

https://www.elastic.co/guide/en/elasticsearch/reference/5.6/installing-xpack-es.html

Before starting elasticsearch, make sure you add the following into your `/usr/local/etc/elasticsearch/elasticsearch.yml`

```bash
xpack.security.enabled: true
xpack.monitoring.enabled: false
xpack.watcher.enabled: false
xpack.ml.enabled: false
xpack.graph.enabled: false
```

This will make sure we are using only the `security` part of the X-Pack and avoids creating indexes for the other modules.

After starting elasticsearch verify:

```bash
http :9200

HTTP/1.1 401 Unauthorized
```

Default X-Pack user:
```bash
http -a elastic:changeme :9200

HTTP/1.1 200 OK
```

Run the simple client `ElasticsearchJavaClientDemoApplication`


