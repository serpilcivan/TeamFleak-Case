package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class PetApiHelper {
    public static Response addNewPet(int petId, String name, String status) {
        JSONObject pet = new JSONObject();
        pet.put("id", petId);
        pet.put("name", name);
        pet.put("status", status);

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet.toString())
                .when()
                .post("/pet");
    }

    public static Response getPetById(int petId) {
        return RestAssured.given()
                .when()
                .get("/pet/" + petId);
    }

    public static Response findPetByStatus(String status) {
        return RestAssured.given()
                .queryParam("status", status)
                .when()
                .get("/pet/findByStatus");
    }

    public static Response updatePet(int petId, String newName, String status) {
        JSONObject pet = new JSONObject();
        pet.put("id", petId);
        pet.put("name", newName);
        pet.put("status", status);

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet.toString())
                .when()
                .put("/pet");
    }

    public static Response deletePet(int petId) {
        return RestAssured.given()
                .when()
                .delete("/pet/" + petId);
    }
}
