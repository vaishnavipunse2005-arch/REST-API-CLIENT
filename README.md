# REST-API-CLIENT

"COMPANY" : CODTECH IT SOLUTIONS

"NAME" : VAISHNAVI PUNSE 

"INTERN ID" : CTIS6853

"DOMAIN" :JAVA PROGRAMMING

"DURATION" : 4 WEEKS

"MENTOR" : NEELA SANTOSH 

"DESCRIPTION"

Architectural Overview of the REST Client
The provided Java application exemplifies the Client-Server model, a cornerstone of modern software engineering. In this architecture, your application functions as the Client, which initiates a request for specific data, while the Open-Meteo API serves as the Server, which holds the resource (weather data). This interaction is governed by the REST (Representational State Transfer) architectural style. By utilizing a specific Uniform Resource Locator (URL), the client identifies the resource and passes specific query parameters—such as latitude and longitude—to filter the state of the data it wish to retrieve. This demonstrates the principle of Addressability, where every unique resource can be accessed via a specific URI.
Protocol Management and Connection Lifecycle
At the core of this program is the HTTP (Hypertext Transfer Protocol), specifically the GET method. In RESTful design, a GET request is considered idempotent and safe, meaning it retrieves information without modifying the server's data. The HttpURLConnection class in Java manages the lifecycle of this connection, including the TCP/IP handshake and the processing of HTTP Status Codes. Your implementation correctly verifies the 200 OK status, which is the standard signal that the request was successful. Robust software design requires this validation to distinguish between a successful data transfer and various error states, such as a 404 Not Found (client-side error) or a 500 Internal Server Error (server-side failure).
Data Stream Processing and Resource Handling
Because network communication involves transferring data in fragmented packets, the application employs Stream Processing techniques. By using an InputStreamReader and a BufferedReader, the code efficiently reads the incoming byte stream from the network and converts it into human-readable text. The use of a StringBuilder is a critical optimization here; unlike standard strings, which are immutable and create new objects in memory with every change, a StringBuilder allows for the efficient "buffering" of the response until the full payload is received. Furthermore, the inclusion of a try-catch-finally logic (or explicit closing of the stream) ensures proper Resource Management, preventing memory leaks or hanging connections that could crash an application over time.
Data Deserialization and JSON Parsing
Once the raw data is captured as a string, it must undergo Deserialization to become useful to the application. The program uses the JSON (JavaScript Object Notation) format, which is the industry standard for REST APIs due to its lightweight nature and hierarchical structure. Through the JSONObject library, the application maps the flat text response into an object-oriented tree. This allows the program to programmatically "navigate" to the current_weather node and extract specific attributes like temperature and wind speed. This process highlights the Separation of Concerns, where the networking logic (fetching) is distinct from the business logic (parsing and displaying), making the code easier to maintain and scale.
