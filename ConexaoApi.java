package AtividadeApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoApi {
    public static void main(String[] args) {
    try {
        String url = "https://api.codetabs.com/v1/loc?github=LuanWoichechoscki/OTES";

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = "";
        String line;
        while ((line = br.readLine()) != null) {
            output += line;
        }

        conn.disconnect();



    } catch (
    IOException ex) {
        Logger.getLogger(ConexaoApi.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}