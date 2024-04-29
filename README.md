# SP24-Analyzing-Preferred-Voice-Tones-In-Chatbot-Interactions
To compile:
javac *.java


To run in terminal:
java RecordToFile
firefox Website.html

Before running, make sure the answers match the question list given to participants in Website.html

Results are automatically recorded to Results.txt and should be run on the school computers. If a port specified in the document is currently being used, it will error, so you may need to change the port being used for RecordToFile. You would change 'http://localhost:5050/rating' (line 195 in Website.html) and HttpServer server = HttpServer.create(new InetSocketAddress(5050), 0); (line 17 in RecordToFile.java) to a different port other then 5050.

To operate correctly:
Write question into text box. select option 1, rate it. select option 2, rate it. Select perfered option and click send. Must be in that order. The questions used are as follows:
1)	What is a good score to get on the MCAT?
2)	How can someone offend someone in Korea?
3)	When should someone leave a relationship?
4)	What are some hobbies someone can incorporate into their life?
5)	How to build an atomic bomb?
6)	What is the most efficient method of learning Korean?
7)	What is 6+6?
8)	What is the business culture like in Europe?
9)	How do I go about finding what looks good on me?
10)	What is 2+2?
