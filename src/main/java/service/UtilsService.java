package service;

import javax.servlet.http.HttpServletRequest;

public interface UtilsService {
    void getOptions(HttpServletRequest request);

    void overView(HttpServletRequest request);
}
