# WordCounter

This project has been developed for Synechron Interview purpose. It exposes three APIs
1. Insert word - http://localhost:8080/word-counter/rest/v0.1/insert/{word}
	Eg. http://localhost:8080/word-counter/rest/v0.1/insert/secure
	This API insert the word in the application. It will also increments the count when the word is inserted again each time. 
	
2. Get count - http://localhost:8080/word-counter/rest/v0.1/count-word?word={word}
	Eg. http://localhost:8080/word-counter/rest/v0.1/count-word?word=flower
	This API retrives the word and its count passed in the application. 
	
3. Insert word - http://localhost:8080/word-counter/rest/v0.1/listAllWords
	Eg. http://localhost:8080/word-counter/rest/v0.1/listAllWords
	This API lists all the words and its count available in the application.
	
The application does not support words with special characters or numbers. If such words were passed then it will respond the respective error messages.


	