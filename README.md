# SP24-Analyzing-Preferred-Voice-Tones-In-Chatbot-Interactions
To compile:
javac *.java


To run in terminal:
java RecordToFile
firefox Website.html

Before running, make sure the answers match the question list given to participants in Website.html

Results are automatically recorded to Results.txt and should be run on the school computers. If a port specified in the document is currently being used, it will error, so you may need to change the port being used for RecordToFile. You would change 'http://localhost:5050/rating' (line 195 in Website.html) and HttpServer server = HttpServer.create(new InetSocketAddress(5050), 0); (line 17 in RecordToFile.java) to a different port other then 5050.
