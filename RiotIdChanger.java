package LCUConnector;

import org.apache.hc.core5.http.ParseException;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class RiotIdChanger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("RIOT ID CHANGER");

        System.out.println("Digite o nick:");
        String name = scanner.nextLine();

        System.out.println("Digite a #:");
        String tag = scanner.nextLine();

        try {
            LeagueClient leagueClient = new LeagueClient("C:\\Riot Games\\League of Legends\\lockfile");
            leagueClient.Connect();

            JSONObject data = new JSONObject();
            data.put("gameName", name);
            data.put("tagLine", tag);

            String endpoint = "/lol-summoner/v1/save-alias";
            String response = leagueClient.MakeApiRequest("POST", endpoint, data.toJSONString());

            System.out.println("Resposta da API: " + response);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
