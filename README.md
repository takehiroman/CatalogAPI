# 商品情報のAPI作成

* 提出課題用のリポジトリです。

### 使用した技術要素

* Java 1.8.0
* PlayFramework 2.5.10
* MySQL 5.1.20

### API一覧

|api名|HTTPメソッド|リソースパス|
|---|---|---|
|商品一件作成|POST|/catalog|
|商品一件取得|GET|/catalog/{id}|
|商品一件更新|PUT|/catalog/{id}|
|商品一件削除|DELETE|/catalog/{id}|
|商品全件取得|GET|/catalog/|

### 開発環境のセットアップ

1. このプロジェクトを`git clone`する
2. プロジェクト内に移動し，`brew install sbt`でsbtをインストールする
3. `brew install mysql`でMySQLをインストールし，`mysql.server start`で起動する
4. インストールが完了したら，`sbt run`でアプリケーションを起動する
5. 起動後に，localhost:9000で各APIを利用することができる。