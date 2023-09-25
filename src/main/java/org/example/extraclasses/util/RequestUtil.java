package org.example.extraclasses.util;

import org.example.extraclasses.exceptions.ParseRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RequestUtil {
    public static byte[] readBytesByParamName(HttpServletRequest request, String paramName, int bufferSize) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (InputStream is = request.getPart(paramName).getInputStream()) {
            int nRead;
            byte[] data = new byte[bufferSize];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
        } catch (IOException | ServletException e) {
            throw new ParseRequestException("Error during get part with name: " + paramName, e);
        }
        return buffer.toByteArray();
    }
}
