package controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Imagens
 */
@WebServlet("/Imagens")
public class Imagens extends HttpServlet {
    private static final String BASE_DIR = "/home/rauan/Desenvolvimento/Java/Imagens";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        if (nome == null || nome.contains("..")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nome inválido");
            return;
        }

        File imagem = new File(BASE_DIR, nome);
        if (!imagem.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType(getServletContext().getMimeType(imagem.getName()));
        Files.copy(imagem.toPath(), response.getOutputStream());
    }
}
