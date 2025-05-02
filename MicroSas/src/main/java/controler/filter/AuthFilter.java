package controler.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebFilter({"/usuario/*", "/coletor/*"}) // filtra rotas específicasS
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI();
        boolean isUsuarioArea = path.contains("/usuario/");
        boolean isColetorArea = path.contains("/coletor/");

        boolean usuarioLogado = session != null && session.getAttribute("usuarioLogado") != null;
        boolean coletorLogado = session != null && session.getAttribute("coletorLogado") != null;

        if ((isUsuarioArea && usuarioLogado) || (isColetorArea && coletorLogado)) {
            chain.doFilter(request, response); // acesso permitido
        } else {
            res.sendRedirect(req.getContextPath() + "/index.jsp"); // acesso negado
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {}
    public void destroy() {}
}