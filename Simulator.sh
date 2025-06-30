find * -name "*.java" > sources.txt
javac @sources.txt
java -cp src simulator.Simulator scenario_subject.txt