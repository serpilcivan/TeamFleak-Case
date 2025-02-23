package tests;

import utils.BaseTest;
import utils.PetApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetTests extends BaseTest {
    int petId = 1002;
    String initialName = "Buddy";
    String updatedName = "Max";
    String status = "available";

    @Test(priority = 1)
    public void testAddNewPet() {
        Response response = PetApiHelper.addNewPet(petId, initialName, status);
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to add pet");
    }

    @Test(priority = 2)
    public void testGetPetById() {
        Response response = PetApiHelper.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 200, "Pet not found");
        Assert.assertEquals(response.jsonPath().getString("name"), initialName);
    }

    @Test(priority = 3)
    public void testFindPetByStatus() {
        Response response = PetApiHelper.findPetByStatus(status);
        Assert.assertEquals(response.getStatusCode(), 200, "No pets found");

        boolean petExists = response.jsonPath().getList("id").contains(petId);
        Assert.assertTrue(petExists, "Created pet not in available pets");
    }

    @Test(priority = 4)
    public void testUpdatePetName() {
        Response response = PetApiHelper.updatePet(petId, updatedName, status);
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to update pet");
    }

    @Test(priority = 5)
    public void testVerifyUpdatedPetName() {
        Response response = PetApiHelper.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 200, "Pet not found");
        Assert.assertEquals(response.jsonPath().getString("name"), updatedName, "Pet name did not update");
    }

    @Test(priority = 6)
    public void testDeletePet() {
        Response response = PetApiHelper.deletePet(petId);
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to delete pet");
    }

    @Test(priority = 7)
    public void testGetDeletedPet() {
        Response response = PetApiHelper.getPetById(petId);
        Assert.assertEquals(response.getStatusCode(), 404, "Deleted pet still found");
    }
    @Test
    public void testGetNonExistentPet() {
        int invalidPetId = 99999;
        Response response = PetApiHelper.getPetById(invalidPetId);
        Assert.assertEquals(response.getStatusCode(), 404, "Non-existent pet should return 404");
    }
    @Test
    public void testDeleteNonExistentPet() {
        int invalidPetId = 99999;
        Response response = PetApiHelper.deletePet(invalidPetId);
        Assert.assertEquals(response.getStatusCode(), 404, "Deleting non-existent pet should return 404");
    }


}
