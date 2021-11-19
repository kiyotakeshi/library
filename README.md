# library

TODO: 起動方法、動作確認方法など書く

## API 仕様書(OAS)の確認

- 仕様の最新化

```shell
# 仕様書の作成
./gradlew test --tests GenerateOasFile

# テスト実行日時のタイムスタンプに更新されていることを確認
$ \ls -l openapi/openapi.json
-rw-r--r--  1 kiyotakeshi  staff  10520 Nov 20 01:57 openapi/openapi.json
```

- nginx の起動([Redoc](https://github.com/Redocly/redoc) の CDN を読み込んで OpenAPI を描画する)

```shell
docker compose -f openapi/docker-compose.yaml up -d 

$ docker compose -f openapi/docker-compose.yaml ps   
NAME                COMMAND                  SERVICE             STATUS              PORTS
library-oas-nginx   "/docker-entrypoint.…"   nginx               running             0.0.0.0:9000->80/tcp
```

- [http://localhost:9000/](http://localhost:9000/) にアクセスし仕様を確認

- 終了時

```shell
docker compose -f openapi/docker-compose.yaml down
```