curlまとめ

商品登録

商品全件表示
curl -X GET -H "Cache-Control: no-cache" 'http://localhost:9000/catalog'
商品１件表示
curl -X GET -H "Cache-Control: no-cache" 'http://localhost:9000/catalog/1'
商品更新

商品削除
curl -X DELETE "http://localhost:9000/catalog/id"


## API一覧
|api名|HTTPメソッド|リソースパス|
|---|---|---|
|商品一件作成|POST|/catalog|
|商品一件取得|GET|/catalog/{id}|
|商品一件更新|PUT|/catalog/{id}|
|商品一件削除|DELETE|/catalog/{id}|
|商品全件取得|GET|/catalog/|

{id}の中身はInteger型のみを受け付ける

## APIの詳細



## 商品一件作成

## 商品一件取得

## 商品一件更新

## 商品一件削除

## 商品全件取得


## 商品情報を登録する時
* 商品のデータが未入力の時 errormessage
* 商品の名前が100文字超えた時 errornessage
* 商品の紹介が500文字超えてた時 errormessage

## 商品を取得する時
* 商品が存在しない時 errormessage

## 商品を更新する時
* 更新する商品が存在しない時 errormessage
* データが間違っている時 errormessage

## 商品を削除する時
* 商品が存在しない時 errormessage

