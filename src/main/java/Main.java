import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

import io.resurface.*;

public class Main {

    public static void main(String[] args) {

        port(8080);
        staticFileLocation("/public");

        HttpRules.setDefaultRules("include debug");
        HttpLogger logger = new HttpLogger();
        after((request, response) -> {
            if (response.body() != null) HttpMessage.send(logger, request.raw(), response.raw(), response.body(), request.body());
        });

        get("/hello", (req, res) -> "Hello World");

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        post("/", (req, res) -> "Received POST message: " + req.body());

    }

}
