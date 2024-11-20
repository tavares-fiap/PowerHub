package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FindAddress_DAO {

    public HashMap<String, String> findAddressByCEP(String cep) {
        HashMap<String, String> resultMap = new HashMap<>();
        try {
            // URL da API ViaCep
            String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
            URL url = new URL(urlString);

            // Configurando a conexão
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Verificando o código de resposta
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Erro na requisição: HTTP código " + conn.getResponseCode());
            }

            // Lendo a resposta
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                jsonResponse.append(linha);
            }

            // Fechando a conexão
            conn.disconnect();

            // Parseando o JSON manualmente
            String json = jsonResponse.toString().replace("{", "").replace("}", "").replace("\"", "");
            String[] pares = json.split(",");

            for (String par : pares) {
                String[] chaveValor = par.split(":");
                if (chaveValor.length == 2) {
                    resultMap.put(chaveValor[0].trim(), chaveValor[1].trim());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o CEP.\nCodigo do erro: " + e.getMessage());
        }
        return resultMap;
    }
}
