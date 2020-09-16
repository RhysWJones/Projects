package filter;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "CheckLoggedIn", urlPatterns
        =
        {
            "/*"
        })
public class CheckLoggedIn implements Filter
{

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public CheckLoggedIn()
    {
    }

    /*
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession sessionScope = request.getSession(true);
        String systemTagURI = request.getContextPath() + "/";
        String loginURI = request.getContextPath() + "/faces/login.xhtml";
        String indexURI = request.getContextPath() + "/faces/index.xhtml";
        String registerURI = request.getContextPath() + "/faces/register.xhtml";
        String templateURI = request.getContextPath() + "/faces/template.xhtml";
        String viewCinemasURI = request.getContextPath() + "/faces/viewCinemas.xhtml";
        String viewShowingsURI = request.getContextPath() + "/faces/viewShowings.xhtml";
        
        UserDTO loggedIn;
        if (sessionScope.getAttribute("loggedCustomer") != null)
        {
            loggedIn = (UserDTO) sessionScope.getAttribute("loggedCustomer");
        }
        else
        {
            loggedIn = (UserDTO) sessionScope.getAttribute("loggedAdmin");
        }
        
        boolean systemTagRequest = request.getRequestURI().equals(systemTagURI);
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean indexRequest = request.getRequestURI().equals(indexURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);
        boolean templateRequest = request.getRequestURI().equals(templateURI);
        boolean viewCinemasRequest = request.getRequestURI().equals(viewCinemasURI);
        boolean viewShowingsRequest = request.getRequestURI().equals(viewShowingsURI);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + "/faces/javax.faces.resource/");
        boolean allowWebservices = request.getRequestURI().startsWith(request.getContextPath() + "/test")
                || request.getRequestURI().startsWith(request.getContextPath() + "/webresources")
                || request.getRequestURI().startsWith(request.getContextPath() + "/cc.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/item.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/collapse.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/expand.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/og.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/cg.gif")
                || request.getRequestURI().startsWith(request.getContextPath() + "/css_master-all.css")
                || request.getRequestURI().startsWith(request.getContextPath() + "/images/");
        
        

        if (allowWebservices || loggedIn != null || systemTagRequest || loginRequest || registerRequest || templateRequest || viewCinemasRequest || viewShowingsRequest || resourceRequest || indexRequest)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginURI);
        }
    }

    /*
     * Destroy method for this filter
     */
    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    /*
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);
    }

}
