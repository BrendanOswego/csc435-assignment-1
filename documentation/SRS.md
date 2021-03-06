Brendan Goldberg
<p align='center'>Software Requirements Specification Document</p>

## 1. Purpose
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The goal of this project is to create a library web application.
## 2. Scope
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The application name is “Simple Library”. The main focus of the application is to allow users to find information about different books. Users will also be able to add book information to the application. This target users of this application are people that like reading books and want to find new material to read.
## 3. Product Functions
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Users will be able to search for different books that are stored in the application. They will also be able to add their own entries into the application if the entry is not already stored.
## 4. Backend Functionality
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The application will be written in the Java programming language. Entries in the application will be stored in a `java.util.List` of Book Objects. The application will be running on Apache Tomcat using Maven to build .war files for better version control. Java Servlets will be used for the application logic of displaying information to the user as well as storing information on a user’s request.
### Endpoints
```json
{
  "url": "/assignment-1/books",
  "method": "GET",
  "description": "Returns a page that displays all books in the application, as well as a link to add books."
},
{
  "url": "/assignment-1/books",
  "method": "POST",
  "parameters": {
    "title": "string",
    "author": "string"
  },
  "description": "Adds a new entry to the Books List with an incremented ID based on previous ID value."
},
{
  "url": "/assignment-1/books/{id}",
  "method": "GET",
  "description": "Returns JSON formatted data for the book with the specified id parameter. If no book is found, returns error message saying no book was found."
},
{
  "url": "/assignment-1/books/add",
  "method": "GET",
  "description": "Returns a page with a form to allow users to add a new Entry to the Book List."
}
```
## 5. Backend Frontend Interaction
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The application will have different endpoints that users can access to either read or write information. These endpoints will correspond to some Java Servlet that will handle the protocols for their respective endpoints such as GET, and POST requests. Basic HTML and CSS will be used to better the user’s experience. SASS will be used in the backend which will compile to a main CSS file for a better development process.
