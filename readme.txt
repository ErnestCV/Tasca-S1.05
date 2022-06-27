//Nivell 1, exercici 1
//En el pom hem de declarar <mainClass>n1ex1.Main</mainClass>, o si no, afegir -D"exec.mainClass"="n1ex1.Main"
cd n1ex1
mvn compile
mvn exec:java -D"exec.args"="C:\\Users\\formacio\\IdeaProjects"

//Nivell 1, exercici 2
//En el pom hem de declarar <mainClass>n1ex1.Main</mainClass>, o si no, afegir -D"exec.mainClass"="org.n1ex2.Main"
cd n1ex2
mvn compile
mvn exec:java -D"exec.args"="C:\\Users\\formacio\\IdeaProjects"

//Nivell 1, exercici 3
//En el pom hem de declarar <mainClass>n1ex1.Main</mainClass>, o si no, afegir -D"exec.mainClass"="org.n1ex3.Main"
cd n1ex3
mvn compile exec:java -D"exec.args"="C:\\Users\\formacio\\IdeaProjects\\Tasca-S1.05"

