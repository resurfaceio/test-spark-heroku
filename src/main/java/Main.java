import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

import io.resurface.HttpLogger;

public class Main {

    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        HttpLogger logger = new HttpLogger("$LOGGER_URL");
        after((request, response) -> {
            if (response.body() != null) logger.log(request.raw(), request.body(), response.raw(), response.body());
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
