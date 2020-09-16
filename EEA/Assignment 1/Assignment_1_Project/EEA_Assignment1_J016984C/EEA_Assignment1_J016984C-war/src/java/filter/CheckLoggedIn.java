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

/**
 *
 * @author Rhys
 */
@WebFilter(filterName = "CheckLoggedIn", urlPatterns
        =
        {
            "/*"
        })
public class CheckLoggedIn implements Filter
{
    private FilterConfig filterConfig = null;

    public CheckLoggedIn()
    {
    }

    
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
        String layoutURI = request.getContextPath() + "/faces/Layout.xhtml";
        String deliverySearchURI = request.getContextPath() + "/faces/deliverySearch.xhtml";
        String expandedDeliveryViewURI = request.getContextPath() + "/faces/expandedDeliveryView.xhtml";
        String bookCollectionURI = request.getContextPath() + "/faces/bookCollection.xhtml";
        String rescheduleDeliveryURI = request.getContextPath() + "/faces/expandedDeliveryView.xhtml";
        
        UserDTO loggedIn;
        if (sessionScope.getAttribute("loggedUser") != null)
        {
            loggedIn = (UserDTO) sessionScope.getAttribute("loggedUser");
        }
        else
        {
            loggedIn = (UserDTO) sessionScope.getAttribute("loggedDriver");
        }
        
        boolean systemTagRequest = request.getRequestURI().equals(systemTagURI);
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean indexRequest = request.getRequestURI().equals(indexURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);
        boolean layoutRequest = request.getRequestURI().equals(layoutURI);
        boolean deliverySearchRequest = request.getRequestURI().equals(deliverySearchURI);
        boolean expandedDeliveryViewRequest = request.getRequestURI().equals(expandedDeliveryViewURI);
        boolean bookCollectionRequest = request.getRequestURI().equals(bookCollectionURI);
        boolean rescheduleDeliveryRequest = request.getRequestURI().equals(rescheduleDeliveryURI);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + "/faces/javax.faces.resource/");

        if (loggedIn != null || systemTagRequest || loginRequest || registerRequest || layoutRequest || deliverySearchRequest || expandedDeliveryViewRequest || bookCollectionRequest || rescheduleDeliveryRequest || resourceRequest || indexRequest)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginURI);
        }
    }

    
    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }

    
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
