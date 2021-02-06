import java.io.IOException;
import java.util.ArrayList;
import models.Bidding;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/** Classe Main (Principal) para extração de dados utilizando Jsoup */
public class Main {

	/** Constante contendo o link do site do departamento de licitações da UFSC */
	private static final String PAGE_URL   = "http://notes.ufsc.br/aplic/licitcpl.nsf/vwLicitacao?OpenView&Start=1&Count=30&Expand=1#1";
	/** Constante contendo o aplicação/versão do agente de usuário requisitante */
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

	public static void main (String[] args) {

		try {
			/** Armazena a página requisitada retornada da Biblioteca Jsoup na variável (type Document) */
			Document document = Jsoup.connect(PAGE_URL).userAgent(USER_AGENT).get();
			/** Armazena os dados pegos da Tela pelo Jsoup na variável (type Elements) */
			Elements trs = document.body().select("form div").get(2).select("tr");
			ArrayList<Bidding> biddings = new ArrayList<>();
			Bidding bidding = new Bidding();

			for(Element tr: trs){
				Elements td = tr.select("td");
				/** Valida quando o laço de repetição retornar a 8ª <td>, tag onde está os dados esperados */
				if (td.size() == 8) {
					/** Seta nos atributos da Classe Bidding os valores pegos da tela */
					bidding.setId(td.get(1).text());
					bidding.setDescription(td.get(2).text());
					bidding.setDate(treatDate(td));
					bidding.setType(td.get(6).text());

					/** Retorna os valores de forma visual */
					System.out.println(bidding.toString());
				}
			}
		} catch (IOException e) {
			/** Retorna o erro gerado de forma visual */
			e.printStackTrace();
		}
	}

	private static String treatDate(Elements td) {
		/** Retorna a Data (type String) no formato dd/MM/YYYY hh:mm */
		return td.get(3).text() + " " + td.get(4).text();
	}

}