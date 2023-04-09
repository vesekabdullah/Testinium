package testiniumAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class TestiniumAPI {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.trello.com";

        //CREATE BOARD
        String createBoardJsonBody = "{\n" +
                "\"name\": \"My New Board\",\n" +
                "\"defaultLabels\": true,\n" +
                "\"defaultLists\": true,\n" +
                "\"desc\": \"This is my new board description\",\n" +
                "\"idOrganization\": \"123456789012345678901234\",\n" +
                "\"idBoardSource\": \"987654321098765432109876\",\n" +
                "\"keepFromSource\": \"cards\",\n" +
                "\"powerUps\": \"all\",\n" +
                "\"prefs_permissionLevel\": \"private\",\n" +
                "\"prefs_voting\": \"members\",\n" +
                "\"prefs_comments\": \"members\",\n" +
                "\"prefs_invitations\": \"members\",\n" +
                "\"prefs_selfJoin\": true,\n" +
                "\"prefs_cardCovers\": true,\n" +
                "\"prefs_background\": \"blue\",\n" +
                "\"prefs_cardAging\": \"regular\"\n" +
                "}";
        String createBoardresponse = given().log().all().header("Content-Type", "application/json").
                body(createBoardJsonBody).when().post("/1/boards/").then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(createBoardresponse);
        String idBoard = js.getString("idBoardSource");
        String idOrganization = js.getString("idOrganization");

        System.out.println(createBoardresponse);


        //CREATE FIRST CARD
        String addFirstCartJsonBody = "{\n" +
                "  \"name\": \"My New First Card\",\n" +
                "  \"desc\": \"This is a description for my new card\",\n" +
                "  \"pos\": \"top\",\n" +
                "  \"due\": \"2023-04-30\",\n" +
                "  \"start\": null,\n" +
                "  \"dueComplete\": false,\n" +
                "  \"idList\": \"123456789012345678901234\",\n" +
                "  \"idMembers\": [\"987654321098765432109876\", \"876543210987654321098765\"],\n" +
                "  \"idLabels\": [\"012345678901234567890123\", \"234567890123456789012345\"],\n" +
                "  \"urlSource\": \"https://example.com\",\n" +
                "  \"fileSource\": \"file://example.pdf\",\n" +
                "  \"mimeType\": \"application/pdf\",\n" +
                "  \"idCardSource\": \"456789012345678901234567\",\n" +
                "  \"keepFromSource\": \"attachments,checklists,comments\",\n" +
                "  \"address\": \"123 Main St, Anytown, USA\",\n" +
                "  \"locationName\": \"My Office\",\n" +
                "  \"coordinates\": \"37.7749,-122.4194\"\n" +
                "}\n";


        String addFirstCardResponse = given().log().all().header("Content-Type", "application/json").
                body(addFirstCartJsonBody).when().post(" /1/cards").then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(addFirstCardResponse);
        String idList = js1.getString("idList");
        String idMembers = js1.getString("idMembers");
        String idLabels = js1.getString("idLabels");


        System.out.println(addFirstCardResponse);


        //CREATE SECOND CARD
        String addSecondCartJsonBody = "{\n" +
                "  \"name\": \"My New Second Card\",\n" +
                "  \"desc\": \"This is a description for my new card\",\n" +
                "  \"pos\": \"top\",\n" +
                "  \"due\": \"2023-04-30\",\n" +
                "  \"start\": null,\n" +
                "  \"dueComplete\": false,\n" +
                "  \"idList\": \"123456789012345678901234\",\n" +
                "  \"idMembers\": [\"987654321098765432109876\", \"876543210987654321098765\"],\n" +
                "  \"idLabels\": [\"012345678901234567890123\", \"234567890123456789012345\"],\n" +
                "  \"urlSource\": \"https://example.com\",\n" +
                "  \"fileSource\": \"file://example.pdf\",\n" +
                "  \"mimeType\": \"application/pdf\",\n" +
                "  \"idCardSource\": \"456789012345678901234567\",\n" +
                "  \"keepFromSource\": \"attachments,checklists,comments\",\n" +
                "  \"address\": \"TELEFON SOK, TURKEY\",\n" +
                "  \"locationName\": \"My Office\",\n" +
                "  \"coordinates\": \"37.7749,-122.4194\"\n" +
                "}\n";


        String addSecondCardResponse = given().log().all().header("Content-Type", "application/json").
                body(addSecondCartJsonBody).when().post(" /1/cards").then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js2 = new JsonPath(addSecondCardResponse);
        String idList2 = js2.getString("idList");
        String idMembers2 = js2.getString("idMembers");
        String idLabels2 = js2.getString("idLabels");


        System.out.println(addSecondCardResponse);


        //  UPDATE CARD
        String updateCard = "{\n" +
                "  \"name\": \"Updated Card Name\",\n" +
                "  \"desc\": \"Updated description for the card\",\n" +
                "  \"closed\": true,\n" +
                "  \"idMembers\":\"" + idMembers2 + "\",\n" +
                "  \"idAttachmentCover\": \"012345678901234567890123\",\n" +
                "  \"idList\": \"" + idList2 + "\",\n" +
                "  \"idLabels\": \"" + idLabels2 + "\",\n" +
                "  \"idBoard\": \"" + idBoard + "\",\n" +
                "  \"pos\": 3.5,\n" +
                "  \"due\": \"2023-05-15\",\n" +
                "  \"start\": null,\n" +
                "  \"dueComplete\": true,\n" +
                "  \"subscribed\": true,\n" +
                "  \"address\": \"456 Main St, Anytown, USA\",\n" +
                "  \"locationName\": \"My Home\",\n" +
                "  \"coordinates\": \"37.7749,-122.4194\",\n" +
                "  \"cover\": {\n" +
                "    \"idAttachment\": \"012345678901234567890123\",\n" +
                "    \"color\": \"blue\"\n" +
                "  }\n" +
                "}\n";

        String updateCardResponse = given().log().all().header("Content-Type", "application/json").
                body(addFirstCartJsonBody).when().put(" /1/cards/{id}").then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(updateCardResponse);


//DELETE CARD

        Response deleteCardResponse = RestAssured.delete("/1/cards/{id}");

        System.out.println(deleteCardResponse.getBody().asString());
        System.out.println(deleteCardResponse.getStatusCode());

        //DELETE BOARD


        Response deleteBoardresponse = RestAssured.delete(" /1/boards/{id}");

        System.out.println(deleteBoardresponse.getBody().asString());
        System.out.println(deleteBoardresponse.getStatusCode());


    }
}


