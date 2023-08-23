package stepDefinition;

//import cucumber.api.java.Before;
//import cucumber.runtime.StepDefinition;
import io.cucumber.java.Before;


public class Hooks
{

@Before("@deletePlace")
    public void beforeScenario() throws Throwable {

    /*
    stepDefinition_placeValidations s = new stepDefinition_placeValidations();
    if(s.placeID==null) {
        s.add_Place_Payload_with("Subha", "French", "Asia");
        s.user_calls_with_Post_http_request("AddPlaceAPI", "POST");
        s.verify_place_ID_created_maps_to_using("Subha", "getPlaceAPI");
    }

     */
}

}
