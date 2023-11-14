package org.example.extraclasses.util;

import org.example.extraclasses.exception.ParseRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RequestUtil {
    private static final Logger log = Logger.getLogger(RequestUtil.class.getName());

    public static byte[] readBytesByParamName (HttpServletRequest request,String paramName, int bufferSize) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            log.info("Param name:     "+paramName);
            Part part = request.getPart(paramName);
            log.info("Part:     "+part);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        try (InputStream is = request.getPart(paramName).getInputStream()) {
            {
                int nRead;
                byte[] data = new byte[bufferSize];
                while ((nRead = is.read(data, 0, data.length)) !=-1){
                buffer.write(data, 0, nRead);
                }
            }
        } catch (IOException | ServletException e) {
            throw new ParseRequestException("Error during get part with name: " + paramName,e);
        }
        return buffer.toByteArray();
    }
}
