package controllers;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import models.Catalog;
import static play.libs.Json.toJson;
import play.libs.Json;
import play.mvc.*;

import java.util.List;

public class CatalogsRestController extends Controller {

    //商品登録
    @BodyParser.Of(BodyParser.Json.class)
    public Result addCatalog(){
        JsonNode json = request().body().asJson();

        if(json.toString().equals("{}")){
            return badRequest("商品データがありません");
        }

         Catalog catalog = Json.fromJson(json, Catalog.class);

         if(catalog.name == null){
             return badRequest("商品名のデータがありません");
         }
         if(catalog.intro == null){
             return badRequest("説明文のデータがありません");
         }
         if(catalog.imgUrl == null){
             return badRequest("画像URLのデータがありません");
         }
        if(catalog.value == 0){
             return badRequest("値段のデータがありません");
         }

         catalog.save();
         return created();
    }

    //商品全件取得
    public Result getCatalog(){

        List<Catalog> catalogs = new Model.Finder(String.class,Catalog.class).all();
        if(catalogs.isEmpty()){
            return notFound("商品データが見つかりません");
        }
        return ok(toJson(catalogs));
    }

    //商品1件取得
    public Result getCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("商品データが見つかりません");
        }

        return ok(toJson(catalog));
    }

    //商品1件更新
    public Result putCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("商品データが見つかりません");
        }

        JsonNode json = request().body().asJson();
        Catalog catalogToBe = Json.fromJson(json, Catalog.class);
        catalog = catalogToBe;
        catalog.update();

        return noContent();
    }

    //商品1件削除
    public Result deleteCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("商品データが見つかりません");
        }

        catalog.delete();
        return noContent();

    }

}
