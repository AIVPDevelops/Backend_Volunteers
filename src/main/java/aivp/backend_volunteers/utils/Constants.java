package aivp.backend_volunteers.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Constants {

    public static final int STATUS_OK = 200;
    public static final String MESSAGE_OK = "Petición exitosa";
    public static final int STATUS_CREATED = 201;
    public static final String MESSAGE_CREATED = "Resource created successfully";
    public static final int STATUS_NO_CONTENT = 204;
    public static final String MESSAGE_NO_CONTENT = "No content available";
    public static final int STATUS_BAD_REQUEST = 400;
    public static final String MESSAGE_BAD_REQUEST = "Invalid request parameters";
    public static final int STATUS_UNAUTHORIZED = 401;
    public static final String MESSAGE_UNAUTHORIZED = "Unauthorized access";
    public static final int STATUS_FORBIDDEN = 403;
    public static final String MESSAGE_FORBIDDEN = "Access forbidden";
    public static final int STATUS_NOT_FOUND = 404;
    public static final String MESSAGE_NOT_FOUND = "Resource not found";
    public static final int STATUS_CONFLICT = 409;
    public static final String MESSAGE_CONFLICT = "Conflict with existing resource";
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
    public static final String MESSAGE_INTERNAL_SERVER_ERROR = "Internal server error occurred";
    public static final String MESSAGE_INTERNAL_DATABASE_ERROR = "Database internal error: ";
    public static final int STATUS_SERVICE_UNAVAILABLE = 503;
    public static final String MESSAGE_SERVICE_UNAVAILABLE = "Service temporarily unavailable";
    public static final String USER_NOT_FOUND_BY_EMAIL = "Usuario no encontrado con email: ";
    public static final String USER_NOT_FOUND = "Usuario no encontrado.";
    public static final String UNEXPECTED_ERROR = "Unexpected error: ";
    public static final String BACKEND_STATUS_OK = "Backend is running perfectly.";
}
