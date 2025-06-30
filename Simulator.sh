find * -name "*.java" > sources.txt
javac @sources.txt
# java -cp src simulator.Simulator scenario/scenario_subject.txt
java -cp src simulator.Simulator scenario/scenario_1.txt
# java -cp src simulator.Simulator scenario/scenario_2.txt
# java -cp src simulator.Simulator scenario/scenario_3.txt