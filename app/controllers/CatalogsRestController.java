package controllers;


import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import models.Catalog;
import play.Application;
import static play.libs.Json.toJson;
import play.libs.Json;
import play.mvc.*;
import play.db.*;

import javax.inject.Inject;
import java.sql.*;
import java.util.List;

public class CatalogsRestController extends Controller {
    //Post
    @BodyParser.Of(BodyParser.Json.class)
    public Result addCatalog(){
        JsonNode json = request().body().asJson();

         Catalog catalog = Json.fromJson(json, Catalog.class);

         if(catalog.toString().equals("")){
             return badRequest("Miss");
         }

         catalog.save();
         return ok();
    }
    //Get
    public Result getCatalog(){

        List<Catalog> catalogs = new Model.Finder(String.class,Catalog.class).all();

        return ok(toJson(catalogs));
    }
    //Get(id)
    public Result getCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);

        if(catalog == null){
            return notFound("catalog not found");
        }

        return ok(toJson(catalog));
    }
    //Put
    @BodyParser.Of(BodyParser.Json.class)
    public Result putCatalogItem(Long id){
        Catalog catalog = Catalog.find.byId(id);
        if(catalog == null){
            return notFound("catalog not found");
        }

        JsonNode json = request().body().asJson();
        Catalog catalogToBe = Json.fromJson(json, Catalog.class);
        catalog = catalogToBe;
        catalog.update();

        return ok();
    }

    //Delete
    public Result deleteCatalog(Long id){
        Catalog catalog = Catalog.find.byId(id);
        if(catalog == null){
            return notFound("catalog not found");
        }

        catalog.delete();
        return ok();

    }

    //Search
    public Result searchCatalog(String name){
        List<Catalog> catalog = Catalog.find.where().like("name", "%"+name+"%").findList();
        if(catalog == null){
            return notFound("catalog not found");
        }

        return ok(toJson(catalog));
    }



}
