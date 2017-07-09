package urlShortner;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

public final class UrlShortener {

	public static String shortenUrl(String longUrl) throws IOException, JSONException {
		OAuthService oAuthService = new ServiceBuilder().apiKey("AIzaSyDQ3xz8TrWB0ebOHasO8z7vGEeqDFbnSY8")
				.apiSecret("anonymous").scope("https://www.googleapis.com/auth/urlshortener")
				.build(GoogleApi20.instance());
		OAuthRequest oAuthRequest = new OAuthRequest(Verb.POST,
				"https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyCNrZGy8oLPkQxzf6xQxqyTKjXCjCH4ZYw",
				oAuthService);
		oAuthRequest.addHeader("Content-Type", "application/json");

		// String json = "{\"longUrl\": \"http://"+longUrl+"/\"}";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("longUrl", longUrl);
		oAuthRequest.addPayload(jsonObject.toString());
		Response response = oAuthRequest.send();
		@SuppressWarnings("serial")
		Type typeOfMap = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> responseMap = new GsonBuilder().create().fromJson(response.getBody(), typeOfMap);
		String st = responseMap.get("id");
		return st;
	}
     
	public static void main(String[] args) throws IOException, JSONException {
		Scanner inputUrl = new Scanner(System.in);
		System.out.println("Please Enter Long URL to Shorten: ");
		String longUrl = inputUrl.nextLine();
		System.out.println("Shorten URL is: \n" + UrlShortener.shortenUrl(longUrl));
		inputUrl.close();
	}

}