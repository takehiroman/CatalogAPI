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

         Catalog catalog = Json.fromJson(json, Catalog.class);

         if(catalog.toString().equals("")){
             return badRequest("登録データが空文字です");
         }

         catalog.save();
         return ok();
    }

    //商品全件取得
    public Result getCatalog(){

        List<Catalog> catalogs = new Model.Finder(String.class,Catalog.class).all();

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
    @BodyParser.Of(BodyParser.Json.class)
    public Result putCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("商品データが見つかりません");
        }

        JsonNode json = request().body().asJson();
        Catalog catalogToBe = Json.fromJson(json, Catalog.class);
        catalog = catalogToBe;
        catalog.update();

        return ok();
    }

    //商品1件削除
    public Result deleteCatalog(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("商品データが見つかりません");
        }

        catalog.delete();
        return ok();

    }

}
